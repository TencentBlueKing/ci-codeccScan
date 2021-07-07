// Copyright (c) 2013 The Go Authors. All rights reserved.
//
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file or at
// https://developers.google.com/open-source/licenses/bsd.

// Package lint contains a linter for Go source code.
package lint

import (
	"bufio"
	"bytes"
	"container/list"
	"fmt"
	"go/ast"
	"go/parser"
	"go/printer"
	"go/token"
	"go/types"
	"os"
	"regexp"
	"sort"
	"strconv"
	"strings"
	"unicode"
	"unicode/utf8"

	"golang.org/x/tools/go/gcexportdata"
)

const styleGuideBase = "https://golang.org/wiki/CodeReviewComments"

// A Linter lints Go source code.
type Linter struct {
}

type TOSAConfig struct {
	CommentRatio   int
	FuncNameLength int
	LineLength     int
	PluginDir      string
	FuncSize       int
}

var Config = TOSAConfig{CommentRatio: 10, FuncNameLength: 35, LineLength: 120, PluginDir: "", FuncSize: 80}

func SetConfig(config TOSAConfig) {
	Config = config
}

// Problem represents a problem in some source code.
type Problem struct {
	Position   token.Position // position in source file
	Text       string         // the prose that describes the problem
	Link       string         // (optional) the link to the style guide for the problem
	Confidence float64        // a value in (0,1] estimating the confidence in this problem's correctness
	LineText   string         // the source line
	Category   string         // a short name for the general category of the problem

	// If the problem has a suggested fix (the minority case),
	// ReplacementLine is a full replacement for the relevant line of the source file.
	ReplacementLine string
}

func (p *Problem) String() string {
	if p.Link != "" {
		return p.Text + "\n\n" + p.Link
	}
	return p.Text
}

type byPosition []Problem

func (p byPosition) Len() int      { return len(p) }
func (p byPosition) Swap(i, j int) { p[i], p[j] = p[j], p[i] }

func (p byPosition) Less(i, j int) bool {
	pi, pj := p[i].Position, p[j].Position

	if pi.Filename != pj.Filename {
		return pi.Filename < pj.Filename
	}
	if pi.Line != pj.Line {
		return pi.Line < pj.Line
	}
	if pi.Column != pj.Column {
		return pi.Column < pj.Column
	}

	return p[i].Text < p[j].Text
}

// Lint lints src.
func (l *Linter) Lint(filename string, src []byte) ([]Problem, error) {

	return l.LintFiles(map[string][]byte{filename: src})
}

// LintFiles lints a set of files of a single package.
// The argument is a map of filename to source.
func (l *Linter) LintFiles(files map[string][]byte) ([]Problem, error) {
	pkg := &pkg{
		fset:  token.NewFileSet(),
		files: make(map[string]*file),
	}
	var pkgName string
	for filename, src := range files {
		if isGenerated(src) {
			continue // See issue #239
		}
		f, err := parser.ParseFile(pkg.fset, filename, src, parser.ParseComments)
		if err != nil {
			return nil, err
		}
		if pkgName == "" {
			pkgName = f.Name.Name
		} else if f.Name.Name != pkgName {
			return nil, fmt.Errorf("%s is in package %s, not %s", filename, f.Name.Name, pkgName)
		}
		pkg.files[filename] = &file{
			pkg:      pkg,
			f:        f,
			fset:     pkg.fset,
			src:      src,
			filename: filename,
		}
	}
	if len(pkg.files) == 0 {
		return nil, nil
	}
	return pkg.lint(), nil
}

var (
	genHdr = []byte("// Code generated ")
	genFtr = []byte(" DO NOT EDIT.")
)

// isGenerated reports whether the source file is generated code
// according the rules from https://golang.org/s/generatedcode.
func isGenerated(src []byte) bool {
	sc := bufio.NewScanner(bytes.NewReader(src))
	for sc.Scan() {
		b := sc.Bytes()
		if bytes.HasPrefix(b, genHdr) && bytes.HasSuffix(b, genFtr) && len(b) >= len(genHdr)+len(genFtr) {
			return true
		}
	}
	return false
}

// pkg represents a package being linted.
type pkg struct {
	fset  *token.FileSet
	files map[string]*file

	typesPkg  *types.Package
	typesInfo *types.Info

	// sortable is the set of types in the package that implement sort.Interface.
	sortable map[string]bool
	// main is whether this is a "main" package.
	main bool

	problems []Problem
}

func (p *pkg) lint() []Problem {
	if err := p.typeCheck(); err != nil {
		/* TODO(dsymonds): Consider reporting these errors when golint operates on entire packages.
		if e, ok := err.(types.Error); ok {
			pos := p.fset.Position(e.Pos)
			conf := 1.0
			if strings.Contains(e.Msg, "can't find import: ") {
				// Golint is probably being run in a context that doesn't support
				// typechecking (e.g. package files aren't found), so don't warn about it.
				conf = 0
			}
			if conf > 0 {
				p.errorfAt(pos, conf, category("typechecking"), e.Msg)
			}

			// TODO(dsymonds): Abort if !e.Soft?
		}
		*/
	}

	p.scanSortable()
	p.main = p.isMain()

	for _, f := range p.files {
		f.lint()
	}

	sort.Sort(byPosition(p.problems))

	return p.problems
}

// file represents a file being linted.
type file struct {
	pkg      *pkg
	f        *ast.File
	fset     *token.FileSet
	src      []byte
	filename string
}

var soFileList list.List

func walkfunc(path string, info os.FileInfo, err error) error {
	fi, err := os.Stat(path)
	if err != nil {
		fmt.Println(err)
		return nil
	}
	if fi.Mode().IsRegular() {
		if strings.HasSuffix(path, ".so") {
			soFileList.PushBack(path)
		}
	}
	return nil
}

/*
func (f *file) RunPlugin() {
	if len(Config.PluginDir) == 0 {
		return
	}

	soFileList.Init()
	filepath.Walk(Config.PluginDir, walkfunc)
	if soFileList.Len() == 0 {
		fmt.Println("can not find any *.so file")
		return
	}

	for i := soFileList.Front(); i != nil; i = i.Next() {
		soPath := i.Value.(string)
		resultList := f.loadPluginFile(soPath)
		for res := resultList.Front(); res != nil; res = res.Next() {
			resEle := res.Value.(codecc.RESULT)
			if resEle.HasErr {
				msg := resEle.CheckerName + "->" + resEle.ErrMsg
				f.errorf(resEle.ErrPosition, resEle.Confidence, msg)
			}
		}
	}
}

func (f *file) loadPluginFile(soPath string) list.List {
	//fmt.Printf("will load[%s]\n", soPath)
	p, err := plugin.Open(soPath)
	if err != nil {
		panic(err)
	}
	goFile, err := p.Lookup("GoFile")
	if err != nil {
		panic(err)
	}
	ck, err := p.Lookup("MyLintChecker")
	if err != nil {
		panic(err)
	}
	*goFile.(*codecc.FILE) = codecc.FILE{
		Src:      f.src,
		Fset:     f.fset,
		F:        f.f,
		Filename: f.filename,
	}
	//ptr.Pkg = ff.pkg
	ck.(func())()

	result, err := p.Lookup("ResultList")
	if err != nil {
		panic(err)
	}

	var checkerRes list.List
	checkerRes.PushBackList(result.(*list.List))
	(result.(*list.List)).Init()

	return checkerRes

}
*/

func (f *file) lintFunctionSize() {
	f.walk(func(n ast.Node) bool {
		fn, ok := n.(*ast.FuncDecl)
		if !ok {
			return true
		}
		//ast.Print(f.fset, f.f)
		//fmt.Printf("file:%s, funcname:%s\n",f.filename, fn.Name.Name)
		if fn.Type == nil || fn.Body == nil {
			return true
		}
		startPos := f.fset.Position(fn.Type.Func)
		endPos := f.fset.Position(fn.Body.Rbrace)
		totalLine := endPos.Line - startPos.Line + 1
		code := string(f.src)
		//fmt.Printf("file:%s, funcname:%s, len code is %d, start:%d, rbace:%d, startLine:%d, endLine:%d \n",f.filename, fn.Name.Name, len(code), int(fn.Type.Func)-1, int(fn.Body.Rbrace), startPos.Offset, endPos.Offset)
		if startPos.Offset > len(code)-1 || endPos.Offset > len(code)-1 {
			return true
		}
		s := code[startPos.Offset : endPos.Offset+1]
		if len(s) > 0 {
			codeLines := strings.Split(s, "\n")
			for i := 0; i < len(codeLines); i++ {
				if strings.TrimSpace(codeLines[i]) == "" {
					totalLine--
				}
			}
		}

		maxFuncSize := Config.FuncSize
		funcType := ""
		if strings.HasPrefix(fn.Name.Name, "Test") {
			maxFuncSize = Config.FuncSize * 2
			funcType = "单元测试函数"
		}
		fmt.Printf("Config.FuncSize:%d, maxFuncSize:%d \n", Config.FuncSize, maxFuncSize)
		if totalLine > maxFuncSize {
			f.errorf(fn, 1, fmt.Sprintf("golint/fnsize->该%s函数代码逻辑行和注释行的行数是%d，规范设定值为%d", funcType, totalLine, maxFuncSize))
		}
		return true
	})
}

//check function parameter count
func (f *file) lintFunParaCount() {
	f.walk(func(n ast.Node) bool {
		fn, ok := n.(*ast.FuncDecl)
		if !ok {
			return true
		}
		//ast.Print(f.fset, f.f)
		//fmt.Printf("file:%s, funcname:%s\n",f.filename, fn.Name.Name)
		if fn.Type == nil || fn.Body == nil {
			return true
		}
		total := 0
		for _, e := range fn.Type.Params.List {
			total += len(e.Names)
		}

		if total > 5 {
			f.errorf(fn.Type.Params, 1, fmt.Sprintf("golint/funcparacount->函数参数个数为%d，规范设定值为5", total))
		}
		return true
	})
}

//check function parameter count
func (f *file) lintSwitchShouldAlwaysHasDefault() {
	f.walk(func(n ast.Node) bool {
		sw, ok := n.(*ast.SwitchStmt)
		if !ok {
			return true
		}

		var caseListLen = len(sw.Body.List)
		if sw.Body.List[caseListLen-1].(*ast.CaseClause).List == nil {
			f.errorf(sw, 1, fmt.Sprintf("golint/switchdefault->switch必须有default"))
		}
		return true
	})
}

func (f *file) lintToDo() {
	// todo
	// ToDo
	// TODO
	// TO-DO
	if f.isTest() {
		return
	}
	var fileContent = string(f.src)

	split := strings.Split(fileContent, "\n")
	for i, line := range split {
		if strings.Contains(line, "todo") || strings.Contains(line, "ToDo") || strings.Contains(line, "TODO") {
			var position = token.Position{
				Filename: f.filename,
				Offset:   0,
				Line:     i + 1,
				Column:   1,
			}
			f.pkg.errorfAt(position, 1, "golint/todo->find todo list, do not forget to complete it")
		}
	}

}

func (f *file) isTest() bool { return strings.HasSuffix(f.filename, "_test.go") }

func (f *file) lint() {
	//Run custom plugin checkers
	//f.RunPlugin()

	f.lintNoGoTo()
	f.lintFunParaCount()
	f.lintSwitchShouldAlwaysHasDefault()
	f.lintFileLineCount()

	f.lintStructDoc()
	f.lintFunctionSize()
	f.lintToDo()

	f.lintTOSALicense()
	f.lintTOSALineEnding()
	f.lintTOSATab()
	f.lintTOSAFuncNameLength()
	f.lintTOSACommentRatio()
	f.lintTOSALineLength()
	f.lintTOSAUTF8()

	f.lintPackageComment()
	f.lintImports()
	f.lintBlankImports()
	f.lintExported()
	f.lintNames()
	f.lintVarDecls()
	f.lintElses()
	f.lintRanges()
	f.lintErrorf()
	f.lintErrors()
	f.lintErrorStrings()
	f.lintReceiverNames()
	f.lintIncDec()
	f.lintErrorReturn()
	f.lintUnexportedReturn()
	f.lintTimeNames()
	f.lintContextKeyTypes()
	f.lintContextArgs()
}

type link string
type category string

// The variadic arguments may start with link and category types,
// and must end with a format string and any arguments.
// It returns the new Problem.
func (f *file) errorf(n ast.Node, confidence float64, args ...interface{}) *Problem {
	pos := f.fset.Position(n.Pos())
	if pos.Filename == "" {
		pos.Filename = f.filename
	}
	return f.pkg.errorfAt(pos, confidence, args...)
}

func (p *pkg) errorfAt(pos token.Position, confidence float64, args ...interface{}) *Problem {
	problem := Problem{
		Position:   pos,
		Confidence: confidence,
	}
	if pos.Filename != "" {
		// The file might not exist in our mapping if a //line directive was encountered.
		if f, ok := p.files[pos.Filename]; ok {
			problem.LineText = srcLine(f.src, pos)
		}
	}

argLoop:
	for len(args) > 1 { // always leave at least the format string in args
		switch v := args[0].(type) {
		case link:
			problem.Link = string(v)
		case category:
			problem.Category = string(v)
		default:
			break argLoop
		}
		args = args[1:]
	}

	problem.Text = fmt.Sprintf(args[0].(string), args[1:]...)

	p.problems = append(p.problems, problem)
	return &p.problems[len(p.problems)-1]
}

var newImporter = func(fset *token.FileSet) types.ImporterFrom {
	return gcexportdata.NewImporter(fset, make(map[string]*types.Package))
}

func (p *pkg) typeCheck() error {
	config := &types.Config{
		// By setting a no-op error reporter, the type checker does as much work as possible.
		Error:    func(error) {},
		Importer: newImporter(p.fset),
	}
	info := &types.Info{
		Types:  make(map[ast.Expr]types.TypeAndValue),
		Defs:   make(map[*ast.Ident]types.Object),
		Uses:   make(map[*ast.Ident]types.Object),
		Scopes: make(map[ast.Node]*types.Scope),
	}
	var anyFile *file
	var astFiles []*ast.File
	for _, f := range p.files {
		anyFile = f
		astFiles = append(astFiles, f.f)
	}
	pkg, err := config.Check(anyFile.f.Name.Name, p.fset, astFiles, info)
	// Remember the typechecking info, even if config.Check failed,
	// since we will get partial information.
	p.typesPkg = pkg
	p.typesInfo = info
	return err
}

func (p *pkg) typeOf(expr ast.Expr) types.Type {
	if p.typesInfo == nil {
		return nil
	}
	return p.typesInfo.TypeOf(expr)
}

func (p *pkg) isNamedType(typ types.Type, importPath, name string) bool {
	n, ok := typ.(*types.Named)
	if !ok {
		return false
	}
	tn := n.Obj()
	return tn != nil && tn.Pkg() != nil && tn.Pkg().Path() == importPath && tn.Name() == name
}

// scopeOf returns the tightest scope encompassing id.
func (p *pkg) scopeOf(id *ast.Ident) *types.Scope {
	var scope *types.Scope
	if obj := p.typesInfo.ObjectOf(id); obj != nil {
		scope = obj.Parent()
	}
	if scope == p.typesPkg.Scope() {
		// We were given a top-level identifier.
		// Use the file-level scope instead of the package-level scope.
		pos := id.Pos()
		for _, f := range p.files {
			if f.f.Pos() <= pos && pos < f.f.End() {
				scope = p.typesInfo.Scopes[f.f]
				break
			}
		}
	}
	return scope
}

func (p *pkg) scanSortable() {
	p.sortable = make(map[string]bool)

	// bitfield for which methods exist on each type.
	const (
		Len = 1 << iota
		Less
		Swap
	)
	nmap := map[string]int{"Len": Len, "Less": Less, "Swap": Swap}
	has := make(map[string]int)
	for _, f := range p.files {
		f.walk(func(n ast.Node) bool {
			fn, ok := n.(*ast.FuncDecl)
			if !ok || fn.Recv == nil || len(fn.Recv.List) == 0 {
				return true
			}
			// TODO(dsymonds): We could check the signature to be more precise.
			recv := receiverType(fn)
			if i, ok := nmap[fn.Name.Name]; ok {
				has[recv] |= i
			}
			return false
		})
	}
	for typ, ms := range has {
		if ms == Len|Less|Swap {
			p.sortable[typ] = true
		}
	}
}

func (p *pkg) isMain() bool {
	for _, f := range p.files {
		if f.isMain() {
			return true
		}
	}
	return false
}

func (f *file) isMain() bool {
	if f.f.Name.Name == "main" {
		return true
	}
	return false
}

// created on 15 Apr
func (f *file) lintStructComment() {
	if f.isTest() {
		return
	}
	if len(f.src) == 0 {
		return
	}

	var fileContent = string(f.src)
	var sourceLen = len(fileContent)
	var commentTotalCharsCount int
	for _, comment := range f.f.Comments {
		commentTotalCharsCount += int(comment.End()) - int(comment.Pos())
	}
	var ratio = float64(commentTotalCharsCount) / float64(sourceLen)

	if int(ratio*100) < Config.CommentRatio {
		var position = token.Position{
			Filename: f.filename,
			Offset:   0,
			Line:     1,
			Column:   1,
		}
		f.pkg.errorfAt(position, 1, "tosa/comment_ratio->comment ratio is %.2f%%, should not smaller than %d%%", ratio*100, Config.CommentRatio)
	}
}

//tosa checker
func (f *file) lintTOSACommentRatio() {
	if f.isTest() {
		return
	}
	if len(f.src) == 0 {
		return
	}

	var fileContent = string(f.src)
	var sourceLen = len(fileContent)
	var commentTotalCharsCount int
	for _, comment := range f.f.Comments {
		commentTotalCharsCount += int(comment.End()) - int(comment.Pos())
	}
	var ratio = float64(commentTotalCharsCount) / float64(sourceLen)

	if int(ratio*100) < Config.CommentRatio {
		var position = token.Position{
			Filename: f.filename,
			Offset:   0,
			Line:     1,
			Column:   1,
		}
		f.pkg.errorfAt(position, 1, "tosa/comment_ratio->comment ratio is %.2f%%, should not smaller than %d%%", ratio*100, Config.CommentRatio)
	}
}

//tosa checker
func (f *file) lintTOSAFuncNameLength() {
	f.walk(func(n ast.Node) bool {
		fn, ok := n.(*ast.FuncDecl)
		if !ok {
			return true
		}
		if len(fn.Name.Name) > Config.FuncNameLength {
			f.errorf(fn.Name, 1, "tosa/fn_length->function name should not exceed %d characters", Config.FuncNameLength)
		}
		return true
	})
}

func isStartWithTab(line string) bool {
	if strings.HasPrefix(line, " *") {
		return true
	}
	for _, c := range line {
		if c == ' ' {
			return false
		} else if c != '\t' || c != ' ' {
			break
		}
	}
	return true
}

//tosa checker func
func (f *file) lintTOSATab() {
	if f.isTest() {
		return
	}

	if len(f.src) == 0 {
		return
	}
	/*for _, comment := range f.f.Comments {
		fmt.Println(strconv.FormatInt(int64(comment.Pos()), 10) + ":" + strconv.FormatInt(int64(comment.End()), 10))
	}*/

	var fileContent = string(f.src)

	split := strings.Split(fileContent, "\n")
	for i, line := range split {
		if isStartWithTab(line) == false {
			var position = token.Position{
				Filename: f.filename,
				Offset:   0,
				Line:     i + 1,
				Column:   1,
			}
			f.pkg.errorfAt(position, 1, "tosa/indent->Go source file should only use tab for indent")
		}
	}

	//for i :=0; i<len(f.f.Comments); i++{
	//fileContent = strings.Replace(fileContent, f.f.Comments[0].Text(), "", -1)
	//}

	//fmt.Println(fileContent)

}

//tosa checker func
func (f *file) lintTOSALineEnding() {
	if f.isTest() {
		return
	}

	if len(f.src) == 0 {
		return
	}

	var fileContent = string(f.src)
	if strings.Contains(fileContent, "\r") {
		var position = token.Position{
			Filename: f.filename,
			Offset:   0,
			Line:     1,
			Column:   1,
		}
		f.pkg.errorfAt(position, 1, "tosa/newline->Source file should only use LF for new line ending character")

	}
}

//tosa checker func
func (f *file) lintTOSALicense() {
	if f.isTest() {
		return
	}

	if len(f.f.Comments) == 0 || f.f.Comments[0].Pos() > f.f.Package {
		var position = token.Position{
			Filename: f.filename,
			Offset:   0,
			Line:     1,
			Column:   1,
		}
		f.pkg.errorfAt(position, 1, "tosa/license->Header should contain Tencent Opensource License")
		return
	}

	var firstComment = f.f.Comments[0]
	if strings.Contains(firstComment.Text(), "Tencent is pleased to support the open source community by making") == false {
		f.errorf(firstComment, 1, "tosa/license->Header should contain Tencent Opensource License")
	}

	//fmt.Println(f.src)
	//fmt.Println(string(f.src))

}

//tosa checker func
func (f *file) lintTOSALineLength() {
	if f.isTest() {
		return
	}
	var fileContent = string(f.src)

	split := strings.Split(fileContent, "\n")
	importSpecArr := f.f.Imports
	importSpecLineArr := make([]int, 5)
	for _, importSpec := range importSpecArr {
		importSpecLine := f.fset.Position(importSpec.Pos()).Line
		importSpecLineArr = append(importSpecLineArr, importSpecLine)
	}

	structTagLineArr := make([]int, 5)
	f.walk(func(node ast.Node) bool {
		switch v := node.(type) {
		case *ast.StructType:
			structFiledArr := v.Fields.List
			for _, filed := range structFiledArr {
				if filed.Tag != nil {
					structTagLine := f.fset.Position(filed.Pos()).Line
					structTagLineArr = append(structTagLineArr, structTagLine)
				}
			}
		}
		return true
	})
	for i, line := range split {

		// import 模块语句和struct tag不限制行长度
		if len([]rune(line)) > Config.LineLength && !contains(i+1, importSpecLineArr) && !contains(i+1, structTagLineArr) {
			var position = token.Position{
				Filename: f.filename,
				Offset:   0,
				Line:     i + 1,
				Column:   1,
			}
			f.pkg.errorfAt(position, 1, "tosa/linelength->line length[%d] should not exceed %d characters", len([]rune(line)), Config.LineLength)
		}
	}
}

//check goto
func (f *file) lintNoGoTo() {
	if f.isTest() {
		return
	}
	var fileContent = string(f.src)

	split := strings.Split(fileContent, "\n")
	for i, line := range split {
		if strings.Contains(line, "goto") && !strings.Contains(line, "//") {
			var position = token.Position{
				Filename: f.filename,
				Offset:   0,
				Line:     i + 1,
				Column:   1,
			}
			f.pkg.errorfAt(position, 1, "golint/nogoto->should not use goto")
		}
	}
}

//check file line count
func (f *file) lintFileLineCount() {
	if f.isTest() {
		return
	}
	var fileContent = string(f.src)

	split := strings.Split(fileContent, "\n")
	if len(split) > 800 {
		var position = token.Position{
			Filename: f.filename,
			Offset:   0,
			Line:     1,
			Column:   1,
		}
		f.pkg.errorfAt(position, 1, "golint/filesize->should not use goto")
	}
}

func validUTF8(buf []byte) bool {
	nBytes := 0
	for i := 0; i < len(buf); i++ {
		if nBytes == 0 {
			if (buf[i] & 0x80) != 0 { //与操作之后不为0，说明首位为1
				for (buf[i] & 0x80) != 0 {
					buf[i] <<= 1 //左移一位
					nBytes++     //记录字符共占几个字节
				}

				if nBytes < 2 || nBytes > 6 { //因为UTF8编码单字符最多不超过6个字节
					return false
				}

				nBytes-- //减掉首字节的一个计数
			}
		} else {                     //处理多字节字符
			if buf[i]&0xc0 != 0x80 { //判断多字节后面的字节是否是10开头
				return false
			}
			nBytes--
		}
	}
	return nBytes == 0
}

//tosa checker
func (f *file) lintTOSAUTF8() {
	if f.isTest() {
		return
	}

	//var isUTF8 = validUTF8(f.src)
	//utf8.FullRune(f.src)

	if utf8.FullRune(f.src) == false {
		var position = token.Position{
			Filename: f.filename,
			Offset:   0,
			Line:     1,
			Column:   1,
		}
		f.pkg.errorfAt(position, 1, "tosa/utf8->file encodings should be UTF8")

	}
}

// lintPackageComment checks package comments. It complains if
// there is no package comment, or if it is not of the right form.
// This has a notable false positive in that a package comment
// could rightfully appear in a different file of the same package,
// but that's not easy to fix since this linter is file-oriented.
func (f *file) lintPackageComment() {
	if f.isTest() {
		return
	}

	const ref = styleGuideBase + "#package-comments"
	prefix := "Package " + f.f.Name.Name + " "

	// Look for a detached package comment.
	// First, scan for the last comment that occurs before the "package" keyword.
	var lastCG *ast.CommentGroup
	for _, cg := range f.f.Comments {
		if cg.Pos() > f.f.Package {
			// Gone past "package" keyword.
			break
		}
		lastCG = cg
	}
	if lastCG != nil && strings.HasPrefix(lastCG.Text(), prefix) {
		endPos := f.fset.Position(lastCG.End())
		pkgPos := f.fset.Position(f.f.Package)
		if endPos.Line+1 < pkgPos.Line {
			// There isn't a great place to anchor this error;
			// the start of the blank lines between the doc and the package statement
			// is at least pointing at the location of the problem.
			pos := token.Position{
				Filename: endPos.Filename,
				// Offset not set; it is non-trivial, and doesn't appear to be needed.
				Line:   endPos.Line + 1,
				Column: 1,
			}
			//f.pkg.errorfAt(pos, 0.9, link(ref), category("comments"), "package comment is detached; there should be no blank lines between it and the package statement")
			f.pkg.errorfAt(pos, 0.9, link(ref), category("comments"), "golint/package->package注释与声明之间不应该有空行")
			return
		}
	}

	if f.f.Doc == nil {
		//f.errorf(f.f, 0.2, link(ref), category("comments"), "should have a package comment, unless it's in another file for this package")
		f.errorf(f.f, 0.2, link(ref), category("comments"), "golint/package->package需要写注释")
		return
	}
	s := f.f.Doc.Text()
	if ts := strings.TrimLeft(s, " \t"); ts != s {
		//f.errorf(f.f.Doc, 1, link(ref), category("comments"), "package comment should not have leading space")
		f.errorf(f.f.Doc, 1, link(ref), category("comments"), "golint/package->package注释开头不应该有空格")
		s = ts
	}
	// Only non-main packages need to keep to this form.
	if !f.pkg.main && !strings.HasPrefix(s, prefix) {
		//f.errorf(f.f.Doc, 1, link(ref), category("comments"), `package comment should be of the form "%s..."`, prefix)
		f.errorf(f.f.Doc, 1, link(ref), category("comments"), `golint/package->package注释应该是该种形式 %s..."`, prefix)
	}
}

// lintBlankImports complains if a non-main package has blank imports that are
// not documented.
func (f *file) lintBlankImports() {
	// In package main and in tests, we don't complain about blank imports.
	if f.pkg.main || f.isTest() {
		return
	}

	// The first element of each contiguous group of blank imports should have
	// an explanatory comment of some kind.
	for i, imp := range f.f.Imports {
		pos := f.fset.Position(imp.Pos())

		if !isBlank(imp.Name) {
			continue // Ignore non-blank imports.
		}
		if i > 0 {
			prev := f.f.Imports[i-1]
			prevPos := f.fset.Position(prev.Pos())
			if isBlank(prev.Name) && prevPos.Line+1 == pos.Line {
				continue // A subsequent blank in a group.
			}
		}

		// This is the first blank import of a group.
		if imp.Doc == nil && imp.Comment == nil {
			ref := ""
			//f.errorf(imp, 1, link(ref), category("imports"), "a blank import should be only in a main or test package, or have a comment justifying it")
			f.errorf(imp, 1, link(ref), category("imports"), "golint/package->空的import应只能在main或test package里面，或者使用注释说明")
		}
	}
}

// lintImports examines import blocks.
func (f *file) lintImports() {
	for i, is := range f.f.Imports {
		_ = i
		if is.Name != nil && is.Name.Name == "." && !f.isTest() {
			//f.errorf(is, 1, link(styleGuideBase+"#import-dot"), category("imports"), "should not use dot imports")
			f.errorf(is, 1, link(styleGuideBase+"#import-dot"), category("imports"), "golint/package->不应该使用 . imports 形式")
		}

	}
}

const docCommentsLink = styleGuideBase + "#doc-comments"

// lintExported examines the exported names.
// It complains if any required doc comments are missing,
// or if they are not of the right form. The exact rules are in
// lintFuncDoc, lintTypeDoc and lintValueSpecDoc; this function
// also tracks the GenDecl structure being traversed to permit
// doc comments for constants to be on top of the const block.
// It also complains if the names stutter when combined with
// the package name.
func (f *file) lintExported() {
	if f.isTest() {
		return
	}

	var lastGen *ast.GenDecl // last GenDecl entered.

	// Set of GenDecls that have already had missing comments flagged.
	genDeclMissingComments := make(map[*ast.GenDecl]bool)

	f.walk(func(node ast.Node) bool {
		switch v := node.(type) {
		case *ast.GenDecl:
			if v.Tok == token.IMPORT {
				return false
			}
			// token.CONST, token.TYPE or token.VAR
			lastGen = v
			return true
		case *ast.FuncDecl:
			f.lintFuncDoc(v)
			if v.Recv == nil {
				// Only check for stutter on functions, not methods.
				// Method names are not used package-qualified.
				f.checkStutter(v.Name, "func")
			}
			// Don't proceed inside funcs.
			return false
		case *ast.TypeSpec:
			// inside a GenDecl, which usually has the doc
			doc := v.Doc
			if doc == nil {
				doc = lastGen.Doc
			}
			f.lintTypeDoc(v, doc)
			f.checkStutter(v.Name, "type")
			// Don't proceed inside types.
			return false
		case *ast.ValueSpec:
			f.lintValueSpecDoc(v, lastGen, genDeclMissingComments)
			return false
		}
		return true
	})
}

var allCapsRE = regexp.MustCompile(`^[A-Z0-9_]+$`)

// knownNameExceptions is a set of names that are known to be exempt from naming checks.
// This is usually because they are constrained by having to match names in the
// standard library.
var knownNameExceptions = map[string]bool{
	"LastInsertId": true, // must match database/sql
	"kWh":          true,
}

// lintNames examines all names in the file.
// It complains if any use underscores or incorrect known initialisms.
func (f *file) lintNames() {
	// Package names need slightly different handling than other names.
	if strings.Contains(f.f.Name.Name, "_") && !strings.HasSuffix(f.f.Name.Name, "_test") {
		//f.errorf(f.f, 1, link("http://golang.org/doc/effective_go.html#package-names"), category("naming"), "don't use an underscore in package name")
		f.errorf(f.f, 1, link("http://golang.org/doc/effective_go.html#package-names"), category("naming"), "golint/package->package名称不应该有下划线")
	}

	check := func(id *ast.Ident, thing string) {
		if id.Name == "_" {
			return
		}
		if knownNameExceptions[id.Name] {
			return
		}

		// Handle two common styles from other languages that don't belong in Go.
		if len(id.Name) >= 5 && allCapsRE.MatchString(id.Name) && strings.Contains(id.Name, "_") {
			//f.errorf(id, 0.8, link(styleGuideBase+"#mixed-caps"), category("naming"), "don't use ALL_CAPS in Go names; use CamelCase")
			f.errorf(id, 0.8, link(styleGuideBase+"#mixed-caps"), category("naming"), "golint/naming->Go名称不应该使用全部大写，请使用驼峰格式")
			return
		}
		if len(id.Name) > 2 && id.Name[0] == 'k' && id.Name[1] >= 'A' && id.Name[1] <= 'Z' {
			should := string(id.Name[1]+'a'-'A') + id.Name[2:]
			//f.errorf(id, 0.8, link(styleGuideBase+"#mixed-caps"), category("naming"), "don't use leading k in Go names; %s %s should be %s", thing, id.Name, should)
			f.errorf(id, 0.8, link(styleGuideBase+"#mixed-caps"), category("naming"), "golint/naming->Go名称不应该使用k开头；%s %s应该是%s", thing, id.Name, should)
		}

		should := lintName(id.Name)
		if id.Name == should {
			return
		}

		if len(id.Name) > 2 && strings.Contains(id.Name[1:], "_") {
			//f.errorf(id, 0.9, link("http://golang.org/doc/effective_go.html#mixed-caps"), category("naming"), "don't use underscores in Go names; %s %s should be %s", thing, id.Name, should)
			f.errorf(id, 0.9, link("http://golang.org/doc/effective_go.html#mixed-caps"), category("naming"), "golint/naming->Go名称不应该使用下划线；%s %s应该是%s", thing, id.Name, should)
			return
		}
		//f.errorf(id, 0.8, link(styleGuideBase+"#initialisms"), category("naming"), "%s %s should be %s", thing, id.Name, should)
		f.errorf(id, 0.8, link(styleGuideBase+"#initialisms"), category("naming"), "golint/naming->%s %s 应该是 %s", thing, id.Name, should)
	}
	checkList := func(fl *ast.FieldList, thing string) {
		if fl == nil {
			return
		}
		for _, f := range fl.List {
			for _, id := range f.Names {
				check(id, thing)
			}
		}
	}
	f.walk(func(node ast.Node) bool {
		switch v := node.(type) {
		case *ast.AssignStmt:
			if v.Tok == token.ASSIGN {
				return true
			}
			for _, exp := range v.Lhs {
				if id, ok := exp.(*ast.Ident); ok {
					check(id, "var")
				}
			}
		case *ast.FuncDecl:
			if f.isTest() && (strings.HasPrefix(v.Name.Name, "Example") || strings.HasPrefix(v.Name.Name, "Test") || strings.HasPrefix(v.Name.Name, "Benchmark")) {
				return true
			}

			thing := "func"
			if v.Recv != nil {
				thing = "method"
			}

			// Exclude naming warnings for functions that are exported to C but
			// not exported in the Go API.
			// See https://github.com/golang/lint/issues/144.
			if ast.IsExported(v.Name.Name) || !isCgoExported(v) {
				check(v.Name, thing)
			}

			checkList(v.Type.Params, thing+" parameter")
			checkList(v.Type.Results, thing+" result")
		case *ast.GenDecl:
			if v.Tok == token.IMPORT {
				return true
			}
			var thing string
			switch v.Tok {
			case token.CONST:
				thing = "const"
			case token.TYPE:
				thing = "type"
			case token.VAR:
				thing = "var"
			}
			for _, spec := range v.Specs {
				switch s := spec.(type) {
				case *ast.TypeSpec:
					check(s.Name, thing)
				case *ast.ValueSpec:
					for _, id := range s.Names {
						check(id, thing)
					}
				}
			}
		case *ast.InterfaceType:
			// Do not check interface method names.
			// They are often constrainted by the method names of concrete types.
			for _, x := range v.Methods.List {
				ft, ok := x.Type.(*ast.FuncType)
				if !ok { // might be an embedded interface name
					continue
				}
				checkList(ft.Params, "interface method parameter")
				checkList(ft.Results, "interface method result")
			}
		case *ast.RangeStmt:
			if v.Tok == token.ASSIGN {
				return true
			}
			if id, ok := v.Key.(*ast.Ident); ok {
				check(id, "range var")
			}
			if id, ok := v.Value.(*ast.Ident); ok {
				check(id, "range var")
			}
		case *ast.StructType:
			for _, f := range v.Fields.List {
				for _, id := range f.Names {
					check(id, "struct field")
				}
			}
		}
		return true
	})
}

// lintName returns a different name if it should be different.
func lintName(name string) (should string) {
	// Fast path for simple cases: "_" and all lowercase.
	if name == "_" {
		return name
	}
	allLower := true
	for _, r := range name {
		if !unicode.IsLower(r) {
			allLower = false
			break
		}
	}
	if allLower {
		return name
	}

	// Split camelCase at any lower->upper transition, and split on underscores.
	// Check each word for common initialisms.
	runes := []rune(name)
	w, i := 0, 0 // index of start of word, scan
	for i+1 <= len(runes) {
		eow := false // whether we hit the end of a word
		if i+1 == len(runes) {
			eow = true
		} else if runes[i+1] == '_' {
			// underscore; shift the remainder forward over any run of underscores
			eow = true
			n := 1
			for i+n+1 < len(runes) && runes[i+n+1] == '_' {
				n++
			}

			// Leave at most one underscore if the underscore is between two digits
			if i+n+1 < len(runes) && unicode.IsDigit(runes[i]) && unicode.IsDigit(runes[i+n+1]) {
				n--
			}

			copy(runes[i+1:], runes[i+n+1:])
			runes = runes[:len(runes)-n]
		} else if unicode.IsLower(runes[i]) && !unicode.IsLower(runes[i+1]) {
			// lower->non-lower
			eow = true
		}
		i++
		if !eow {
			continue
		}

		// [w,i) is a word.
		word := string(runes[w:i])
		if u := strings.ToUpper(word); commonInitialisms[u] {
			// Keep consistent case, which is lowercase only at the start.
			if w == 0 && unicode.IsLower(runes[w]) {
				u = strings.ToLower(u)
			}
			// All the common initialisms are ASCII,
			// so we can replace the bytes exactly.
			copy(runes[w:], []rune(u))
		} else if w > 0 && strings.ToLower(word) == word {
			// already all lowercase, and not the first word, so uppercase the first character.
			runes[w] = unicode.ToUpper(runes[w])
		}
		w = i
	}
	return string(runes)
}

// commonInitialisms is a set of common initialisms.
// Only add entries that are highly unlikely to be non-initialisms.
// For instance, "ID" is fine (Freudian code is rare), but "AND" is not.
var commonInitialisms = map[string]bool{
	"ACL":   true,
	"API":   true,
	"ASCII": true,
	"CPU":   true,
	"CSS":   true,
	"DNS":   true,
	"EOF":   true,
	"GUID":  true,
	"HTML":  true,
	"HTTP":  true,
	"HTTPS": true,
	"ID":    true,
	"IP":    true,
	"JSON":  true,
	"LHS":   true,
	"QPS":   true,
	"RAM":   true,
	"RHS":   true,
	"RPC":   true,
	"SLA":   true,
	"SMTP":  true,
	"SQL":   true,
	"SSH":   true,
	"TCP":   true,
	"TLS":   true,
	"TTL":   true,
	"UDP":   true,
	"UI":    true,
	"UID":   true,
	"UUID":  true,
	"URI":   true,
	"URL":   true,
	"UTF8":  true,
	"VM":    true,
	"XML":   true,
	"XMPP":  true,
	"XSRF":  true,
	"XSS":   true,
}

// lintTypeDoc examines the doc comment on a type.
// It complains if they are missing from an exported type,
// or if they are not of the standard form.
func (f *file) lintTypeDoc(t *ast.TypeSpec, doc *ast.CommentGroup) {
	if !ast.IsExported(t.Name.Name) {
		return
	}
	if doc == nil {
		//f.errorf(t, 1, link(docCommentsLink), category("comments"), "exported type %v should have comment or be unexported", t.Name)
		f.errorf(t, 1, link(docCommentsLink), category("comments"), "golint/comment->exported类型变量 %v 应该有注释，或者改成非exported类型", t.Name)
		return
	}

	s := doc.Text()
	articles := [...]string{"A", "An", "The"}
	for _, a := range articles {
		if strings.HasPrefix(s, a+" ") {
			s = s[len(a)+1:]
			break
		}
	}
	if !strings.HasPrefix(s, t.Name.Name+" ") {
		//f.errorf(doc, 1, link(docCommentsLink), category("comments"), `comment on exported type %v should be of the form "%v ..." (with optional leading article)`, t.Name, t.Name)
		f.errorf(doc, 1, link(docCommentsLink), category("comments"), `golint/comment->在exported类型 %v的注释，形式应该是%v ...`, t.Name, t.Name)
	}
}

var commonMethods = map[string]bool{
	"Error":     true,
	"Read":      true,
	"ServeHTTP": true,
	"String":    true,
	"Write":     true,
}

// lintFuncDoc examines doc comments on functions and methods.
// It complains if they are missing, or not of the right form.
// It has specific exclusions for well-known methods (see commonMethods above).
func (f *file) lintFuncDoc(fn *ast.FuncDecl) {
	if !ast.IsExported(fn.Name.Name) {
		// func is unexported
		return
	}
	kind := "function"
	name := fn.Name.Name
	if fn.Recv != nil && len(fn.Recv.List) > 0 {
		// method
		kind = "method"
		recv := receiverType(fn)
		if !ast.IsExported(recv) {
			// receiver is unexported
			return
		}
		if commonMethods[name] {
			return
		}
		switch name {
		case "Len", "Less", "Swap":
			if f.pkg.sortable[recv] {
				return
			}
		}
		name = recv + "." + name
	}
	if fn.Doc == nil {
		//f.errorf(fn, 1, link(docCommentsLink), category("comments"), "exported %s %s should have comment or be unexported", kind, name)
		f.errorf(fn, 1, link(docCommentsLink), category("comments"), "golint/comment->exported类型 %s %s应该有注释，或者设置为unexported类型", kind, name)
		return
	}
	s := fn.Doc.Text()
	prefix := fn.Name.Name + " "
	if !strings.HasPrefix(s, prefix) {
		f.errorf(fn.Doc, 1, link(docCommentsLink), category("comments"), `golint/comment->在exported类型%s %s的注释，形式应该是%s…`, kind, name, prefix)
	}
}

func (f *file) lintStructDoc() {
	//var inGenDecl = false
	var genDeclComment *ast.CommentGroup
	var genDeclPos token.Position

	f.walk(func(node ast.Node) bool {

		switch v := node.(type) {

		case *ast.GenDecl:
			genDeclComment = nil
			if v.Tok == token.TYPE {
				genDeclPos = f.fset.Position(v.TokPos)
				//fmt.Printf("find gendecl, pos %d\n", genDeclPos.Line)
				genDeclComment = v.Doc

			}

		case *ast.FuncDecl:
			funcName := []rune(v.Name.Name)
			if v.Doc == nil && unicode.IsUpper(funcName[0]) && !strings.HasPrefix(string(funcName), "Test") {
				f.errorf(v, 1, "golint/funccomment->导出函数需要有注释说明")
			}

		case *ast.InterfaceType:
			interfacePos := f.fset.Position(v.Interface)
			if interfacePos.Line == genDeclPos.Line && genDeclComment == nil {
				f.errorf(v, 1, "golint/interfacecomment->接口需要有注释说明")
			}
			//fmt.Printf("find interface, pos %d\n", interfacePos.Line)

		case *ast.StructType:
			structPos := f.fset.Position(v.Struct)

			var fileContent = string(f.src)
			fileLines := strings.Split(fileContent, "\n")
			structLine := fileLines[structPos.Line-1]
			structLineArr := strings.Fields(structLine)
			var structName string
			if structLineArr[0] == "type" {
				structName = structLineArr[1]
			} else {
				structName = structLineArr[0]
			}

			structNameArr := []rune(structName)

			if unicode.IsUpper(structNameArr[0]) && structPos.Line == genDeclPos.Line && genDeclComment == nil {
				f.errorf(v, 1, "golint/structcomment->导出结构体需要有注释说明")
			}
			//fmt.Printf("find struct at %d\n", f.fset.Position(v.Struct).Line)

		case *ast.Ident:
			if v.Obj != nil && v.Obj.Kind == ast.Con {
				if strings.ToUpper(v.Name) != v.Name {
					f.errorf(v, 1, "golint/convar->常量[%s]需要全部大写", v.Name)
				}
			}

		case *ast.FuncType:
			for _, para := range v.Params.List {
				for _, paraName := range para.Names {
					runeName := []rune(paraName.Name)
					if unicode.IsLower(runeName[0]) == false && runeName[0] != '_' {
						f.errorf(v, 1, "golint/funcpara->参数[%s]的首字母需要小写", paraName)
					}
					if para.Type.Pos()-1 >= 0 && int(para.Type.End()-1) < len(f.src) {
						paraTypeString := string(f.src[para.Type.Pos()-1 : para.Type.End()-1])
						if strings.Contains(paraTypeString, " map") && strings.Contains(paraTypeString, "*") {
							f.errorf(v, 1, "golint/noptr->不建议map类型使用指针类型")
						}
						if strings.Contains(paraTypeString, " chan") && strings.Contains(paraTypeString, "*") {
							f.errorf(v, 1, "golint/noptr->不建议chan类型使用指针类型")
						}
					}
				}
			}

			if v.Results != nil && v.Results.List != nil {
				for _, resultPara := range v.Results.List {
					//resultName := resultPara.Names[0].Name
					for _, resultName := range resultPara.Names {
						runeName := []rune(resultName.Name)
						if unicode.IsLower(runeName[0]) == false {
							f.errorf(v, 1, "golint/funcret->返回值参数[%s]首字母需要小写", resultName)
						}
					}
				}
			}

		}
		return true
	})
}

// lintValueSpecDoc examines package-global variables and constants.
// It complains if they are not individually declared,
// or if they are not suitably documented in the right form (unless they are in a block that is commented).
func (f *file) lintValueSpecDoc(vs *ast.ValueSpec, gd *ast.GenDecl, genDeclMissingComments map[*ast.GenDecl]bool) {
	kind := "var"
	if gd.Tok == token.CONST {
		kind = "const"
	}

	if len(vs.Names) > 1 {
		// Check that none are exported except for the first.
		for _, n := range vs.Names[1:] {
			if ast.IsExported(n.Name) {
				//f.errorf(vs, 1, category("comments"), "exported %s %s should have its own declaration", kind, n.Name)
				f.errorf(vs, 1, category("comments"), "golint/comment->exported类型%s %s应该有它自己的声明", kind, n.Name)
				return
			}
		}
	}

	// Only one name.
	name := vs.Names[0].Name
	if !ast.IsExported(name) {
		return
	}

	if vs.Doc == nil && gd.Doc == nil {
		if genDeclMissingComments[gd] {
			return
		}
		block := ""
		if kind == "const" && gd.Lparen.IsValid() {
			block = " (or a comment on this block)"
		}
		//f.errorf(vs, 1, link(docCommentsLink), category("comments"), "exported %s %s should have comment%s or be unexported", kind, name, block)
		f.errorf(vs, 1, link(docCommentsLink), category("comments"), "golint/comment->exported类型 %s %s应该有注释%s，或者设置为unexported类型", kind, name, block)
		genDeclMissingComments[gd] = true
		return
	}
	// If this GenDecl has parens and a comment, we don't check its comment form.
	if gd.Lparen.IsValid() && gd.Doc != nil {
		return
	}
	// The relevant text to check will be on either vs.Doc or gd.Doc.
	// Use vs.Doc preferentially.
	doc := vs.Doc
	if doc == nil {
		doc = gd.Doc
	}
	prefix := name + " "
	if !strings.HasPrefix(doc.Text(), prefix) {
		//f.errorf(doc, 1, link(docCommentsLink), category("comments"), `comment on exported %s %s should be of the form "%s..."`, kind, name, prefix)
		f.errorf(doc, 1, link(docCommentsLink), category("comments"), `golint/comment->在exported类型%s %s的注释，形式应该是"%s..."`, kind, name, prefix)
	}
}

func (f *file) checkStutter(id *ast.Ident, thing string) {
	pkg, name := f.f.Name.Name, id.Name
	if !ast.IsExported(name) {
		// unexported name
		return
	}
	// A name stutters if the package name is a strict prefix
	// and the next character of the name starts a new word.
	if len(name) <= len(pkg) {
		// name is too short to stutter.
		// This permits the name to be the same as the package name.
		return
	}
	if !strings.EqualFold(pkg, name[:len(pkg)]) {
		return
	}
	// We can assume the name is well-formed UTF-8.
	// If the next rune after the package name is uppercase or an underscore
	// the it's starting a new word and thus this name stutters.
	rem := name[len(pkg):]
	if next, _ := utf8.DecodeRuneInString(rem); next == '_' || unicode.IsUpper(next) {
		//f.errorf(id, 0.8, link(styleGuideBase+"#package-names"), category("naming"), "%s name will be used as %s.%s by other packages, and that stutters; consider calling this %s", thing, pkg, name, rem)
		f.errorf(id, 0.8, link(styleGuideBase+"#package-names"), category("naming"), "golint/naming->%s 名称会被其他packages以 %s.%s引用，可以考虑这样调用 %s", thing, pkg, name, rem)
	}
}

// zeroLiteral is a set of ast.BasicLit values that are zero values.
// It is not exhaustive.
var zeroLiteral = map[string]bool{
	"false": true, // bool
	// runes
	`'\x00'`: true,
	`'\000'`: true,
	// strings
	`""`: true,
	"``": true,
	// numerics
	"0":   true,
	"0.":  true,
	"0.0": true,
	"0i":  true,
}

// lintVarDecls examines variable declarations. It complains about declarations with
// redundant LHS types that can be inferred from the RHS.
func (f *file) lintVarDecls() {
	var lastGen *ast.GenDecl // last GenDecl entered.

	f.walk(func(node ast.Node) bool {
		switch v := node.(type) {
		case *ast.GenDecl:
			if v.Tok != token.CONST && v.Tok != token.VAR {
				return false
			}
			lastGen = v
			return true
		case *ast.ValueSpec:
			if lastGen.Tok == token.CONST {
				return false
			}
			if len(v.Names) > 1 || v.Type == nil || len(v.Values) == 0 {
				return false
			}
			rhs := v.Values[0]
			// An underscore var appears in a common idiom for compile-time interface satisfaction,
			// as in "var _ Interface = (*Concrete)(nil)".
			if isIdent(v.Names[0], "_") {
				return false
			}
			// If the RHS is a zero value, suggest dropping it.
			zero := false
			if lit, ok := rhs.(*ast.BasicLit); ok {
				zero = zeroLiteral[lit.Value]
			} else if isIdent(rhs, "nil") {
				zero = true
			}
			if zero {
				//f.errorf(rhs, 0.9, category("zero-value"), "should drop = %s from declaration of var %s; it is the zero value", f.render(rhs), v.Names[0])
				f.errorf(rhs, 0.9, category("zero-value"), "golint/decl->应该丢弃 = %s，从变量%s声明中；它的值为0 ", f.render(rhs), v.Names[0])
				return false
			}
			lhsTyp := f.pkg.typeOf(v.Type)
			rhsTyp := f.pkg.typeOf(rhs)

			if !validType(lhsTyp) || !validType(rhsTyp) {
				// Type checking failed (often due to missing imports).
				return false
			}

			if !types.Identical(lhsTyp, rhsTyp) {
				// Assignment to a different type is not redundant.
				return false
			}

			// The next three conditions are for suppressing the warning in situations
			// where we were unable to typecheck.

			// If the LHS type is an interface, don't warn, since it is probably a
			// concrete type on the RHS. Note that our feeble lexical check here
			// will only pick up interface{} and other literal interface types;
			// that covers most of the cases we care to exclude right now.
			if _, ok := v.Type.(*ast.InterfaceType); ok {
				return false
			}
			// If the RHS is an untyped const, only warn if the LHS type is its default type.
			if defType, ok := f.isUntypedConst(rhs); ok && !isIdent(v.Type, defType) {
				return false
			}

			//f.errorf(v.Type, 0.8, category("type-inference"), "should omit type %s from declaration of var %s; it will be inferred from the right-hand side", f.render(v.Type), v.Names[0])
			f.errorf(v.Type, 0.8, category("type-inference"), "golint/decl->可以省略类型%s，因为该类型可以从变量%s的声明语句中的右值推导出来", f.render(v.Type), v.Names[0])
			return false
		}
		return true
	})
}

func validType(T types.Type) bool {
	return T != nil &&
		T != types.Typ[types.Invalid] &&
		!strings.Contains(T.String(), "invalid type") // good but not foolproof
}

// lintElses examines else blocks. It complains about any else block whose if block ends in a return.
func (f *file) lintElses() {
	// We don't want to flag if { } else if { } else { } constructions.
	// They will appear as an IfStmt whose Else field is also an IfStmt.
	// Record such a node so we ignore it when we visit it.
	ignore := make(map[*ast.IfStmt]bool)

	f.walk(func(node ast.Node) bool {
		ifStmt, ok := node.(*ast.IfStmt)
		if !ok || ifStmt.Else == nil {
			return true
		}
		if ignore[ifStmt] {
			return true
		}
		if elseif, ok := ifStmt.Else.(*ast.IfStmt); ok {
			ignore[elseif] = true
			return true
		}
		if _, ok := ifStmt.Else.(*ast.BlockStmt); !ok {
			// only care about elses without conditions
			return true
		}
		if len(ifStmt.Body.List) == 0 {
			return true
		}
		shortDecl := false // does the if statement have a ":=" initialization statement?
		if ifStmt.Init != nil {
			if as, ok := ifStmt.Init.(*ast.AssignStmt); ok && as.Tok == token.DEFINE {
				shortDecl = true
			}
		}
		lastStmt := ifStmt.Body.List[len(ifStmt.Body.List)-1]
		if _, ok := lastStmt.(*ast.ReturnStmt); ok {
			extra := ""
			if shortDecl {
				extra = " (move short variable declaration to its own line if necessary)"
			}
			//f.errorf(ifStmt.Else, 1, link(styleGuideBase+"#indent-error-flow"), category("indent"), "if block ends with a return statement, so drop this else and outdent its block"+extra)
			f.errorf(ifStmt.Else, 1, link(styleGuideBase+"#indent-error-flow"), category("indent"), "golint/ret->if语块以return语句结束，那么可以删去else分支并将else内的语句移到if语块外"+extra)
		}
		return true
	})
}

// lintRanges examines range clauses. It complains about redundant constructions.
func (f *file) lintRanges() {
	f.walk(func(node ast.Node) bool {
		rs, ok := node.(*ast.RangeStmt)
		if !ok {
			return true
		}
		if rs.Value == nil {
			// for x = range m { ... }
			return true // single var form
		}
		if !isIdent(rs.Value, "_") {
			// for ?, y = range m { ... }
			return true
		}

		//p := f.errorf(rs.Value, 1, category("range-loop"), "should omit 2nd value from range; this loop is equivalent to `for %s %s range ...`", f.render(rs.Key), rs.Tok)
		p := f.errorf(rs.Value, 1, category("range-loop"), "golint/equivalent->应该省略range的第二个值；这个循环等效于`for %s %s range ...`", f.render(rs.Key), rs.Tok)

		newRS := *rs // shallow copy
		newRS.Value = nil
		p.ReplacementLine = f.firstLineOf(&newRS, rs)

		return true
	})
}

// lintErrorf examines errors.New and testing.Error calls. It complains if its only argument is an fmt.Sprintf invocation.
func (f *file) lintErrorf() {
	f.walk(func(node ast.Node) bool {
		ce, ok := node.(*ast.CallExpr)
		if !ok || len(ce.Args) != 1 {
			return true
		}
		isErrorsNew := isPkgDot(ce.Fun, "errors", "New")
		var isTestingError bool
		se, ok := ce.Fun.(*ast.SelectorExpr)
		if ok && se.Sel.Name == "Error" {
			if typ := f.pkg.typeOf(se.X); typ != nil {
				isTestingError = typ.String() == "*testing.T"
			}
		}
		if !isErrorsNew && !isTestingError {
			return true
		}
		arg := ce.Args[0]
		ce, ok = arg.(*ast.CallExpr)
		if !ok || !isPkgDot(ce.Fun, "fmt", "Sprintf") {
			return true
		}
		errorfPrefix := "fmt"
		if isTestingError {
			errorfPrefix = f.render(se.X)
		}
		//p := f.errorf(node, 1, category("errors"), "should replace %s(fmt.Sprintf(...)) with %s.Errorf(...)", f.render(se), errorfPrefix)
		p := f.errorf(node, 1, category("errors"), "golint/print-> %s(fmt.Sprintf(...)) 不符合要求，应该使用 %s.Errorf(...)替换之", f.render(se), errorfPrefix)

		m := f.srcLineWithMatch(ce, `^(.*)`+f.render(se)+`\(fmt\.Sprintf\((.*)\)\)(.*)$`)
		if m != nil {
			p.ReplacementLine = m[1] + errorfPrefix + ".Errorf(" + m[2] + ")" + m[3]
		}

		return true
	})
}

// lintErrors examines global error vars. It complains if they aren't named in the standard way.
func (f *file) lintErrors() {
	for _, decl := range f.f.Decls {
		gd, ok := decl.(*ast.GenDecl)
		if !ok || gd.Tok != token.VAR {
			continue
		}
		for _, spec := range gd.Specs {
			spec := spec.(*ast.ValueSpec)
			if len(spec.Names) != 1 || len(spec.Values) != 1 {
				continue
			}
			ce, ok := spec.Values[0].(*ast.CallExpr)
			if !ok {
				continue
			}
			if !isPkgDot(ce.Fun, "errors", "New") && !isPkgDot(ce.Fun, "fmt", "Errorf") {
				continue
			}

			id := spec.Names[0]
			prefix := "err"
			if id.IsExported() {
				prefix = "Err"
			}
			if !strings.HasPrefix(id.Name, prefix) {
				//f.errorf(id, 0.9, category("naming"), "error var %s should have name of the form %sFoo", id.Name, prefix)
				f.errorf(id, 0.9, category("naming"), "golint/naming->error变量%s应该以%sFoo形式命名", id.Name, prefix)
			}
		}
	}
}

func lintErrorString(s string) (isClean bool, conf float64) {
	const basicConfidence = 0.8
	const capConfidence = basicConfidence - 0.2
	first, firstN := utf8.DecodeRuneInString(s)
	last, _ := utf8.DecodeLastRuneInString(s)
	if last == '.' || last == ':' || last == '!' || last == '\n' {
		return false, basicConfidence
	}
	if unicode.IsUpper(first) {
		// People use proper nouns and exported Go identifiers in error strings,
		// so decrease the confidence of warnings for capitalization.
		if len(s) <= firstN {
			return false, capConfidence
		}
		// Flag strings starting with something that doesn't look like an initialism.
		if second, _ := utf8.DecodeRuneInString(s[firstN:]); !unicode.IsUpper(second) {
			return false, capConfidence
		}
	}
	return true, 0
}

// lintErrorStrings examines error strings.
// It complains if they are capitalized or end in punctuation or a newline.
func (f *file) lintErrorStrings() {
	f.walk(func(node ast.Node) bool {
		ce, ok := node.(*ast.CallExpr)
		if !ok {
			return true
		}
		if !isPkgDot(ce.Fun, "errors", "New") && !isPkgDot(ce.Fun, "fmt", "Errorf") {
			return true
		}
		if len(ce.Args) < 1 {
			return true
		}
		str, ok := ce.Args[0].(*ast.BasicLit)
		if !ok || str.Kind != token.STRING {
			return true
		}
		s, _ := strconv.Unquote(str.Value) // can assume well-formed Go
		if s == "" {
			return true
		}
		clean, conf := lintErrorString(s)
		if clean {
			return true
		}

		//f.errorf(str, conf, link(styleGuideBase+"#error-strings"), category("errors"),
		//	"error strings should not be capitalized or end with punctuation or a newline")
		f.errorf(str, conf, link(styleGuideBase+"#error-strings"), category("errors"),
			"golint/string->错误字符串不应该大写，或者标点符号、新行结尾")
		return true
	})
}

// lintReceiverNames examines receiver names. It complains about inconsistent
// names used for the same type and names such as "this".
func (f *file) lintReceiverNames() {
	typeReceiver := map[string]string{}
	f.walk(func(n ast.Node) bool {
		fn, ok := n.(*ast.FuncDecl)
		if !ok || fn.Recv == nil || len(fn.Recv.List) == 0 {
			return true
		}
		names := fn.Recv.List[0].Names
		if len(names) < 1 {
			return true
		}
		name := names[0].Name
		const ref = styleGuideBase + "#receiver-names"
		if name == "_" {
			//f.errorf(n, 1, link(ref), category("naming"), `receiver name should not be an underscore`)
			f.errorf(n, 1, link(ref), category("naming"), `golint/naming->receiver名称不应该有下划线，如果是不使用的，可以省略`)
			return true
		}
		if name == "this" || name == "self" {
			//f.errorf(n, 1, link(ref), category("naming"), `receiver name should be a reflection of its identity; don't use generic names such as "this" or "self"`)
			f.errorf(n, 1, link(ref), category("naming"), `golint/naming->receiver名称应该是其身份的反射；不要使用this或者self`)
			return true
		}
		recv := receiverType(fn)
		if prev, ok := typeReceiver[recv]; ok && prev != name {
			//f.errorf(n, 1, link(ref), category("naming"), "receiver name %s should be consistent with previous receiver name %s for %s", name, prev, recv)
			f.errorf(n, 1, link(ref), category("naming"), "golint/naming->receiver名称%s应该与之前的%s %s保持一致", name, prev, recv)
			return true
		}
		typeReceiver[recv] = name
		return true
	})
}

// lintIncDec examines statements that increment or decrement a variable.
// It complains if they don't use x++ or x--.
func (f *file) lintIncDec() {
	f.walk(func(n ast.Node) bool {
		as, ok := n.(*ast.AssignStmt)
		if !ok {
			return true
		}
		if len(as.Lhs) != 1 {
			return true
		}
		if !isOne(as.Rhs[0]) {
			return true
		}
		var suffix string
		switch as.Tok {
		case token.ADD_ASSIGN:
			suffix = "++"
		case token.SUB_ASSIGN:
			suffix = "--"
		default:
			return true
		}
		//f.errorf(as, 0.8, category("unary-op"), "should replace %s with %s%s", f.render(as), f.render(as.Lhs[0]), suffix)
		f.errorf(as, 0.8, category("unary-op"), "golint/replace->可以将%s写成%s%s", f.render(as), f.render(as.Lhs[0]), suffix)
		return true
	})
}

// lintErrorReturn examines function declarations that return an error.
// It complains if the error isn't the last parameter.
func (f *file) lintErrorReturn() {
	f.walk(func(n ast.Node) bool {
		fn, ok := n.(*ast.FuncDecl)
		if !ok || fn.Type.Results == nil {
			return true
		}
		ret := fn.Type.Results.List
		if len(ret) <= 1 {
			return true
		}
		// An error return parameter should be the last parameter.
		// Flag any error parameters found before the last.
		for _, r := range ret[:len(ret)-1] {
			if isIdent(r.Type, "error") {
				//f.errorf(fn, 0.9, category("arg-order"), "error should be the last type when returning multiple items")
				f.errorf(fn, 0.9, category("arg-order"), "golint/ret->当返回多个值时，错误值应该放到最后")
				break // only flag one
			}
		}
		return true
	})
}

// lintUnexportedReturn examines exported function declarations.
// It complains if any return an unexported type.
func (f *file) lintUnexportedReturn() {
	f.walk(func(n ast.Node) bool {
		fn, ok := n.(*ast.FuncDecl)
		if !ok {
			return true
		}
		if fn.Type.Results == nil {
			return false
		}
		if !fn.Name.IsExported() {
			return false
		}
		thing := "func"
		if fn.Recv != nil && len(fn.Recv.List) > 0 {
			thing = "method"
			if !ast.IsExported(receiverType(fn)) {
				// Don't report exported methods of unexported types,
				// such as private implementations of sort.Interface.
				return false
			}
		}
		for _, ret := range fn.Type.Results.List {
			typ := f.pkg.typeOf(ret.Type)
			if exportedType(typ) {
				continue
			}
			//f.errorf(ret.Type, 0.8, category("unexported-type-in-api"),
			//	"exported %s %s returns unexported type %s, which can be annoying to use",
			//	thing, fn.Name.Name, typ)
			f.errorf(ret.Type, 0.8, category("unexported-type-in-api"),
				"golint/ret->exported类型 %s %s 返回unexported类型 %s，这会造成使用上的困扰",
				thing, fn.Name.Name, typ)
			break // only flag one
		}
		return false
	})
}

// exportedType reports whether typ is an exported type.
// It is imprecise, and will err on the side of returning true,
// such as for composite types.
func exportedType(typ types.Type) bool {
	switch T := typ.(type) {
	case *types.Named:
		// Builtin types have no package.
		return T.Obj().Pkg() == nil || T.Obj().Exported()
	case *types.Map:
		return exportedType(T.Key()) && exportedType(T.Elem())
	case interface {
		Elem() types.Type
	}: // array, slice, pointer, chan
		return exportedType(T.Elem())
	}
	// Be conservative about other types, such as struct, interface, etc.
	return true
}

// timeSuffixes is a list of name suffixes that imply a time unit.
// This is not an exhaustive list.
var timeSuffixes = []string{
	"Sec", "Secs", "Seconds",
	"Msec", "Msecs",
	"Milli", "Millis", "Milliseconds",
	"Usec", "Usecs", "Microseconds",
	"MS", "Ms",
}

func (f *file) lintTimeNames() {
	f.walk(func(node ast.Node) bool {
		v, ok := node.(*ast.ValueSpec)
		if !ok {
			return true
		}
		for _, name := range v.Names {
			origTyp := f.pkg.typeOf(name)
			// Look for time.Duration or *time.Duration;
			// the latter is common when using flag.Duration.
			typ := origTyp
			if pt, ok := typ.(*types.Pointer); ok {
				typ = pt.Elem()
			}
			if !f.pkg.isNamedType(typ, "time", "Duration") {
				continue
			}
			suffix := ""
			for _, suf := range timeSuffixes {
				if strings.HasSuffix(name.Name, suf) {
					suffix = suf
					break
				}
			}
			if suffix == "" {
				continue
			}
			//f.errorf(v, 0.9, category("time"), "var %s is of type %v; don't use unit-specific suffix %q", name.Name, origTyp, suffix)
			f.errorf(v, 0.9, category("time"), "golint/type->var %s 是类型 %v，不要使用unit-specific后缀 %q", name.Name, origTyp, suffix)
		}
		return true
	})
}

// lintContextKeyTypes checks for call expressions to context.WithValue with
// basic types used for the key argument.
// See: https://golang.org/issue/17293
func (f *file) lintContextKeyTypes() {
	f.walk(func(node ast.Node) bool {
		switch node := node.(type) {
		case *ast.CallExpr:
			f.checkContextKeyType(node)
		}

		return true
	})
}

// checkContextKeyType reports an error if the call expression calls
// context.WithValue with a key argument of basic type.
func (f *file) checkContextKeyType(x *ast.CallExpr) {
	sel, ok := x.Fun.(*ast.SelectorExpr)
	if !ok {
		return
	}
	pkg, ok := sel.X.(*ast.Ident)
	if !ok || pkg.Name != "context" {
		return
	}
	if sel.Sel.Name != "WithValue" {
		return
	}

	// key is second argument to context.WithValue
	if len(x.Args) != 3 {
		return
	}
	key := f.pkg.typesInfo.Types[x.Args[1]]

	if ktyp, ok := key.Type.(*types.Basic); ok && ktyp.Kind() != types.Invalid {
		//f.errorf(x, 1.0, category("context"), fmt.Sprintf("should not use basic type %s as key in context.WithValue", key.Type))
		f.errorf(x, 1.0, category("context"), fmt.Sprintf("golint/type->不应该使用基础类型 %s 作为context.WithValue的key", key.Type))
	}
}

// lintContextArgs examines function declarations that contain an
// argument with a type of context.Context
// It complains if that argument isn't the first parameter.
func (f *file) lintContextArgs() {
	f.walk(func(n ast.Node) bool {
		fn, ok := n.(*ast.FuncDecl)
		if !ok || len(fn.Type.Params.List) <= 1 {
			return true
		}
		// A context.Context should be the first parameter of a function.
		// Flag any that show up after the first.
		for _, arg := range fn.Type.Params.List[1:] {
			if isPkgDot(arg.Type, "context", "Context") {
				//f.errorf(fn, 0.9, link("https://golang.org/pkg/context/"), category("arg-order"), "context.Context should be the first parameter of a function")
				f.errorf(fn, 0.9, link("https://golang.org/pkg/context/"), category("arg-order"), "golint/args->context.Context应该是函数的第一个参数")
				break // only flag one
			}
		}
		return true
	})
}

// receiverType returns the named type of the method receiver, sans "*",
// or "invalid-type" if fn.Recv is ill formed.
func receiverType(fn *ast.FuncDecl) string {
	switch e := fn.Recv.List[0].Type.(type) {
	case *ast.Ident:
		return e.Name
	case *ast.StarExpr:
		if id, ok := e.X.(*ast.Ident); ok {
			return id.Name
		}
	}
	// The parser accepts much more than just the legal forms.
	return "invalid-type"
}

func (f *file) walk(fn func(ast.Node) bool) {
	ast.Walk(walker(fn), f.f)
}

func (f *file) render(x interface{}) string {
	var buf bytes.Buffer
	if err := printer.Fprint(&buf, f.fset, x); err != nil {
		panic(err)
	}
	return buf.String()
}

func (f *file) debugRender(x interface{}) string {
	var buf bytes.Buffer
	if err := ast.Fprint(&buf, f.fset, x, nil); err != nil {
		panic(err)
	}
	return buf.String()
}

// walker adapts a function to satisfy the ast.Visitor interface.
// The function return whether the walk should proceed into the node's children.
type walker func(ast.Node) bool

func (w walker) Visit(node ast.Node) ast.Visitor {
	if w(node) {
		return w
	}
	return nil
}

func isIdent(expr ast.Expr, ident string) bool {
	id, ok := expr.(*ast.Ident)
	return ok && id.Name == ident
}

// isBlank returns whether id is the blank identifier "_".
// If id == nil, the answer is false.
func isBlank(id *ast.Ident) bool { return id != nil && id.Name == "_" }

func isPkgDot(expr ast.Expr, pkg, name string) bool {
	sel, ok := expr.(*ast.SelectorExpr)
	return ok && isIdent(sel.X, pkg) && isIdent(sel.Sel, name)
}

func isZero(expr ast.Expr) bool {
	lit, ok := expr.(*ast.BasicLit)
	return ok && lit.Kind == token.INT && lit.Value == "0"
}

func isOne(expr ast.Expr) bool {
	lit, ok := expr.(*ast.BasicLit)
	return ok && lit.Kind == token.INT && lit.Value == "1"
}

func isCgoExported(f *ast.FuncDecl) bool {
	if f.Recv != nil || f.Doc == nil {
		return false
	}

	cgoExport := regexp.MustCompile(fmt.Sprintf("(?m)^//export %s$", regexp.QuoteMeta(f.Name.Name)))
	for _, c := range f.Doc.List {
		if cgoExport.MatchString(c.Text) {
			return true
		}
	}
	return false
}

var basicTypeKinds = map[types.BasicKind]string{
	types.UntypedBool:    "bool",
	types.UntypedInt:     "int",
	types.UntypedRune:    "rune",
	types.UntypedFloat:   "float64",
	types.UntypedComplex: "complex128",
	types.UntypedString:  "string",
}

// isUntypedConst reports whether expr is an untyped constant,
// and indicates what its default type is.
// scope may be nil.
func (f *file) isUntypedConst(expr ast.Expr) (defType string, ok bool) {
	// Re-evaluate expr outside of its context to see if it's untyped.
	// (An expr evaluated within, for example, an assignment context will get the type of the LHS.)
	exprStr := f.render(expr)
	tv, err := types.Eval(f.fset, f.pkg.typesPkg, expr.Pos(), exprStr)
	if err != nil {
		return "", false
	}
	if b, ok := tv.Type.(*types.Basic); ok {
		if dt, ok := basicTypeKinds[b.Kind()]; ok {
			return dt, true
		}
	}

	return "", false
}

// firstLineOf renders the given node and returns its first line.
// It will also match the indentation of another node.
func (f *file) firstLineOf(node, match ast.Node) string {
	line := f.render(node)
	if i := strings.Index(line, "\n"); i >= 0 {
		line = line[:i]
	}
	return f.indentOf(match) + line
}

func (f *file) indentOf(node ast.Node) string {
	line := srcLine(f.src, f.fset.Position(node.Pos()))
	for i, r := range line {
		switch r {
		case ' ', '\t':
		default:
			return line[:i]
		}
	}
	return line // unusual or empty line
}

func (f *file) srcLineWithMatch(node ast.Node, pattern string) (m []string) {
	line := srcLine(f.src, f.fset.Position(node.Pos()))
	line = strings.TrimSuffix(line, "\n")
	rx := regexp.MustCompile(pattern)
	return rx.FindStringSubmatch(line)
}

// srcLine returns the complete line at p, including the terminating newline.
func srcLine(src []byte, p token.Position) string {
	// Run to end of line in both directions if not at line start/end.
	lo, hi := p.Offset, p.Offset+1
	for lo > 0 && src[lo-1] != '\n' {
		lo--
	}
	for hi < len(src) && src[hi-1] != '\n' {
		hi++
	}
	return string(src[lo:hi])
}

func contains(value int, array []int) bool {
	for _, v := range array {
		if v == value {
			return true
		}
	}
	return false
}

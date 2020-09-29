## 概述:
PHP_CodeSniffer工具用于检查PHP的编码规范。PHPCS支持包括PEAR、PSR-1、PSR-2、PSR-12等5类代码规范标准，涵盖257种告警类型。该工程以容器方式，对phpc工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

sdk：适配工具脚步路径

tool: 工具二进制路径

software: 安装包路径

third_rules: 自定义规则扩展路径

## 工具版本：

phpc: 3.4.0

## 镜像打包:
打包命令：docker build -t phpc_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：
{"projName":"DEVOPS_A6AC1784A0951044","scanPath":"/data/iegci/test_tool/test_code/codeFormatTest","whitePathList":[],"scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.temp/.*",".*/pinpoint_piggy/.*",".*/\\.git"],"incrementalFiles":[],"openCheckers":[{"checkerName":"Squiz.ControlStructures.ForEachLoopDeclaration.SpaceBeforeClose","nativeChecker":true},{"checkerName":"Squiz.WhiteSpace.ControlStructureSpacing.SpacingAfterOpen","nativeChecker":true}]}


### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.php", "/data/project/code/src/test.php"]] |
| openCheckers | 打开的规则列表 | [{"checkerName":"Squiz.ControlStructures.ForEachLoopDeclaration.SpaceBeforeClose","nativeChecker":true},{"checkerName":"Squiz.WhiteSpace.ControlStructureSpacing.SpacingAfterOpen","nativeChecker":true}] |
| checkerName | 规则名称, 参考附2 | Squiz.ControlStructures.ForEachLoopDeclaration.SpaceBeforeClose |
| nativeChecker | 是否工具默认规则 | true |

## 镜像运行:
docker run -it phpc_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"checkerName":"Generic.Yong.FilesMaxLength.NotUtf8","description":"Found not UTF-8","filePath":"/data/iegci/test_tool/test_code/codeFormatTest/testBad.php","line":2},{"checkerName":"Generic.Yong.FilesMaxLength.TooDeep","description":"Too deep in fun or if, switch, try","filePath":"/data/iegci/test_tool/test_code/codeFormatTest/testBad.php","line":8}]}

### output.json字段说明:
| 字段名 | 说明 |
| --- | --- |
| defects | 告警列表 |
| filePath | 文件路径 |
| line | 文件行 |
| checkerName | 规则名称 |
| description | 规则描述 |


### 附1：
以下为语言对应数字，如果项目存在多语言，则数字相加：
| 数字 | 对应语言 |
| --- | --- |
| 1 | cs |
| 2 | cpp |
| 4 | java |
| 8 | php |
| 16 | objectivec |
| 32 | python |
| 64 | js |
| 128 | ruby |
| 512 | go |
| 1024 | swift |
| 4096 | kotlin |

### 附2 规则对应表
| 规则名 | 规则描述 | 适用语言 |
| --- | --- | --- |
| Generic.Arrays.ArrayIndent.CloseBraceIncorrect	| Ensures that array are indented one tab stop.	| PHP |
| Generic.Arrays.ArrayIndent.CloseBraceNotNewLine	| Ensures that array are indented one tab stop.	| PHP |
| Generic.Arrays.ArrayIndent.KeyIncorrect	| Ensures that array are indented one tab stop.	| PHP |
| Generic.Arrays.DisallowLongArraySyntax.Found	| Bans the use of the PHP long array syntax.	| PHP |
| Generic.Arrays.DisallowShortArraySyntax.Found	| Bans the use of the PHP short array syntax.	| PHP |
| Generic.Classes.DuplicateClassName.Found	| Reports errors if the same class or interface name is used in multiple files.	| PHP |
| Generic.Classes.OpeningBraceSameLine.BraceOnNewLine	| Checks that the opening brace of a class/interface/trait is on the same line as the class declaration.	| PHP |
| Generic.Classes.OpeningBraceSameLine.ContentAfterBrace	| Checks that the opening brace of a class/interface/trait is on the same line as the class declaration.	| PHP |
| Generic.Classes.OpeningBraceSameLine.MissingBrace	| Checks that the opening brace of a class/interface/trait is on the same line as the class declaration.	| PHP |
| Generic.Classes.OpeningBraceSameLine.SpaceBeforeBrace	| Checks that the opening brace of a class/interface/trait is on the same line as the class declaration.	| PHP |
| Generic.CodeAnalysis.AssignmentInCondition.Found	| Detects variable assignments being made within conditions.	| PHP |
| Generic.CodeAnalysis.AssignmentInCondition.FoundInWhileCondition	| Detects variable assignments being made within conditions.	| PHP |
| Generic.CodeAnalysis.EmptyPHPStatement.EmptyPHPOpenCloseTagsDetected	| Checks against empty PHP statements.	| PHP |
| Generic.CodeAnalysis.EmptyPHPStatement.SemicolonWithoutCodeDetected	| Checks against empty PHP statements.	| PHP |
| Generic.CodeAnalysis.EmptyStatement.Detected	| This sniff class detected empty statement.	| PHP |
| Generic.CodeAnalysis.ForLoopShouldBeWhileLoop.CanSimplify	| Detects for-loops that can be simplified to a while-loop.	| PHP |
| Generic.CodeAnalysis.ForLoopWithTestFunctionCall.NotAllowed	| Detects for-loops that use a function call in the test expression.	| PHP |
| Generic.CodeAnalysis.JumbledIncrementer.Found	| Detects incrementer jumbling in for loops.	| PHP |
| Generic.CodeAnalysis.UnconditionalIfStatement.Found	| Detects unconditional if- and elseif-statements.	| PHP |
| Generic.CodeAnalysis.UnnecessaryFinalModifier.Found	| Detects unnecessary final modifiers inside of final classes.	| PHP |
| Generic.CodeAnalysis.UnusedFunctionParameter.Found	| Checks for unused function parameters.	| PHP |
| Generic.CodeAnalysis.UnusedFunctionParameter.FoundAfterLastUsed	| Checks for unused function parameters.	| PHP |
| Generic.CodeAnalysis.UnusedFunctionParameter.FoundBeforeLastUsed	| Checks for unused function parameters.	| PHP |
| Generic.CodeAnalysis.UnusedFunctionParameter.FoundInExtendedClass	| Checks for unused function parameters.	| PHP |
| Generic.CodeAnalysis.UnusedFunctionParameter.FoundInExtendedClassAfterLastUsed	| Checks for unused function parameters.	| PHP |
| Generic.CodeAnalysis.UnusedFunctionParameter.FoundInExtendedClassBeforeLastUsed	| Checks for unused function parameters.	| PHP |
| Generic.CodeAnalysis.UnusedFunctionParameter.FoundInImplementedInterface	| Checks for unused function parameters.	| PHP |
| Generic.CodeAnalysis.UnusedFunctionParameter.FoundInImplementedInterfaceAfterLastUsed	| Checks for unused function parameters.	| PHP |
| Generic.CodeAnalysis.UnusedFunctionParameter.FoundInImplementedInterfaceBeforeLastUsed	| Checks for unused function parameters.	| PHP |
| Generic.CodeAnalysis.UselessOverridingMethod.Found	| Detects unnecessary overridden methods that simply call their parent.	| PHP |
| Generic.Commenting.DocComment.ContentAfterOpen	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.ContentBeforeClose	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.Empty	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.LongNotCapital	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.MissingShort	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.NonParamGroup	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.ParamGroup	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.ParamNotFirst	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.ShortNotCapital	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.SpacingAfter	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.SpacingAfterTagGroup	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.SpacingBeforeShort	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.SpacingBeforeTags	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.SpacingBetween	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.TagValueIndent	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.DocComment.TagsNotGrouped	| Ensures doc blocks follow basic formatting.	| PHP |
| Generic.Commenting.Fixme.CommentFound	| Warns about FIXME comments.	| PHP |
| Generic.Commenting.Fixme.TaskFound	| Warns about FIXME comments.	| PHP |
| Generic.Commenting.Todo.CommentFound	| Warns about TODO comments.	| PHP |
| Generic.Commenting.Todo.TaskFound	| Warns about TODO comments.	| PHP |
| Generic.ControlStructures.InlineControlStructure.Discouraged	| Verifies that inline control statements are not present.	| PHP |
| Generic.ControlStructures.InlineControlStructure.NotAllowed	| Verifies that inline control statements are not present.	| PHP |
| Generic.Debug.CSSLint.ExternalTool	| Runs csslint on the file.	| PHP |
| Generic.Debug.ClosureLinter.ExternalTool	| Runs gjslint on the file.	| PHP |
| Generic.Debug.ClosureLinter.ExternalToolError	| Runs gjslint on the file.	| PHP |
| Generic.Debug.ESLint.ExternalTool	| Runs eslint on the file.	| PHP |
| Generic.Debug.JSHint.ExternalTool	| Runs jshint.js on the file.	| PHP |
| Generic.Files.ByteOrderMark.Found	| A simple sniff for detecting BOMs that may corrupt application work.	| PHP |
| Generic.Files.EndFileNewline.NotFound	| Ensures the file ends with a newline character.	| PHP |
| Generic.Files.EndFileNoNewline.Found	| Ensures the file does not end with a newline character.	| PHP |
| Generic.Files.InlineHTML.Found	| Ensures the whole file is PHP only, with no whitespace or inline HTML.	| PHP |
| Generic.Files.LineEndings.InvalidEOLChar	| Checks that end of line characters are correct.	| PHP |
| Generic.Files.LineLength.MaxExceeded	| Checks the length of all lines in a file.	| PHP |
| Generic.Files.LineLength.TooLong	| Checks the length of all lines in a file.	| PHP |
| Generic.Files.LowercasedFilename.NotFound	| Checks that all file names are lowercased.	| PHP |
| Generic.Files.OneClassPerFile.MultipleFound	| Checks that only one class is declared per file.	| PHP |
| Generic.Files.OneInterfacePerFile.MultipleFound	| Checks that only one interface is declared per file.	| PHP |
| Generic.Files.OneObjectStructurePerFile.MultipleFound	| Checks that only one object structure is declared per file.	| PHP |
| Generic.Files.OneTraitPerFile.MultipleFound	| Checks that only one trait is declared per file.	| PHP |
| Generic.Formatting.DisallowMultipleStatements.SameLine	| Ensures each statement is on a line by itself.	| PHP |
| Generic.Formatting.MultipleStatementAlignment.Incorrect	| Checks alignment of assignments.	| PHP |
| Generic.Formatting.MultipleStatementAlignment.IncorrectWarning	| Checks alignment of assignments.	| PHP |
| Generic.Formatting.MultipleStatementAlignment.NotSame	| Checks alignment of assignments.	| PHP |
| Generic.Formatting.MultipleStatementAlignment.NotSameWarning	| Checks alignment of assignments.	| PHP |
| Generic.Formatting.NoSpaceAfterCast.SpaceFound	| Ensures there is no space after cast tokens.	| PHP |
| Generic.Formatting.SpaceAfterCast.CommentFound	| Ensures there is a single space after cast tokens.	| PHP |
| Generic.Formatting.SpaceAfterCast.NoSpace	| Ensures there is a single space after cast tokens.	| PHP |
| Generic.Formatting.SpaceAfterCast.TooLittleSpace	| Ensures there is a single space after cast tokens.	| PHP |
| Generic.Formatting.SpaceAfterCast.TooMuchSpace	| Ensures there is a single space after cast tokens.	| PHP |
| Generic.Formatting.SpaceAfterNot.CommentFound	| Ensures there is a single space after a NOT operator.	| PHP |
| Generic.Formatting.SpaceAfterNot.Incorrect	| Ensures there is a single space after a NOT operator.	| PHP |
| Generic.Formatting.SpaceBeforeCast.NoSpace	| Ensures there is a single space before cast tokens.	| PHP |
| Generic.Formatting.SpaceBeforeCast.TooMuchSpace	| Ensures there is a single space before cast tokens.	| PHP |
| Generic.Functions.CallTimePassByReference.NotAllowed	| Ensures that variables are not passed by reference when calling a function.	| PHP |
| Generic.Functions.FunctionCallArgumentSpacing.NoSpaceAfterComma	| Checks that calls to methods and functions are spaced correctly.	| PHP |
| Generic.Functions.FunctionCallArgumentSpacing.NoSpaceAfterEquals	| Checks that calls to methods and functions are spaced correctly.	| PHP |
| Generic.Functions.FunctionCallArgumentSpacing.NoSpaceBeforeEquals	| Checks that calls to methods and functions are spaced correctly.	| PHP |
| Generic.Functions.FunctionCallArgumentSpacing.SpaceBeforeComma	| Checks that calls to methods and functions are spaced correctly.	| PHP |
| Generic.Functions.FunctionCallArgumentSpacing.TooMuchSpaceAfterComma	| Checks that calls to methods and functions are spaced correctly.	| PHP |
| Generic.Functions.OpeningFunctionBraceBsdAllman.BraceIndent	| Checks that the opening brace of a function is on the line after the function declaration.	| PHP |
| Generic.Functions.OpeningFunctionBraceBsdAllman.BraceOnSameLine	| Checks that the opening brace of a function is on the line after the function declaration.	| PHP |
| Generic.Functions.OpeningFunctionBraceBsdAllman.BraceSpacing	| Checks that the opening brace of a function is on the line after the function declaration.	| PHP |
| Generic.Functions.OpeningFunctionBraceBsdAllman.ContentAfterBrace	| Checks that the opening brace of a function is on the line after the function declaration.	| PHP |
| Generic.Functions.OpeningFunctionBraceKernighanRitchie.BraceOnNewLine	| Checks that the opening brace of a function is on the same line as the function declaration.	| PHP |
| Generic.Functions.OpeningFunctionBraceKernighanRitchie.ContentAfterBrace	| Checks that the opening brace of a function is on the same line as the function declaration.	| PHP |
| Generic.Functions.OpeningFunctionBraceKernighanRitchie.SpaceBeforeBrace	| Checks that the opening brace of a function is on the same line as the function declaration.	| PHP |
| Generic.Metrics.CyclomaticComplexity.MaxExceeded	| Checks the cyclomatic complexity (McCabe) for functions.	| PHP |
| Generic.Metrics.CyclomaticComplexity.TooHigh	| Checks the cyclomatic complexity (McCabe) for functions.	| PHP |
| Generic.Metrics.NestingLevel.MaxExceeded	| Checks the nesting level for methods.	| PHP |
| Generic.Metrics.NestingLevel.TooHigh	| Checks the nesting level for methods.	| PHP |
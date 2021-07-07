## 工具介绍

Gometalinter是一款开源的 Golang 代码检查工具，支持检查代码规范、死代码、语法错误和安全漏洞等问题。

Gometalinter中的**Golint**，适合于代码规范的落地。

目前支持的规则已经在checkers.json中进行了声明。

## 开发新规则的步骤

1、从master拉规则分支，命名建议为：story_xxx_MMdd （xxx为规则名，MMdd表示月日）

2、将规则分支代码clone到本地，推荐本地使用Goland IDE打开gometalinter工程

3、IDE工程里进入到tool/gometalinter/src/gopkg.in/alecthomas/gometalinter.v2/_linters/src/github.com/golang/lint这个目录。其中所有的golint规则都在lint.go这个文件里。

4、添加新规则的修改点，这里假设需要添加一条 golint/xyz规则：

 - (1)  新建 func (f file) lintXYZ() {} 函数（函数名自定义，没有硬性要求），在该函数里实现对语法树的检查。
 - (2)  在func (f file) lint(){} 函数中添加调用语句，如： f.lintXYZ()
 - (3)  保存代码，在linux机器中checkout这份新的工程代码（如/data/iegci/test_tool/goml_scan）。需要确保该环境有go执行命令。（如48机器的/data/codecc_software/go/bin，需要export到PATH）
 - (4)  进入到tool/gometalinter/src/gopkg.in/alecthomas/gometalinter.v2/_linters/src/github.com/golang/lint/golint目录，执行 go build即可，如遇到提示找不到依赖文件，则需要将依赖文件的路径添加到GOPATH变量中，这些依赖文件都在工程中，可以根据所提示的路径找到。
 - (5)  编译得到的golint可执行程序，需要覆盖tool/gometalinter/bin/下对应的程序。

5、在checkers.json中添加新增规则的描述。在描述时需要说明该规则对应到哪一条规范，并附上链接。规则描述示例如下：
- 单测函数行数限制也是普通函数的2倍，即为160行。即单测函数的行数，包含代码行、注释行、空白行，不得超过160行，否则需要重新评估函数的功能是否过于复杂需进行分拆。  [tencent standards/go 2.6](https://{github.com/xxxxx}/standards/go#26-%E5%BF%85%E9%A1%BB%E5%8D%95%E5%85%83%E6%B5%8B%E8%AF%95)

6、在test目录下添加**规则测试代码文件**

7、MR代码到test分支

8、执行流水线部署http://{devops.public.url}/console/pipeline/codecc-tool-auto/p-97719f2456d341c2aa8e4500c6f5f5cc

9、测试完成提合并请求到master分支

10、工具负责人austinshen审核结合第6步骤和第8步骤执行的测试样例代码检查结果，及代码检视结果，评估后正式发布到生产

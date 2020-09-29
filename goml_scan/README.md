## 概述:
Gometalinter工具集成了目前绝大多数Golang代码检查工具，精心进行了规则分类和汉化，支持检测安全问题、无用代码、最佳实践、编码规范等66种告警类型。该工程以容器方式，对Gometalinter工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

node_modules: node模块路径

sdk：适配工具脚步路径

sotfware：安装包路径

tool: 工具二进制路径

third_rules: 自定义规则扩展目录

## 工具版本：

gometalinter: v2

## 镜像打包:
打包命令：docker build -t goml_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：
{"projName":"DEVOPS_866A3D9D5DE99C24","scanPath":"/data/iegci/test_tool/test_code/rate_limit_center","whitePathList":[],"scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.git",".*/third/.*",".*/.git/.*"],"incrementalFiles":[],"openCheckers":[{"checkerName":"golint/funcret","nativeChecker":true},{"checkerName":"golint/fnsize","nativeChecker":true,"checkerOptions":[{"checkerOptionName":"fnsize","checkerOptionValue":"80"}]}]}


### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.go", "/data/project/code/src/test.go"]] |
| openCheckers | 打开的规则列表 | [{"checkerName":"golint/funcret","nativeChecker":true},{"checkerName":"golint/fnsize","nativeChecker":true,"checkerOptions":[{"checkerOptionName":"fnsize","checkerOptionValue":"80"}] |
| checkerName | 规则名称, 参考附2 | golint/funcret |
| nativeChecker | 是否工具默认规则 | true |

## 镜像运行:
docker run -it goml_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"checkerName":"golint/structcomment","description":"\u7ed3\u6784\u4f53\u9700\u8981\u6709\u6ce8\u91ca\u8bf4\u660e","filePath":"/data/iegci/test_tool/test_code/rate_limit_center/internal/dao/DCacheIndexDAO.go","line":"31"},{"checkerName":"golint/interfacecomment","description":"\u63a5\u53e3\u9700\u8981\u6709\u6ce8\u91ca\u8bf4\u660e","filePath":"/data/iegci/test_tool/test_code/rate_limit_center/internal/dao/InterfaceDAO.go","line":"34"}]}

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
| deadcode/unused	| %s 未使用的函数	| Golang |
| errcheck/retvalue	| 没有检查返回值	| Golang |
| gas/calls	| 审查不安全的调用	| Golang |
| gas/crypto	| 1、crypto/rc4已被列入import的黑名单中；<br> 2、硬编码凭证；<br> 3、crypto/md5已被列入import的黑名单中；<br> 4、使用了弱的加密方法；<br> 5、RSA Key至少应该有%d位(bits)；<br> 6、crypto/des已被列入import的黑名单中；<br> 7、使用弱的数字随机生成器（使用math/rand，而不是crypto/rand）；<br>	| Golang |
| gas/error	| 没有处理错误	| Golang |
| gas/escape	| 该方法不会自动转义HTML。验证数据格式良好。	| Golang |
| gas/file	| 在tmp目录创建文件没有使用ioutil.Tempfile	| Golang |
| gas/httpoxy	| net/http/cgi已被列入import的黑名单中：Go版本低于1.6.3容易受到Httpoxy的攻击：(CVE-2016-5386)；	| Golang |
| gas/modulus	| 检查模数是否为0	| Golang |
| gas/network	| 绑定了所有网络接口	| Golang |
| gas/permission	| 1、文件至少需要%#o的权限；<br>2、目录至少需要%#o的权限；	| Golang |
| gas/sql	| 1、使用了SQL字符拼接；<br>2、使用了SQL字符格式化；	| Golang |
| gas/subprocess	| 1、子进程启动时传入了部分路径；<br>2、检查子进程的启动；<br>3、子进程启动使用了变量参数；<br>4、子进程启动时传入了变量；	| Golang |
| gas/tls	| 1、PreferServerCipherSuites设为false；<br>2、MinVersion太低；<br>3、InsecureSkipVerify设为true；<br>4、InsecureSkipVerify可能为true；<br>5、MaxVersion太低；<br>6、MinVersion可能太低；<br>7、PreferServerCipherSuites可能为false；<br>8、MaxVersion可能太低；	| Golang |
| goconst/string	| 重复使用的字符串应提取为常量：在 %s:%d:%d:%d 也使用了字符串 "%s"，文件为： %s	| Golang |
| gofmt/notformat	| 文件没有使用 gofmt -s 格式化	| Golang |
| goimports/notimport	| 文件没有被goimport	| Golang |
| golint/args	| context.Context应该是函数的第一个参数	| Golang |
| golint/comment	| 1、exported类型%s %s应该有它自己的声明；<br>2、exported类型变量应该有注释，或者改成非exported类型；<br>3、exported类型 %s %s应该有注释%s，或者设置为unexported类型；<br>4、exported类型 %s %s应该有注释，或者设置为unexported类型；<br>5、在exported类型 %v的注释，形式应该是%v…；<br>6、在exported类型%s %s的注释，形式应该是%s…；	| Golang |
| golint/convar	| 常量需要是全部大写	| Golang |
| golint/decl	| 1、应该丢弃 = %s，从变量%s声明中；它的值为0；<br>2、应该省略类型%s，从变量%s声明中；它会从右手边推断出来；	| Golang |
| golint/equivalent	| 应该省略range的第二个值；这个循环等效于`for %s %s range ...`	| Golang |
| golint/fnsize	| 检查函数体行数（逻辑代码行+注释行）是否超过设定值，默认80行 	| Golang |
| golint/funccomment	| 函数需要有注释说明	| Golang |
| golint/funcpara	| 函数参数的首字母需要小写	| Golang |
| golint/funcret	| 函数返回参数首字母需要小写	| Golang |
| golint/interfacecomment	| 接口需要有注释说明	| Golang |
| golint/naming	| 1、%s 名称会被其他packages以 %s.%s引用，可以考虑这样调用 %s；<br>2、error变量%s应该以%sFoo形式命名；<br>3、Go名称不应该使用全部大写，请使用驼峰格式；<br>4、Go名称不应该使用k开头；%s %s应该是%s；<br>5、%s %s 应该是 %s；<br>6、receiver名称不应该有下划线，如果是不使用的，可以省略；<br>7、receiver名称应该是其身份的反射；不要使用this或者self；<br>8、receiver名称%s应该与之前的%s %s保持一致；<br>9、Go名称不应该使用下划线；%s %s应该是%s；	| Golang |
| golint/nogoto	| 业务代码禁止使用goto，其他框架或底层源码推荐尽量不用	| Golang |
| golint/noptr	| 不建议map、chan类型使用指针类型	| Golang |
| golint/package	| 1、package注释开头不应该有空格；<br>2、空的import应只能在main或test package里面，或者使用注释说明；<br>3、package需要写注释；<br>4、不应该使用 . imports 形式；<br>5、package注释与声明之间不应该有空行；<br>6、package名称不应该有下划线；<br>7、package注释应该是该种形式 %s；	| Golang |
| golint/print	| %s(fmt.Sprintf(...)) 不符合要求，应该使用 %s.Errorf(...)替换之	| Golang |
| golint/replace	| 应该替换%s以%s%s	| Golang |
| golint/ret	| 1、当返回多个值时，错误值应该放到最后；<br>2、exported类型 %s %s 返回unexported类型 %s，这会造成使用上的困扰；<br>3、if语块以return语句结束，那么可以删去else分支并将else内的语句移到if语块外；	| Golang |
| golint/string	| 错误字符串不应该大写，或者标点符号、新行结尾	| Golang |
| golint/structcomment	| 结构体需要有注释说明	| Golang |
| golint/todo	| 检测注释中出现的todo单词	| Golang |
| golint/type	| 1、不应该使用基础类型 %s 作为context.WithValue的key；<br>2、var %s 是类型 %v，不要使用unit-specific后缀 %q；	| Golang |
| gosimple/boolcmp	| 应该省略bool常量的比较，可以简化为：%s	| Golang |
| gosimple/copy	| 应该使用copy()而不是循环	| Golang |
| gosimple/for	| 应该使用for range，而不是 for select{}	| Golang |
| gosimple/sendrecv	| 应该使用简单通道的send/receive，而不是select	| Golang |
| gosimple/usageadvice	| 1、应该转换 %s(类型为%s）到%s，而不是使用struct结构；<br>2、应该使用 for {} 而不是 for true {}；<br>3、不必要的nil检查；<br>4、应该使用原生字符串 (`...`)及regexp.%s避免转义两次；<br>5、应该使用无条件的 %s.%s 来替换这个if语句；<br>6、当 %s 为true时，%s不可能为nil；<br>7、应该写 %s 而不是 %s；<br>8、应该在新的一行里合并变量的声明和赋值；<br>9、多余的break语句；<br>10、应该使用fmt.Errorf(...)，而不是errors.New(fmt.Sprintf(...))；<br>11、应该省略nil检查；%s执行len()定义为0；<br>12、应该使用%s = append(%s, %s...) 来替换循环；<br>13、使用slice时应该省略第二个index，s[a:len(s)] 等效于 s[a:]；<br>14、应该使用time.Util，而不是t.Sub(time.Now())；<br>15、应该使用%v.String()方法而不是%v；<br>16、if %s != nil { return %s }; return %s' 可以简化为 'return %s'；<br>17、'_ = <-ch' 可以简化为 '<-ch'；<br>18、应该使用 'return <expr>'，而不是 'if <expr> { return <bool> }; return <bool>'；<br>19、应该使用String()，而不是fmt.Sprintf；<br>20、应该使用%v.Bytes()方法而不是%v；<br>21、应该使用 %s%s.%s(%s)；<br>22、应该使用time.Since，而不是time.Now().Sub；<br>23、多余的return语句；<br>24、应该使用make(%s, %s)；<br>25、应该使用%sbytes.Equal(%s)；<br>26、应该使用make(%s)；<br>27、参数已经是字符串，没有必要使用fmt.Sprintf；<br>28、应该使用copy(%s[:%s], %s[%s:])；<br>29、参数的基础类型是字符串，应该使用简单的转换而不是使用fmt.Sprintf；<br>30、应该省略range的值；这个循环等效与 `for range ...`；	| Golang |
| ineffassign/assign	| 无效赋值：%s	| Golang |
| interfacer/interface	| %s 可以为 %s	| Golang |
| maligned/size	| %s：结构大小%d 可以为 %d	| Golang |
| misspell/spell	| %s 应拼写为 %s	| Golang |
| nakedret/ret	| 检查named return语句的函数体是否超过一定数值，默认是5行	| Golang |
| safesql/sql	| 潜在不安全的SQL语句	| Golang |
| staticcheck/append	| append的结果不会被使用，除非在其他的appends里	| Golang |
| staticcheck/args	| 1、参数%s在使用前被覆写了；<br>2、该函数类似print风格的函数，有第一个动态参数，但没有其他更多的参数。应该使用print风格的函数。；<br>3、io.Seeker的第一个参数是偏移值offset，但是使用了io.Seek*常量；	| Golang |
| staticcheck/assign	| 1、%s 自赋值为 %s；<br>2、赋值给nil map；<br>3、不应该赋值给%s；	| Golang |
| staticcheck/boolean	| 对于boolean类型的双重否定是没有效果的，是笔误吗？	| Golang |
| staticcheck/break	| break语句没有效果，是希望跳出外部循环吗？	| Golang |
| staticcheck/compare	| 1、比较两个不同长度的字符串是否相等，会永远返回false；<br>2、无符号数不可能 < 0；<br>3、无符号数永远 >= 0；<br>4、x %s 0的结果永远等于x；<br>5、没有数值等于NaN，即使Nan本身；<br>6、x & 0的结果永远等于 0；	| Golang |
| staticcheck/condition	| 这个条件多次出现在if/else if链中	| Golang |
| staticcheck/defer	| 1、刚好在lock之后defer %s，你是想defer %s吗？；<br>2、defer %s 前，应该先检查返回的错误码；	| Golang |
| staticcheck/deprecated	| %s 已经废弃：%s	| Golang |
| staticcheck/efficient	| m[string(key)] 可能比 k := string(key); m[k] 更加高效	| Golang |
| staticcheck/emptybranch	| 空的分支	| Golang |
| staticcheck/exec	| exec.Command的第一个参数看起来是shell命令，但是缺少了程序名或者路径	| Golang |
| staticcheck/exit	| TestMain应该调用os.Exit来设置退出码	| Golang |
| staticcheck/exp	| 1、%s操作符两边存在相同的表达式；<br>2、二元表达式永远是 %t，对于所有可能的值（%s %s %s）；	| Golang |
| staticcheck/explicit	| 只有第1个常量是显式类型	| Golang |
| staticcheck/finalizer	| finalizer closes over the object, preventing the finalizer from ever running (at %s)	| Golang |
| staticcheck/goroutine	| goroutine调用T.%s，作为测试test必须在相同的goroutine里调用	| Golang |
| staticcheck/httpheader	| 在http.Header里的keys都是规范化的，然而%q并不符合规范；修改该常量或者使用http.CanonicalHeaderKey	| Golang |
| staticcheck/infinite	| 调用了无限递归	| Golang |
| staticcheck/iowriter	| io.Writer.Write 不能修改所提供的buffer缓冲区，即使是临时性的	| Golang |
| staticcheck/loop	| 1、在range循环中，defers不会运行，除非通道被关闭；<br>2、循环变量没有变化；<br>3、循环条件一直没有变化，或者存在竞争条件；<br>4、外层循环无条件终止；<br>5、这个循环会spin，导致100%CPU的使用；<br>6、无限循环中的defers永远不会运行；<br>7、在for+select循环中不应该存在空的default case，会导致循环spin；	| Golang |
| staticcheck/overrun	| index索引超出界限（bounds）	| Golang |
| staticcheck/resource	| 空的临界区（critical section)	| Golang |
| staticcheck/return	| %s 是一个纯函数（pure function），但是它的返回值被忽略了	| Golang |
| staticcheck/routine	| 启动goroutine前应该先调用%s，以避免竞争	| Golang |
| staticcheck/signal	| 1、%s 信号不能被捕获；<br>2、%s 不能被捕获（是syscall.SIGTERM吗？）；	| Golang |
| staticcheck/simple	| 1、文件模式 %s 计算结果是 %#o；是否应该是 0%s；<br>2、&*x 可以简化为 x。这个用法不会复制x。；	| Golang |
| staticcheck/sleep	| 睡眠 %d（ns）很可能是一个bug。如果不是的话请明确下:%s	| Golang |
| staticcheck/timeticker	| 使用time.Tick在某些场景下会泄漏。可以考虑在endless function中使用，或者使用time.NewTicker。	| Golang |
| staticcheck/unused	| 这个变量%s的值不会被使用	| Golang |
| structcheck/field	| 未使用的struct字段	| Golang |
| tosa/comment_ratio	| 腾讯开源注释率要求不少于10%	| Golang |
| tosa/fn_length	| 函数名长度限制	| Golang |
| tosa/indent	| 缩进使用tab	| Golang |
| tosa/license	| 腾讯开源文件头需要包含开源协议信息	| Golang |
| tosa/linelength	| 源码每一行字符数不能超过指定阈值，默认阈值为120 	| Golang |
| tosa/newline	| 源码文件禁止使用回车字符（CR）	| Golang |
| tosa/utf8	| 文件编码必须是utf8	| Golang |
| unconvert/convert	| 不必要的转换	| Golang |
| unparam/unused	| 参数%s没有使用	| Golang |
| unparam/value	| 1、参数始终接收%v；<br>2、参数%s始终是%s；	| Golang |
| unused/unused	| %s没有被使用	| Golang |
| varcheck/unused	| 未使用的全局变量	| Golang |
| vet/vet	| 检测妨碍编译的错误	| Golang |
| vetshadow/shadow	| %q的声明覆盖了%s位置的声明	| Golang |
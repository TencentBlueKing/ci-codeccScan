## 概述:
EsLint工具是一款Javascript检查工具，使用它可以避免低级错误和统一代码风格。通过精挑细选定制出「完美」的规则配置，支持ECMAScript 6语法标准，支持React和Vue框架。。该工程以容器方式，对ESLint工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

node_modules: node模块路径

sdk：适配工具脚步路径

sotfware：安装包路径

third_rules: 自定义规则扩展目录

## 工具版本：

eslint: 6.8.0

## 镜像打包:
打包命令：docker build -t eslint_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：
{"projName":"DEVOPS_ECBDAEDFD573D23F","projectId":"a68","scanPath":"/data/iegci/test_tool/test_code/JS_test","whitePathList":[],"scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.temp/.*"],"incrementalFiles":[],"openCheckers":[{"checkerName":"@typescript-eslint/member-ordering","nativeChecker":true,"severity":1},{"checkerName":"@typescript-eslint/no-non-null-asserted-optional-chain","nativeChecker":true,"severity":1}]}


### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.js", "/data/project/code/src/test.js"]] |
| openCheckers | 打开的规则列表 | [{"checkerName":"@typescript-eslint/member-ordering","nativeChecker":true,"severity":1},{"checkerName":"@typescript-eslint/no-non-null-asserted-optional-chain","nativeChecker":true,"severity":1}] |
| checkerName | 规则名称, 参考附2 | @typescript-eslint/member-ordering |
| nativeChecker | 是否工具默认规则 | true |

## 镜像运行:
docker run -it eslint_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"checkerName":"@typescript-eslint/explicit-member-accessibility","description":"Missing accessibility modifier on method definition constructor.","filePath":"/data/iegci/test_tool/test_code/TS_rough/src/svg.ts","line":9},{"checkerName":"@typescript-eslint/explicit-member-accessibility","description":"Missing accessibility modifier on method definition draw.","filePath":"/data/iegci/test_tool/test_code/TS_rough/src/svg.ts","line":14},{"checkerName":"@typescript-eslint/explicit-member-accessibility","description":"Missing accessibility modifier on get property accessor generator.","filePath":"/data/iegci/test_tool/test_code/TS_rough/src/svg.ts","line":78}]}

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
| @typescript-eslint/adjacent-overload-signatures	| 重载的函数必须写在一起	| TS |
| @typescript-eslint/class-literal-property-style	| 类的只读属性若是一个字面量，则必须使用只读属性而不是 getter	| TS |
| @typescript-eslint/consistent-type-assertions	| 类型断言必须使用 as Type，禁止使用 <Type>，禁止对对象字面量进行类型断言（断言成 any 是允许的）	| TS |
| @typescript-eslint/explicit-member-accessibility	| 必须设置类的成员的可访问性. 将不需要公开的成员设为私有的，可以增强代码的可理解性，对文档输出也很友好	| TS |
| @typescript-eslint/member-ordering	| 指定类成员的排序规则：1. static > instance, 2. field > constructor > method， 3. public > protected > private	| TS |
| @typescript-eslint/no-empty-interface	| 禁止定义空的接口	| TS |
| @typescript-eslint/no-inferrable-types	| 禁止给一个初始化时直接赋值为 number, string 的变量显式的声明类型	| TS |
| @typescript-eslint/no-namespace	| 禁止使用 namespace 来定义命名空间	| TS |
| @typescript-eslint/no-non-null-asserted-optional-chain	| 禁止在 optional chaining 之后使用 non-null 断言（感叹号）	| TS |
| @typescript-eslint/no-require-imports	| 禁止使用 require，统一使用 import 来引入模块，特殊情况使用单行注释允许 require 引入	| TS |
| @typescript-eslint/no-this-alias	| 禁止将 this 赋值给其他变量，除非是解构赋值	| TS |
| @typescript-eslint/no-unused-expressions	| 禁止无用的表达式	| TS |
| @typescript-eslint/no-useless-constructor	| 禁止出现没必要的 constructor	| TS |
| @typescript-eslint/prefer-for-of	| 使用 for 循环遍历数组时，如果索引仅用于获取成员，则必须使用 for of 循环替代 for 循环	| TS |
| @typescript-eslint/prefer-function-type	| 使用函数类型别名替代包含函数调用声明的接口	| TS |
| @typescript-eslint/prefer-namespace-keyword	| 禁止使用 module 来定义命名空间	| TS |
| @typescript-eslint/prefer-optional-chain	| 使用 optional chaining 替代 &&	| TS |
| @typescript-eslint/triple-slash-reference	| 禁止使用三斜杠导入文件	| TS |
| @typescript-eslint/type-annotation-spacing	| 在类型注释周围需要一致的间距	| TS |
| @typescript-eslint/typedef	| interface 和 type 定义时必须声明成员的类型	| TS |
| @typescript-eslint/unified-signatures	| 函数重载时，若能通过联合类型将两个函数的类型声明合为一个，则使用联合类型而不是两个函数声明	| TS |
| accessor-pairs	| 有 setter 的地方必须有 getter，有 getter 的地方可以没有 setter	| JS |
| array-bracket-newline	| 配置数组的中括号内前后的换行格式	| JS |
| array-bracket-spacing	| 数组的括号内的前后禁止有空格	| JS |
| array-callback-return	| 数组的一些方法（map, reduce 等）的回调函数中，必须有返回值	| JS |
| array-element-newline	| 配置数组的元素之间的换行格式	| JS |
| arrow-body-style	| 箭头函数能够省略 return 的时候，必须省略，比如必须写成 () => 0，禁止写成 () => { return 0 }	| JS |
| arrow-parens	| 函数只有一个参数并且函数体没有大括号，就删除圆括号。 否则，为了保证清晰和一致性，请给参数加上括号。	| JS |
| arrow-spacing	| 箭头函数的箭头前后必须有空格	| JS |
| block-scoped-var	| 将 var 定义的变量视为块作用域，禁止在块外使用	| JS |
| block-spacing	| 代码块如果在一行内，那么大括号内的首尾必须有空格，比如 function () { alert('Hello') }	| JS |
| brace-style	| if 与 else 的大括号风格必须一致	| JS |
| callback-return	| callback 之后必须立即 return	| JS |
| camelcase	| 变量名必须是 camelcase 风格的	| JS |
| capitalized-comments	| 注释的首字母必须大写	| JS |
| class-methods-use-this	| 在类的非静态方法中，必须存在对 this 的引用	| JS |
| comma-dangle	| 当最后一个元素或属性与闭括号 ] 或 } 在 不同的行时，要求使用拖尾逗号；当在 同一行时，禁止使用拖尾逗号。	| JS |
| comma-spacing	| 逗号前禁止有空格，逗号后必须要有空格	| JS |
| comma-style	| 禁止在行首写逗号	| JS |
| comment-ratio	| 注释行数在文件总行数占比不少于10%	| JS |
| complexity	| 禁止函数的循环复杂度超过 20	| JS |
| computed-property-spacing	| 用作对象的计算属性时，中括号内的首尾禁止有空格	| JS |
| consistent-return	| 禁止函数在不同分支返回不同类型的值	| JS |
| consistent-this	| 限制 this 的别名	| JS |
| constructor-super	| constructor 中必须有 super	| JS |
| curly	| if 后面必须要有 {，除非是单行 if	| JS |
| default-case	| switch 语句必须有 default	| JS |
| dot-location	| 链式调用的时候，点号必须放在第二行开头处，禁止放在第一行结尾处	| JS |
| dot-notation	| 禁止出现 foo['bar']，必须写成 foo.bar	| JS |
| eol-last	| 文件最后一行必须有一个空行	| JS |
| eqeqeq	| 必须使用 === 或 !==，禁止使用 == 或 !=，与 null 比较时除外	| JS |
| for-direction	| 禁止 for 循环出现方向错误的循环，比如 for (i = 0; i < 10; i--)	| JS |
| func-call-spacing	| 函数名和执行它的括号之间禁止有空格	| JS |
| func-id-match	| 函数名字符数不超过35个	| JS |
| func-name-matching	| 函数赋值给变量的时候，函数名必须与变量名一致	| JS |
| func-names	| 函数必须有名字	| JS |
| func-style	| 必须只使用函数申明或只使用函数表达式	| JS |
| generator-star-spacing	| generator 的 * 前面禁止有空格，后面必须有空格	| JS |
| getter-return	| getter 必须有返回值，并且禁止返回空，比如 return;	| JS |
| global-require	| require 必须在全局作用域下	| JS |
| guard-for-in	| for in 内部必须有 hasOwnProperty	| JS |
| handle-callback-err	| callback 中的 error 必须被处理	| JS |
| id-blacklist	| 禁止使用指定的标识符	| JS |
| id-length	| 限制变量名长度	| JS |
| id-match	| 限制变量名必须匹配指定的正则表达式	| JS |
| import/first	| 导入语句前不允许有任何非导入语句	| JS |
| import/no-mutable-exports	| 禁止使用 let 导出	| JS |
| import/no-webpack-loader-syntax	| 禁用导入的模块时使用 webpack 特有的语法（感叹号）	| JS |
| import/prefer-default-export	| 当只有一个导出时，必须使用 export default	| JS |
| indent	| 缩进以2空格为单位	| JS |
| init-declarations	| 变量必须在定义的时候赋值	| JS |
| jsx-quotes	| jsx 中的属性必须用双引号	| JS |
| key-spacing	| 对象字面量中冒号前面禁止有空格，后面必须有空格	| JS |
| keyword-spacing	| 关键字前后必须有空格	| JS |
| license	| 文件头需要包含开源协议信息	| JS |
| line-comment-position	| 单行注释必须写在上一行	| JS |
| linebreak-style	| 限制换行符为 LF 或 CRLF	| JS |
| linebreak-style-tosa	| 行尾使用换行符LF且禁止使用回车键CR	| JS |
| lines-around-comment	| 注释前后必须有空行	| JS |
| max-depth	| 代码块嵌套的深度禁止超过 5 层	| JS |
| max-len	| 限制一行最多的字符个数 	| JS |
| max-len-tosa	| 单行字符数不超过指定数量（默认为120个） 	| JS |
| max-lines	| 限制一个文件最多的行数	| JS |
| max-nested-callbacks	| 回调函数嵌套禁止超过 3 层，多了请用 async await 替代	| JS |
| max-params	| 函数的参数禁止超过 7 个	| JS |
| max-statements	| 限制函数块中的语句数量	| JS |
| max-statements-per-line	| 限制一行中的语句数量	| JS |
| multiline-ternary	| 三元表达式必须得换行	| JS |
| new-cap	| new 后面的类名必须首字母大写	| JS |
| new-parens	| new 后面的类必须有小括号	| JS |
| newline-per-chained-call	| 链式调用必须换行	| JS |
| no-alert	| 禁止使用 alert	| JS |
| no-array-constructor	| 禁止使用 Array 构造函数	| JS |
| no-await-in-loop	| 禁止将 await 写在循环里，因为这样就无法同时发送多个异步请求了	| JS |
| no-bitwise	| 禁止使用位运算	| JS |
| no-buffer-constructor	| 禁止直接使用 Buffer	| JS |
| no-caller	| 禁止使用 caller 或 callee	| JS |
| no-case-declarations	| switch 的 case 内有变量定义的时候，必须使用大括号将 case 内变成一个代码块	| JS |
| no-catch-shadow	| 禁止 catch 的参数名与定义过的变量重复	| JS |
| no-class-assign	| 禁止对定义过的 class 重新赋值	| JS |
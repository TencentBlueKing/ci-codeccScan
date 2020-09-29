## 概述:
Ktlint是一款开源库，它可以对项目中的kotlin文件做lint check，还可以格式化代码。可以理解为它包含了linter和formatter的静态代码检查工具。。该工程以容器方式，对ktlint工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

sdk：适配工具脚步路径

tool: 工具二进制路径

## 工具版本：

ktlint: 0.29.0

## 镜像打包:
打包命令：docker build -t ktlint_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：
{"projName":"DEVOPS_B7642C8018CCB7EB","scanPath":"/data/landun/workspace","whitePathList":[],"scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.temp/.*"],"incrementalFiles":[],"openCheckers":[{"checkerName":"no-multi-spaces","nativeChecker":true},{"checkerName":"no-empty-class-body","nativeChecker":true},{"checkerName":"chain-wrapping","nativeChecker":true}]}


### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.kt", "/data/project/code/src/test.kt"]] |
| openCheckers | 打开的规则列表 | [{"checkerName":"no-multi-spaces","nativeChecker":true},{"checkerName":"no-empty-class-body","nativeChecker":true},{"checkerName":"chain-wrapping","nativeChecker":true}] |
| checkerName | 规则名称, 参考附2 | no-multi-spaces |
| nativeChecker | 是否工具默认规则 | true |

## 镜像运行:
docker run -it ktlint_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"checkerName":"no-unused-imports","description":"Unused import","filePath":"/data/iegci/test_tool/test_code/CodeccCheckAtomDebug/src/main/kotlin/com/tencent/devops/api/CodeccSdkApi.kt","line":"52"},{"checkerName":"comment-spacing","description":"Missing space after //","filePath":"/data/iegci/test_tool/test_code/CodeccCheckAtomDebug/src/main/kotlin/com/tencent/devops/api/CodeccSdkApi.kt","line":"389"}]}

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
| annotation		| | Kotlin |
| chain-wrapping		| | Kotlin |
| colon-spacing		| | Kotlin |
| comma-spacing		| | Kotlin |
| comment-spacing		| | Kotlin |
| curly-spacing		| | Kotlin |
| dot-spacing		| | Kotlin |
| double-colon-spacing		| | Kotlin |
| enum-entry-name-case		| | Kotlin |
| final-newline		| | Kotlin |
| import-ordering		| | Kotlin |
| indent		| | Kotlin |
| keyword-spacing		| | Kotlin |
| max-line-length		| | Kotlin |
| modifier-order		| | Kotlin |
| multiline-if-else		| | Kotlin |
| no-blank-line-before-rbrace		| | Kotlin |
| no-consecutive-blank-lines		| | Kotlin |
| no-empty-class-body		| | Kotlin |
| no-empty-first-line-in-method-block		| | Kotlin |
| no-line-break-after-else		| | Kotlin |
| no-line-break-before-assignment		| | Kotlin |
| no-multi-spaces		| | Kotlin |
| no-semi		| | Kotlin |
| no-trailing-spaces		| | Kotlin |
| no-unit-return		| | Kotlin |
| no-unused-imports		| | Kotlin |
| no-var		| | Kotlin |
| no-wildcard-imports		| | Kotlin |
| op-spacing		| | Kotlin |
| package-name		| | Kotlin |
| parameter-list-wrapping		| | Kotlin |
| paren-spacing		| | Kotlin |
| range-spacing		| | Kotlin |
| spacing-around-angle-brackets		| | Kotlin |
| spacing-between-declarations-with-annotations		| | Kotlin |
| spacing-between-declarations-with-comments		| | Kotlin |
| string-template		| | Kotlin |
| unary-op-spacing		| | Kotlin |
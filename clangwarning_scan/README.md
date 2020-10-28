## 概述:
Clang编译器提供的警告信息，可在项目编译过程中扫描出代码警告

## 目录结构：
docker: 镜像打包文件Dockerfile路径

src: 工具二进制路径

test: 测试的输入输出文件

## 工具版本：

clangwarning: 1.0.0

## 镜像打包:
打包命令：docker build -t clangwarning_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：
{
    "scanType": "full",
    "openCheckers":\[
        {
            "checkerName": "unused-function"
        },{
            "checkerName": "documentation"
        }
    ],
    "scanPath": "/usr/codecc/tool_scan"
}


### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| scanType | 进行全量或增量检查 | full或increment |
| openCheckers | 打开的规则列表 | [{"checkerName":"no-multi-spaces","nativeChecker":true},{"checkerName":"no-empty-class-body","nativeChecker":true},{"checkerName":"chain-wrapping","nativeChecker":true}] |

## 镜像运行:
docker run -it clangwarning_scan:latest /bin/bash -c "/bin/bash##-c##"python3 ./src/clangwarning.py --input={input.json} --output={output.json}"

## 结果描述：

### output.json模版：
{
    "message":"scan complete",
    "code":0,
    "defects":\[
        {
            "line":"23",
            "checkerName":"unused-function",
            "description":" unused function 'rgb_use' ",
            "filePath":"/Users/bkdevops/Landun/workspace/SourceCode/ThirdPart/renderer.c"
        }
    ]
}

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
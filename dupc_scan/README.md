## 概述:
重复率工具是检测项目中复制粘贴和重复开发相同逻辑等问题，帮助团队发现重复代码。消除重复代码，能减少代码的重复输入，避免增加不必要的代码量，便于代码的集中管理和维护。该工程以容器方式，对phpc工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

sdk：适配工具脚步路径

tool: 工具二进制路径

## 工具版本：

cpd: 6.13.0

## 镜像打包:
打包命令：docker build -t dupc_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：
{"projName":"CODE_55D5005A8EFFDEC8","scanPath":"/data/iegci/test_tool/test_code/cpp_test_jim","language":108,"whitePathList":[],"toolOptions":[],"scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.temp/.*",".*/pinpoint_piggy/.*",".*/\\.git"],"incrementalFiles":[],"openCheckers":[{"checkerName":"DUPC_threshold","nativeChecker":true}]}


### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| language | 代码语言映射，参考附1 | 108 |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.php", "/data/project/code/src/test.php"]] |
| openCheckers | 打开的规则列表 | [{"checkerName":"DUPC_threshold","nativeChecker":true}] |
| checkerName | 规则名称, 参考附2 | DUPC_threshold |
| nativeChecker | 是否工具默认规则 | true |

## 镜像运行:
docker run -it dupc_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"block_list":[{"end_lines":120,"finger_print":"56ec1a9288ec667677955e5e4b4cbe59","start_lines":1}],"block_num":1,"dup_lines":119,"dup_rate":"98.35%","file_path":"/data/iegci/test_tool/exporting-server/php/php-batik/index.php","total_lines":121},{"block_list":[{"end_lines":120,"finger_print":"56ec1a9288ec667677955e5e4b4cbe59","start_lines":1}],"block_num":1,"dup_lines":119,"dup_rate":"98.35%","file_path":"/data/iegci/test_tool/php/php-batik/index.php","total_lines":121}]"dup_line_count":278496,"total_line_count":355967}

### output.json字段说明:
| 字段名 | 说明 |
| --- | --- |
| defects | 告警列表 |
| block_list | 重复块列表 |
| start_lines | 重复开始行 |
| end_lines | 重复结束行 |
| finger_print | 重复标签 |
| block_num | 重复块数 |
| dup_lines | 重复行数 |
| dup_rate | 重复率 |
| file_path | 文件路径 |
| total_lines | 文件总行数 |
| dup_line_count | 所有文件重复行总数 |
| total_line_count | 所有文件行总数 |


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
| DUPC_threshold	| 检查代码中不同位置的相同的代码片段。帮助开发者发现冗余代码，以便代码抽象和重构。	| Golang,JAVA,C#,C/C++,OC/OC++,JS,Kotlin,Python |
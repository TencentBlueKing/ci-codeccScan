## 概述:
cloc是一款代码统计工具，可以统计代码中各类语言代码行、注释行、空白行的情况。该工程以容器方式，对cloc工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

sdk：适配工具脚步路径

tool：工具二进制路径

## 工具版本：
cloc：1.82

## 镜像打包:
打包命令：docker build -t cloc_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：

{"projName":"CODECC_E62163C1E8070479","projectId":"CODE_186495","scanPath":"/data/iegci/test_tool/test_code/clouddriver","whitePathList":["/data/iegci/test_tool/test_code/clouddriver"],"scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.temp/.*",".*/pinpoint_piggy/.*"],"incrementalFiles":[]}

### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.py", "/data/project/code/src/test.py"]] |

## 镜像运行:
docker run -it cloc_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"blank":6,"code":17,"comment":15,"filePath":"/data/iegci/test_tool/test_code/client/test.java","language":"Java"}],"languages":"Java","tool_name":"cloc"}

### output.json字段说明:
| 字段名 | 说明 |
| --- | --- |
| defects | 告警列表 |
| filePath | 文件路径 |
| blank | 空白行数 |
| code | 有效行数 |
| comment | 注释行数 |
| language | 代码语言 |
| languages | 语言列表 |
| tool_name | 工具名称 |


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

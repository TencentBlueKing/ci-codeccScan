## 概述:
CCN为圈复杂度的简称，lizard是开源的圈复杂度检查工具，它目前是支持语言最多的一款圈复杂度检查工具。支持命令行操作，能够方便统计函数总行数，注释总行数，复杂度值，可以指定语言扫描，过滤路径和自定义圈复杂度风险值。该工程以容器方式，对Lizard工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

sdk：适配工具脚步路径

tool：工具二进制路径

## 工具版本：
Lizard：16.1

complexity : 0.1.1

## 镜像打包:
打包命令：docker build -t ccn_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：

{"projName":"DEVOPS_214A69F1F4F935DE","scanPath":"/data/project/code ","whitePathList":[],"scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.temp/.*",".*/\\.git"],"incrementalFiles":[],"openCheckers":[{"checkerName":"CCN_threshold","nativeChecker":true,"checkerOptions":[{"checkerOptionName":"ccn_threshold","checkerOptionValue":"30"}]}]}

### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.py", "/data/project/code/src/test.py"]] |
| openCheckers | 打开的规则列表 | [{"checkerName": "CCN_threshold","nativeChecker": true,"checkerOptions": [{"checkerOptionName": "ccn_threshold","checkerOptionValue": "30"}]}] |
| checkerName | 规则名称, 参考附2 | CCN_threshold |
| nativeChecker | 是否工具默认规则 | true |
| checkerOptions | 规则参数 | [{"checkerOptionName": "ccn_threshold","checkerOptionValue": "30"}] |

## 镜像运行:
docker run -it ccn_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"ccn":"2","condition_lines":"20","endLine":"24","filePath":"/data/iegci/test_tool/test_code/svnauth_svr/app/utils/CodeCCLogger.java","function_lines":"13-24","function_name":"CodeCCLogger::ERROR","long_name":"CodeCCLogger::ERROR( String format , Object ... args)","startLine":"13","total_lines":"12"},{"ccn":"3","condition_lines":"32,35","endLine":"39","filePath":"/data/iegci/test_tool/test_code/svnauth_svr/app/utils/CodeCCLogger.java","function_lines":"26-39","function_name":"CodeCCLogger::INFO","long_name":"CodeCCLogger::INFO( String format , Object ... args)","startLine":"26","total_lines":"14"}],"filesTotalCCN":[{"file_path":"/data/iegci/test_tool/test_code/svnauth_svr/app/utils/CodeCCLogger.java","total_ccn_count":"2.75"},{"file_path":"/data/iegci/test_tool/test_code/svnauth_svr/app/common/constant/ComConstants.java","total_ccn_count":"0.0"}]}

### output.json字段说明:
| 字段名 | 说明 |
| --- | --- |
| defects | 方法圈复杂度告警列表 |
| filePath | 文件路径 |
| ccn | 方法圈复杂度值 |
| function_name | 方法名 |
| long_name | 方法长名带参数 |
| function_lines | 方法开始行-方法结束行 |
| total_lines | 方法总行数 |
| startLine | 方法开始行 |
| endLine | 方法结束行 |
| condition_lines | 圈复杂度标记行 |
| filesTotalCCN | 文件平均圈复杂度数列表 |
| total_ccn_count | 文件平均圈复杂度数 |

### 附2 规则对应表
| 规则名 | 规则描述 | 适用语言 |
| --- | --- | --- |
| CCN_threshold | 检查圈复杂度大于等于特定阈值的函数，默认阈值为20。复杂度越高代码存在缺陷的风险越大。 | JAVA,C#,Golang,C/C++,OC/OC++,JS,PHP,Ruby,Python,Swift,LUA,TS |
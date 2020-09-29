## 概述:
scm指定的是git和svn工具，该工程实现了获取仓库版本信息，获取文件行作者信息，获取增量文件信息，并且通过版本号对比，获取差异文件列表。该工程以容器方式，对git和svn工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

sdk：适配工具脚步路径

tool: 工具二进制路径

software: 安装包路径

third_rules: 自定义规则扩展路径

## 工具版本：

git: 1.8.3.1
svn: 1.9.12

## 镜像打包:
打包命令：docker build -t scm_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：
Git/SVN获取仓库版本信息:

{"dir_path_list":["/Users/workspace/phpc_scan"]}

Git/SVN获取行作者信息：

{"file_path_list":["/workspace/bin/agent_init.py"]}

Git/SVN获取增量文件信息：

{"scm_increment":[{"pre_revision":"","workspacke_path":"/data/landun/workspace"}]}

Git分支差异：

{"workspace":["/data/landun/workspace"],"bk_ci_hook_source_branch":"support_auto_tool_scan","bk_ci_hook_target_branch":"master"}

### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| dir_path_list | 项目路径列表 | /Users/workspace/phpc_scan |
| file_path_list | 文件路径列表 | /workspace/bin/agent_init.py |
| scm_increment | 增量对比信息 | [{"pre_revision":"","workspacke_path":"/data/landun/workspace"}] |
| scapre_revision | 上次版本 | HEAD^ |
| workspacke_path | 对比路径 | /data/landun/workspace |
| bk_ci_hook_source_branch | 源分支名称 | support_auto_tool_scan |
| bk_ci_hook_target_branch | 目标分支名称 | master |

## 镜像运行:
Git/SVN获取仓库版本信息:

docker run -it scm_scan:latest /bin/bash -c "python3 ./src/git_info.py --input=/data/git_info_input.json --output=/data/git_info_output.json"

docker run -it scm_scan:latest /bin/bash -c "python3 ./src/svn_info.py --input=/data/svn_info_input.json --output=/data/svn_info_output.json"

Git/SVN获取行作者信息：

docker run -it scm_scan:latest /bin/bash -c "python3 ./src/git_blame.py --input=/data/git_blame_input.json --output=/data/git_blame_output.json"

docker run -it scm_scan:latest /bin/bash -c "python3 ./src/svn_blame.py --input=/data/svn_blame_input.json --output=/data/svn_blame_output.json"

Git/SVN获取增量文件信息：

docker run -it scm_scan:latest /bin/bash -c "python3 ./src/git_increment.py --input=/data/git_increment_input.json --output=/data/git_increment_output.json"

docker run -it scm_scan:latest /bin/bash -c "python3 ./src/svn_increment.py --input=/data/svn_increment_input.json --output=/data/svn_increment_output.json"

Git分支差异：

docker run -it scm_scan:latest /bin/bash -c "python3 ./src/git_branch_diff.py --input=/data/git_branch_diff_input.json --output=/data/git_branch_diff_output.json"

## 结果描述：

### output.json模版：
Git/SVN获取仓库版本信息:

{"scm_info":[{"author":"user","branch":"external_landun_codecc_201909","latestTime":1569392928,"revisionId":"8e5c988","url":"/codecc/multi_tools_script.git"},{"author":"user","branch":"multi_tools_script_dev","latestTime":1569747895,"revisionId":"9e38db2","url":"/codecc/multi_tools_script.git"}]}

Git/SVN获取行作者信息：

[{"branch":"master","changeRecords":[{"author":"user","authorMail":"user@tencent.com","lineRevisionId":"ec151f2003717e806e1aa8252e9085baf3287eb3","lineShortRevisionId":"ec151f20","lineUpdateTime":1574388417000,"lines":[[1,66]]}],"filePath":"/workspace/kw_platform_agent/bin/agent_init.py","fileRelPath":"/bin/agent_init.py","fileUpdateTime":1574388417000,"revision":"ec151f2","scmType":"git","url":"/codecc-tools/kw_platform_agent.git"}]

Git/SVN获取增量文件信息：

{"scm_increment":[{"deleteFileList":[],"latestRevision":"8e5c988","updateFileList":["E:\\git_codecc_workspace\\external_landun_codecc_201910\\scan/bin/common/codecc_config.py","E:\\git_codecc_workspace\\external_landun_codecc_201910\\scan/bin/common/codecc_web.py"]},{"deleteFileList":[],"latestRevision":"9e38db2","updateFileList":["E:\\git_codecc_workspace\\multi_tools_script_dev_jimxzcai_201909\\scan/bin/common/codecc_config.py"]}]}

Git分支差异：

{"scm_increment":[{"deleteFileList":[],"diffFileList":[{"diffLineList":[15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30],"filePath":"/data/iegci/test_tool/test_code/codecc_agent/bin/common/codecc_web.py"},{"diffLineList":[164],"filePath":"/data/iegci/test_tool/test_code/codecc_agent/bin/scan.py"}],"updateFileList":["/data/iegci/test_tool/test_code/codecc_agent/bin/common/codecc_web.py","/data/iegci/test_tool/test_code/codecc_agent/bin/scan.py"]}]}


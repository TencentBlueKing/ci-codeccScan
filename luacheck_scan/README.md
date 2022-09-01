## 打包命令：
docker 打包命令：`docker build -f ./docker/Dockerfile -t scan:temp .`

## 目录结构：
`docker` docker镜像文件保存目录

`sdk`  python执行脚本解析目录

## 镜像运行
> docker run -it luacheck_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 入参文件（json）：
> projName 项目名称
> 
> scanPath 扫描路径，此处需使用绝对路径
> 
> openCheckers 检查的规则集

openCheckers 子属性：
> checkerName 规则名称
> severity 告警级别
> checkerOptions 携带的参数

checkerOptions 子属性：

> checkerOptionName 参数名
> 
> checkerOptionValue 参数值

规则集请看：[checkers.json](./checkers.json)

## 自定义luacheck配置文件：
luacheck配置文件文件名请设置为：`.luacheckrc`放在扫描路径下

## 输出结构例子：
> {
      "filePath": "D:/user_test/xxx.lua",
      "line": "152",
      "checkerName": "W631",
      "description": "line is too long (121 > 120)"
    },
    {
      "filePath": "D:/user_test/xxx.lua",
      "line": "173",
      "checkerName": "W212",
      "description": "unused argument 'conf'"
    },
    {
      "filePath": "D:/user_test/xxx.lua",
      "line": "183",
      "checkerName": "W212",
      "description": "unused argument 'conf'"
    }
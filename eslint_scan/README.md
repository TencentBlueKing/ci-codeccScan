### 工具介绍

**ESLint**是一个开源的 JavaScript 代码检查工具。它被设计的容易拓展、拥有大量的自定义规则、容易的通过插件来安装。它给出准确的输出，而且包括规则名，这样可以知道哪个规则造成了错误。ESLint不仅可以支持代码风格的检查，而且还可以简单检查代码中潜在的错误。

目前支持的规则已经在checkers.json中进行了声明。

### 开发新规则步骤

1.从master拉规则分支，命名建议为：story_xxx_MMdd （xxx为规则名，MMdd表示月日）

2.将规则分支代码clone到本地

3.所有自定义规则都存放在sdk/config/third_config.js，具体规则逻辑存放在third_rules目录下，新建规则可参考该目录下其他规则文件

4.在checker.json中添加新增规则的描述。在描述时需要说明该规则对应到哪一条规范，并附上链接。规则描述示例如下：

- 必须使用 === 或 !==，禁止使用 == 或 !=。 [tencent standards/javascript 15]({scmUrl}/standards/javascript#15-%E6%AF%94%E8%BE%83%E8%BF%90%E7%AE%97%E7%AC%A6%E5%92%8C%E7%AD%89%E5%8F%B7)

5.在test目录下添加规则测试代码文件

6.MR代码到test分支

7.执行流水线部署/console/pipeline/codecc-tool-auto/p-2b74a1496b1c493e812d304b50e9b233/history

8.测试完成提合并请求到master分支，由工具负责人审核评估后正式发布到生产

### 本地调试

#### 打包docker镜像
```
docker build -t eslint-scan:temp -f ./docker/Dockerfile.manual .
```
#### 进入docker镜像
```
docker run -v 本地目录:/data/landun/workspace -it eslint-scan:temp /bin/bash
```
#### 执行工具并输入结果
```
python3 ./sdk/src/scan.py --input=/data/landun/workspace/input.json --output=/data/landun/workspace/output.json
```
#### 退出docker镜像
```
exit
```

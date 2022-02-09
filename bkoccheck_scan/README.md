# 开发新OCCheck2规则步骤和流程：

1.从master拉规则分支，命名建议为：story_xxx_MMdd （xxx为规则名，MMdd表示月日）

2.将规则分支代码clone到本地

3.所有自定义规则都存放在tool/src/main/java/checks目录，新建规则可参考该目录下其他规则文件
假设新增规则：MaxLinesPerFunction
 - (1)  新建Java类源文件（类名命名格式：MaxLinesPerFunction），import需要的类库，如common.BaseCheck、common.CheckerAnnotation，common.DefectMessage等，并继承 BaseCheck 类。
 - (2)  按需求覆写4个父类方法，分别是：checkText()、initOption()、exitMethodDefinition()、exitFunctionDefinition()
 - (3)  编写规则检查逻辑，根据规范说明书的检查要点实现对应的检查规则。编写规则过程中，可以：
         - a. 借助ochecke2源码，理解相关结构的定义与使用方法，尤其是类似的规则。
 - (4)  编译jar包，编译之前，设置maven环境变量，如：export PATH=$MAVEN_HOME/bin:$PATH, 然后运行编译脚步：tool/build.sh
 - (5)  编写config文件，tool/config.xml。该文件是独立于occheck2存在的yml配置文件，它的作用是指示本次检查开启的检查规则及规则选项。
 - (6)  编译工程，本地测试：java -jar tool/occheck.jar --output tool/output.json --format json  --config tool/config.xml $FILE_PATH

4.在checker.json中添加新增规则的描述

5.在test目录下添加规则测试代码文件

6.MR代码到test分支

7.执行流水线部署

8.测试完成提合并请求到master分支，由工具负责人审核评估后正式发布到生产

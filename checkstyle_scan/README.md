## 工具介绍

Checkstyle是一款开源的 Java 代码检查工具，用于检查Java源代码是否符合编码规范。它可以找到类和方法设计问题，还能够检查代码布局和格式问题。

目前支持的规则已经在checkers.json中进行了声明。

## 开发新规则的步骤

1、从master拉规则分支，命名建议为：story_xxx_MMdd （xxx为规则名，MMdd表示月日）

2、将规则分支代码clone到本地，推荐本地使用IntelliJ IDEA打开checkstyle_scan工程

3、IDE工程里进入到checkstyle_scan\tool\checkstyle-tencent-extend\src\main\java\com\tencent\checks这个目录，所有的自定义规则到放在这个目录下。

4、添加新规则的修改点，这里假设需要添加一条 CommentRatioCheck规则：

 - (1)  新建Java类源文件（类名命名格式：CamelCaseCheck），import需要的类库，如com.puppycrawl.tools.checkstyle.api.AbstractCheck、com.puppycrawl.tools.checkstyle.api.DetailAST等，并继承 AbstractCheck 类。
 - (2)  覆写4个父类方法，分别是：getDefaultTokens()、getAcceptableTokens()、getRequiredTokens()、visitToken()
 - (3)  编写规则检查逻辑，根据规范说明书的检查要点实现对应的检查规则。编写规则过程中，可以：
         - a. 借助GUI查看目标文档结构。[具体使用请参考](https://checkstyle.sourceforge.io/writingchecks.html#The_Checkstyle_SDK_Gui)
         - b. 借助checkstyle源码，理解相关结构的定义与使用方法，尤其是类似的规则。
 - (4)  编写config文件，参考checkstyle_scan\sdk\config\tencent_config.xml配置你新增的规则，可以在该文件上添加你的规则，也可以另起文件添加你的规则。该文件的作用是指示本次检查开启的检查规则及规则选项。
 - (5)  编译工程，本地测试：java -classpath checkstyle-tencent-extend.jar com.puppycrawl.tools.checkstyle.Main -c $CONFIG $FILE_PATH

[注：更多规则定制方法可以参考官方文档](https://checkstyle.sourceforge.io/extending.html)
5、在checkers.json中添加新增规则的描述。在描述时需要说明该规则对应到哪一条规范，并附上链接。规则描述示例如下：
 - Checks license headers are present in source files.

6、在test目录下添加规则测试代码文件

7、MR代码到test分支

8、执行流水线部署

9、测试完成提合并请求到master分支，由工具负责人austinshen审核评估后正式发布到生产

## 工具介绍

StyleCop工具是微软的开源静态代码分析工具，它检查C＃代码是否符合StyleCop推荐的编码样式和Microsoft .NET Framework设计指南。

目前支持的规则已经在checkers.json中进行了声明。

## 开发新规则的步骤

1、从master拉规则分支，命名建议为：story_xxx_MMdd （xxx为规则名，MMdd表示月日）

2、将规则分支代码clone到本地，推荐本地使用 Visual Studio 打开 CodeCCRules.sln 工程方案

3、IDE工程里进入到stylecop_scan\tool\stylecop-tencent-extend\CodeCCRules这个目录，所有的自定义规则到放在这个目录下。

4、添加新规则的修改点，这里假设需要添加一条 TOSACommentRatio 规则：
 - (1)  新建cs源码文件，继承SourceAnalyzer，并打上固定注解[SourceAnalyzer(typeof(CsParser))]，如：HelloRule.cs
 - (2)  重写父类AnalyzeDocument()方法，编写规则检查逻辑
 - (3)  新建规则描述文件，该描述文件名必须要和cs源码文件一致，如：HelloRule.xml；并将该资源文件属性设为"嵌入的资源(Embedded Resource)"
 - (4)  编写config文件，参考stylecop_scan\sdk\config\tencent_config.xml配置你新增的规则
    - (a) Analyzers节点的ID规范为：{namespace}.{classname}
    - (b) Rules节点的Name则为第(3)点的HelloRule.xml中的规则名字
    - (c) RuleSettings节点中的```<BooleanProperty Name="Enabled">True</BooleanProperty>```，True则为开启对应的校验规则，False则为关闭
 - (5)  编译工程，把生成的dll拷贝到stylecop_scan\tool\bin这个目录
 - (6)  本地测试
    - (a) 把cd 切换到目录 stylecop_scan\tool\bin
    - (b) 执行：mono StyleCopCLI.exe -set {配置文件路径} -cs {被扫cs源码文件路径} -out {结果输出文件路径}
        ```如：mono StyleCopCLI.exe -set ..\..\sdk\config\tencent_config.xml -cs d:\HelloWorld.cs -out result.xml```
    - (c) 查阅结果文件，看看规则命中情况    
    
5、在checkers.json中添加新增规则的描述。在描述时需要说明该规则对应到哪一条规范，并附上链接。规则描述示例如下：
``` [必须]注释语句与其注释对象之间不能空行 ```

 6、在test目录下添加规则测试代码文件

 7、MR代码到test分支

 8、以"**调试模式**"执行流水线将工具集成到CodeCC平台
 
 9、测试完成提合并请求到master分支

 10、工具负责人weijianguan审核结合第6步骤和第8步骤执行的测试样例代码检查结果，及代码检视结果，评估后发布到灰度，再由灰度发布到正式

 **<font size=4 color="#660000" face="微软雅黑">>>相关官方文档查阅： [StyleCop](https://github.com/StyleCop/StyleCop)、[StyleCopCLI](https://github.com/bbadjari/stylecopcli)</font>**
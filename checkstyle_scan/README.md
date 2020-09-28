## 概述:
CheckStyle工具用于检查Java源代码是否符合编码规范。它可以找到类和方法设计问题，还能够检查代码布局和格式问题。该工程以容器方式，对checkstyle工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

sdk：适配工具脚步路径

tool：工具二进制路径

third_rules: 自定义规则扩展目录


## 工具版本：

checkstye：基于开源checkstyle-8.29版本做二次开发：

## 镜像打包:
打包命令：docker build -t checkstyle_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：

{"projName":"DEVOPS_B592E10DAA9EB6DE","projectId":"codeccsvr","scanPath":"/data/iegci/test_tool/test_code/wcdstat2","language":4,"whitePathList":[],"scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.temp/.*","/wcdstat_luna/luna/src/main/webapp/.*"],"incrementalFiles":[],"openCheckers":[{"checkerName":"SeparatorWrapDot","nativeChecker":true},{"checkerName":"LineLength","nativeChecker":true,"checkerOptions":[{"checkerOptionName":"max","checkerOptionValue":"100"}]}]}

### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.py", "/data/project/code/src/test.java"]] |
| openCheckers | 打开的规则列表 | [{"checkerName":"SeparatorWrapDot","nativeChecker":true},{"checkerName":"LineLength","nativeChecker":true,"checkerOptions":[{"checkerOptionName":"max","checkerOptionValue":"100"}]}] |
| checkerName | 规则名称, 参考附2 | SeparatorWrapDot |
| nativeChecker | 是否工具默认规则 | true |
| checkerOptions | 规则参数 | [{"checkerOptionName":"max","checkerOptionValue":"100"}] |

## 镜像运行:
docker run -it checkstyle_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"checkerName":"FileTabCharacter","description":"\u884c\u5185\u542b\u6709\u5236\u8868\u7b26 tab \u3002","filePath":"/data/iegci/test_tool/test_code/wcdstat2/wcdstat_luna/common/src/main/java/com/tencent/luna/common/service/redis/Redis.java","line":"24"},{"checkerName":"ModifierOrder","description":"'static' \u4fee\u9970\u7b26\u987a\u5e8f\u8fdd\u53cd JLS \u5efa\u8bae.","filePath":"/data/iegci/test_tool/test_code/wcdstat2/wcdstat_luna/common/src/main/java/com/tencent/luna/common/service/redis/Redis.java","line":"24"},{"checkerName":"FileTabCharacter","description":"\u884c\u5185\u542b\u6709\u5236\u8868\u7b26 tab \u3002","filePath":"/data/iegci/test_tool/test_code/wcdstat2/wcdstat_luna/common/src/main/java/com/tencent/luna/common/service/redis/Redis.java","line":"25"}]}

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
| AbbreviationAsWordInName	| The Check validate abbreviations(consecutive capital letters) length in identifier name, it also allow in enforce camel case naming.	| JAVA |
| AbstractClassName	| Ensures that the names of abstract classes conforming to some regular expression and check that abstract modifier exists.	| JAVA |
| AnnotationLocation	| Check location of annotation on language elements.	| JAVA |
| AnnotationLocationMostCases	| Check location of annotation on language elements.	| JAVA |
| AnnotationLocationVariables	| Check location of annotation on language elements.	| JAVA |
| AnnotationOnSameLine	| The check does verifying that annotations are located on the same line with their targets.	| JAVA |
| AnnotationUseStyle	| This check controls the style with the usage of annotations.	| JAVA |
| AnonInnerLength	| Checks for long anonymous inner classes.	| JAVA |
| ArrayTrailingComma	| Checks if array initialization contains optional trailing comma.	| JAVA |
| ArrayTypeStyle	| Checks the style of array type definitions.	| JAVA |
| AtclauseOrder	| Checks the order of at-clauses.	| JAVA |
| AvoidEscapedUnicodeCharacters	| Restrict using Unicode escapes.	| JAVA |
| AvoidInlineConditionals	| Detects inline conditionals.	| JAVA |
| AvoidNestedBlocks	| Finds nested blocks.	| JAVA |
| AvoidStarImport	| Check that finds import statements that use the * notation.	| JAVA |
| AvoidStaticImport	| Check that finds static imports.	| JAVA |
| BooleanExpressionComplexity	| Restricts nested boolean operators (&&, ||, &, | and ^) to a specified depth (default = 3).	| JAVA |
| CatchParameterName	| Checks that catch parameter names conform to a format specified by the format property.	| JAVA |
| ClassDataAbstractionCoupling	| This metric measures the number of instantiations of other classes within the given class.	| JAVA |
| ClassFanOutComplexity	| The number of other classes a given class relies on.	| JAVA |
| ClassTypeParameterName	| Checks that class type parameter names conform to a format specified by the format property.	| JAVA |
| CommentRatioCheck	| Checks for a minimum comment ratio(the threshold is 10%).	| JAVA |
| CommentsIndentation	| Controls the indentation between comments and surrounding code.	| JAVA |
| ConstantName	| Checks that constant names conform to a format specified by the format property.	| JAVA |
| CovariantEquals	| Checks that if a class defines a covariant method equals, then it defines method equals(java.lang.Object).	| JAVA |
| CustomImportOrder	| Checks that the groups of import declarations appear in the order specified by the user.	| JAVA |
| CyclomaticComplexity	| Checks cyclomatic complexity against a specified limit. 	| JAVA |
| DeclarationOrder	| Checks that the parts of a class or interface declaration appear in the order suggested by the Code Conventions for the Java Programming Language.	| JAVA |
| DefaultComesLast	| Check that the default is after all the cases in a switch statement.	| JAVA |
| DescendantToken	| Checks for restricted tokens beneath other tokens.	| JAVA |
| DesignForExtension	| Checks that classes are designed for inheritance.	| JAVA |
| EmptyBlock	| Checks for empty blocks but does not validate sequential blocks.	| JAVA |
| EmptyCatchBlock	| Checks for empty catch blocks with few options to skip violation.	| JAVA |
| EmptyForInitializerPad	| Checks the padding of an empty for initializer; that is whether a space is required at an empty for initializer, or such spaces are forbidden.	| JAVA |
| EmptyForIteratorPad	| Checks the padding of an empty for iterator; that is whether a space is required at an empty for iterator, or such spaces are forbidden.	| JAVA |
| EmptyLineSeparator	| Checks for blank line separators.	| JAVA |
| EmptyStatement	| Detects empty statements (standalone ';').	| JAVA |
| EqualsAvoidNull	| Checks that any combination of String literals is on the left side of an equals() comparison.	| JAVA |
| EqualsHashCode	| Checks that classes that override equals() also override hashCode().	| JAVA |
| EscapeSequence	| 对于具有特殊转义序列的任何字符(\b, \t, \n, \f, \r, ", '及\)，我们使用它的转义序列，而不是相应的八进制(比如\012)或Unicode(比如\u000a)转义。	| JAVA |
| ExecutableStatementCount	| Restricts the number of executable statements to a specified limit (default = 30).	| JAVA |
| ExplicitInitialization	| Checks if any class or object member explicitly initialized to default for its type value (null for object references, zero for numeric types and char and false for boolean.	| JAVA |
| FallThrough	| Checks for fall through in switch statements Finds locations where a case contains Java code - but lacks a break, return, throw or continue statement.	| JAVA |
| FileEncodingCheck	| Checks source files are encoded in UTF-8.	| JAVA |
| FileLength	| Checks for long source files. 	| JAVA |
| FileTabCharacter	| Checks to see if a file contains a tab character.	| JAVA |
| FinalClass	| Checks that class which has only private constructors is declared as final.	| JAVA |
| FinalLocalVariable	| Ensures that local variables that never get their values changed, must be declared final.	| JAVA |
| FinalParameters	| Check that method/constructor/catch/foreach parameters are final.	| JAVA |
| GenericWhitespace	| Checks that the whitespace around the Generic tokens < and > are correct to the typical convention.	| JAVA |
| Header	| Checks the header of the source against a fixed header file.	| JAVA |
| HiddenField	| Checks that a local variable or a parameter does not shadow a field that is defined in the same class.	| JAVA |
| HideUtilityClassConstructor	| Make sure that utility classes (classes that contain only static methods) do not have a public constructor.	| JAVA |
| IllegalCatch	| Catching java.lang.Exception, java.lang.Error or java.lang.RuntimeException is almost never acceptable.	| JAVA |
| IllegalImport	| Checks for imports from a set of illegal packages.	| JAVA |
| IllegalInstantiation	| Checks for illegal instantiations where a factory method is preferred.	| JAVA |
| IllegalThrows	| Throwing java.lang.Error or java.lang.RuntimeException is almost never acceptable.	| JAVA |
| IllegalToken	| Checks for illegal tokens.	| JAVA |
| IllegalTokenText	| Checks for illegal token text.	| JAVA |
| IllegalType	| Checks that particular classes or interfaces are never used.	| JAVA |
| ImportOrder	| Ensures that groups of imports come in a specific order.	| JAVA |
| Indentation	| Checks correct indentation of Java Code. 	| JAVA |
| InnerAssignment	| Checks for assignments in subexpressions, such as in String s = Integer.toString(i = 2);.	| JAVA |
| InnerTypeLast	| Check nested (internal) classes/interfaces are declared at the bottom of the class after all method and field declarations.	| JAVA |
| InterfaceIsType	| Implements Bloch, Effective Java, Item 17 - Use Interfaces only to define types.	| JAVA |
| InterfaceTypeParameterName	| Checks that interface type parameter names conform to a format specified by the format property.	| JAVA |
| InvalidJavadocPosition	| Checks that Javadocs are located at the correct position.	| JAVA |
| JavaNCSS	| This check calculates the Non Commenting Source Statements (NCSS) metric for Java source files and methods.	| JAVA |
| JavadocMethod	| Checks the Javadoc of a method or constructor.	| JAVA |
| JavadocPackage	| Checks that all packages have a package documentation.	| JAVA |
| JavadocParagraph	| Checks Javadoc paragraphs.	| JAVA |
| JavadocStyle	| Custom Checkstyle Check to validate Javadoc.	| JAVA |
| JavadocTagContinuationIndentation	| Checks the indentation of the continuation lines in at-clauses.	| JAVA |
| JavadocType	| Checks the Javadoc of a type.	| JAVA |
| JavadocVariable	| Checks that a variable has Javadoc comment.	| JAVA |
| LambdaParameterName	| Check to verify lambda parameter names.	| JAVA |
| LeftCurly	| Checks the placement of left curly braces on types, methods and other blocks:	| JAVA |
| LicenseCheck	| Checks license headers are present in source files.	| JAVA |
| LineLength	| Checks for long lines. 	| JAVA |
| LineLength-tosa	| Checks for long lines(the default threshold is 120). 	| JAVA |
| LineSeparatorCheck	| Checks correct line separator style(use LF, no CR).	| JAVA |
| LocalFinalVariableName	| Checks that local final variable names conform to a format specified by the format property.	| JAVA |
| LocalVariableName	| Checks that local, non-final variable names conform to a format specified by the format property.	| JAVA |
| MagicNumber	| Checks for magic numbers.	| JAVA |
| MemberName	| Checks that instance variable names conform to a format specified by the format property.	| JAVA |
| MethodCount	| Checks the number of methods declared in each type declaration by access modifier or total count. 	| JAVA |
| MethodLength	| Checks for long methods(the default threshold is 150). 	| JAVA |
| MethodName	| Checks that method names conform to a format specified by the format property.	| JAVA |
| MethodName-tosa	| Checks that method names conform to a format specified by the format property(The function name has no more than 35 characters).	| JAVA |
| MethodParamPad	| Checks the padding between the identifier of a method definition, constructor definition, method call, or constructor invocation; and the left parenthesis of the parameter list.	| JAVA |
| MethodTypeParameterName	| Checks that class type parameter names conform to a format specified by the format property.	| JAVA |
| MissingCtor	| Checks that classes (except abstract one) define a ctor and don't rely on the default one.	| JAVA |
| MissingDeprecated	| This class is used to verify that both the java.lang.Deprecated annotation is present and the @deprecated Javadoc tag is present when either is present.	| JAVA |
| MissingJavadocMethod	| Checks for missing Javadoc comments for a method or constructor.	| JAVA |
| MissingOverride	| This class is used to verify that the java.lang.Override annotation is present when the {@inheritDoc} javadoc tag is present.	| JAVA |
| MissingSwitchDefault	| Checks that switch statement has "default" clause.	| JAVA |
| ModifiedControlVariable	| Check for ensuring that for loop control variables are not modified inside the for block.	| JAVA |
| ModifierOrder	| Checks that the order of modifiers conforms to the suggestions in the Java Language specification, sections 8.1.1, 8.3.1 and 8.4.3.	| JAVA |
| MultipleStringLiterals	| Checks for multiple occurrences of the same string literal within a single file.	| JAVA |
| MultipleVariableDeclarations	| Checks that each variable declaration is in its own statement and on its own line. | JAVA |
## 概述:
StyleCop工具是微软的开源静态代码分析工具，它检查C＃代码是否符合StyleCop推荐的编码样式和Microsoft .NET Framework设计指南。该工程以容器方式，对stylecop工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

sdk：适配工具脚步路径

tool: 工具二进制路径

software: 安装包路径

third_rules: 自定义规则扩展路径

## 工具版本：

stylecop: 1.4.0.0

## 镜像打包:
打包命令：docker build -t stylecop_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：
{"projName":"DEVOPS_477710D960043601","scanPath":"/data/iegci/test_tool/test_code/AndroidQQ","whitePathList":[],"scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.temp/.*",".*/\\.git"],"incrementalFiles":[],"openCheckers":[{"checkerName":"CommaOrSemicolonMustBeFollowedBySpaceOrEndOfLine","nativeChecker":true},{"checkerName":"MemberVariableAccessModifierMustBeDeclared","nativeChecker":true}]}


### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.py", "/data/project/code/src/test.py"]] |
| openCheckers | 打开的规则列表 | [{"checkerName":"CommaOrSemicolonMustBeFollowedBySpaceOrEndOfLine","nativeChecker":true},{"checkerName":"MemberVariableAccessModifierMustBeDeclared","nativeChecker":true}] |
| checkerName | 规则名称, 参考附2 | CommaOrSemicolonMustBeFollowedBySpaceOrEndOfLine |
| nativeChecker | 是否工具默认规则 | true |

## 镜像运行:
docker run -it stylecop_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"checkerName":"SingleLineCommentMustNotBeEmpty","description":"[\u5fc5\u987b]\u5355\u884c\u6ce8\u91ca\u4e0d\u80fd\u4e3a\u7a7a","filePath":"/data/iegci/test_tool/test_code/AndroidQQ/QzoneVideoPlugin/jni/maxvideo/AVCodec/libSrc/zlib1.2.8/contrib/dotzlib/DotZLib/AssemblyInfo.cs","line":"4"},{"checkerName":"SingleLineCommentMustNotBeEmpty","description":"[\u5fc5\u987b]\u5355\u884c\u6ce8\u91ca\u4e0d\u80fd\u4e3a\u7a7a","filePath":"/data/iegci/test_tool/test_code/AndroidQQ/QzoneVideoPlugin/jni/maxvideo/AVCodec/libSrc/zlib1.2.8/contrib/dotzlib/DotZLib/AssemblyInfo.cs","line":"8"}]}

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
| AccessModifierMustBeDeclared	| [必须]类、结构体、枚举、接口、delegate定义时必须显示声明访问修饰符	| C# |
| AccessibleFieldsMustBeginWithUpperCaseLetter	| Validates that the name of a public or internal field must begin with an upper-case letter.	| C# |
| AllAccessorsMustBeMultiLineOrSingleLine	| Validates that an accessor in a property or indexer is only placed on a single line if all accessors in the property or indexer are placed on a single line.	| C# |
| ArithmeticExpressionsMustDeclarePrecedence	| Verifies that the code does not rely on implied arithmetic operator precedence.	| C# |
| AttributeConstructorMustNotUseUnnecessaryParenthesis	| Verifies that parenthesis are removed from attribute constructors when there are no parameters.	| C# |
| BlockStatementsMustNotContainEmbeddedComments	| Validates that there are no comments placed between the declaration and opening bracket in a bracketed statement.	| C# |
| BlockStatementsMustNotContainEmbeddedRegions	| Validates that there are no regions placed between the declaration and opening bracket in a bracketed statement.	| C# |
| ChainedStatementBlocksMustNotBePrecededByBlankLine	| Validates than an else, catch, or finally statement is not preceded by a blank line.	| C# |
| ClassFieldShouldNotBePublicOrProtected	| 检查类成员是否定义了Public或者Protected修饰访问，有则给出告警	| C# |
| ClassStructMethodDelegateNameMustUseUpperCamelCase	| [必须]类、结构体、方法、delegate、枚举及枚举值须用大驼峰形式命名	| C# |
| ClosingAttributeBracketsMustBeSpacedCorrectly	| Validates the spacing before and after a closing attribute bracket.	| C# |
| ClosingCurlyBracketMustBeFollowedByBlankLine	| Validates that a bracketed statement or element is followed by a blank line.	| C# |
| ClosingCurlyBracketsMustBeSpacedCorrectly	| Validates the spacing before and after a closing curly bracket.	| C# |
| ClosingCurlyBracketsMustNotBePrecededByBlankLine	| Validates that a closing curly bracket in a bracketed statement or element is not preceded by a blank line.	| C# |
| ClosingGenericBracketsMustBeSpacedCorrectly	| Validates the spacing before and after a closing bracket in a generic type.	| C# |
| ClosingParenthesisMustBeOnLineOfLastParameter	| Verifies that the closing bracket of a parameter list is placed just after the last parameter, on the same line.	| C# |
| ClosingParenthesisMustBeOnLineOfOpeningParenthesis	| Verifies that the closing bracket of a parameter list is placed just after the opening bracket when the method has no parameters.	| C# |
| ClosingParenthesisMustBeSpacedCorrectly	| Validates the spacing before and after a closing parenthesis.	| C# |
| ClosingSquareBracketsMustBeSpacedCorrectly	| Validates the spacing before and after a closing square bracket.	| C# |
| CodeAnalysisSuppressionMustHaveJustification	| Validates that a Code Analysis suppression contains a justifiction describing the reason for the suppression.	| C# |
| CodeMustNotContainBlankLinesAtEndOfFile	| Validates that the code does not contain blank lines at the end of the file.	| C# |
| CodeMustNotContainBlankLinesAtStartOfFile	| Validates that the code does not contain blank lines at the start of the file.	| C# |
| CodeMustNotContainEmptyStatements	| [必须]不允许存在空的语句	| C# |
| CodeMustNotContainMultipleBlankLinesInARow	| Validates that the code does not contain multiple blank lines in a row.	| C# |
| CodeMustNotContainMultipleStatementsOnOneLine	| [必须]一行只能有一个语句	| C# |
| CodeMustNotContainMultipleWhitespaceInARow	| Verifies that the code does not contain more than one spacing in a row.	| C# |
| CodeMustNotContainSpaceAfterNewKeywordInImplicitlyTypedArrayAllocation	| Verifies that there is no space between the new keyword and the opening square bracket in an implicitly typed array allocation.	| C# |
| ColonsMustBeSpacedCorrectly	| Validates the spacing before and after a colon.	| C# |
| CommaMustBeOnSameLineAsPreviousParameter	| Verifies that a comma between two parameters is placed just after the previous parameter, on the same line.	| C# |
| CommaOrSemicolonMustBeFollowedBySpaceOrEndOfLine	| [必须]逗号、分号后须跟空格或换行	| C# |
| CommaOrSemicolonOrCloseParenthesisMustNotBeFollowedByComment	| [必须]逗号、分号、右括号后不能紧跟注释	| C# |
| CommasMustBeSpacedCorrectly	| Validates the spacing before and a comma.	| C# |
| CommentMustBeFollowedByItsCommentTarget	| [必须]注释语句与其注释对象之间不能空行	| C# |
| CommentMustUseCSharpXMLDocumentCommentFormat	| [必须]注释必须使用C#标准的XML文档注释格式	| C# |
| CommentsMustContainText	| The comment is empty. Add text to the comment or remove it.	| C# |
| ConditionalExpressionsMustDeclarePrecedence	| Verifies that the code does not rely on implied conditional operator precedence.	| C# |
| ConstFieldNameMustNotContainUnderscore	| [推荐]const型成员变量建议不带前缀和下划线	| C# |
| ConstFieldNameMustUseUpperCamelCase	| [推荐]const型成员变量命名建议用大驼峰形式	| C# |
| ConstFieldNamesMustBeginWithUpperCaseLetter	| Validates that the name of a constant begins with an upper-case letter.	| C# |
| ConstVariableNameMustUseUpperCamelCase	| [推荐]const型变量命名须用大驼峰形式	| C# |
| ConstantsMustAppearBeforeFields	| Validates that all constant elements are placed before non-constant elements of the same type.	| C# |
| ConstructorSummaryDocumentationMustBeginWithStandardText	| Verifies that a constructor's summary text begins with the appropriate wording.	| C# |
| CurlyBracketsForMultiLineStatementsMustNotShareLine	| Validates that the opening or closing curly bracket in a bracketed statement is placed on its own line if the statement spans multiple lines.	| C# |
| CurlyBracketsMustNotBeOmitted	| Validates that opening and closing curly brackets are always included, even if the statement type allows them to be omitted.	| C# |
| DebugAssertMustProvideMessageText	| Validates that calls to Debug.Assert provide a message in the second parameter describing the reason for the assert.	| C# |
| DebugFailMustProvideMessageText	| Validates that calls to Debug.Fail provide a message in the first parameter describing the reason for the failure.	| C# |
| DeclarationKeywordsMustFollowOrder	| Verifies the ordering of keywords in an element declaration.	| C# |
| DeclaritionInGlobalNameSpaceIsForbidden	| [必须]禁止在全局命名空间声明类型	| C# |
| DelegateNameShouldBePascal	| 检查委托的命名是否符合Pascal命名规范，没有则给出告警	| C# |
| DelegateNameShouldEndsWithEventHandler	| 检查委托的命名是否以EventHandler结尾，没有则给出告警	| C# |
| DereferenceAndAccessOfSymbolsMustBeSpacedCorrectly	| Validates the spacing before and after a dereference or address-of symbol.	| C# |
| DestructorSummaryDocumentationMustBeginWithStandardText	| Verifies that a destructor's summary text begins with the appropriate wording.	| C# |
| DoNotPlaceRegionsWithinElements	| Prevents the use of regions within code elements, which limits code readability.	| C# |
| DoNotPrefixCallsWithBaseUnlessLocalImplementationExists	| Verifies that the 'base.' prefix is not misused.	| C# |
| DoNotSplitNullConditionalOperators	| Verifies that the code does not contain new rows or spaces.	| C# |
| DoNotUseRegions	| Prevents the use of regions anywhere within the code.	| C# |
| DocumentationHeadersMustNotContainBlankLines	| Verifies that a documentation header does not contain blank lines.	| C# |
| DocumentationLinesMustBeginWithSingleSpace	| Verifies that the forward slashes at the beginning of an documentation header line are followed by a single space.	| C# |
| DocumentationMustContainValidXml	| Indicates that a documentation header is composed of invalid Xml and cannot be parsed.	| C# |
| DocumentationMustMeetCharacterPercentage	| Verifies that the documentation text within a documentation section does not contain an excessive amount of symbols, making it difficult to read.	| C# |
| DocumentationTextMustBeginWithACapitalLetter	| Validates that the documentation text within a documentation section begins with a capital letter.	| C# |
| DocumentationTextMustContainWhitespace	| Verifies that the documentation text within a documentation section contains at least two words, separated by whitespace.	| C# |
| DocumentationTextMustEndWithAPeriod	| Validates that the documentation text within a documentation section ends with a period.	| C# |
| DocumentationTextMustMeetMinimumCharacterLength	| Verifies that the documentation text within a documentation section meets or exceeds the minimum length.	| C# |
| DocumentationTextMustNotBeEmpty	| Validates that the description within a documentation tag is filled-in.	| C# |
| ElementDocumentationHeaderMustBePrecededByBlankLine	| Validates that a documentation header is preceded by a blank line, or is the first item in its scope.	| C# |
| ElementDocumentationHeadersMustNotBeFollowedByBlankLine	| Validates that a documentation header is not followed by a blank line.	| C# |
| ElementDocumentationMustBeSpelledCorrectly	| Validates that an element's documentation header contains correctly spelled words.	| C# |
| ElementDocumentationMustHaveSummary	| Validates that a documentation header contains a properly formatted summary tag.	| C# |
| ElementDocumentationMustHaveSummaryText	| Validates that an element's summary tag contains a filled-in description.	| C# |
| ElementDocumentationMustNotBeCopiedAndPasted	| Validates that an element's documentation header does not contain repeated documentation text.	| C# |
| ElementDocumentationMustNotHaveDefaultSummary	| Validates that the summary tag in an element's documentation header is not the default text generated by Visual Studio.	| C# |
| ElementMustBeginWithLowerCaseLetter	| Validates that names of certain types of elements begin with a lower-case letter.	| C# |
| ElementMustBeginWithUpperCaseLetter	| Validates that names of certain types of elements begin with an upper-case letter.	| C# |
| ElementMustNotBeOnSingleLine	| Validates that a bracketed element is not placement on a single line.	| C# |
| ElementParameterDocumentationMustDeclareParameterName	| Validates that all param tags in an element's documentation header contain a filled-in name attribute.	| C# |
| ElementParameterDocumentationMustHaveText	| Validates that an element's documentation header contains filled-in descriptions for each parameter in the element's parameter list.	| C# |
| ElementParameterDocumentationMustMatchElementParameters	| Validates that an element's documentation header does not contain param tags for parameters which do not exist in the element's parameter list.	| C# |
| ElementParametersMustBeDocumented	| Validates that an element's documentation header contains a param tag for each item in the element's parameter list.	| C# |
| ElementReturnValueDocumentationMustHaveText	| Validates that an element's returns tag contains a filled-in description.	| C# |
| ElementReturnValueMustBeDocumented	| Validates that an element's documentation header contains a returns tag if the element has a return value.	| C# |
| ElementsMustAppearInTheCorrectOrder	| Validates that elements are placed in the correct order.	| C# |
| ElementsMustBeDocumented	| Validates that an element contains a properly formatted documentation header.	| C# |
| ElementsMustBeOrderedByAccess	| Validates that elements of the same type are placed in order by access.	| C# |
| ElementsMustBeSeparatedByBlankLine	| Validates that adjacent elements are separated by a blank line.	| C# |
| EnumItemNameShouldBePascal	| 检查枚举值的命名是否符合Pascal命名规范，没有则给出告警	| C# |
| EnumItemNameShouldNotContainEnumName	| 检查枚举值的命名是否含有枚举类型名称，有则给出告警	| C# |
| EnumNameShouldBePascal	| 检查枚举的命名是否符合Pascal命名规范，没有则给出告警	| C# |
| EnumNameShouldNotContainEnum	| 检查枚举的命名是否函数Enum单词，没有则给出告警	| C# |
| EnumOrEnumItemNameMustUseUpperCamelCase	| [必须]类、结构体、方法、delegate、枚举及枚举值须用大驼峰形式命名	| C# |
| EnumerationItemsMustBeDocumented	| Validates that an item within an enumeration contains a properly formatted documentation header.	| C# |
| EventAccessorsMustFollowOrder	| Verifies that add-accessors are placed before remove-accessors within events.	| C# |
| EventNameShouldEndsWithEvent	| 检查事件的命名是否以Event结尾，没有则给出告警	| C# |
| FieldNameShouldBePascal	| 检查结构体成员的命名是否符合Pascal命名规范，没有则给出告警	| C# |
| FieldNameShouldNotContainStructName	| 检查结构体成员的命名是否含有结构体类型名，有则给出告警	| C# |
| FieldNamesMustBeginWithLowerCaseLetter	| Validates that the name of a variable or field begins with a lower-case letter.	| C# |
| FieldNamesMustNotBeginWithUnderscore	| Validates that the name of a field does not begin with an underscore.	| C# |
| FieldNamesMustNotContainUnderscore	| Validates that the name of a field does not contain underscores.	| C# |
| FieldNamesMustNotUseHungarianNotation	| Validates that a variable name is not prepended with lower-case characters matching the signature of Hungarian notation.	| C# |
| FieldsMustBePrivate	| Validates that a field is declared with private access.	| C# |
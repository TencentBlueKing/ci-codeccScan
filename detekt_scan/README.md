## 概述:
Detekt是Kotlin语言代码分析工具，除了能扫出编码的风格规范问题之外，还能检查出代码的复杂度、某些潜在逻辑错误以及性能问题，告警类型多达152种。该工程以容器方式，对Detekt工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

sdk：适配工具脚步路径

tool：工具二进制路径

third_rules: 自定义规则扩展目录

## 工具版本：

detekt: 1.0.0-RC14

## 镜像打包:
打包命令：docker build -t detekt_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：
{"projName":"DEVOPS_EC2615AF7D1229FC","projectId":"codecc","scanPath":"/data/iegci/test_tool/test_code/CodeccCheckAtomDebug","whitePathList":[],"scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.temp/.*"],"incrementalFiles":[],"openCheckers":[{"checkerName":"EnumNaming","nativeChecker":true},{"checkerName":"EmptyDoWhileBlock","nativeChecker":true},{"checkerName":"ThrowsCount","nativeChecker":true,"checkerOptions":[{"checkerOptionName":"max","checkerOptionValue":"2"}]}]}


### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.kt", "/data/project/code/src/test.kt"]] |
| openCheckers | 打开的规则列表 | [{"checkerName":"EnumNaming","nativeChecker":true},{"checkerName":"EmptyDoWhileBlock","nativeChecker":true}] |
| checkerName | 规则名称, 参考附2 | EnumNaming |
| nativeChecker | 是否工具默认规则 | true |

## 镜像运行:
docker run -it detekt_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"checkerName":"ComplexMethod","description":"The function execute appears to be too complex.","filePath":"/data/iegci/test_tool/test_code/CodeccCheckAtomDebug/src/main/kotlin/com/tencent/devops/v3/CodeccCheckAtom.kt","line":"22"},{"checkerName":"TooGenericExceptionCaught","description":"Caught exception is too generic. Prefer catching specific exceptions to the case that is currently handled.","filePath":"/data/iegci/test_tool/test_code/CodeccCheckAtomDebug/src/main/kotlin/com/tencent/devops/v3/CodeccCheckAtom.kt","line":"62"}]}

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
| ArrayPrimitive	| Reports when Array is used. Prefer using Kotlin specialized Array Instances such as IntArray, ByteArray and so on.	| Kotlin |
| ClassNaming	| Reports when class or object names which do not follow the specified naming convention are used.	| Kotlin |
| CollapsibleIfStatements	| This rule detects if statements which can be collapsed.	| Kotlin |
| CommentOverPrivateFunction	| This rule reports comments and documentation that has been added to private functions.	| Kotlin |
| CommentOverPrivateProperty	| This rule reports comments and documentation above private properties.	| Kotlin |
| ComplexCondition	| Complex conditions make it hard to understand which cases lead to the condition being true or false. To improve readability and understanding of complex conditions consider extracting them into well-named functions or variables and call those instead.	| Kotlin |
| ComplexInterface	| This rule reports complex interfaces which contain too many functions and/or properties.	| Kotlin |
| ComplexMethod	| Complex methods are hard to understand and read. It might not be obvious what side-effects a complex method has. Prefer splitting up complex methods into smaller methods that are in turn easier to understand. Smaller methods can also be named much clearer which leads to improved readability of the code.	| Kotlin |
| ConstructorParameterNaming	| Reports constructor parameter names which do not follow the specified naming convention are used.	| Kotlin |
| DataClassContainsFunctions	| "This rule reports functions inside data classes which have not been whitelisted as a conversion function.Data classes should mainly be used to store data. This rule assumes that they should not contain any extra functions aside functions that help with converting objects from/to one another. Data classes will automatically have a generated equals, toString and hashCode function by the compiler."	| Kotlin |
| DuplicateCaseInWhenExpression	| "Flags duplicate case statements in when expressions.If a when expression contains the same case statement multiple times they should be merged. Otherwise it might be easy to miss one of the cases when reading the code, leading to unwanted side effects."	| Kotlin |
| EmptyCatchBlock	| Reports empty catch blocks.	| Kotlin |
| EmptyClassBlock	| Reports empty classes.	| Kotlin |
| EmptyDefaultConstructor	| Reports empty default constructors.	| Kotlin |
| EmptyDoWhileBlock	| Reports empty do/while loops.	| Kotlin |
| EmptyElseBlock	| Reports empty else blocks.	| Kotlin |
| EmptyFinallyBlock	| Reports empty finally blocks.	| Kotlin |
| EmptyForBlock	| Reports empty for loops.	| Kotlin |
| EmptyFunctionBlock	| Reports empty functions.	| Kotlin |
| EmptyIfBlock	| Reports empty if blocks.	| Kotlin |
| EmptyInitBlock	| Reports empty init expressions.	| Kotlin |
| EmptyKtFile	| Reports empty Kotlin (.kt) files.	| Kotlin |
| EmptySecondaryConstructor	| Reports empty secondary constructors.	| Kotlin |
| EmptyWhenBlock	| Reports empty when expressions.	| Kotlin |
| EmptyWhileBlock	| Reports empty while expressions.	| Kotlin |
| EndOfSentenceFormat	| This rule validates the end of the first sentence of a KDoc comment.	| Kotlin |
| EnumNaming	| Reports when enum names which do not follow the specified naming convention are used.	| Kotlin |
| EqualsAlwaysReturnsTrueOrFalse	| Reports equals() methods which will always return true or false.	| Kotlin |
| EqualsNullCall	| To compare an object with null prefer using ==. This rule detects and reports instances in the code where the equals() method is used to compare a value with null.	| Kotlin |
| EqualsOnSignatureLine	| Requires that the equals sign, when used for an expression style function, is on the same line as the rest of the function signature.	| Kotlin |
| EqualsWithHashCodeExist	| "When a class overrides the equals() method it should also override the hashCode() method.All hash-based collections depend on objects meeting the equals-contract. Two equal objects must produce the same hashcode. When inheriting equals or hashcode, override the inherited and call the super method for clarification"	| Kotlin |
| ExplicitGarbageCollectionCall	| Reports all calls to explicitly trigger the Garbage Collector. Code should work independently of the garbage collector and should not require the GC to be triggered in certain points in time.	| Kotlin |
| ExplicitItLambdaParameter	| Lambda expressions are one of the core features of the language. They often include very small chunks of code using only one parameter. In this cases Kotlin can supply the implicit it parameter to make code more concise. It fits most usecases, but when faced larger or nested chunks of code, you might want to add an explicit name for the parameter. Naming it just it is meaningless and only makes your code misleading, especially when dealing with nested functions.	| Kotlin |
| ExpressionBodySyntax	| Functions which only contain a return statement can be collapsed to an expression body.	| Kotlin |
| ForEachOnRange	| Reports when a forEach method on ranges is used. Prefer using simple for loops.	| Kotlin |
| ForbiddenClassName	| Reports class names which are forbidden per configuration.	| Kotlin |
| ForbiddenComment	| This rule allows to set a list of comments which are forbidden in the codebase and should only be used during development. Offending code comments will then be reported.	| Kotlin |
| ForbiddenImport	| This rule allows to set a list of forbidden imports. This can be used to discourage the use of unstable, experimental or deprecated APIs. Detekt will then report all imports that are forbidden.	| Kotlin |
| ForbiddenVoid	| This rule detects usages of Void and reports them as forbidden. The Kotlin type Unit should be used instead. This type corresponds to the Void class in Java and has only one value - the Unit object.	| Kotlin |
| FunctionMaxLength	| Reports when very long function names are used.	| Kotlin |
| FunctionMinLength	| Reports when very short function names are used.	| Kotlin |
| FunctionNaming	| Reports when function names which do not follow the specified naming convention are used.	| Kotlin |
| FunctionOnlyReturningConstant	| This rule detects functions that only returns a single constant. Instead prefer to define the constant directly as a const val.	| Kotlin |
| FunctionParameterNaming	| Reports function parameter names which do not follow the specified naming convention are used.	| Kotlin |
| InvalidRange	| Reports ranges which are empty.	| Kotlin |
| IteratorHasNextCallsNextMethod	| Verifies implementations of the Iterator interface. The hasNext() method of an Iterator implementation should not have any side effects. This rule reports implementations that call the next() method of the Iterator inside the hasNext() method.	| Kotlin |
| IteratorNotThrowingNoSuchElementException	| Reports implementations of the Iterator interface which do not throw a NoSuchElementException in the implementation of the next() method. When there are no more elements to return an Iterator should throw a NoSuchElementException.	| Kotlin |
| LabeledExpression	| This rule reports labeled expressions. Expressions with labels generally increase complexity and worsen the maintainability of the code. Refactor the violating code to not use labels instead. Labeled expressions referencing an outer class with a label from an inner class are allowed, because there is no way to get the instance of an outer class from an inner class in Kotlin.	| Kotlin |
| LargeClass	| This rule reports class which have too many lines.	| Kotlin |
| LateinitUsage	| "Turn on this rule to flag usages of the lateinit modifier.Using lateinit for property initialization can be error prone and the actual initialization is not guaranteed. Try using constructor injection or delegation to initialize properties"	| Kotlin |
| LongMethod	| This rule reports methods which have too many lines.	| Kotlin |
| LongParameterList	| Reports functions which have more parameters than a certain threshold.	| Kotlin |
| LoopWithTooManyJumpStatements	| Loops which contain multiple break or continue statements are hard to read and understand. To increase readability they should be refactored into simpler loops.	| Kotlin |
| MagicNumber	| This rule detects and reports usages of magic numbers in the code. Prefer defining constants with clear names describing what the magic number means.	| Kotlin |
| MandatoryBracesIfStatements	| This rule detects multi-line if statements which do not have braces. Adding braces would improve readability and avoid possible errors.	| Kotlin |
| MatchingDeclarationName	| “If a Kotlin file contains a single non-private class (potentially with related top-level declarations), its name should be the same as the name of the class, with the .kt extension appended. If a file contains multiple classes, or only top-level declarations, choose a name describing what the file contains, and name the file accordingly. Use camel humps with an uppercase first letter"	| Kotlin |
| MaxLineLength	| This rule reports lines of code which exceed a defined maximum line length.	| Kotlin |
| MayBeConst	| This rule identifies and reports properties (val) that may be const val instead. Using const val can lead to better performance of the resulting bytecode as well as better interoperability with Java.	| Kotlin |
| MemberNameEqualsClassName	| This rule reports a member that has the same as the containing class or object.	| Kotlin |
| MethodOverloading	| This rule reports methods which are overloaded often.	| Kotlin |
| ModifierOrder	| This rule reports cases in the code where modifiers are not in the correct order.	| Kotlin |
| NestedBlockDepth	| This rule reports excessive nesting depth in functions.	| Kotlin |
| NestedClassesVisibility	| Nested classes are often used to implement functionality local to the class it is nested in. Therefore it should not be public to other parts of the code. Prefer keeping nested classes private.	| Kotlin |
| NewLineAtEndOfFile	| This rule reports files which do not end with a line separator.	| Kotlin |
| NoTabs	| This rule reports if tabs are used in Kotlin files.	| Kotlin |
| ObjectPropertyNaming	| Reports when property names inside objects which do not follow the specified naming convention are used.	| Kotlin |
| OptionalAbstractKeyword	| This rule reports abstract modifiers which are unnecessary and can be removed.	| Kotlin |
| OptionalUnit	| It is not necessary to define a return type of Unit on functions or to specify a lone Unit statement. This rule detects and reports instances where the Unit return type is specified on functions and the occurrences of a lone Unit statement.	| Kotlin |
| OptionalWhenBraces	| This rule reports unnecessary braces in when expressions. These optional braces should be removed.	| Kotlin |
| PackageNaming	| Reports when package names which do not follow the specified naming convention are used.	| Kotlin |
| PreferToOverPairSyntax	| This rule detects the usage of the Pair constructor to create pairs of values. Using to is preferred.	| Kotlin |
| ProtectedMemberInFinalClass	| Kotlin classes are final by default. Thus classes which are not marked as open should not contain any protected members. Consider using private or internal modifiers instead.	| Kotlin |
| RedundantVisibilityModifierRule	| This rule checks for redundant visibility modifiers.	| Kotlin |
| ReturnCount	| Restrict the number of return methods allowed in methods. Having many exit points in a function can be confusing and impacts readability of the code.	| Kotlin |
| SafeCast	| This rule inspects casts and reports casts which could be replaced with safe casts instead.	| Kotlin |
| SerialVersionUIDInSerializableClass	| Classes which implement the Serializable interface should also correctly declare a serialVersionUID. This rule verifies that a serialVersionUID was correctly defined.	| Kotlin |
| SpacingBetweenPackageAndImports	| This rule verifies spacing between package and import statements as well as between import statements and class declarations.	| Kotlin |
| SpreadOperator	| Using a spread operator causes a full copy of the array to be created before calling a method. This has a very high performance penalty.	| Kotlin |
| StringLiteralDuplication	| This rule detects and reports duplicated String literals.	| Kotlin |
| ThrowingExceptionFromFinally	| This rule reports all cases where exceptions are thrown from a finally block. Throwing exceptions from a finally block should be avoided as it can lead to confusion and discarded exceptions.	| Kotlin |
| ThrowingExceptionsWithoutMessageOrCause	| This rule reports all exceptions which are thrown without arguments or further description. Exceptions should always call one of the constructor overloads to provide a message or a cause. Exceptions should be meaningful and contain as much detail about the error case as possible. This will help to track down an underlying issue in a better way.	| Kotlin |
| ThrowingNewInstanceOfSameException	| Exceptions should not be wrapped inside the same exception type and then rethrown. Prefer wrapping exceptions in more meaningful exception types.	| Kotlin |
| ThrowsCount	| Functions should have clear throw statements. Functions with many throw statements can be harder to read and lead to confusion. Instead prefer to limit the amount of throw statements in a function.(max value 2) 	| Kotlin |
| TooGenericExceptionCaught	| This rule reports catch blocks for exceptions that have a type that is too generic. It should be preferred to catch specific exceptions to the case that is currently handled. If the scope of the caught exception is too broad it can lead to unintended exceptions being caught.	| Kotlin |
| TooGenericExceptionThrown	| This rule reports thrown exceptions that have a type that is too generic. It should be preferred to throw specific exceptions to the case that has currently occurred.	| Kotlin |
| TooManyFunctions	| This rule reports files, classes, interfaces, objects and enums which contain too many functions. Each element can be configured with different thresholds.	| Kotlin |
| TopLevelPropertyNaming	| Reports when top level constant names which do not follow the specified naming convention are used.	| Kotlin |
| TrailingWhitespace	| This rule reports lines that end with a whitespace.	| Kotlin |
| UnconditionalJumpStatementInLoop	| Reports loops which contain jump statements that jump regardless of any conditions.	| Kotlin |
| UnderscoresInNumericLiterals	| This rule detects and reports decimal base 10 numeric literals above a certain length that should be underscore separated for readability. Underscores that do not make groups of 3 digits are also reported even if their length is under the acceptableDecimalLength. For Serializable classes or objects, the field serialVersionUID is explicitly ignored.	| Kotlin |
| UndocumentedPublicClass	| This rule reports public classes, objects and interfaces which do not have the required documentation.	| Kotlin |
| UndocumentedPublicFunction	| This rule will report any public function which does not have the required documentation.	| Kotlin |
| UnnecessaryAbstractClass	| This rule inspects abstract classes. In case an abstract class does not have any concrete members it should be refactored into an interface. Abstract classes which do not define any abstract members should instead be refactored into concrete classes.	| Kotlin |
| UnnecessaryApply	| apply expressions are used frequently, but sometimes their usage should be replaced with an ordinary method/extension function call to reduce visual complexity	| Kotlin |
| UnnecessaryInheritance	| This rule reports unnecessary super types. Inheriting from Any or Object is unnecessary and should simply be removed.	| Kotlin |
| UnnecessaryLet	| let expressions are used extensively in our code for null-checking and chaining functions, but sometimes their usage should be replaced with a ordinary method/extension function call to reduce visual complexity	| Kotlin |
| UnnecessaryParentheses	| This rule reports unnecessary parentheses around expressions. These unnecessary parentheses can safely be removed.	| Kotlin |
| UnnecessaryTemporaryInstantiation	| Avoid temporary objects when converting primitive types to String. This has a performance penalty when compared to using primitive types directly. To solve this issue, remove the wrapping type.	| Kotlin |
| UnreachableCode	| Reports unreachable code.	| Kotlin |
| UnsafeCallOnNullableType	| Reports unsafe calls on nullable types. These calls will throw a NullPointerException in case the nullable value is null. Kotlin provides many ways to work with nullable types to increase null safety. Guard the code appropriately to prevent NullPointerExceptions.	| Kotlin |
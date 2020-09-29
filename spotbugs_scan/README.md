## 概述:
SpotBugs 是FindBugs的继任者，使用静态分析来查找Java代码中bug。是一款自由软件，按照GNU Lesser General Public License 的条款发布。该工程以容器方式，对spotbugs工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
sdk：适配工具脚步路径

software: 安装包路径

tool: 工具二进制路径

## 工具版本：

spotbugs 4.0.6

## 入参文件编写:

### input.json模版：
{"projName":"DEVOPS_A6AC1784A0951044","scanPath":"/data/iegci/test_tool/test_code/codeFormatTest","whitePathList":[],"toolOptions":[{"optionName":"subPath","optionValue":"./spotbugs_scan/tool"}],"buildScript":"/data/build.sh","scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.temp/.*"],"incrementalFiles":[],"openCheckers":[{"checkerName":"BC-IMPOSSIBLE-DOWNCAST","nativeChecker":true},{"checkerName":"BC-IMPOSSIBLE-CAST","nativeChecker":true}]}


### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| toolOptions | 工具属性,指定spotbugs安装路径 | [{"optionName":"subPath","optionValue":"./spotbugs_scan/tool"}] |
| buildScript | java项目编译脚步路径 | /data/build.sh |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.java", "/data/project/code/src/test.java"]] |
| openCheckers | 打开的规则列表 | [{"checkerName":"BC-IMPOSSIBLE-DOWNCAST","nativeChecker":true},{"checkerName":"BC-IMPOSSIBLE-CAST","nativeChecker":true}] |
| checkerName | 规则名称, 参考附2 | BC-IMPOSSIBLE-CAST |
| nativeChecker | 是否工具默认规则 | true |

## 命令运行:
cd ./spotbugs_scan

python3 ./src/spotbugs.py --input=/data/input.json --output=/data/output.json

## 结果描述：

### output.json模版：
{"defects":[{"checkerName":"BC-IMPOSSIBLE-CAST","description":" Impossible cast","filePath":"/data/iegci/test_tool/test_code/checkstyle_scan/sdk/src/config.java","line":"33"},{"checkerName":"BC-IMPOSSIBLE-DOWNCAST","description":" Impossible downcast ","filePath":"/data/iegci/test_tool/test_code/checkstyle_scan/sdk/src/config.java","line":"34"}]}

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
| AM-CREATES-EMPTY-JAR-FILE-ENTRY	| Creates an empty jar file entry	| JAVA |
| AM-CREATES-EMPTY-ZIP-FILE-ENTRY	| Creates an empty zip file entry	| JAVA |
| AT-OPERATION-SEQUENCE-ON-CONCURRENT-ABSTRACTION	| Sequence of calls to concurrent abstraction may not be atomic	| JAVA |
| BAC-BAD-APPLET-CONSTRUCTOR	| Bad Applet Constructor relies on uninitialized AppletStub	| JAVA |
| BC-BAD-CAST-TO-ABSTRACT-COLLECTION	| Questionable cast to abstract collection	| JAVA |
| BC-BAD-CAST-TO-CONCRETE-COLLECTION	| Questionable cast to concrete collection	| JAVA |
| BC-EQUALS-METHOD-SHOULD-WORK-FOR-ALL-OBJECTS	| Equals method should not assume anything about the type of its argument	| JAVA |
| BC-IMPOSSIBLE-CAST	| Impossible cast	| JAVA |
| BC-IMPOSSIBLE-DOWNCAST	| Impossible downcast	| JAVA |
| BC-IMPOSSIBLE-DOWNCAST-OF-TOARRAY	| Impossible downcast of toArray() result	| JAVA |
| BC-IMPOSSIBLE-INSTANCEOF	| instanceof will always return false	| JAVA |
| BC-UNCONFIRMED-CAST	| Unchecked/unconfirmed cast	| JAVA |
| BC-UNCONFIRMED-CAST-OF-RETURN-VALUE	| Unchecked/unconfirmed cast of return value from method	| JAVA |
| BC-VACUOUS-INSTANCEOF	| instanceof will always return true	| JAVA |
| BIT-ADD-OF-SIGNED-BYTE	| Bitwise add of signed byte value	| JAVA |
| BIT-AND	| Incompatible bit masks	| JAVA |
| BIT-AND-ZZ	| Check to see if ((…) & 0) == 0	| JAVA |
| BIT-IOR	| Incompatible bit masks	| JAVA |
| BIT-IOR-OF-SIGNED-BYTE	| Bitwise OR of signed byte value	| JAVA |
| BIT-SIGNED-CHECK	| Check for sign of bitwise operation	| JAVA |
| BIT-SIGNED-CHECK-HIGH-BIT	| Check for sign of bitwise operation involving negative number	| JAVA |
| BOA-BADLY-OVERRIDDEN-ADAPTER	| Class overrides a method implemented in super class Adapter wrongly	| JAVA |
| BSHIFT-WRONG-ADD-PRIORITY	| Possible bad parsing of shift operation	| JAVA |
| BX-BOXING-IMMEDIATELY-UNBOXED	| Primitive value is boxed and then immediately unboxed	| JAVA |
| BX-BOXING-IMMEDIATELY-UNBOXED-TO-PERFORM-COERCION	| Primitive value is boxed then unboxed to perform primitive coercion	| JAVA |
| BX-UNBOXED-AND-COERCED-FOR-TERNARY-OPERATOR	| Primitive value is unboxed and coerced for ternary operator	| JAVA |
| BX-UNBOXING-IMMEDIATELY-REBOXED	| Boxed value is unboxed and then immediately reboxed	| JAVA |
| CAA-COVARIANT-ARRAY-ELEMENT-STORE	| Possibly incompatible element is stored in covariant array	| JAVA |
| CAA-COVARIANT-ARRAY-FIELD	| Covariant array assignment to a field	| JAVA |
| CAA-COVARIANT-ARRAY-LOCAL	| Covariant array assignment to a local variable	| JAVA |
| CAA-COVARIANT-ARRAY-RETURN	| Covariant array is returned from the method	| JAVA |
| CD-CIRCULAR-DEPENDENCY	| Test for circular dependencies among classes	| JAVA |
| CI-CONFUSED-INHERITANCE	| Class is final but declares protected field	| JAVA |
| CN-IDIOM	| Class implements Cloneable but does not define or use clone method	| JAVA |
| CN-IDIOM-NO-SUPER-CALL	| clone method does not call super.clone()	| JAVA |
| CN-IMPLEMENTS-CLONE-BUT-NOT-CLONEABLE	| Class defines clone() but doesn’t implement Cloneable	| JAVA |
| CNT-ROUGH-CONSTANT-VALUE	| Rough value of known constant found	| JAVA |
| CO-ABSTRACT-SELF	| Abstract class defines covariant compareTo() method	| JAVA |
| CO-COMPARETO-INCORRECT-FLOATING	| compareTo()/compare() incorrectly handles float or double value	| JAVA |
| CO-COMPARETO-RESULTS-MIN-VALUE	| compareTo()/compare() returns Integer.MIN_VALUE	| JAVA |
| CO-SELF-NO-OBJECT	| Covariant compareTo() method defined	| JAVA |
| DB-DUPLICATE-BRANCHES	| Method uses the same code for two branches	| JAVA |
| DB-DUPLICATE-SWITCH-CLAUSES	| Method uses the same code for two switch clauses	| JAVA |
| DC-DOUBLECHECK	| Possible double check of field	| JAVA |
| DC-PARTIALLY-CONSTRUCTED	| Possible exposure of partially initialized object	| JAVA |
| DE-MIGHT-DROP	| Method might drop exception	| JAVA |
| DE-MIGHT-IGNORE	| Method might ignore exception	| JAVA |
| DL-SYNCHRONIZATION-ON-BOOLEAN	| Synchronization on Boolean	| JAVA |
| DL-SYNCHRONIZATION-ON-BOXED-PRIMITIVE	| Synchronization on boxed primitive	| JAVA |
| DL-SYNCHRONIZATION-ON-SHARED-CONSTANT	| Synchronization on interned String	| JAVA |
| DL-SYNCHRONIZATION-ON-UNSHARED-BOXED-PRIMITIVE	| Synchronization on boxed primitive values	| JAVA |
| DLS-DEAD-LOCAL-INCREMENT-IN-RETURN	| Useless increment in return statement	| JAVA |
| DLS-DEAD-LOCAL-STORE	| Dead store to local variable	| JAVA |
| DLS-DEAD-LOCAL-STORE-IN-RETURN	| Useless assignment in return statement	| JAVA |
| DLS-DEAD-LOCAL-STORE-OF-NULL	| Dead store of null to local variable	| JAVA |
| DLS-DEAD-LOCAL-STORE-SHADOWS-FIELD	| Dead store to local variable that shadows field	| JAVA |
| DLS-DEAD-STORE-OF-CLASS-LITERAL	| Dead store of class literal	| JAVA |
| DLS-OVERWRITTEN-INCREMENT	| Overwritten increment	| JAVA |
| DM-BOOLEAN-CTOR	| Method invokes inefficient Boolean constructor; use Boolean.valueOf(…) instead	| JAVA |
| DM-BOXED-PRIMITIVE-FOR-COMPARE	| Boxing a primitive to compare	| JAVA |
| DM-BOXED-PRIMITIVE-FOR-PARSING	| Boxing/unboxing to parse a primitive	| JAVA |
| DM-BOXED-PRIMITIVE-TOSTRING	| Method allocates a boxed primitive just to call toString	| JAVA |
| DM-CONVERT-CASE	| Consider using Locale parameterized version of invoked method	| JAVA |
| DM-DEFAULT-ENCODING	| Reliance on default encoding	| JAVA |
| DM-EXIT	| Method invokes System.exit(…)	| JAVA |
| DM-FP-NUMBER-CTOR	| Method invokes inefficient floating-point Number constructor; use static valueOf instead	| JAVA |
| DM-GC	| Explicit garbage collection; extremely dubious except in benchmarking code	| JAVA |
| DM-INVALID-MIN-MAX	| Incorrect combination of Math.max and Math.min	| JAVA |
| DM-MONITOR-WAIT-ON-CONDITION	| Monitor wait() called on Condition	| JAVA |
| DM-NEW-FOR-GETCLASS	| Method allocates an object, only to get the class object	| JAVA |
| DM-NEXTINT-VIA-NEXTDOUBLE	| Use the nextInt method of Random rather than nextDouble to generate a random integer	| JAVA |
| DM-NUMBER-CTOR	| Method invokes inefficient Number constructor; use static valueOf instead	| JAVA |
| DM-RUN-FINALIZERS-ON-EXIT	| Method invokes dangerous method runFinalizersOnExit	| JAVA |
| DM-STRING-CTOR	| Method invokes inefficient new String(String) constructor	| JAVA |
| DM-STRING-TOSTRING	| Method invokes toString() method on a String	| JAVA |
| DM-STRING-VOID-CTOR	| Method invokes inefficient new String() constructor	| JAVA |
| DM-USELESS-THREAD	| A thread was created using the default empty run method	| JAVA |
| DMI-ANNOTATION-IS-NOT-VISIBLE-TO-REFLECTION	| Can’t use reflection to check for presence of annotation without runtime retention	| JAVA |
| DMI-ARGUMENTS-WRONG-ORDER	| Reversed method arguments	| JAVA |
| DMI-BAD-MONTH	| Bad constant value for month	| JAVA |
| DMI-BIGDECIMAL-CONSTRUCTED-FROM-DOUBLE	| BigDecimal constructed from double that isn’t represented precisely	| JAVA |
| DMI-BLOCKING-METHODS-ON-URL	| The equals and hashCode methods of URL are blocking	| JAVA |
| DMI-CALLING-NEXT-FROM-HASNEXT	| hasNext method invokes next	| JAVA |
| DMI-COLLECTION-OF-URLS	| Maps and sets of URLs can be performance hogs	| JAVA |
| DMI-COLLECTIONS-SHOULD-NOT-CONTAIN-THEMSELVES	| Collections should not contain themselves	| JAVA |
| DMI-CONSTANT-DB-PASSWORD	| Hardcoded constant database password	| JAVA |
| DMI-DOH	| D’oh! A nonsensical method invocation	| JAVA |
| DMI-EMPTY-DB-PASSWORD	| Empty database password	| JAVA |
| DMI-ENTRY-SETS-MAY-REUSE-ENTRY-OBJECTS	| Adding elements of an entry set may fail due to reuse of Entry objects	| JAVA |
| DMI-FUTILE-ATTEMPT-TO-CHANGE-MAXPOOL-SIZE-OF-SCHEDULED-THREAD-POOL-EXECUTOR	| Futile attempt to change max pool size of ScheduledThreadPoolExecutor	| JAVA |
| DMI-HARDCODED-ABSOLUTE-FILENAME	| Code contains a hard coded reference to an absolute pathname	| JAVA |
| DMI-INVOKING-HASHCODE-ON-ARRAY	| Invocation of hashCode on an array	| JAVA |
| DMI-INVOKING-TOSTRING-ON-ANONYMOUS-ARRAY	| Invocation of toString on an unnamed array	| JAVA |
| DMI-INVOKING-TOSTRING-ON-ARRAY	| Invocation of toString on an array	| JAVA |
| DMI-LONG-BITS-TO-DOUBLE-INVOKED-ON-INT	| Double.longBitsToDouble invoked on an int	| JAVA |
| DMI-NONSERIALIZABLE-OBJECT-WRITTEN	| Non serializable object written to ObjectOutput	| JAVA |
| DMI-RANDOM-USED-ONLY-ONCE	| Random object created and used only once	| JAVA |
| DMI-SCHEDULED-THREAD-POOL-EXECUTOR-WITH-ZERO-CORE-THREADS	| Creation of ScheduledThreadPoolExecutor with zero core threads	| JAVA |
| DMI-THREAD-PASSED-WHERE-RUNNABLE-EXPECTED	| Thread passed where Runnable expected	| JAVA |
| DMI-UNSUPPORTED-METHOD	| Call to unsupported method	| JAVA |
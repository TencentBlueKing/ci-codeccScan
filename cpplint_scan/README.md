## 概述:
CppLint工具包含64种告警类型，支持对《Google C++风格指南》的检查，不仅能检查代码可读性，而且能检查C++11特性和代码中一些潜在的运行时安全问题。该工程以容器方式，对cpplint工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

sdk：适配工具脚步路径

tool：工具二进制路径

third_rules: 自定义规则扩展目录

## 工具版本：

cpplint：1.4.4

## 镜像打包:
打包命令：docker build -t cpplint_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：
{"projName":"DEVOPS_214A69F1F4F935DE","scanPath":"/data/iegci/test_tool/test_code/mqq_fastcgi_app","whitePathList":[],"scanType":"full","skipPaths":[".*/test/.*"],"incrementalFiles":[],"openCheckers":[{"checkerName":"build/include_order","nativeChecker":true},{"checkerName":"runtime/operator","nativeChecker":true}]}


### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.cpp", "/data/project/code/src/test.cpp"]] |
| openCheckers | 打开的规则列表 | [{"checkerName":"build/include_order","nativeChecker":true},{"checkerName":"runtime/operator","nativeChecker":true}] |
| checkerName | 规则名称, 参考附2 | build/include_order |
| nativeChecker | 是否工具默认规则 | true |

## 镜像运行:
docker run -it cpplint_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"checkerName":"legal/copyright","description":"No copyright message found.  You should have a line: \"Copyright [year] <Copyright Owner>\"","filePath":"/data/iegci/test_tool/test_code/mqq_fastcgi_app/cgi/business/mqq/qwallet_aacollection/qaa_deal_qry/qaa_deal_qry.h","line":"0"},{"checkerName":"build/header_guard","description":"#ifndef header guard has wrong style, please use: CGI_BUSINESS_MQQ_QWALLET_AACOLLECTION_QAA_DEAL_QRY_QAA_DEAL_QRY_H_","filePath":"/data/iegci/test_tool/test_code/mqq_fastcgi_app/cgi/business/mqq/qwallet_aacollection/qaa_deal_qry/qaa_deal_qry.h","line":"1"}]}

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
| build/c++11	| 1.检查对C++11标准提到的右值引用的使用，如果检查到使用右值引用，给出警告（未批准的C++特性）。<br> 2. 检查是否使用了默认的lambda捕获，如果使用了，给出警告（未批准的C++特性）。<br> 3. 检查是否include了未批准的C++特性的头文件，如cfenv、condition_variable等。如果检查到了，给出警告。<br> 4. 检查是否使用了std: : alignment_of或std: : aligned_union，如果使用了，给出警告。	| C/C++ |
| build/c++14	| 1.检查是否使用了未经批准的C++14头文件，如果使用了，给出警告。	| C/C++ |
| build/c++tr1	| 1.检查是否使用了未经批准的C++TR1头文件，如果使用了，给出警告。	| C/C++ |
| build/class	| 1.检查类声明是否完整，即类声明的结束部位是否含有“}”。如果没有，给出类声明不完整警告。	| C/C++ |
| build/deprecated	| 1. 检查是否使用了“&gt;?”或者“&lt;?”操作符。如果使用了，给出警告，并建议使用max或者min代替之。	| C/C++ |
| build/endif_comment	| 1.检查#endif后面是否跟有注释，如果没有注释，给出警告。	| C/C++ |
| build/explicit_make_pair	| 1.为了C++11的兼容性，省略make_pair中的模板参数，或者直接使用pair，或者直接构造一个pair。如果检测到make_pair中使用了模板参数，给出警告。	| C/C++ |
| build/forward_decl	| 1.在作用域内（如namespace作用域），检查是否使用了类似“class AA: : tt;”这种格式的前向声明。如果有这种前向声明，给出警告。	| C/C++ |
| build/header_define	| 检查OneSDK头文件是否使用#ifndef...#define进行保护，没有则给出告警	| C/C++ |
| build/header_guard	| 1.检查两点: (1)头文件中是否含有#ifndef、#define，(2)#ifndef和#define中的内容是否一样。如果上述两条有一条满足，给出警告。<br> 2. 检查#ifndef的格式是否正确，正确的命名格式是：PATH_FILE_H_。如果格式有出入，给出警告。<br> 3. 检查#endif的格式是否正确，正确的格式是#endif // PATH_FILE_H_。如果不满足这种格式，给出警告。<br> 4. 对上一点3的补充检查：检查#endif后面的注释，如果没有/* */或者//...格式注释，给出警告。	| C/C++ |
| build/include	| 1.检查每一个C++源文件是否都有一个对应的.h头文件，如果没有，给出警告。<br> 2. 检查include的头文件是否加上路径，如果没有，给出警告。<br> 3. 检查是否include了多次同一个头文件，如果是，给出警告。<br> 4. 不要include其他包里面的.cc文件。如果include了，给出警告。	| C/C++ |
| build/include_alpha	| 1.检查相同目录下头文件是否按字母序升序引用，如果没有，给出警告。	| C/C++ |
| build/include_order	| 1.检查include文件的顺序：本文件相应头文件，C系统文件，C++系统文件，其他库文件。	| C/C++ |
| build/include_what_you_use	| 1.检查是否添加必要的标准模版库，如果没有，给出警告。	| C/C++ |
| build/namespaces	| 1. 检查命名空间定义是否有结束标记，如果没有，给出警告。<br> 2. 检查是否使用了using编译指令，如果使用了，给出警告，提示用户使用using声明指令。<br> 3. 检查在.h文件中是否使用了不具名的命名控件，如果使用了，给出警告。	| C/C++ |
| build/namespaces_literals	| 检查使用usingstd; 建议使用具体命名空间，如：using std: string	| C/C++ |
| build/no_using	| 检查头文件是否使用了using namespace，有则给出告警	| C/C++ |
| build/printf_format	| 1. 检查是否使用了未定义的字符转义序列，如\%,\[,\(和\{。如果检查到这些转义序列，给出警告。	| C/C++ |
| build/storage_class	| 1. 存储类型的关键字（static、extern、typedef、etc）应该放在其他关键词（如const、volatile、void等）前面。如果没有放到前面，给出警告。	| C/C++ |
| legal/copyright	| 1. 检查文件中是否包含“Copyright [year]&lt;Copyright Owner&gt;”，如果不包含，给出警告。	| C/C++ |
| naming/capitalize	| 检查文件名首字母是否大写，没有则给出告警	| C/C++ |
| naming/extension	| 检查文件后缀名是否全部小写，没有则给出告警	| C/C++ |
| naming/underscore	| 检查文件名是否有下划线，有则给出告警	| C/C++ |
| readability/alt_tokens	| 1. 检查符号（and、bitor、or、xor、compl、bitand、and_eq、or_eq、xor_eq、not和not_eq）的使用，建议使用（&amp;&amp;、/、//、^、~、&amp;、&amp;=、|=、^=、!、!=）代替以上几类符号。	| C/C++ |
| readability/brace_new_line	| 检查{是否另起一行，没有则给出告警	| C/C++ |
| readability/braces	| 1. 检查if ... elseif ... elseif这种结构，如果其中有if或者else if使用了大括号({})，则其他的if或者else if没有使用大括号（{}），则给出警告。<br> 2. 检查if或else体中有多条语句时，是否有大括号{}。如果没有，则给出警告。<br> 3. 检查else是否和与之匹配的if有同样的缩进，如果没有，给出警告；同时建议用户，对于嵌套关系比较模糊的情况，使用{}标示。<br> 4. 检查右大括号}后面是否有“;”，如果有，给出警告。PS：对于namespace、class等正确的情况，不会给出警告。<br> 5. 检查if是否在单独一行，如果不在单独一行，给出警告。	| C/C++ |
| readability/casting	| 1.对基本类型，检查是否使用了过时的类型转换，建议使用static_cast()代替(type)这种转换方式。检查的类型有：int,float,double,bool,char,int32,uint32,int64,uint64.<br> 2. 检查是否在类型转换前面使用了取址操作符。如果使用了，给出警告。如以下语句就会收到警告：&down_cast(obj)->member_;', alt_error_msg)	| C/C++ |
| readability/check	| 1.检查ASSERT和CHECK断言的使用，建议使用ASSERT_EQ和CHECK_EQ等方式，而不是使用ASSERT_TRUE(condition)这种形式。	| C/C++ |
| readability/class_name	| 检查类名首字母大写/小写开头，默认为大写	| C/C++ |
| readability/constructors	| 1. 检查宏DISALLOW_COPY_AND_ASSIGN和DISALLOW_IMPLICIT_CONSTRUCTORS的作用域是否正确，正确的作用域为private。<br> 2. 检查宏DISALLOW_COPY_AND_ASSIGN和DISALLOW_IMPLICIT_CONSTRUCTORS的位置是否正确，正确的位置是在类的结束位置。	| C/C++ |
| readability/enum_name	| 检查枚举名首字母大写/小写开头，默认为大写	| C/C++ |
| readability/enum_naming	| 检查枚举是否有名称、是否以k开头，且是否符合Pascal命名规范，没有则给出告警	| C/C++ |
| readability/file_header	| 检查文件头是否包含Version/Module/Author标签，没有则给出告警	| C/C++ |
| readability/fn_size	| 1. 建议编写小巧、功能集中的函数，大于50行开始给出警告，具体警告等级和代码行数关系为：50 =&gt; 0, 100 =&gt; 1, 200 =&gt; 2, 400 =&gt; 3, 800 =&gt; 4, 1600 =&gt; 5；测试代码量可以加倍。<br> 2. 检查到函数定义，但是没有找到函数体的时候，给出警告。	| C/C++ |
| readability/function	| 1. 检查函数参数是否是不含参数名称的参数,如果是,给出警告.(如void test(int)会给出警告)	| C/C++ |
| readability/function_name	| 检查函数名称是否符合Pascal命名规范，没有则给出告警	| C/C++ |
| readability/inheritance	| 1. 在函数的后面如果有关键字final或者overrider，表示该函数不可以为虚函数，如果检查到final或overrider修饰的函数有virtual修饰，会给出警告。	| C/C++ |
| readability/interface_ctor_dtor	| 检查接口是否有virtual析构函数，没有则给出告警	| C/C++ |
| readability/interface_function	| 检查接口函数声明是否包含virtual修饰符，且是纯虚函数，没有则给出告警	| C/C++ |
| readability/interface_name	| 检查接口名称首字母大写，且以I开头，没有则给出告警	| C/C++ |
| readability/macro_naming	| 检查枚举名称是否全部大写，或以下划线分隔，没有则给出告警	| C/C++ |
| readability/multiline_comment	| 1. 多行注释，如果没有搜索到注释结束标识符，给出警告。<br> 2. 检测到了多行注释/* */，lint工具可能会对此给出警告，建议使用//代替之。	| C/C++ |
| readability/multiline_string	| 1. 检测到有字符串分多行显示时，“...”这种连接多行字符串的方式在lint中会得到警告，建议使用C++11的raw strings或者concatenation代替。	| C/C++ |
| readability/namespace	| 1. 检查namespace的结束位置是否有注释，注释格式为namespace“//namespace xxx”。<br> 2. 检查匿名namespace的结束位置注释是否合法，注释格式应该为“//namespace”或者“//anonymous namespace”	| C/C++ |
| readability/nolint	| 1. 检查文件中是否有未知的NOLINT错误分类<br> 2. 检查未知的分类GLOBAL_NOLINT；	| C/C++ |
| readability/ns_gcloud	| 检查OneSDK头文件是否以namepace Gcloud{}包括，没有则给出告警	| C/C++ |
| readability/nul	| 1. 检查文件中是否存在'\0'字符，即NUL字符，如果存在，给出警告。	| C/C++ |
| readability/streams	| 1. 建议不要使用流（google C++编程规范条目），新版本cpplint已经不支持对此条目的检查。	| C/C++ |
| readability/struct_name	| 检查结构体名首字母大写/小写开头，默认为大写	| C/C++ |
| readability/struct_naming	| 检查结构体名称、成员命名是否符合Pascal规范	| C/C++ |
| readability/todo	| 1. 检查TODO注释的格式是否正确，建议格式为“// TODO(my_username): Stuff.”	| C/C++ |
| readability/union_name	| 检查联合体名首字母大写/小写开头，默认为大写	| C/C++ |
| readability/utf8	| 1. 检查文件中是否包含非法的UTF-8字符，如果存在，给出警告。	| C/C++ |
| readability/utf8-tosa	| 文件编码必须是utf8	| C/C++ |
| runtime/arrays	| 1. 检查是否使用变量来初始化数组。如果发现了，给出警告，并建议使用编译时常量来初始化数组。	| C/C++ |
| runtime/casting	| 1. 检查是否在类型转换前面使用了取址操作符。如果使用了，给出警告，因为这种用法有可能获取临时变量的地址。如以下语句就会收到警告：&amp;down_cast&lt;Obj*&gt;(obj)-&gt;member_;', alt_error_msg)	| C/C++ |
| runtime/explicit	| 1. 检查只有一个参数的构造函数(默认参数不算)是否使用了explicit关键字。如果没有使用，给出警告。<br> 2. 检查没有参数的构造函数是否使用了explicit关键字。如果使用了，给出警告。 3. 检查有多个参数的构造函数是否使用了explicit关键字。如果使用了，给出警告。	| C/C++ |
| runtime/indentation_namespace	| 1. 检查是否在namespace中存在缩进。如果有，给出警告。	| C/C++ |
| runtime/init	| 1. 检查是否存在使用变量自身初始化自己的情况。如果存在这种情况，给出警告。	| C/C++ |
| runtime/int	| 1. 检查port前面是否使用了unsigned short修饰。如果不是，给出警告。<br> 2. 检查是否使用了short、long、long long。如果发现使用了这些，给出警告，并建议使用int16、int64等代替之。	| C/C++ |
| runtime/invalid_increment	| 1. 检查是否有使用（*++、*--）的情况。如果使用了这种情况，给出警告，提示这种情况会同时改变指针的位置。	| C/C++ |
| runtime/member_string_references	| 1. 检查是否定义了const xxx&amp;这种类型的类数据成员。如果存在，给出警告，建议使用指针代替之。	| C/C++ |
| runtime/memset	| 1. 检查memset是否有书写错误。如果检查到类似于memset(buf, sizeof(buf), 0)，则是一个潜在的memset bug，给出警告。	| C/C++ |
| runtime/operator	| 1. 检查是否重载了操作符&amp;。如果重载了，鉴于该操作符的危险性，给出警告。	| C/C++ |
| runtime/printf	| 1. 检查使用printf时，潜在的格式化bugs。如果发现，给出警告。<br> 2. 当检查到snprintf函数中存在数字（size）参数时，建议使用sizeof（变量）代替数字。<br> 3. 检查是否使用了sprintf。如果使用了，给出警告，并建议使用snprintf代替之。<br> 4. 检查是否使用了strcpy或strcat。如果使用了，给出警告，并建议使用snprintf代替之。	| C/C++ |
| runtime/printf_format	| 1. 检查在使用printf打印语句时，是否使用了“%qd”。如果使用了，给出警告，建议使用“%lld”。<br> 2. 检查在使用printf打印语句时，是否使用了“%1$d”这种格式。如果使用了，给出警告。	| C/C++ |
| runtime/references	| 1. 在函数参数中，查找是否使用了非const型的指针。如果发现了这种类型的指针，则给出警告，并建议使用const型或者指针代替之。	| C/C++ |
| runtime/rtti	| 1. 小心使用dynamic_cast<>,如果需要在类层次中使用，使用static_cast<>进行向上转型.如果虚函数足够使用，不要使用RTTI（新版本cpplint已经删除）	| C/C++ |
| runtime/sizeof	| 1. 建议使用sizeof(变量)的形式	| C/C++ |
| runtime/string	| 1. 检查是否使用了static或global修饰的string常量。如果检测到了，给出警告，并建议使用C风格字符串代替。	| C/C++ |
| runtime/threadsafe_fn	| 1. 检查是否使用了在POSIX标准中非线程安全的函数，如果使用了，给出警告。	| C/C++ |
| runtime/virtual	| 该规则说明正在补充中…	| C/C++ |
| runtime/vlog	| 1. VLOG()接受数值等级参数，如果使用符号等级参数，请使用LOG()	| C/C++ |
| tosa/comment	| 腾讯开源注释率要求不少于10%	| C/C++ |
| tosa/copyright	| 腾讯开源文件头需要包含开源协议信息	| C/C++ |
| tosa/cr	| 行尾使用换行符LF且禁止使用回车键CR	| C/C++ |
| tosa/fn_name_length	| 函数名长度限制（不得超过35个字符）	| C/C++ |
| tosa/indent	| 采用指定个数空格缩进（默认为4个）且禁止使用tab键 	| C/C++ |
| tosa/line_length	| 源码每一行字符数限制（默认不得超过120个） 	| C/C++ |
| whitespace/blank_line	| 1. 检查代码块开始处是否有空行。如果在代码块开始的时候有空行，给出警告。<br> 2. 检查代码块结束处是否有空行。如果有空行，给出警告。<br> 3. 检查public\protected\private后面是否有空行。如果有空行，给出警告。	| C/C++ |
| whitespace/braces	| 1. 检查“[”符号前面是否有空白。如果有，给出警告。<br> 2. 检查“{”符号前面是否留有空白。如果没有，给出警告。<br> 3. 检查“}else”这种情况的else前面是否留有空白。如果没有，给出警告。<br> 4. 检查“{”是否接在语句最后，即“{”是否直接跟在语句的后面，而不是单独起一行。如果单独占一行，给出警告。	| C/C++ |
| whitespace/carriage_return	| 检查是否有回车符"\r"存在，有则给出告警	| C/C++ |
| whitespace/comma	| 1. 在逗号“,”之后需要有空格。如果没有，给出警告。	| C/C++ |
| whitespace/comments	| 1. 检查代码和注释之间的空格数量，建议最少空2格。如果没有，给出警告。<br> 2. 检查在注释内容和注释符号//之间的空格。如果没有空格，给出警告。	| C/C++ |
| whitespace/empty_conditional_body	| 1. 检查是否存在空条件体（对应于if）。如果存在，给出警告，建议使用{}。	| C/C++ |
| whitespace/empty_if_body	| 1. 检查if语块是否有效，是否有else分支，如果没有，给出警告。	| C/C++ |
| whitespace/empty_loop_body	| 1. 检查是否存在空循环体(对应for、while)。如果存在，给出警告，建议使用{}。	| C/C++ |
| whitespace/end_of_line	| 1. 检查每一行的末尾是否有空格。如果有空格，给出警告，建议删除这些空格。	| C/C++ |
| whitespace/ending_newline	| 1. 检查文件结尾是否有空白行，如果没有，提示用户添加一行空白行。	| C/C++ |
| whitespace/forcolon	| 1. 检查for循环中冒号前后是否有空格，如果没有，给出警告。	| C/C++ |
| whitespace/indent	| 1. 检查每一行开始的缩进数量是否合法。如果出现奇数个缩进的情况，给出警告。建议使用2个空格缩进。<br> 2. 结束的括号（如)、}）应该和开始的括号对齐。如果不对其，给出警告。<br> 3. 检查public、private、protected、signals和slots的缩进是否合理。建议缩进一个空格，如果不是，给出警告。	| C/C++ |
| whitespace/labels	| 该规则说明正在补充中…	| C/C++ |
| whitespace/line_length	| 检查每一行代码的长度。对于长度超过100个字符的，给出严重级别警告。	| C/C++ |
| whitespace/newline	| 1. 检查一行上是否有多条语句。如果出现，给出警告。<br> 2. 检查else语句的位置，建议和}在一行上。如果不在一行上，给出警告。<br> 3. 检查是否出现“else{”这种语句。如果出现，给出警告，建议将{放到下一行。<br> 4. 检查{是否和do\while在同一行上。如果出现，给出警告，建议将{放到下一行。<br> 5. 检查在换行的时候，是否使用了回车\r。如果使用了，给出警告，建议使用\n换行。	| C/C++ |
| whitespace/operators	| 1. 检查“=”号两边是否有空格。如果没有，给出警告。<br> 2. 检查“==|!=|&lt;=|&gt;=||”双目运算符两边是否有空格。如果没有，给出警告。<br> 3. 检查“&lt;|&gt;|&lt;&lt;|&gt;&gt;|!|~|--|++”等单目运算符两边是否有空格。如果没有，给出警告。<br> 4. 检查“&amp;&amp;”两边是否有空格。如果没有，给出警告。	| C/C++ |
| whitespace/parens	| 1. 检查函数名和开始的括号(之间是否有空格，如果有空格，给出警告。<br> 2. 检查函数的结束括号)是否和函数名在同一行上。如果不在同一行，在下一行的话给出警告。<br> 3. 检查函数的结束括号）前面是否有空格，如果有空格，给出警告。<br> 4. 检查if\for\while\switch和开始的括号(之间是否有空格，如果没有空格，给出警告。<br> 5. 检查if\for\while\switch后面的括号()之间的空格是否对称。如果不对称。给出警告（如if( foo )这种情况）。<br> 6. 检查if\for\while\switch后面的括号()内侧的空格情况，建议可以有0个或者1个空格。如果不是0个或者1个，给出警告。	| C/C++ |
| whitespace/pos_braces	| 检查大括号“{”不单独占一行，如果单独占一行，则告警。	| C/C++ |
| whitespace/semicolon	| 1. 在分号“;”之后需要有空格。如果没有，给出警告。<br> 2. 检查使用分号“;”表示空状态的语句。如果检查到了，给出警告，并提示使用{}代替。<br> 3. 检查每行最后一个分号“;”，看其前面是否有空格。如果有空格，给出警告。	| C/C++ |
| whitespace/tab	| 1. 检查文中是否使用了Tab。如果使用了，给出警告，建议使用空格代替。	| C/C++ |
| whitespace/todo	| 1. 检查TODO注释前后的空格数量，如果没有空格，会给出警告；如果多余1个空格，也给出警告。	| C/C++ |
## 概述:
PyLint工具包含218种告警类型，支持PEP8代码风格检查，不仅能检查违反编码风格标准和写得非常糟糕的代码，而且能检查某些Python特定的问题和代码中的错误。该工程以容器方式，对pylint工具进行封装，并定义标准输入和输出。从而保证CodeCC平台数据解析模版化。

## 目录结构：
docker: 镜像打包文件Dockerfile路径

sdk：适配工具脚步路径

tool: 工具二进制路径

software: 安装包路径

third_rules: 自定义规则扩展路径

## 工具版本：

pylint 2.5.2
astroid 2.4.1
Python 3.6.8 

## 镜像打包:
打包命令：docker build -t pylint_scan:latest -f ./docker/Dockerfile .

## 入参文件编写:

### input.json模版：
{"projName":"DEVOPS_86C11311495401CE","scanPath":"/data/iegci/test_tool/test_code/dspAlgm","whitePathList":[],"toolOptions":[{"optionName":"py_version","optionValue":"py3"}],"scanType":"full","skipPaths":[".*/\\.svn/.*",".*/\\.git/.*",".*/\\.git",".*/ams/.*"],"incrementalFiles":[],"openCheckers":[{"checkerName":"len-as-condition","nativeChecker":true},{"checkerName":"missing-docstring","nativeChecker":true}]}


### input.json字段说明:
| 字段名 | 说明 | 举例 |
| --- | --- | --- |
| projName | 项目名称 | DEVOPS_214A69F1F4F935DE |
| scanPath | 待扫描的路径，此处需使用绝对路径 | /data/project/code |
| whitePathList | 指定扫描路径列表(白名单) | /data/project/code/src |
| toolOptions | 工具属性 | [{"optionName":"py_version","optionValue":"py3"}] |
| scanType | 进行全量或增量检查 | full或increment |
| skipPaths | 屏蔽路径正则表达式列表(黑名单) | [".\*/demo/.\*", ".\*/protobuf/.\*"] |
| incrementalFiles | 增量扫描的文件清单，清单为空表示全量扫描 | ["/data/project/code/src/main.py", "/data/project/code/src/test.py"]] |
| openCheckers | 打开的规则列表 | [{"checkerName":"len-as-condition","nativeChecker":true},{"checkerName":"missing-docstring","nativeChecker":true}] |
| checkerName | 规则名称, 参考附2 | len-as-condition |
| nativeChecker | 是否工具默认规则 | true |

## 镜像运行:
docker run -it pylint_scan:latest /bin/bash -c "cd /usr/codecc/tool_scan; python3 ./sdk/src/scan.py --input=/data/input.json --output=/data/output.json"

## 结果描述：

### output.json模版：
{"defects":[{"checkerName":"bad-indentation","description":" Bad indentation. Found 24 spaces, expected 20","filePath":"/data/iegci/test_tool/test_code/checkstyle_scan/sdk/src/config.py","line":"33"},{"checkerName":"bad-indentation","description":" Bad indentation. Found 28 spaces, expected 24","filePath":"/data/iegci/test_tool/test_code/checkstyle_scan/sdk/src/config.py","line":"34"}]}

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
| abstract-class-instantiated	| Used when an abstract class with abc.ABCMeta as metaclass has abstract methods and is instantiated.	| Python |
| abstract-method	| Used when an abstract method (i.e. raise NotImplementedError) is not overridden in concrete class.	| Python |
| access-member-before-definition	| Used when an instance member is accessed before it's actually assigned.	| Python |
| anomalous-backslash-in-string	| Used when a backslash is in a literal string but not as an escape.	| Python |
| anomalous-unicode-escape-in-string	| Used when an escape like \u is encountered in a byte string where it has no effect.	| Python |
| arguments-differ	| Used when a method has a different number of arguments than in the implemented interface or in an overridden method.	| Python |
| assert-on-tuple	| A call of assert on a tuple will always evaluate to true if the tuple is not empty, and will always evaluate to false if it is.	| Python |
| assigning-non-slot	| Used when assigning to an attribute not defined in the class slots.	| Python |
| assignment-from-no-return	| Used when an assignment is done on a function call but the inferred function doesn't return anything.	| Python |
| assignment-from-none	| Used when an assignment is done on a function call but the inferred function returns nothing but None.	| Python |
| astroid-error	| Used when an unexpected error occurred while building the Astroid representation. This is usually accompanied by a traceback. Please report such errors !	| Python |
| attribute-defined-outside-init	| Used when an instance attribute is defined outside the init method.	| Python |
| bad-classmethod-argument	| Used when a class method has a first argument named differently than the value specified in valid-classmethod-first-arg option (default to "cls"), recommended to easily differentiate them from regular instance methods.	| Python |
| bad-continuation	| Wrong continued indentation before block (add 4 spaces)	| Python |
| bad-except-order	| Used when except clauses are not in the correct order (from the more specific to the more generic). If you don't fix the order, some exceptions may not be caught by the most specific handler.	| Python |
| bad-exception-context	| Used when using the syntax "raise ... from ...", where the exception context is not an exception, nor None. This message can't be emitted when using Python < 3.0.	| Python |
| bad-format-character	| Used when a unsupported format character is used in a format string.	| Python |
| bad-format-string	| Used when a PEP 3101 format string is invalid. This message can't be emitted when using Python < 2.7.	| Python |
| bad-format-string-key	| Used when a format string that uses named conversion specifiers is used with a dictionary whose keys are not all strings.	| Python |
| bad-indentation	| Used when an unexpected number of indentation's tabulations or spaces has been found.	| Python |
| bad-inline-option	| Used when an inline option is either badly formatted or can't be used inside modules.	| Python |
| bad-mcs-classmethod-argument	| Used when a metaclass class method has a first argument named differently than the value specified in valid-metaclass-classmethod-first-arg option (default to "mcs"), recommended to easily differentiate them from regular instance methods.	| Python |
| bad-mcs-method-argument	| Used when a metaclass method has a first argument named differently than the value specified in valid-classmethod-first-arg option (default to "cls"), recommended to easily differentiate them from regular instance methods.	| Python |
| bad-open-mode	| Python supports: r, w, a[, x] modes with b, +, and U (only with r) options. See http://docs.python.org/2/library/functions.html#open	| Python |
| bad-option-value	| Used when a bad value for an inline option is encountered.	| Python |
| bad-reversed-sequence	| Used when the first argument to reversed() builtin isn't a sequence (does not implement reversed, nor getitem and len	| Python |
| bad-space-indentation	| Used when an unexpected number of indentation's spaces has been found(the default threshold is 4). 	| Python |
| bad-staticmethod-argument	| Used when a static method has "self" or a value specified in valid- classmethod-first-arg option or valid-metaclass-classmethod-first-arg option as first argument.	| Python |
| bad-str-strip-call	| The argument to a str.{l,r,}strip call contains a duplicate character,	| Python |
| bad-super-call	| Used when another argument than the current class is given as first argument of the super builtin.	| Python |
| bad-whitespace	| Used when a wrong number of spaces is used around an operator, bracket or block opener.	| Python |
| bare-except	| Used when an except clause doesn't specify exceptions type to catch.	| Python |
| binary-op-exception	| Used when the exception to catch is of the form "except A or B:". If intending to catch multiple, rewrite as "except (A, B):"	| Python |
| blacklisted-name	| Used when the name is listed in the black list (unauthorized names).	| Python |
| broad-except	| Used when an except catches a too general exception, possibly burying unrelated errors.	| Python |
| catching-non-exception	| Used when a class which doesn't inherit from Exception is used as an exception in an except clause.	| Python |
| cell-var-from-loop	| A variable used in a closure is defined in a loop. This will result in all closures using the same value for the closed-over variable.	| Python |
| confusing-with-statement	| Emitted when a with statement component returns multiple values and uses name binding with as only for a part of those values, as in with ctx() as a, b. This can be misleading, since it's not clear if the context manager returns a tuple or if the node without a name binding is another context manager.	| Python |
| consider-iterating-dictionary	| Emitted when the keys of a dictionary are iterated through the .keys() method. It is enough to just iterate through the dictionary itself, as in "for key in dictionary".	| Python |
| consider-merging-isinstance	| Used when multiple consecutive isinstance calls can be merged into one.	| Python |
| consider-using-enumerate	| Emitted when code that iterates with range and len is encountered. Such code can be simplified by using the enumerate builtin.	| Python |
| consider-using-ternary	| Used when one of known pre-python 2.5 ternary syntax is used.	| Python |
| continue-in-finally	| Emitted when the continue keyword is found inside a finally clause, which is a SyntaxError.	| Python |
| cyclic-import	| Used when a cyclic import between two or more modules is detected.	| Python |
| dangerous-default-value	| Used when a mutable value as list or dictionary is detected in a default value for an argument.	| Python |
| deprecated-method	| The method is marked as deprecated and will be removed in a future version of Python. Consider looking for an alternative in the documentation.	| Python |
| deprecated-module	| Used a module marked as deprecated is imported.	| Python |
| deprecated-pragma	| Some inline pylint options have been renamed or reworked, only the most recent form should be used. NOTE:skip-all is only available with pylint >= 0.26	| Python |
| duplicate-argument-name	| Duplicate argument names in function definitions are syntax errors.	| Python |
| duplicate-bases	| Used when a class has duplicate bases.	| Python |
| duplicate-code	| Indicates that a set of similar lines has been detected among multiple file. This usually means that the code should be refactored to avoid this duplication.	| Python |
| duplicate-except	| Used when an except catches a type that was already caught by a previous handler.	| Python |
| duplicate-key	| Used when a dictionary expression binds the same key multiple times.	| Python |
| empty-docstring	| Used when a module, function, class or method has an empty docstring (it would be too easy ;).	| Python |
| eval-used	| Used when you use the "eval" function, to discourage its usage. Consider using ast.literal_eval for safely evaluating strings containing Python expressions from untrusted sources.	| Python |
| exec-used	| Used when you use the "exec" statement (function for Python 3), to discourage its usage. That doesn't mean you cannot use it !	| Python |
| expression-not-assigned	| Used when an expression that is not a function call is assigned to nothing. Probably something else was intended.	| Python |
| fatal	| used when an error occurred preventing the analysis of a module (unable to find it for instance).	| Python |
| file-ignored	| Used to inform that the file will not be checked	| Python |
| fixme	| Used when a warning note as FIXME or XXX is detected.	| Python |
| format-combined-specification	| Used when a PEP 3101 format string contains both automatic field numbering (e.g. '{}') and manual field specification (e.g. '{0}'). This message can't be emitted when using Python < 2.7.	| Python |
| format-needs-mapping	| Used when a format string that uses named conversion specifiers is used with an argument that is not a mapping.	| Python |
| function-name-too-long	| Used when a name is longer than a given number of characters(the threshold is 35).	| Python |
| function-redefined	| Used when a function / class / method is redefined.	| Python |
| global-at-module-level	| Used when you use the "global" statement at the module level since it has no effect	| Python |
| global-statement	| Used when you use the "global" statement to update a global variable. Pylint just try to discourage this usage. That doesn't mean you cannot use it !	| Python |
| global-variable-not-assigned	| Used when a variable is defined through the "global" statement but no assignment to this variable is done.	| Python |
| global-variable-undefined	| Used when a variable is defined through the "global" statement but the variable is not defined in the module scope.	| Python |
| import-error	| Used when pylint has been unable to import a module.	| Python |
| import-self	| Used when a module is importing itself.	| Python |
| inconsistent-mro	| Used when a class has an inconsistent method resolution order.	| Python |
| inherit-non-class	| Used when a class inherits from something which is not a class.	| Python |
| init-is-generator	| Used when the special class method init is turned into a generator by a yield in its body.	| Python |
| invalid-all-object	| Used when an invalid (non-string) object occurs in all.	| Python |
| invalid-characters-in-docstring	| Used when a word in docstring cannot be checked by enchant.	| Python |
| invalid-format-index	| Used when a PEP 3101 format string uses a lookup specifier ({a[1]}), but the argument passed for formatting doesn't contain or doesn't have that key as an attribute. This message can't be emitted when using Python < 2.7.	| Python |
| invalid-length-returned	| Used when an len method returns something which is not a non-negative integer	| Python |
| invalid-metaclass	| Emitted whenever we can detect that a class is using, as a metaclass, something which might be invalid for using as a metaclass.	| Python |
| invalid-name	| Used when the name doesn't match the regular expression associated to its type (constant, variable, class...).	| Python |
| invalid-sequence-index	| Used when a sequence type is indexed with an invalid type. Valid types are ints, slices, and objects with an index method.	| Python |
| invalid-slice-index	| Used when a slice index is not an integer, None, or an object with an index method.	| Python |
| invalid-slots	| Used when an invalid slots is found in class. Only a string, an iterable or a sequence is permitted.	| Python |
| invalid-slots-object	| Used when an invalid (non-string) object occurs in slots.	| Python |
| invalid-star-assignment-target	| Emitted when a star expression is used as a starred assignment target. This message can't be emitted when using Python < 3.0.	| Python |
| invalid-unary-operand-type	| Emitted when a unary operand is used on an object which does not support this type of operation	| Python |
| len-as-condition	| Used when Pylint detects incorrect use of len(sequence) inside conditions.	| Python |
| line-too-long	| Used when a line is longer than a given number of characters. 	| Python |
| line-too-long-tosa	| Used when a line is longer than a given number of characters(the default threshold is 120). 	| Python |
| literal-comparison	| Used when comparing an object to a literal, which is usually what you do not want to do, since you can compare to a different literal than what was expected altogether.	| Python |
| locally-disabled	| Used when an inline option disables a message or a messages category.	| Python |
| locally-enabled	| Used when an inline option enables a message or a messages category.	| Python |
| logging-format-interpolation	| Used when a logging statement has a call form of "logging.method>(format_string.format(format_args...))". Such calls should use % formatting instead, but leave interpolation to the logging function by passing the parameters as arguments.	| Python |
| logging-format-truncated	| Used when a logging statement format string terminates before the end of a conversion specifier.	| Python |
| logging-not-lazy	| Used when a logging statement has a call form of "logging.(format_string % (format_args...))". Such calls should leave string interpolation to the logging method itself and be written "logging.(format_string, format_args...)" so that the program may avoid incurring the cost of the interpolation in those cases in which no message will be logged. For more, see http://www.python.org/dev/peps/pep-0282/.	| Python |
| logging-too-few-args	| Used when a logging format string is given too few arguments.	| Python |
| logging-too-many-args	| Used when a logging format string is given too many arguments.	| Python |
| logging-unsupported-format	| Used when an unsupported format character is used in a logging statement format string.	| Python |
| lost-exception	| Used when a break or a return statement is found inside the finally clause of a try...finally block: the exceptions raised in the try clause will be silently swallowed instead of being re-raised.	| Python |
| low-comment-ratio	| Used when the comment ratio is lower than expected(the threshold is 10%).	| Python |
| method-check-failed	| Used when Pylint has been unable to check methods signature compatibility for an unexpected reason. Please report this kind if you don't make sense of it.	| Python |
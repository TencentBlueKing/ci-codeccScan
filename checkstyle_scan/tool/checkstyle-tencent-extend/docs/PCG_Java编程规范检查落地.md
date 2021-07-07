# PCG Java编程规范检查落地

本文档记录了PCG Java编程规范的部分需求，及该需求的解决方案。

## 需求描述

### 需求1

import语句可分为以下几组，按照这个顺序，每组由一个空行分隔：
(1)所有的静态导入独立成组
(2)com.google imports(仅当这个源文件是在com.google包下)
(3)第三方的包。每个顶级包为一组，字典序。例如：android, com, junit, org, sun
(4)java imports
(5)javax imports 组内不空行，按字典序排列。

这个需求可以使用CheckStyle原生检查器ImportOrder实现，：

``` xml
<module name="ImportOrder">
  <property name="option" value="above"/>             <!-- All static imports are at the top. -->
  <property name="separated" value="true"/>           <!-- Type import groups should be separated by, at least, one blank line. -->
  <property name="ordered" value="true"/>             <!-- Type imports within each group should be sorted. -->
  <property name="sortStaticImportsAlphabetically" value="true"/> <!-- Static imports are sorted within the group. -->
  <property name="groups" value="*, android, com, junit, org, sun, /^java\./,javax"/>
</module>
```

### 需求2

需求：Long型的常数在赋值时使用大写L后缀，不要使用小写l后缀，小写容易和数字1混淆。

这条需求通过新开发的检查器LongIntegerSuffixCheck检查器实现，该检查器无任何参数。要使用该检查器，可以在配置文件中加上如下的描述：

```xml
<module name="TreeWalker">
  <module name="com.tencent.checks.LongIntegerSuffixCheck"/>
</module>
```

### 需求3

需求：对于具有特殊转义序列的任何字符(\b, \t, \n, \f, \r, ", '及\)，我们使用它的转义序列，而不是相应的八进制(比如\012)或Unicode(比如\u000a)转义。
需求：除了行结束符序列，ASCII水平空格字符(0x20，即空格)是源文件中唯一允许出现的空白字符，这意味着：
  1.所有其它字符串中的空白字符都要进行转义
  2.制表符不用于缩进。

这两条需求通过新开发的检查器EscapeSequenceCheck实现，该检查器拥有两个可配置参数，使用方式为：

```xml
<module name="TreeWalker">
  <module name="com.tencent.checks.EscapeSequenceCheck">
      <property name="checkSpecialEscapeSequence" value="true"/>  <!-- 用于检查具有特殊转义序列的字符 -->
      <property name="checkWhitespace" value="true"/> <!--用于检查字符/字符串常量中的非空格外的空白字符-->
  </module>
</module>
```

## 新增检查器说明

### LongIntegerSuffixCheck

检查器的全称为`com.tencent.checks.LongIntegerSuffixCheck`。作用：强制要求long类型常数使用大写的'L'后缀。

要使用该检查器，可以使用如下配置：

```xml
<module name="TreeWalker">
  <module name="com.tencent.checks.LongIntegerSuffixCheck"/>
</module>
```

### EscapeSequenceCheck

检查器的全称为`com.tencent.checks.EscapeSequenceCheck`。作用：

1. 对于具有特殊转义序列的任何字符(\b, \t, \n, \f, \r, \", \'及\\)，我们使用它的转义序列，而不是相应的八进制(比如\012)或Unicode(比如\u000a)转义。
2. 字符常量中不应直接使用空格(0x20)之外的空白字符，而应使用其对应的转义序列。

比如，我们期望使用该检查器完成如下这个检查要求：

  1. 对于具有特殊转义序列的任何字符(\b, \t, \n, \f, \r, \", \'及\\)，我们使用它的转义序列，而不是相应的八进制(比如\012)或Unicode(比如\u000a)转义。
  2. 不检查字符常量中的非法空白字符。

则可以使用如下这个配置：

```xml
<module name="TreeWalker">
  <module name="com.tencent.checks.EscapeSequenceCheck">
      <property name="checkSpecialEscapeSequence" value="true"/>  <!-- 用于检查具有特殊转义序列的字符 -->
      <property name="checkWhitespace" value="false"/>  <!--不检查字符常量中的非法空白字符-->
  </module>
</module>
```
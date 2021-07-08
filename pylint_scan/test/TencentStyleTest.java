/*
 * Tencent is pleased to support the open source community by making QMUI_Android available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the MIT License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */




import com.puppycrawl.tools.checkstyle.StatelessCheck;
import com.puppycrawl.tools.checkstyle.api.AbstractFileSetCheck;
import com.puppycrawl.tools.checkstyle.api.FileText;

import java.io.File;
import java.lang.Math;

/**
 * TencentStyleTest.
 */
class TencentStyleTest
{

  /**
   * A key is pointing to the warning message text in "messages.properties"
   * file.
   */
  public void foo() {
    System.out.println(1);
  }

  public void defLongMethodHasExactly35Characters() {
  }

  public void defLongMethodHasMoreThan35CharactersName() {
    defLongMethodHasMoreThan35CharactersName();
  }


  static class Example {
    static final int XXX = 10l;
    static final long YYY = 10;
    // 在字符串内有一个tab键
    static final String myString = "\u0048\u0065\u006C\u006C\u006F	\u000a W'orld";
    // 换行符
    static final char myChar = '\u000a';
    // 单引号转义检查
    static final char singleQuote = '\u0027';

    // 单引号的8进制转义
    static final char singleQuote2 = '\47';
    static final char singleQuote3 = '\047';

    static final String well = "Everything is well.";
    static void printHello() {
      System.out.print("Hello");
    }

    public static void accessStaticMember() {
      Example e = new Example();
      e.printHello();
      int x = TencentStyleTest.Example.XXX * Math.PI;
      TencentStyleTest.Example.printHello();
    }
  }
}

//===----------------------------------------------------------------------===////===----------------------------------------------------------------------===//

/* C-style comment. */
// C++ style comment.
/* C-style comment. */

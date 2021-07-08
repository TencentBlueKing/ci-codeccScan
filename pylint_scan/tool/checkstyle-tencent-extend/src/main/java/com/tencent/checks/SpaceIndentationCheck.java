package com.tencent.checks;

import com.puppycrawl.tools.checkstyle.FileStatefulCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.checks.indentation.IndentationCheck;

@FileStatefulCheck
public class SpaceIndentationCheck extends IndentationCheck {

    /**
     * A key is pointing to the warning message text in "messages.properties"
     * file.
     */
    public static final String MSG_CONTAINS_TAB = "containsTab";

    private void checkTabCharacter() {

        for (int i = 0; i < getLines().length; i++) {
            final String line = getLine(i);
            final int tabPosition = line.indexOf('\t');

            if (-1 != tabPosition) {
                // 这个日志可以抑制后续IndentationCheck输出的在同一行的错误。
                indentationLog(i + 1, MSG_CONTAINS_TAB);
            }
        }
    }

    @Override
    public void beginTree(DetailAST ast) {
        super.beginTree(ast);

        checkTabCharacter();
    }
}

package com.tencent.checks;

import com.puppycrawl.tools.checkstyle.StatelessCheck;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.TextBlock;
import com.puppycrawl.tools.checkstyle.utils.CommonUtil;

import java.util.List;
import java.util.Map;

/**
 * Checks the code comment ratio.
 */
@StatelessCheck
public class CommentRatioCheck extends AbstractCheck {
    public static final String MSG_ERROR = "comment.ratio";

    /**
     * The default minimum required comment ratio.
     */
    public static final double COMMENT_RATIO = 0.20;

    /**
     * Configurable minimum required comment ratio.
     */
    private double commentRatio = COMMENT_RATIO;

    public void setCommentRatio(String ratio) {
        commentRatio = Double.parseDouble(ratio) / 100;
    }

    @Override
    public boolean isCommentNodesRequired() {
        return true;
    }

    @Override
    public int[] getDefaultTokens() {
        return getRequiredTokens();
    }

    @Override
    public int[] getAcceptableTokens() {
        return getRequiredTokens();
    }

    @Override
    public int[] getRequiredTokens() {
        return CommonUtil.EMPTY_INT_ARRAY;
    }

    private void checkCommentRatio() {
        final FileContents fileContents = getFileContents();

        final Map<Integer, TextBlock> cppComments = fileContents.getSingleLineComments();
        // Javadoc is also a C-style comment.
        final Map<Integer, List<TextBlock>> cComments = fileContents.getBlockComments();

        int blankLineCount = 0;
        int commentLineCount = 0;
        int lineCount = fileContents.getLines().length;

        for (int lineNo = 0; lineNo < lineCount; lineNo++) {

            if (cppComments.containsKey(lineNo)) {
                commentLineCount++;
            } else if (cComments.containsKey(lineNo)) {
                // Checkstyle has a bug:
                // If the end of file is a single line C-style comment, then Checkstyle would not report it.

                final List<TextBlock> commentList = cComments.get(lineNo);
                TextBlock commentStart = commentList.get(0);
                TextBlock commentEnd = commentList.get(commentList.size() - 1);

                int blockCommentCount = commentEnd.getEndLineNo() - commentStart.getStartLineNo() + 1;
                commentLineCount += blockCommentCount;
            } else if (fileContents.lineIsBlank(lineNo)) {
                blankLineCount++;
            }
        }

        double ratio = commentLineCount * 1.0f / (lineCount - blankLineCount);
        if (ratio < commentRatio) {
            log(1, MSG_ERROR, ratio, commentRatio);
        }
    }

    @Override
    public void beginTree(DetailAST rootAST) {
        checkCommentRatio();
    }

    @Override
    public void visitToken(DetailAST ast) {
        throw new IllegalStateException("visitToken() shouldn't be called.");
    }
}

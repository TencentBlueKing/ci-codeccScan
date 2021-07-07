package checks;

import common.BaseCheck;
import common.CheckerAnnotation;
import common.DefectMessage;
import org.antlr.v4.runtime.Token;
import parser.ObjectiveCParser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/16
 */
@CheckerAnnotation
public class MaxLinesPerFunction extends BaseCheck
{
    private int max = 100;
    private String source;
    private boolean inBlockComment = false;

    @Override public void exitMethodDefinition(ObjectiveCParser.MethodDefinitionContext ctx) {
        ObjectiveCParser.CompoundStatementContext compoundStatementContext = ctx.compoundStatement();
        if(compoundStatementContext == null)
        {
            return;
        }
        Token start = compoundStatementContext.start;
        Token end = compoundStatementContext.stop;
        checkSize(start.getLine(), end.getLine());
    }

    @Override public void exitFunctionDefinition(ObjectiveCParser.FunctionDefinitionContext ctx) {
        ObjectiveCParser.CompoundStatementContext compoundStatementContext = ctx.compoundStatement();
        if(compoundStatementContext == null)
        {
            return;
        }
        Token start = compoundStatementContext.start;
        Token end = compoundStatementContext.stop;
        checkSize(start.getLine(), end.getLine());
    }

    @Override public void initOption()
    {
        String configMax = this.getOption("LineThreshold");
        if(configMax != null)
        {
            this.max = Integer.valueOf(configMax);
        }
    }

    private void checkSize(int startLine, int endLine)
    {
        int blankAndCommentCount = countBlankAndCommentLine(this.source, startLine, endLine);
        int totalLine = endLine - startLine +1 - blankAndCommentCount;
        if(totalLine > max)
        {
            DefectMessage msg = new DefectMessage();
            msg.setCheckerName(this.getClass().getSimpleName());
            msg.setFilePath(this.getFilePath());
            msg.setLineNo(startLine);
            msg.setMessage(String.format("去除注释、空白行后，函数体不应该超过%d行，当前拥有%d行有效行", max, totalLine));
            //System.out.println(Thread.currentThread().getName() + " :: " + new Gson().toJson(msg));
            this.addMessage(msg);
        }
    }

    @Override public void checkText(String source)
    {
        this.source = source;
    }

    private int countBlankAndCommentLine(String source, int startLine, int endLine)
    {
        String[] split = source.split("\n");
        int count = 0;
        for(int i=startLine; i<endLine; i++)
        {
            String line = split[i].trim();
            if(line.startsWith("//") || isIgnore(line, i+1) || line.length() == 0)
            {
                count ++;
            }
        }
        return count;
    }

    private boolean isIgnore(String line, int lineno)
    {
        if(line.contains("/*") && line.contains("*/"))
        {
            inBlockComment = false;
            return true;
        }

        if (line.contains("/*"))
        {
            inBlockComment = true;
            return true;
        }

        if (line.endsWith("*/"))
        {
            inBlockComment = false;
            return true;
        }

        if (inBlockComment == true)
        {
            return true;
        }

        return false;
    }


}

package checks;


import common.BaseCheck;
import common.CheckerAnnotation;
import common.DefectMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

    /**
     * @author camelxiao
     * @version V2.0
     * @date 2020/3/30
     */
    @CheckerAnnotation
    public class Indent extends BaseCheck
    {
    private String indentStyle = "spaces";
    private int indentSize = 4;
    private char indentChar = ' ';

    private boolean inBlockComment = false;

    private String[] sourceLines;

    Map<Integer, LineIndetInfo> mapLineInfo = new HashMap<>();

    @Override
    public void initOption()
    {
        String configIndentStyle = this.getOption("IndentStyle");
        if (configIndentStyle != null)
        {
            this.indentStyle = configIndentStyle;
        }

        String configIndentSize = this.getOption("IndentSize");
        if (configIndentSize != null)
        {
            this.indentSize = Integer.valueOf(configIndentSize);
        }

        switch (indentStyle)
        {
            case "spaces":
                indentChar = ' ';
                break;

            case "tabs":
                indentChar = '\t';
                break;

            default:
                indentChar = ' ';
                break;
        }
    }

    @Override
    public void checkText(String source)
    {

    }

    public void checkTextXX(String source)
    {
        String[] lines = source.split("\n");
        this.sourceLines = lines;
        inBlockComment = false;
        int lineCount = 0;

        Stack<Integer> levelStack = new Stack<>();
        levelStack.push(0);

        Stack<Integer> baseStack = new Stack<>();
        baseStack.push(0);

        boolean colonAlign = false;
        for (String line : lines)
        {
            lineCount++;
            //忽略空行
            if (line.trim().length() == 0)
            {
                continue;
            }

            //忽略注释
            if (isIgnore(line, lineCount) == true)
            {
                continue;
            }

            String lineTrim = line.trim();
            int lineIndent = getIndentCharCount(line);
            //忽略首字符非indent字符
            if (line.charAt(0) != ' ' && line.charAt(0) != '\t')
            {
                if(lineTrim.endsWith("{"))
                {
                    levelStack.push(1);
                    baseStack.push(indentSize);
                }
                continue;
            }

            if(lineIndent != baseStack.peek())
            {
                //check if 冒号对齐
                if(line.indexOf(":") == line.lastIndexOf(":"))
                {
                    String lastLine = this.sourceLines[lineCount-2];
                    if(lastLine.indexOf(':') == line.indexOf(':'))
                    {
                        colonAlign = true;
                        if(line.endsWith("{"))
                        {
                            levelStack.push(1);
                            baseStack.push(lineIndent + indentSize);
                            System.out.println(String.format("\t***** PUSH"));
                        }
                    }
                }
            }

            System.out.println(String.format("Line:%d, lineIndent:%d, baseStackP:%d, content:%s", lineCount, lineIndent, baseStack.peek(), line));

            System.out.println(String.format("\t---> baseStackP:%d", baseStack.peek()));
            colonAlign = false;

        }
        System.out.println("level stack:"+levelStack.size());
        System.out.println("base stack:"+baseStack.size());
    }



    private int getIndentCharCount(String line)
    {
        int indentCharCount = 0;
        for (int i = 0; i < line.length(); i++)
        {
            if (line.charAt(i) == indentChar)
            {
                indentCharCount++;
            }
            else
            {
                break;
            }
        }
        return indentCharCount;
    }

    private void commitDefect(int lineCount, int indentCharCount)
    {
        //既不符合绝对值对齐，又不符合冒号对齐和相对值对齐
        DefectMessage msg = new DefectMessage();
        msg.setLineNo(lineCount);
        msg.setCheckerName(this.getClass().getSimpleName());
        msg.setFilePath(getFilePath());
        msg.setMessage(String.format("该行缩进不正确(共%d%s)，请以%d%s为基础缩进，期望缩进%d%s", indentCharCount, indentStyle,
                indentSize, indentStyle, indentSize * Math.round((float) indentCharCount / indentSize), indentStyle));
        this.addMessage(msg);
    }

    private boolean isIgnore(String line, int lineno)
    {
        if (line.contains("/*"))
        {
            //System.out.println("find comment start:" + lineno);
            inBlockComment = true;
            return false;
        }

        if (line.endsWith("*/"))
        {
            //System.out.println("find comment end:" + lineno);
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

class LineIndetInfo
{
    private List<Integer> colonIndexList;

    public LineIndetInfo()
    {
        colonIndexList = new ArrayList<>();
    }

    public List<Integer> getIndexList()
    {
        return colonIndexList;
    }

    public boolean hasIndex(int idx)
    {
        return this.colonIndexList.contains(idx);
    }
}



package checks.readability;


import common.CheckerAnnotation;
import common.DefectMessage;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/4/1
 */
@CheckerAnnotation
public class MaxLineLength extends ReadabilityBaseCheck
{
    private boolean inBlockComment = false;
    private int tabWidth = 4;
    private int maxLineLength = 150;

    @Override
    public void initOption()
    {
        String configTabWidth = this.getOption("tabWidth");
        if (configTabWidth != null)
        {
            this.tabWidth = Integer.valueOf(configTabWidth);
        }

        String configMaxLineLength = this.getOption("MaxLineLength");
        if (configMaxLineLength != null)
        {
            this.maxLineLength = Integer.valueOf(configMaxLineLength);
        }

    }

    @Override
    public void checkText(String source)
    {
        String[] lines = source.split("\n");
        int count = 0;
        for (String line : lines)
        {
            count++;
            if (isIgnore(line, count) == true)
            {
                continue;
            }

            int lengthNoString = lengthWithoutString(line);
            if (lengthNoString > maxLineLength)
            {
                DefectMessage msg = new DefectMessage();
                msg.setLineNo(count);
                msg.setCheckerName(this.getClass().getSimpleName());
                msg.setFilePath(getFilePath());
                msg.setMessage(String.format("该行长度[%d]超出设定值%d(去除本行字符串长度)", lengthNoString, maxLineLength));
                this.addMessage(msg);
            }
        }
    }

    private boolean isIgnore(String line, int lineno)
    {
        if (line.trim().startsWith("/*"))
        {
            //System.out.println("find comment start:" + lineno);
            inBlockComment = true;
        }

        if (line.endsWith("*/"))
        {
            //System.out.println("find comment end:" + lineno);
            inBlockComment = false;
        }

        if (inBlockComment == true)
        {
            return true;
        }

        if (line.trim().startsWith("//"))
        {
            return true;
        }

        return false;
    }

/*    private boolean isUrl(String line)
    {
        if (line.contains("http://") ||
                line.contains("ftp://")
                || line.contains("https://")
        || line.contains("@\""))
        {
            return true;
        }
        return false;

        int stringCount = 0;
        boolean inString = false;
        for(int i=0; i<line.length(); i++)
        {
            if(line[i] == "\"" && inString == false)
            {
                stringCount ++;
                inString = true;
            }
            if(line[i] == "\"" && inString == true)
            {
                stringCount ++;
                inString = false;
            }
            if(inString == true)
            {
                stringCount ++;
            }
        }
    }*/

    private int lengthWithoutString(String line)
    {
        int stringCount = 0;
        boolean inString = false;
        for(int i=0; i<line.length(); i++)
        {
            if(line.charAt(i) == '"' && inString == false)
            {
                stringCount ++;
                inString = true;
            }
            else if(line.charAt(i) == '"' && inString == true)
            {
                stringCount ++;
                inString = false;
            }
            else if(inString == true)
            {
                stringCount ++;
            }
        }
        return line.length() - stringCount;
    }

}

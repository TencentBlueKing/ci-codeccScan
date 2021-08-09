package checks.readability;


import common.CheckerAnnotation;
import common.DefectMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/27
 */
@CheckerAnnotation
public class MacroNaming extends ReadabilityBaseCheck
{
    String macroCase = "UPPER_CASE";
    Pattern casePattern = null;

    @Override public void checkText(String source)
    {
        Pattern pattern = Pattern.compile("#define\\s+(?<macroName>\\w+)");
        String[] lines = source.split("\n");
        int lineCount = 0;
        for(String line : lines)
        {
            lineCount++;
            if(line.trim().startsWith("#define") == false)
            {
                continue;
            }

            Matcher matcher = pattern.matcher(line);
            matcher.find();
            String macroName = matcher.group("macroName");
            if (macroName.matches(casePattern.pattern()) == false)
            {
                DefectMessage msg = new DefectMessage();
                msg.setLineNo(lineCount);
                msg.setFilePath(this.getFilePath());
                msg.setCheckerName(this.getClass().getSimpleName());
                msg.setMessage(String.format("\'%s\' 的命名风格不符合配置值:%s", macroName, macroCase));
                this.addMessage(msg);
            }
        }
    }

    @Override public void initOption()
    {
        String configCase = this.getOption("MacroCase");
        if(configCase != null)
        {
            this.macroCase = configCase;
        }
        casePattern = this.getCasePattern(this.macroCase);
    }
}

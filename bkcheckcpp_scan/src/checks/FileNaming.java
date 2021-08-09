package checks;


import checks.readability.ReadabilityBaseCheck;
import common.CheckerAnnotation;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/5/2
 */
@CheckerAnnotation
public class FileNaming extends ReadabilityBaseCheck
{
    private String caseStyle = "LOWER_CASE";

    @Override
    public void checkText(String source)
    {
        Path filePath = Paths.get(this.getFilePath());
        String realFileName = filePath.getFileName().toString().split("\\.")[0];
        Pattern lower_case = this.getCasePattern(caseStyle);
        if(realFileName.matches(lower_case.pattern()) == false)
        {
            this.addMessage(1, "文件名不符合规范：" + lower_case.pattern());
        }
    }

    @Override public void initOption()
    {
        String configCaseStyle = this.getOption("ClassCase");
        if(configCaseStyle != null)
        {
            this.caseStyle = configCaseStyle;
        }
    }
}

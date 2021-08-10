package common;


import parser.CPP14BaseListener;
import reporters.BaseReporter;

import java.util.Map;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/16
 */
//public class BaseCheck extends ObjectiveCParserBaseListener
public class BaseCheck extends CPP14BaseListener
{
    private BaseReporter baseReporter;
    private Map<String, String> checkOptions;
    private String filePath;
    public void setReporter(BaseReporter reporter)
    {
        this.baseReporter = reporter;
    }
    public BaseReporter getReporter()
    {
        return this.baseReporter;
    }
    public void setCheckOptions(Map<String, String> checkOptions){this.checkOptions = checkOptions;}
    public Map<String, String> getCheckOptions()
    {
        return this.checkOptions;
    }
    public String getOption(String key){return this.checkOptions.get(this.getClass().getSimpleName() + "." + key);}
    public void addMessage(DefectMessage msg)
    {
        this.baseReporter.add(msg);
    }
    public void addMessage(int lineno, String msg)
    {
        DefectMessage defect = new DefectMessage();
        defect.setLineNo(lineno);
        defect.setFilePath(getFilePath());
        defect.setCheckerName(this.getClass().getSimpleName());
        defect.setMessage(msg);
        this.baseReporter.add(defect);
    }

    public void initOption(){}
    public void setFilePath(String path)
    {
        this.filePath = path;
    }
    public String getFilePath()
    {
        return this.filePath;
    }

    public void checkText(String source){}
}

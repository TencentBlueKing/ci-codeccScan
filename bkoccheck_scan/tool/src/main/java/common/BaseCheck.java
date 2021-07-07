package common;


import parser.ObjectiveCParserBaseListener;
import reporters.BaseReporter;

import java.util.Map;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/16
 */
public class BaseCheck extends ObjectiveCParserBaseListener
{
    private BaseReporter baseReporter;
    private Map<String, String> checkOptions;
    private String filePath;
    public void setReporter(BaseReporter reporter)
    {
        this.baseReporter = reporter;
    }
    public void setCheckOptions(Map<String, String> checkOptions){this.checkOptions = checkOptions;}
    public String getOption(String key){return this.checkOptions.get(this.getClass().getSimpleName() + "." + key);}
    public void addMessage(DefectMessage msg)
    {
        this.baseReporter.add(msg);
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

package reporters;


import common.DefectMessage;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/4/7
 */
public class TextReporter implements BaseReporter
{
    private StringBuffer defectString;

    public TextReporter()
    {
        defectString = new StringBuffer();
    }

    @Override
    public void add(DefectMessage msg)
    {
        defectString.append(String.format("%s:%d:0: %s [%s]\n", msg.getFilePath(), msg.getLineNo(), msg.getMessage(),
                msg.getCheckerName()));
    }

    @Override
    public String dump()
    {
        return defectString.toString();
    }
}

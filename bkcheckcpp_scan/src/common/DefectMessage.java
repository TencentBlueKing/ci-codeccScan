package common;


/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/24
 */
public class DefectMessage
{
    public int getLineNo()
    {
        return line;
    }

    public void setLineNo(int lineNo)
    {
        this.line = lineNo;
    }

    public String getCheckerName()
    {
        return checkerName;
    }

    public void setCheckerName(String checkerName)
    {
        this.checkerName = checkerName;
    }

    public String getMessage()
    {
        return description;
    }

    public void setMessage(String message)
    {
        this.description = message;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    private String filePath;
    private int line;
    private String checkerName;
    private String description;

}

package common;


/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/24
 */
public class ConfigOptions
{
    private String configFilePath;
    private String outputFilePath;
    private String format;
    private int thread;

    public String getConfigFilePath()
    {
        return configFilePath;
    }

    public void setConfigFilePath(String configFilePath)
    {
        this.configFilePath = configFilePath;
    }

    public String getOutputFilePath()
    {
        return outputFilePath;
    }

    public void setOutputFilePath(String outputFilePath)
    {
        this.outputFilePath = outputFilePath;
    }

    public String getFormat()
    {
        return format;
    }

    public void setFormat(String format)
    {
        this.format = format;
    }

    public int getThread()
    {
        return thread;
    }

    public void setThread(int thread)
    {
        this.thread = thread;
    }

    public String getExtension()
    {
        return extension;
    }

    public void setExtension(String extension)
    {
        this.extension = extension;
    }

    private String extension;
}

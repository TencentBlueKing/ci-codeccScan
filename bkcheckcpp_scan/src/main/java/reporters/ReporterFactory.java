package reporters;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/26
 */
public class ReporterFactory
{
    private BaseReporter reporter;

    public BaseReporter getReporter(String reporterId)
    {
        switch (reporterId)
        {
            case "json":
                return new JsonReporter();

            case "text":
                return new TextReporter();

        }

        return null;
    }

}

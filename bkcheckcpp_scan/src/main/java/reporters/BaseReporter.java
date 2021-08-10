package reporters;


import common.DefectMessage;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/24
 */
public interface BaseReporter
{
    void add(DefectMessage msg);
    String dump();
}

package reporters;


import com.google.gson.Gson;
import common.DefectMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/24
 */
public class JsonReporter implements BaseReporter
{
    private List<DefectMessage> defectList;

    public JsonReporter()
    {
        defectList = Collections.synchronizedList(new ArrayList<>(1024));
    }

    @Override
    public void add(DefectMessage msg)
    {
        defectList.add(msg);
    }

    @Override
    public String dump()
    {
        JsonSummary js = new JsonSummary();
        js.setCode(0);
        js.setMessage("scan completed!");
        js.setDefects(defectList);
        Gson gson = new Gson();
        String jsonString = gson.toJson(js);
        return jsonString;
    }
}

class JsonSummary
{
    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public List<DefectMessage> getDefects()
    {
        return defects;
    }

    public void setDefects(List<DefectMessage> defects)
    {
        this.defects = defects;
    }

    private int code;
    private String message;
    private List<DefectMessage> defects;
}

package common;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/4/21
 */
public class ProperName
{
    private static List<String> properNameList = new ArrayList<String>()
    {{
        addAll(Arrays.asList(
                "ASCII",
                "PDF",
                "XML",
                "HTML",
                "URL",
                "RTF",
                "HTTP",
                "TIFF",
                "JPG",
                "PNG",
                "GIF",
                "LZW",
                "ROM",
                "RGB",
                "CMYK",
                "MIDI",
                "FTP",
                "JSON",
                "OS",
                "ID"
        ));
    }};

    public static boolean isProperName(String name)
    {
        return properNameList.contains(name);
    }

    public static List<String> getProperNameList()
    {
        return properNameList;
    }
}

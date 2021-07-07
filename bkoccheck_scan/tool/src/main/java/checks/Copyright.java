package checks;


import common.BaseCheck;
import common.CheckerAnnotation;
import common.DefectMessage;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/4/8
 */
@CheckerAnnotation
public class Copyright extends BaseCheck
{
    @Override
    public void checkText(String source)
    {
        String[] codeLines = source.split("\n");
        boolean hasCopyright = false;
        for(int i=0; i<10; i++)
        {
            if(codeLines[i].contains("Copyright") || codeLines[i].contains("copyright"))
            {
                hasCopyright = true;
                break;
            }
        }

        if(!hasCopyright)
        {
            DefectMessage msg = new DefectMessage();
            msg.setLineNo(1);
            msg.setCheckerName(this.getClass().getSimpleName());
            msg.setFilePath(getFilePath());
            msg.setMessage("文件头缺少Copyright声明");
            this.addMessage(msg);
        }
    }
}

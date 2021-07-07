package checks.readability;

import common.BaseCheck;
import common.CheckerAnnotation;
import common.DefectMessage;
import parser.ObjectiveCParser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/4/8
 */
@CheckerAnnotation
public class ParameterCount extends BaseCheck
{
    private int max = 6;

    @Override
    public void exitParameterDeclarationList(ObjectiveCParser.ParameterDeclarationListContext ctx)
    {
        check(ctx.parameterDeclaration().size(), ctx.start.getLine(), "函数");
    }

    @Override public void exitMethodSelector(ObjectiveCParser.MethodSelectorContext ctx)
    {
        check(ctx.keywordDeclarator().size(), ctx.start.getLine(), "方法");
    }

    private void check(int count, int lineno, String type)
    {
        if(count > this.max)
        {
            DefectMessage msg = new DefectMessage();
            msg.setLineNo(lineno);
            msg.setCheckerName(this.getClass().getSimpleName());
            msg.setFilePath(getFilePath());
            msg.setMessage(String.format("%s参数个数为%d，超出配置最大值%d", type, count, this.max));
            this.addMessage(msg);
        }
    }

    @Override
    public void initOption()
    {
        String configMax = this.getOption("Max");
        if (configMax != null)
        {
            this.max = Integer.valueOf(configMax);
        }
    }
}

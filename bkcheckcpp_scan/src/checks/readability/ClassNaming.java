package checks.readability;

import common.CheckerAnnotation;
import parser.CPP14Parser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/5/6
 */
@CheckerAnnotation
public class ClassNaming extends ReadabilityBaseCheck
{
    String caseStyle = "CamelCaseWithoutUnderscore";

    @Override public void exitClassspecifier(CPP14Parser.ClassspecifierContext ctx)
    {
        String classNaming = ctx.classhead().classheadname().classname().Identifier().getText();
        //System.out.println(classNaming);
        this.checkNamingStyle(classNaming, ctx.getStart().getLine(), caseStyle, this.getClass().getSimpleName());
    }

    @Override public void initOption()
    {
        String configCaseStyle = this.getOption("ClassCase");
        if(configCaseStyle != null)
        {
            this.caseStyle = configCaseStyle;
        }
    }
}

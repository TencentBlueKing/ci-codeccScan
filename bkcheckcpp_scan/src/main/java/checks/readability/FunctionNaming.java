package checks.readability;


import common.CheckerAnnotation;
import parser.CPP14Parser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/30
 */
@CheckerAnnotation
public class FunctionNaming extends ReadabilityBaseCheck
{
    private String caseStyle = "camelBack";

    @Override public void exitFunctionspecifier(CPP14Parser.FunctionspecifierContext ctx)
    {
        //System.out.println(ctx.declarator().ptrdeclarator().noptrdeclarator().noptrdeclarator().declaratorid().idexpression().unqualifiedid().Identifier().getText());
        System.out.println("dddd"+ctx.getText());
    }

    @Override public void initOption()
    {
        String configCaseStyle = this.getOption("FunctionCase");
        if(configCaseStyle != null)
        {
            this.caseStyle = configCaseStyle;
        }
    }



}

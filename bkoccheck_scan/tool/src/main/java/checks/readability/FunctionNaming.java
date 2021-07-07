package checks.readability;


import common.CheckerAnnotation;
import parser.ObjectiveCParser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/30
 */
@CheckerAnnotation
public class FunctionNaming extends ReadabilityBaseCheck
{
    private String caseStyle = "camelBack";

    @Override public void exitFunctionSignature(ObjectiveCParser.FunctionSignatureContext ctx)
    {
        ObjectiveCParser.IdentifierContext identifier = ctx.identifier();
        if(identifier == null)
        {
            return;
        }

        String functionName = identifier.getText();
        checkNamingStyle(functionName, identifier.start.getLine(), caseStyle, this.getClass().getSimpleName());
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

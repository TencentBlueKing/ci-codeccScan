package checks.readability;


import common.CheckerAnnotation;
import parser.ObjectiveCParser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/30
 */
@CheckerAnnotation
public class ClassNaming extends ReadabilityBaseCheck
{
    private String caseStyle = "CamelCase";

    @Override public void exitClassInterface(ObjectiveCParser.ClassInterfaceContext ctx)
    {
        ObjectiveCParser.GenericTypeSpecifierContext genericTypeSpecifierContext = ctx.genericTypeSpecifier();

        ObjectiveCParser.IdentifierContext identifier = genericTypeSpecifierContext.identifier();
        if(identifier == null)
        {
            return;
        }

        //System.out.println("Class Naming----QQQQQ------>:" + identifier.getText());
        checkNamingStyle(identifier.getText(), identifier.start.getLine(), caseStyle, this.getClass().getSimpleName());
    }

    @Override
    public void initOption()
    {
        String configCase = this.getOption("ClassCase");
        if (configCase != null)
        {
            this.caseStyle = configCase;
        }
    }
}

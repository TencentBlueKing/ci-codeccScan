package checks.readability;


import common.CheckerAnnotation;
import parser.CPP14Parser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/5/8
 */
@CheckerAnnotation
public class NamespaceNaming extends ReadabilityBaseCheck
{
    String caseStyle = "LOWER_CASE";

    @Override public void enterNamespacedefinition(CPP14Parser.NamespacedefinitionContext ctx)
    {
        if(ctx.namednamespacedefinition() == null || ctx.namednamespacedefinition().originalnamespacedefinition() == null)
        {
            return;
        }

        String namespaceName = ctx.namednamespacedefinition().originalnamespacedefinition().Identifier().getSymbol().getText();
        this.checkNamingStyle(namespaceName, ctx.getStart().getLine(), caseStyle, this.getClass().getSimpleName());
    }

    @Override public void initOption()
    {
        String configCaseStyle = this.getOption("NamespaceCase");
        if(configCaseStyle != null)
        {
            this.caseStyle = configCaseStyle;
        }
    }
}

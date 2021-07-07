package checks.readability;


import common.CheckerAnnotation;
import parser.ObjectiveCParser;

import java.util.List;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/30
 */
@CheckerAnnotation
public class ParameterNaming extends ReadabilityBaseCheck
{
    private String caseStyle = "camelBack";
    @Override public void exitParameterDeclaration(ObjectiveCParser.ParameterDeclarationContext ctx)
    {
        if(ctx.declarator() == null || ctx.declarator().directDeclarator() == null)
        {
            return;
        }

        ObjectiveCParser.IdentifierContext identifier = ctx.declarator().directDeclarator().identifier();
        if(identifier == null)
        {
            return;
        }

        String parameterName = identifier.getText();
        checkNamingStyle(parameterName, ctx.start.getLine(), this.caseStyle, this.getClass().getSimpleName());
    }

    @Override public void exitMethodSelector(ObjectiveCParser.MethodSelectorContext ctx)
    {
        List<ObjectiveCParser.KeywordDeclaratorContext> keywordDeclaratorContexts = ctx.keywordDeclarator();
        for(ObjectiveCParser.KeywordDeclaratorContext keyCtx : keywordDeclaratorContexts)
        {
            String parameterName = keyCtx.identifier().getText();
            checkNamingStyle(parameterName, ctx.start.getLine(), this.caseStyle,this.getClass().getSimpleName());
        }
    }

    @Override
    public void initOption()
    {
        String configCaseStyle = this.getOption("ParameterCase");
        if (configCaseStyle != null)
        {
            this.caseStyle = configCaseStyle;
        }
    }

}

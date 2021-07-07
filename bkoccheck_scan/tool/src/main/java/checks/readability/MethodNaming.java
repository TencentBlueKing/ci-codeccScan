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
public class MethodNaming extends ReadabilityBaseCheck
{
    private String caseStyle = "camelBack";

    @Override public void exitMethodSelector(ObjectiveCParser.MethodSelectorContext ctx)
    {
        ObjectiveCParser.SelectorContext selector = ctx.selector();
        if(selector != null)
        {
            //System.out.println("MethodName----------->:" + selector.getText());
            checkNamingStyle(selector.getText(), selector.start.getLine(), caseStyle, this.getClass().getSimpleName());
        }

        List<ObjectiveCParser.KeywordDeclaratorContext> keywordDeclaratorContexts = ctx.keywordDeclarator();
        for(ObjectiveCParser.KeywordDeclaratorContext keywordCtx : keywordDeclaratorContexts)
        {
            if(keywordCtx.selector() != null)
            {
                //System.out.println("MethodName***----------->:" + keywordCtx.selector().identifier().getText());
                checkNamingStyle(keywordCtx.selector().identifier().getText(), keywordCtx.selector().start.getLine(), caseStyle, this.getClass().getSimpleName());
            }
        }

    }

    @Override public void initOption()
    {
        String configCaseStyle = this.getOption("MethodCase");
        if(configCaseStyle != null)
        {
            this.caseStyle = configCaseStyle;
        }
    }
}

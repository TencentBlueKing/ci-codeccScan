package checks.readability;


import common.CheckerAnnotation;
import parser.ObjectiveCParser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/27
 */
@CheckerAnnotation
public class LocalVariableNaming extends ReadabilityBaseCheck
{
    private String caseStyle = "camelBack";

    @Override
    public void exitVarDeclaration(ObjectiveCParser.VarDeclarationContext ctx)
    {
        //ctx.declarationSpecifiers().storageClassSpecifier().get(0);

        if (matchTree(ctx, "compoundStatement.declaration.varDeclaration") == false)
        {
            return;
        }

        if(ctx.initDeclaratorList() == null)
        {
            return;
        }

        for (ObjectiveCParser.InitDeclaratorContext initDeclCtx : ctx.initDeclaratorList().initDeclarator())
        {
            try
            {
                String globalVarName = initDeclCtx.declarator().directDeclarator().identifier().getText();

/*                if (globalVarName.matches(getCasePattern(caseStyle).pattern()) == false)
                {
                    DefectMessage msg = new DefectMessage();
                    msg.setLineNo(ctx.start.getLine());
                    msg.setCheckerName(this.getClass().getSimpleName());
                    msg.setFilePath(getFilePath());
                    msg.setMessage(String.format("\'%s\' 的命名风格不符合配置值:%s", globalVarName, caseStyle));
                    this.addMessage(msg);
                }*/
                this.checkNamingStyle(globalVarName, ctx.start.getLine(), caseStyle, this.getClass().getSimpleName());

            }catch (Exception e)
            {

            }
        }
    }

    @Override
    public void initOption()
    {
        String configCase = this.getOption("LocalVariableCase");
        if (configCase != null)
        {
            this.caseStyle = configCase;
        }
    }
}

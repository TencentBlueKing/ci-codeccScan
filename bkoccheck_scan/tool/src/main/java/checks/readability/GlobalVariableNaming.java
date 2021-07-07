package checks.readability;


import common.CheckerAnnotation;
import common.DefectMessage;
import parser.ObjectiveCParser;

import java.util.List;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/27
 */
@CheckerAnnotation
public class GlobalVariableNaming extends ReadabilityBaseCheck
{
    private String caseStyle = "CamelBack";
    private String prefix = "g";

    @Override
    public void exitVarDeclaration(ObjectiveCParser.VarDeclarationContext ctx)
    {
        //ctx.declarationSpecifiers().storageClassSpecifier().get(0);

        if (matchTree(ctx, "topLevelDeclaration.declaration.varDeclaration") == false
                && matchTree(ctx, "implementationDefinitionList.declaration.varDeclaration") == false
                && matchTree(ctx, "interfaceDeclarationList.declaration.varDeclaration") == false)
        {
            return;
        }


        if (ctx.declarationSpecifiers() == null || ctx.declarationSpecifiers().storageClassSpecifier().size() == 0)
        {
            return;
        }

        //排除非static情况
        for (ObjectiveCParser.StorageClassSpecifierContext storageCtx :
                ctx.declarationSpecifiers().storageClassSpecifier())
        {
            if (storageCtx.STATIC() == null)
            {
                return;
            }
        }


        //System.out.println("typeQualifier size:"+ ctx.declarationSpecifiers().typeQualifier().size());

        //排除 static int const kGlobalConstVar 的情况
        if(ctx.declarationSpecifiers().typeQualifier().size() != 0)
        {
            List<ObjectiveCParser.TypeQualifierContext> typeQualifierContexts =
                    ctx.declarationSpecifiers().typeQualifier();
            for(ObjectiveCParser.TypeQualifierContext typeCtx : typeQualifierContexts)
            {
                if(typeCtx.CONST() != null)
                {
                    return;
                }
            }
        }

        for (ObjectiveCParser.InitDeclaratorContext initDeclCtx : ctx.initDeclaratorList().initDeclarator())
        {
            String globalVarName = initDeclCtx.declarator().directDeclarator().identifier().getText();

            if(initDeclCtx.declarator().pointer()!=null && initDeclCtx.declarator().pointer().declarationSpecifiers() != null)
            {
                ObjectiveCParser.DeclarationSpecifiersContext declarationSpecifiersContext =
                        initDeclCtx.declarator().pointer().declarationSpecifiers();
                for(ObjectiveCParser.TypeQualifierContext typeCtx: declarationSpecifiersContext.typeQualifier())
                {
                    if(typeCtx.CONST() != null)
                    {
                        return;
                    }
                }
            }

            if (globalVarName.startsWith(prefix) == false)
            {
                DefectMessage msg = new DefectMessage();
                msg.setLineNo(ctx.start.getLine());
                msg.setCheckerName(this.getClass().getSimpleName());
                msg.setFilePath(getFilePath());
                msg.setMessage(String.format("全局变量'%s'的命名须以 '%s' 前缀开头", globalVarName, prefix));
                this.addMessage(msg);
            }

            String realGlobalName = globalVarName.substring(prefix.length());
/*            if (realGlobalName.matches(getCasePattern(caseStyle).pattern()) == false)
            {

                DefectMessage msg = new DefectMessage();
                msg.setLineNo(ctx.start.getLine());
                msg.setCheckerName(this.getClass().getSimpleName());
                msg.setFilePath(getFilePath());
                msg.setMessage(String.format("\'%s\' 的命名风格不符合配置值:%s", globalVarName, caseStyle));
                this.addMessage(msg);
            }*/
            this.checkNamingStyle(realGlobalName, ctx.start.getLine(), caseStyle, this.getClass().getSimpleName());
        }
    }

    @Override
    public void initOption()
    {
        String configPrefix = this.getOption("GlobalVariablePrefix");
        if (configPrefix != null)
        {
            this.prefix = configPrefix;
        }

        String configCase = this.getOption("GlobalVariableCase");
        if (configCase != null)
        {
            this.caseStyle = configCase;
        }
    }
}

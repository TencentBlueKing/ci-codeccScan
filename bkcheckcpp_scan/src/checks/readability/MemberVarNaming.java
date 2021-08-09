package checks.readability;


import common.CheckerAnnotation;
import parser.CPP14Parser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/5/6
 */
@CheckerAnnotation
public class MemberVarNaming extends ReadabilityBaseCheck
{
    String classMemberCase = "[a-z0-9_]*_";
    String structMemberCase = "[a-z0-9_]*";

    String currentClassKey = "";

    @Override public void exitMemberdeclarator(CPP14Parser.MemberdeclaratorContext ctx)
    {
        String longSpec = ctx.declarator().getText();
        if(longSpec.contains("("))
        {
            return;
        }
        String memberName = longSpec.split("\\(")[0].replace("*", "");
        if(currentClassKey.equals("class"))
        {
            this.checkNamingRegex(memberName, ctx.getStart().getLine(), classMemberCase, this.getClass().getSimpleName());
        }
        else if(currentClassKey.equals("struct"))
        {
            this.checkNamingRegex(memberName, ctx.getStart().getLine(), structMemberCase, this.getClass().getSimpleName());
        }

    }

    @Override public void enterClassspecifier(CPP14Parser.ClassspecifierContext ctx)
    {
        if(ctx.classhead().classkey().Class() != null)
        {
            currentClassKey = "class";
        }
        else if(ctx.classhead().classkey().Struct() != null)
        {
            currentClassKey = "struct";
        }
        else if(ctx.classhead().classkey().Union() != null)
        {
            currentClassKey = "union";
        }
    }

/*    @Override public void exitClassspecifier(CPP14Parser.ClassspecifierContext ctx)
    {
        System.out.println("exit " + currentClassKey);
    }*/
}

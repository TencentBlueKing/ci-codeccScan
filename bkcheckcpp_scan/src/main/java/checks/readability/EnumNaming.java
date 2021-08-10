package checks.readability;


import common.CheckerAnnotation;
import common.DefectMessage;
import parser.CPP14Parser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/5/6
 */
@CheckerAnnotation
public class EnumNaming extends ReadabilityBaseCheck
{
    String enumNameStyle = "CamelCaseWithoutUnderscore";
    String enumTypeEleStyleWithConstPrefix = "k[A-Z][a-zA-Z0-9]*";
    String enumTypeEleStyleUpperCase = "[A-Z][A-Z0-9_]*";
    String enumTypeEleStyleWithEnumNamePrefix = "";
    String classTypeEleStyle = "CamelCaseWithoutUnderscore";
    String currentEnumType = "";

    @Override public void exitEnumeratordefinition(CPP14Parser.EnumeratordefinitionContext ctx)
    {
        String enumEleName = ctx.enumerator().Identifier().getSymbol().getText();
        //System.out.println(enumEleName);
        if(currentEnumType.equals("class"))
        {
            this.checkNamingStyle(enumEleName, ctx.getStart().getLine(), classTypeEleStyle, this.getClass().getSimpleName());
        }
        else
        {
            boolean isMatch = false;
            if(enumEleName.matches(enumTypeEleStyleWithConstPrefix) || enumEleName.matches(enumTypeEleStyleUpperCase) || enumEleName.matches(enumTypeEleStyleWithEnumNamePrefix))
            {
                isMatch = true;
            }
            if(isMatch == false)
            {
                DefectMessage msg = new DefectMessage();
                msg.setLineNo(ctx.getStart().getLine());
                msg.setCheckerName(this.getClass().getSimpleName());
                msg.setFilePath(getFilePath());
                msg.setMessage(String.format("\'%s\' 的命名风格不符合配置值:%s", enumEleName, enumTypeEleStyleWithConstPrefix
                        + " 或者 "
                        + enumTypeEleStyleUpperCase
                        + " 或者 "
                        + enumTypeEleStyleWithEnumNamePrefix));
                this.addMessage(msg);
            }
        }

    }

    @Override public void initOption()
    {
        String configCaseStyle = this.getOption("EnumNameCase");
        if(configCaseStyle != null)
        {
            this.enumNameStyle = configCaseStyle;
        }

        String configEnumClassTypeCase = this.getOption("EnumClassElementCase");
        if(configEnumClassTypeCase != null)
        {
            this.classTypeEleStyle = configEnumClassTypeCase;
        }
    }

    @Override public void enterEnumspecifier(CPP14Parser.EnumspecifierContext ctx)
    {
        if(ctx.enumhead().enumkey().Class() != null)
        {
            currentEnumType = "class";
        }
        else if(ctx.enumhead().enumkey().Enum() != null)
        {
            currentEnumType = "enum";
        }

        String enumNaming = ctx.enumhead().Identifier().getSymbol().getText();
        //System.out.println(enumNaming);
        enumTypeEleStyleWithEnumNamePrefix = enumNaming + "_[A-Z][A-Z0-9]*";
        //this.checkNamingRegex(enumNaming, ctx.getStart().getLine(), enumNameStyle, this.getClass().getSimpleName());
        this.checkNamingStyle(enumNaming, ctx.getStart().getLine(), enumNameStyle, this.getClass().getSimpleName());
    }
}

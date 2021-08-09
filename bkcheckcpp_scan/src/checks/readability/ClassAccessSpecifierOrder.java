package checks.readability;


import common.BaseCheck;
import common.CheckerAnnotation;
import parser.CPP14Parser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/5/9
 */
@CheckerAnnotation
public class ClassAccessSpecifierOrder extends BaseCheck
{
    boolean inClass = false;

    private enum AccessSpecifier
    {
        PUBLIC(1), PROTECTED(2), PRIVATE(3);

        private int code;

        AccessSpecifier(int code)
        {
            this.code = code;
        }

        public int getCode()
        {
            return this.code;
        }
    }

    AccessSpecifier lastAccSpecifier = AccessSpecifier.PUBLIC;

    @Override public void enterClassspecifier(CPP14Parser.ClassspecifierContext ctx)
    {
        inClass = true;
        lastAccSpecifier = AccessSpecifier.PUBLIC;
    }

    @Override public void exitClassspecifier(CPP14Parser.ClassspecifierContext ctx)
    {
        inClass = false;
    }

    @Override public void enterAccessspecifier(CPP14Parser.AccessspecifierContext ctx)
    {
        if(inClass && ctx.getParent().getRuleIndex() == CPP14Parser.RULE_memberspecification)
        {
            boolean expectOrder = true;
            if(ctx.Public() != null)
            {
                expectOrder = checkOrder(AccessSpecifier.PUBLIC);
                lastAccSpecifier = AccessSpecifier.PUBLIC;
            }
            else if(ctx.Protected() != null)
            {
                expectOrder = checkOrder(AccessSpecifier.PROTECTED);
                lastAccSpecifier = AccessSpecifier.PROTECTED;
            }
            else if(ctx.Private() != null)
            {
                expectOrder = checkOrder(AccessSpecifier.PRIVATE);
                lastAccSpecifier = AccessSpecifier.PRIVATE;
            }

            if(expectOrder == false)
            {
                this.addMessage(ctx.getStart().getLine(), "访问控制符需要按照public/protected/private顺序使用");
            }
        }
    }

    private boolean checkOrder(AccessSpecifier currAcc)
    {
        if(lastAccSpecifier.getCode() > currAcc.getCode())
        {
            return false;
        }

        return true;
    }
}

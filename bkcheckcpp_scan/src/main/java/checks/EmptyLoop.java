package checks;


import common.BaseCheck;
import common.CheckerAnnotation;
import parser.CPP14Parser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/5/8
 */
@CheckerAnnotation
public class EmptyLoop extends BaseCheck
{
    @Override public void exitIterationstatement(CPP14Parser.IterationstatementContext ctx)
    {
        if(ctx.statement().compoundstatement() == null && ctx.statement().expressionstatement().expression() == null)
        {
            this.addMessage(ctx.getStart().getLine(), "缺少循环体的循环语句，建议将循环体写成 {} 或 continue;");
        }
    }
}

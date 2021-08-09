package checks;


import common.BaseCheck;
import common.CheckerAnnotation;
import parser.CPP14Parser;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/5/2
 */
@CheckerAnnotation
public class NoThrow extends BaseCheck
{
    @Override public void exitThrowexpression(CPP14Parser.ThrowexpressionContext ctx)
    {
        this.addMessage(ctx.start.getLine(), "不建议使用C++异常");
    }
}

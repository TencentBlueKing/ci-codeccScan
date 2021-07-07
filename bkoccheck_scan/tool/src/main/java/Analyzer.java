import common.BaseCheck;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;
import parser.ObjectiveCLexer;
import parser.ObjectiveCParser;

import java.util.List;
import java.util.Map;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/19
 */
public class Analyzer implements Runnable
{
    private String source;
    private List<BaseCheck> enableCheckList;
    private final Map<String, String> checkOptions;
    private String filePath;

    private static final Logger logger = Logger.getLogger(Analyzer.class);

    public Analyzer(String source, List<BaseCheck> enableCheckList, Map<String, String> checkOptions, String filePath)
    {
        this.source = source;
        this.enableCheckList = enableCheckList;
        this.checkOptions = checkOptions;
        this.filePath = filePath;
    }

    @Override
    public void run()
    {
        System.out.println("scan file:" + filePath);
        ObjectiveCLexer lexer = new ObjectiveCLexer(CharStreams.fromString(source));
        lexer.removeErrorListeners();
        CommonTokenStream token = new CommonTokenStream(lexer);
        ObjectiveCParser parser = new ObjectiveCParser(token);
        parser.removeErrorListeners();
        parser.setErrorHandler(new DefaultErrorStrategy(){
            @Override
            public void recover(Parser recognizer, RecognitionException e) {
                throw new RuntimeException(e);
            }
        });

        ParseTree parseTree = parser.translationUnit();
        //System.out.println(parseTree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();

        for(BaseCheck check : enableCheckList)
        {
            check.setFilePath(filePath);
            check.checkText(source);
            walker.walk(check, parseTree);
            //System.out.println("[" + Thread.currentThread().getName()+"]finish check:" + check.getClass().getSimpleName());
        }
    }
}

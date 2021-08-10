import common.BaseCheck;
import common.CheckerPool;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;
import parser.CPP14Lexer;
import parser.CPP14Parser;
import reporters.BaseReporter;

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
    private final Map<String, String> checkOptions;
    private final BaseReporter reporter;
    private String filePath;

    private static final Logger logger = Logger.getLogger(Analyzer.class);

    public Analyzer(String source, BaseReporter reporter, Map<String, String> checkOptions, String filePath)
    {
        this.source = source;
        this.checkOptions = checkOptions;
        this.filePath = filePath;
        this.reporter = reporter;
    }

    @Override
    public void run()
    {
        logger.info("scan file:" + filePath);
        CPP14Lexer lexer = new CPP14Lexer(CharStreams.fromString(source));
        lexer.removeErrorListeners();
        CommonTokenStream token = new CommonTokenStream(lexer);
        CPP14Parser parser = new CPP14Parser(token);
        parser.removeErrorListeners();
        parser.setErrorHandler(new DefaultErrorStrategy(){
            @Override
            public void recover(Parser recognizer, RecognitionException e) {
                throw new RuntimeException(e);
            }
        });

        ParseTree parseTree = parser.translationunit();

        //System.out.println(parseTree.toStringTree(parser));


        ParseTreeWalker walker = new ParseTreeWalker();

        BaseCheck allInOneChecker = CheckerPool.getInst().getAllInOneChecker(Thread.currentThread().getName());
        allInOneChecker.setCheckOptions(checkOptions);
        allInOneChecker.setFilePath(filePath);
        allInOneChecker.setReporter(reporter);
        allInOneChecker.checkText(source);
        walker.walk(allInOneChecker, parseTree);
    }
}

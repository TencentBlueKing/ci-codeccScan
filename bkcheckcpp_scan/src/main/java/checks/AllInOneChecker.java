package checks;

import common.BaseCheck;
import common.CheckerPool;
import common.SuperChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/4/30
 */
@SuperChecker
public class AllInOneChecker extends BaseCheck
{
    Map<String, List<String>> checkerListenEvent = new HashMap<>();
    List<String> sourceCheckers = new ArrayList<>();
    Map<String, BaseCheck> mapCheckers = new HashMap<>();

    public void checkText(String source)
    {
        for (String checkerName : sourceCheckers)
        {
            BaseCheck checker = CheckerPool.getInst().get(Thread.currentThread().getName(), checkerName);
            //BaseCheck checker = mapCheckers.get(checkerName);
            checker.setCheckOptions(this.getCheckOptions());
            checker.setReporter(this.getReporter());
            checker.setFilePath(this.getFilePath());
            checker.initOption();
            checker.checkText(source);
        }
    }

    public void registerWalkerChecker()
    {
        //sample code below will be added to this method:
        //addWalkerChecker("FunctionNaming", "exitMethodDefinition");
        //addWalkerChecker("FunctionNaming", "exitFunctionDefinition");
    }

    public void registerSourceChecker()
    {
        //sample code below will be added to this method:
        //sourceCheckers.add("Indent");
        //sourceCheckers.add("MacroNaming");
    }

    private void addWalkerChecker(String checkerName, String listenEvent)
    {
        if (checkerListenEvent.containsKey(listenEvent))
        {
            List<String> checkerList = checkerListenEvent.get(listenEvent);
            checkerList.add(checkerName);
        }
        else
        {
            List<String> checkerList = new ArrayList<>();
            checkerList.add(checkerName);
            checkerListenEvent.put(listenEvent, checkerList);
        }
    }

    public void buildCheckers(List<Class<?>> checkerClass)
    {
        for(Class clazz : checkerClass)
        {
            try
            {
                BaseCheck check = (BaseCheck)clazz.newInstance();
                mapCheckers.put(clazz.getName(), check);
            }
            catch (InstantiationException e)
            {
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
    }

    // sample method below will be added to this class:
/*    @Override public void exitMethodDefinition(ObjectiveCParser.MethodDefinitionContext ctx)
    {
        String listenEvent = "exitMethodDefinition";
        List<String> baseChecksName = checkerListenEvent.get(listenEvent);

        for(int i=0; i<baseChecksName.size(); i++)
        {
            //BaseCheck checker = CheckerPool.getInst().get(Thread.currentThread().getName(), baseChecksName.get(i));
            BaseCheck checker = mapCheckers.get(baseChecksName.get(i));

            checker.setCheckOptions(this.getCheckOptions());
            checker.setReporter(this.getReporter());
            checker.setFilePath(this.getFilePath());
            checker.initOption();

            checker.exitMethodDefinition(ctx);
        }
    }*/
}




package common;

import checks.AllInOneChecker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/5/15
 */
public class CheckerPool
{
    //threadName,
    Map<String, Map<String, BaseCheck>> checkerMap;
    Map<String, AllInOneChecker> allInOneCheckMap;
    List<Class<?>> checkerClass;

    static CheckerPool pool = null;

    public CheckerPool(int poolSize, List<Class<?>> checkerClass)
    {
        this.checkerMap = new HashMap<>(poolSize);
        this.allInOneCheckMap = new HashMap<>(poolSize);
        this.checkerClass = checkerClass;
    }

    public static void init(int poolSize, List<Class<?>> checkerClass)
    {
        pool = new CheckerPool(poolSize, checkerClass);

        for(int i=0; i<=poolSize; i++)
        {
            String threadName = "checker-thread-" + String.valueOf(i);
            Map<String, BaseCheck> checkerList = new HashMap<>();
            for(Class<?> clazz : checkerClass)
            {
                try
                {
                    BaseCheck checker = (BaseCheck) clazz.newInstance();
                    String checkerName = clazz.getName();
                    checkerList.put(checkerName, checker);
                    CheckerPool.getInst().checkerMap.put(threadName, checkerList);
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
            AllInOneChecker allInOneChecker = new AllInOneChecker();
            allInOneChecker.registerWalkerChecker();
            allInOneChecker.registerSourceChecker();
            CheckerPool.getInst().allInOneCheckMap.put(threadName, allInOneChecker);
        }
    }

    public static CheckerPool getInst()
    {
        return pool;
    }

    public BaseCheck get(String threadName, String checkName)
    {
        if(threadName == null)
        {
            return null;
        }

        return checkerMap.get(threadName).get(checkName);
    }

    public BaseCheck getAllInOneChecker(String threadName)
    {
        if(threadName == null)
        {
            return null;
        }

        return allInOneCheckMap.get(threadName);
    }
}

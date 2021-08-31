import common.BaseCheck;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import reporters.BaseReporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/3/16
 */
public class OCCheck
{
    private final Logger logger = LogManager.getLogger(OCCheck.class);

    public Map<String, String> getCheckerOptions()
    {
        return checkerOptions;
    }

    public void setCheckerOptions(Map<String, String> checkerOptions)
    {
        this.checkerOptions = checkerOptions;
    }


    public void setPath(List<String> fileList)
    {
        this.fileList = fileList;
    }

    public List<BaseCheck> getChecksList()
    {
        return checksList;
    }

    public void setChecksList(List<BaseCheck> checksList)
    {
        this.checksList = checksList;
    }

    public void setChecks(List<Class<?>> checks)
    {
        checksClass = checks;
    }

    public void setReporter(BaseReporter reporter)
    {
        this.reporter = reporter;
    }

    private List<BaseCheck> getEnableCheck()
    {
        List<BaseCheck> baseChecks = new ArrayList<>();
        for(Class cl : checksClass)
        {
            try
            {
                BaseCheck checker  = (BaseCheck)cl.newInstance();
                checker.setCheckOptions(checkerOptions);
                checker.setReporter(reporter);
                checker.initOption();
                baseChecks.add(checker);
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
        return baseChecks;
    }

    public void startAnalyze()
    {
        ExecutorService service = Executors.newFixedThreadPool(processor);
        List<Runnable> taskList = new ArrayList<>();
        for(String filePath : fileList)
        {

            String source = readFile(filePath);
            Path path = Paths.get(filePath);
            Analyzer analyzer = new Analyzer(source, getEnableCheck(), checkerOptions, filePath);

            String threadName = path.getFileName().toString();
            //new Thread(analyzer, threadName).start();
            //service.execute(analyzer);
            taskList.add(analyzer);
        }
        //service.shutdown();

        List<Future<?>> futures = new ArrayList<>();
        for (Runnable task : taskList)
        {
            futures.add(service.submit(task));
        }
        for (Future<?> future : futures)
        {
            try
            {
                future.get();
            }
            catch (Exception e)
            { // do logging and nothing else
            }
        }

        awaitTerminationAfterShutdown(service);
        //System.out.println("finish ===================== startAnalyze");
    }

    private String readFile(String filePath) {
        StringBuilder sb = new StringBuilder("");
        try
        {
            String encoding = "UTF8";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    sb.append(lineTxt+"\n");
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                System.err.println(String.format("file not found:%s", filePath));
            }
        }
        catch (Exception e)
        {
            System.err.println(String.format("read error:%s", filePath));
            e.printStackTrace();
        }

        return sb.toString();
    }


    private void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        //System.out.println("calling awaitTerminationAfterShutdown");
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(1, TimeUnit.HOURS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
        //System.out.println("finish calling awaitTerminationAfterShutdown");
    }


    private List<String> fileList;
    private Map<String, String> checkerOptions;
    private List<BaseCheck> checksList;
    private List<Class<?>> checksClass;
    private BaseReporter reporter;

    public int getProcessor()
    {
        return processor;
    }

    public void setProcessor(int processor)
    {
        this.processor = processor;
    }

    private int processor;
}

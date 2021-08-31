import com.google.gson.Gson;
import common.BaseCheck;
import common.CheckerAnnotation;
import common.ConfigOptions;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.reflections.Reflections;
import org.yaml.snakeyaml.Yaml;
import reporters.BaseReporter;
import reporters.ReporterFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/1/9
 */
public class MainEntry
{

    private static final Logger logger = LogManager.getLogger(MainEntry.class);


    public static CommandLine parseOptions(String[] args)
    {
        Options options = new Options();
        Option opt = new Option("h", false, "show this help message and exit");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("c", "config", true, "Specifies a configuration in YAML format.");
        opt.setRequired(true);
        options.addOption(opt);

        opt = new Option("k", "checks", true, "Specifies a comma-separated list of globs with optional '-' prefix.");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("l", "list-checks", false, "List all enabled checks and exit. Use with -checks='*' to list " +
                "all available checks");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("o", "output", true, "File Path to store outputs in.");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("f", "format", true, "Sets the output format. Available formats are 'json' and 'text'.");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("j", "processor",true, "set number of thread to use, usually means the number of files to be check in " +
                "the meanwhile");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("e", true, "set file extensions to be check, default is .h,.m,.mm,.M");
        opt.setRequired(false);
        options.addOption(opt);


        HelpFormatter hf = new HelpFormatter();
        hf.setWidth(110);
        CommandLine commandLine = null;
        CommandLineParser parser = new DefaultParser();
        try
        {
            commandLine = parser.parse(options, args);
            if (commandLine.hasOption('h'))
            {
                // 打印使用帮助
                hf.printHelp("java -jar bkcheck-oc.jar", options, true);
                System.exit(0);
            }

            // 打印opts的名称和值
            Option[] opts = commandLine.getOptions();
            if (opts != null)
            {
                for (Option opt1 : opts)
                {
                    String name = opt1.getLongOpt();
                    //System.out.println(name);
                    String value = commandLine.getOptionValue(name);
                    System.out.println(String.format("command line arg: %s=>%s", name, value));
                }
            }
        }
        catch (ParseException e)
        {
            hf.printHelp("java -jar bkcheck.jar", options, true);
            System.exit(0);
        }
        return commandLine;
    }

    public static void findAllFiles(String path, List<String> skipPaths, List<String> fileList)
    {
        File root = new File(path);
        if (root.isFile())
        {
            if (root.getName().endsWith(".h") || root.getName().endsWith(".m") || root.getName().endsWith(".mm"))
            {
                if (!fileSkip(path, skipPaths))
                {
                    fileList.add(path);
                }
            }
            return;
        }
        else
        {
            for (File file : root.listFiles())
            {
                if (file.isHidden() == true)
                {
                    continue;
                }
                if (file.isDirectory())
                {
                    findAllFiles(file.getPath(), skipPaths, fileList);
                }
                else
                {
                    if (file.getName().endsWith(".h") || file.getName().endsWith(".m") || root.getName().endsWith(".mm"))
                    {
                        if (!fileSkip(file.getPath(), skipPaths))
                        {
                            fileList.add(file.getPath());
                        }
                    }
                }
            }
        }
    }

    public static boolean fileSkip(String path, List<String> skipPaths)
    {
        if (skipPaths.size() <= 0)
        {
            return false;
        }
        try{
            for (String skipPath : skipPaths)
            {
                Pattern pattern = Pattern.compile(skipPath);
                Matcher matcher = pattern.matcher(path);
                if (matcher.matches())
                {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
//            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static void main(String[] argv)
    {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        //String[] arg = {"-f", "json", "-j", "1", "-c", "D:\\occheck_config_codecc_1.0.yml", "c:\\simple6.m"};
        CommandLine commandLine = parseOptions(argv);

        System.out.println("command args:" + new Gson().toJson(argv));
        System.out.println("command args:" + new Gson().toJson(argv));

        ConfigOptions options = initOptions(commandLine);

        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(options.getConfigFilePath());

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        Yaml yaml = new Yaml();
        Map config = (Map) yaml.load(fis);
        String configEnableChecks = (String) config.get("Checks");
        System.out.println("enable checker:" + configEnableChecks);

        String configIncrement = (String) config.get("IncrmentFiles");

        ArrayList<LinkedHashMap> configCheckOptions = (ArrayList<LinkedHashMap>) config.get("CheckOptions");

        ArrayList<String> skipPaths = (ArrayList<String>) config.get("SkipPaths");
        System.out.println("skipPaths: " + new Gson().toJson(skipPaths));

        //System.out.println(configCheckOptions);
        Map<String, String> checkOptions = new HashMap<>();
        for (LinkedHashMap map : configCheckOptions)
        {
            checkOptions.put((String) map.get("key"), String.valueOf(map.get("value")));
        }
        System.out.println("checker options:" + new Gson().toJson(checkOptions));

        ArrayList<String> fileList = new ArrayList<>();
        if(configIncrement == null || configIncrement.isEmpty())
        {
            for (String path : commandLine.getArgs())
            {
                System.out.println("full try adding file:" + path);
                findAllFiles(path, skipPaths, fileList);
            }
        }
        else
        {
            String[] incrList = configIncrement.split(",");
            for (String path : incrList)
            {
                System.out.println("incr try adding file:" + path);
                findAllFiles(path, skipPaths, fileList);
            }
        }

        ReporterFactory reporterFactory = new ReporterFactory();
        BaseReporter reporter = reporterFactory.getReporter(options.getFormat());

        String[] split = configEnableChecks.split(",");
        List<String> configEnableCheckList = Arrays.asList(split);

        List<BaseCheck> enableCheckList = new ArrayList<>();
        List<Class<?>> checkerClass = new ArrayList<>();
        Reflections ref = new Reflections("checks");
        for (Class<?> cl : ref.getTypesAnnotatedWith(CheckerAnnotation.class))
        {
            if (configEnableCheckList.contains(cl.getSimpleName()))
            {
                try
                {
                    BaseCheck checker = (BaseCheck) cl.newInstance();
                    checker.setCheckOptions(checkOptions);
                    checker.setReporter(reporter);
                    checker.initOption();
                    enableCheckList.add(checker);

                    checkerClass.add(cl);
                    //System.out.println("add checker:" + cl.getSimpleName());
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

        System.out.println("file count: " + fileList.size());
        OCCheck occheck = new OCCheck();
        occheck.setPath(fileList);
        occheck.setChecksList(enableCheckList);
        occheck.setCheckerOptions(checkOptions);
        occheck.setChecks(checkerClass);
        occheck.setReporter(reporter);
        occheck.setProcessor(options.getThread());
        occheck.startAnalyze();

        String result = reporter.dump();
        if(commandLine.hasOption('o') || commandLine.hasOption("output"))
        {
            String savePath = commandLine.getOptionValue('o');
            FileOutputStream fos = null;
            try
            {
                fos = new FileOutputStream(savePath);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            try
            {
                fos.write(result.getBytes(Charset.forName("UTF-8")));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            //System.out.println(result);
        }
        System.out.println("finish all analysis");
    }


    private static ConfigOptions initOptions(CommandLine commandLine)
    {
        ConfigOptions options = new ConfigOptions();

        String configFilePath = commandLine.getOptionValue("c");
        options.setConfigFilePath(configFilePath);

        String extension = commandLine.getOptionValue("e");
        if (extension != null)
        {
            options.setExtension(extension);
        }
        else
        {
            options.setExtension("m,mm");
        }

        String format = commandLine.getOptionValue("f");
        if (format != null)
        {
            options.setFormat(format);
        }
        else
        {
            options.setFormat("json");
        }

        String outputFile = commandLine.getOptionValue("o");
        if (outputFile != null)
        {
            options.setOutputFilePath(outputFile);
        }

        String thread = commandLine.getOptionValue("j");
        if (thread != null)
        {
            options.setThread(Integer.valueOf(thread));
        }
        else
        {
            options.setThread(3);
        }

        return options;
    }
}


package common;

import javassist.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/5/14
 */
public class AllInOneMaker
{
    private CtMethod createMethod(String method, String parameterType, CtClass cc)
    {
        String methodSig = String.format("public void %s(%s){}", method, parameterType);
        CtMethod ctMethod = null;
        try
        {
            ctMethod = CtNewMethod.make(methodSig, cc);
            cc.addMethod(ctMethod);
        }
        catch (CannotCompileException e)
        {
            e.printStackTrace();
        }
        return ctMethod;
    }

    private boolean hasMethod(Class<?> clazz, String methodName)
    {
        if(clazz == null)
        {
            return false;
        }

        for(Method m : clazz.getDeclaredMethods())
        {
            if(m.getName().equals(methodName))
            {
                return true;
            }
        }

        return false;
    }

    public void make(List<Class<?>> checkerClass) throws NotFoundException, CannotCompileException, InstantiationException, IllegalAccessException
    {
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("checks.AllInOneChecker");

/*        for(CtMethod mm : cc.getDeclaredMethods())
        {
            System.out.println("******old class method:" + mm.getName());
        }*/

        List<String> baseASTMethods = new ArrayList<>();
        Map<String, String> mapAstMethods = new HashMap<>();
        for(CtMethod m : cc.getSuperclass().getSuperclass().getDeclaredMethods())
        {
            baseASTMethods.add(m.getName());
            mapAstMethods.put(m.getName(), m.getParameterTypes()[0].getName().replace('$', '.'));
        }

        CtMethod registerWalkerCheckerFunction = cc.getDeclaredMethod("registerWalkerChecker");
        CtMethod registerSourceCheckerFunction = cc.getDeclaredMethod("registerSourceChecker");

        for (Class<?> cl : checkerClass)
        {
            //Method checkText = cl.getDeclaredMethods();
            CtClass ccc = cp.get(cl.getName());
            for(CtMethod m : ccc.getDeclaredMethods())
            {
                if(mapAstMethods.containsKey(m.getName()))
                {
                    CtMethod declaredMethod = null;
                    try
                    {
                        declaredMethod = cc.getDeclaredMethod(m.getName());
                    }
                    catch (NotFoundException e)
                    {
                        //e.printStackTrace();
                    }
                    if(declaredMethod == null)
                    {
                        declaredMethod = createMethod(m.getName(), mapAstMethods.get(m.getName()) + " ctx", cc);
                        //System.out.println("=========================>>>>"+m.getName() + "....." + mapAstMethods.get(m.getName()));

                        //declaredMethod.setBody("{String listenEvent = \"exitMethodDefinition\"; java.util.List baseChecks = checkerListenEvent.get(listenEvent); for(int i=0; i<baseChecks.size(); i++)((common.BaseCheck)baseChecks.get(i)).exitMethodDefinition($1);}");
                        String body = String.format("" +
                                "{" +
                                "    String listenEvent = \"%s\"; " +
                                "    java.util.List baseChecksName = checkerListenEvent.get(listenEvent); " +
                                "    for(int i=0; i<baseChecksName.size(); i++) {" +
                                "          common.BaseCheck checker = common.CheckerPool.getInst().get(Thread.currentThread().getName(), (String)baseChecksName.get(i));" +
                                "          checker.setCheckOptions(this.getCheckOptions());" +
                                "          checker.setReporter(this.getReporter());" +
                                "          checker.setFilePath(this.getFilePath());" +
                                "          checker.initOption();" +
                                "          checker.%s($1);" +
                                "}}", m.getName(), m.getName());

                        declaredMethod.setBody(body);
                    }

                    registerWalkerCheckerFunction.insertAfter(String.format("addWalkerChecker(\"%s\", \"%s\");", cl.getName(), m.getName()));
                    //System.out.println("insert to registerWalkerCheckerFunction:" + String.format("addWalkerChecker(\"%s\", \"%s\");", cl.getName(), m.getName()));
                }
            }
            if(hasMethod(cl, "checkText"))
            {
                registerSourceCheckerFunction.insertAfter(String.format("sourceCheckers.add(\"%s\");", cl.getName()));
                //System.out.println("insert to registerSourceCheckerFunction:" + String.format("sourceCheckers.add(\"%s\");", cl.getName()));
            }
        }

        //registerWalkerCheckerFunction.insertAfter("System.out.println(\"***the end of registerWalkerCheckerFunction\");");
        //registerSourceCheckerFunction.insertAfter("System.out.println(\"***the end of registerSourceCheckerFunction\");");

        cc.toClass().newInstance();
    }
}

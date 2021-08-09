package common;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author camelxiao
 * @version V2.0
 * @date 2020/5/19
 */

public class NamedThreadFactory implements ThreadFactory
{

    private static AtomicInteger tag = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r)
    {
        Thread thread = new Thread(r);
        thread.setName("checker-thread-" + tag.getAndIncrement());
        return thread;
    }

}
package io.lee.rpc.common.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Shuaijie
 * @version 1.0.0
 * @description Client thread pool
 */
public class ClientThreadPool {

    private static ThreadPoolExecutor threadPoolExecutor;

    static{
        threadPoolExecutor = new ThreadPoolExecutor(16, 16, 600L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(65536));
    }
    public static void submit(Runnable task){
        threadPoolExecutor.submit(task);
    }

    public static void shutdown() {
        threadPoolExecutor.shutdown();
    }
}

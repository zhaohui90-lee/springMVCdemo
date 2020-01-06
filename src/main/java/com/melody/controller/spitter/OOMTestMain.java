package com.melody.controller.spitter;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class OOMTestMain {

    /**
     * 池中所保存的线程数，包括空闲线程。
     */
    private final static int CORE_POOL_SIZE = 5;

    /**
     * 池中允许的最大线程数。
     */
    private final static int MAXIMUM_POOL_SIZE = 10;

    /**
     * 当线程数大于核心线程时，此为终止前多余的空闲线程等待新任务的最长时间
     */
    private final static long KEEP_ALIVE_TIME = 200L;

    /**
     *  执行前用于保持任务的队列，即任务缓存队列
     */
    private final static ArrayBlockingQueue<Runnable> WORK_QUENE = new ArrayBlockingQueue<Runnable>(5);

    public static void main(String[] args) {
//        ExecutorService es = Executors.newCachedThreadPool();
//        int i = 0;
//        while (true){
//            System.out.println("------" + i);
//            es.submit(new Task(i++));
//        }
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("XX-task-%d").build();

        ExecutorService pool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME,TimeUnit.MILLISECONDS,
                WORK_QUENE,namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());

        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.shutdown();
    }
}

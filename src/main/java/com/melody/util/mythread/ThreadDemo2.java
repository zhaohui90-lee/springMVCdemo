package com.melody.util.mythread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author: melody
 * @Date: 2020-04-07
 */
public class ThreadDemo2 implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (count < 5){
            System.out.println("running:" + count);
            count++;
        }
    }

    public void start(){
//        Thread thread = new Thread(this);
//        thread.start();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

//        singleThreadPool.execute(()-> {
//            System.out.println(Thread.currentThread().getName());
//        });
        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        singleThreadPool.shutdown();
    }

    public static void main(String[] args) {
        ThreadDemo2 demo2 = new ThreadDemo2();
        demo2.start();
    }
}

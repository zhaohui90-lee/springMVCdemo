package com.melody.util.threads.demo4;

import com.melody.util.threads.demo1.LiftOff;

import java.util.concurrent.*;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
/**
 * @Author: melody
 * @Date: 2020-05-27
 */
public class SleepingTask extends LiftOff {

    private static final int COUNT_OF_THREADS = 5;

    @Override
    public void run(){
        try {
            while (countDown-- > 0){
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.err.println("InterruptedException");
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService exec = new ScheduledThreadPoolExecutor(10,
                new BasicThreadFactory.Builder().namingPattern("sleepingTask-schedule-pool-%d").daemon(true).build());
        for (int i = 0; i < COUNT_OF_THREADS; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}

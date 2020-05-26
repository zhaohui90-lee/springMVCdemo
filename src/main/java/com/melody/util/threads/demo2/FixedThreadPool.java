package com.melody.util.threads.demo2;

import com.melody.util.threads.demo1.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: melody
 * @Date: 2020-05-26
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        // 预先分配线程，代价比较高昂
        // 优先使用CachedThreadPool
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}

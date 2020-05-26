package com.melody.util.threads.demo1;

/**
 * @Author: melody
 * @Date: 2020-05-26
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        // System.out优先于start方法运行，说明main方法和start
        // 是两个并行的线程
        System.out.println("waiting....");
    }
}

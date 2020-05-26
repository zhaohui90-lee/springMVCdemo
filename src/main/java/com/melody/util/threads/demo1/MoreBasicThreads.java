package com.melody.util.threads.demo1;

/**
 * @Author: melody
 * @Date: 2020-05-26
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        // #0(9),#1(9),#2(9),#3(9),#0(8),#1(8),#2(8),#4(9),#3(8),#0(7),#1(7),#2(7),#4(8),#3(7),#0(6),#1(6),#2(6),#4(7),#3(6),#0(5),#1(5),#2(5),#4(6),#3(5),#0(4),#1(4),#2(4),#4(5),#3(4),#0(3),#1(3),#2(3),#4(4),#3(3),#0(2),#1(2),#2(2),#4(3),#3(2),#0(1),#1(1),#2(1),#4(2),#3(1),#0(LiftOff!),#1(LiftOff!),#2(LiftOff!),#4(1),#3(LiftOff!),#4(LiftOff!),
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("waiting...");
    }
}

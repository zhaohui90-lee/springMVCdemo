package com.melody.util.mythread;

/**
 * @Author: melody
 * @Date: 2020-04-07
 */
public class ThreadDemo extends Thread {

    @Override
    public void run(){
        int count = 0;
        while (count < 5){
            System.out.println("count: " + count);
            count++;
        }
    }

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        demo.start();
    }
}

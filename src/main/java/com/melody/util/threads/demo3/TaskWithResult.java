package com.melody.util.threads.demo3;

import java.util.concurrent.Callable;

/**
 * @Author: melody
 * @Date: 2020-05-26
 */
public class TaskWithResult implements Callable<String> {

    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}

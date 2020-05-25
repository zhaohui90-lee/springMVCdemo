package com.melody.util.annotations.demo1;

/**
 * @Author: melody
 * @Date: 2020-05-22
 */
public class Testable {
    public void execute(){
        System.out.println("Executing...");
    }
    @Test void testExecute(){
        execute();
    }
}

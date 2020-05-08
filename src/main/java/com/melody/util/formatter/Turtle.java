package com.melody.util.formatter;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @Author: melody
 * @Date: 2020-04-30
 */
public class Turtle {
    private String name;
    private Formatter f;
    public Turtle(String name,Formatter f){
        this.name = name;
        this.f = f;
    }
    public void move(int x,int y){
        f.format("%s The Turtle is at (%d,%d)\n",name,x,y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle tommy = new Turtle("Tommy",new Formatter(outAlias));
        Turtle terry = new Turtle("Terry",new Formatter(outAlias));
        tommy.move(0,0);
        terry.move(1,1);
    }
}

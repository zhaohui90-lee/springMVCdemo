package algorithms;

import org.junit.Test;

public class Algorithms {
    @Test
    public void test1(){
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);
        s1 = "world";
        System.out.println(s1);
        System.out.println(s2);
    }
    @Test
    public void test2(){
        String s = "Hello World";
        s = s.toUpperCase();
        s = s.substring(6,11);
        System.out.println(s);
    }
}

package com.melody.util.enums;

/**
 * @Author: melody
 * @Date: 2020-05-21
 */
public class EnumClass {
    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            System.out.println(s + " ordinary: " + s.ordinal());
            System.out.print(s.compareTo(Shrubbery.CRAWLING) + " ");
            System.out.print(s.equals(Shrubbery.CRAWLING) + " ");
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("----------------------");
        }
    }
}

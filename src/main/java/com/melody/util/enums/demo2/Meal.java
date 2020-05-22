package com.melody.util.enums.demo2;

/**
 * @Author: melody
 * @Date: 2020-05-22
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course c : Course.values()) {
                Food food = c.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}

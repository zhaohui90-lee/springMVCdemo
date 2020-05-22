package com.melody.util.enums.demo2;

/**
 * @Author: melody
 * @Date: 2020-05-22
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        System.out.println(food);
        food = Food.MainCourse.HUMMOUS;
        System.out.println(food);
        food = Food.Dessert.BLACK_FOREST_CAKE;
        System.out.println(food);
    }
}

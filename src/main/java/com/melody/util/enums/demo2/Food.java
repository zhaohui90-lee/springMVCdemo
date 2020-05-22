package com.melody.util.enums.demo2;

/**
 * @Author: melody
 * @Date: 2020-05-22
 */
public interface Food {
    enum Appetizer implements Food{
        /**
         *  Appetizer
         */
        SALAD,SOUP,SPRING_ROLLS;
    }
    enum MainCourse implements Food{
        /**
         * MainCourse
         */
        LASAGNE,BURRITO,PAD_THAI,
        LENTILS,HUMMOUS,VINALOO;
    }
    enum Dessert implements Food{
        /**
         * Dessert
         */
        TIRAMISU,GELATO,BLACK_FOREST_CAKE;
    }
    enum Coffee implements Food{
        /**
         * Coffee
         */
        BLACK_COFFEE,DECAF_COFFEE,ESPRESSO;
    }
}

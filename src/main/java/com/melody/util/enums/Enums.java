package com.melody.util.enums;

import java.util.Random;

/**
 * @Author: melody
 * @Date: 2020-05-22
 */
public class Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values){
        return values[rand.nextInt(values.length)];
    }
}

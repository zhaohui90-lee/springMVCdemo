package com.melody.util.enums.demo1;

import com.melody.util.enums.Enums;

/**
 * @Author: melody
 * @Date: 2020-05-22
 */
public enum Activity {
    /**
     *
     */
    SITTING,LYING,STANDING,HOPPING, RUNNING;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(Enums.random(Activity.class) + " ");
        }
    }
}

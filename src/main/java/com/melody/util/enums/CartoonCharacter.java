package com.melody.util.enums;

import java.util.Random;

/**
 * @Author: melody
 * @Date: 2020-05-22
 */
public enum CartoonCharacter {
    /**
     *
     */
    SLAPPY,SPANKY,AAA,BBB,CCC;
    private Random rand = new Random(47);
    public CartoonCharacter next(){
        return values()[rand.nextInt(values().length)];
    }

}

package com.melody.pojo.pizza;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author 40431
 */

public enum Topping implements Serializable {
    /**
     * pizza的配料
     */
    PEPPERONI, SAUSAGE, HAMBURGER, MUSHROOM,
    CANADIAN_BACON, PINEAPPLE, GREEN_PEPPER,
    JALAPENO, TOMATO, ONION, EXTRA_CHEESE;

    public static List<Topping> asList(){
        Topping[] all = Topping.values();
        return Arrays.asList(all);
    }

    @Override
    public String toString() {
        return "Topping{}";
    }
}

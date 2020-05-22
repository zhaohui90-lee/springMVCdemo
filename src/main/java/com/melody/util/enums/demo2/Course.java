package com.melody.util.enums.demo2;

import com.melody.util.enums.Enums;

/**
 * @Author: melody
 * @Date: 2020-05-22
 */
public enum Course {
    /**
     *
     */
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    private Course(Class<? extends Food> kind){
        this.values = kind.getEnumConstants();
    }

    public Food randomSelection(){
        return Enums.random(values);
    }

}

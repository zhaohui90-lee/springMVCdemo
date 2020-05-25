package com.melody.util.annotations.demo5;

/**
 * @Author: melody
 * @Date: 2020-05-25
 */
public @interface SQLInteger {
    String name() default "";
    Constraints constraints() default @Constraints(unique = true);
}

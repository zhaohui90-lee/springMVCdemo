package com.melody.aop.springAop;

import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Author: melody
 * @Date: 2020-03-24
 */
public class Main {
    public static void main(String[] args) {
        ComposablePointcut pointcut1 = new ComposablePointcut();
        ComposablePointcut pointcut2 = new ComposablePointcut();

        ComposablePointcut unionPointcut = pointcut1.union(pointcut1);
        ComposablePointcut intersectionPointcut = pointcut2.intersection(pointcut1);

    }
}

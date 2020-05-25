package com.melody.util.annotations.demo3;

import com.melody.util.annotations.demo2.PasswordUtils;
import com.melody.util.annotations.demo2.UseCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: melody
 * @Date: 2020-05-25
 * 注解处理器
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases,Class<?> cl){
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null){
                System.out.println("Found Use Case: " + uc.id() + " " + uc.description());
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }
        for (int useCase : useCases) {
            System.out.println("Warning: Missing use case-" + useCase);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}

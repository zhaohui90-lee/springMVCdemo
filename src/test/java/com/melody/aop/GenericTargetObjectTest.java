package com.melody.aop;

import com.melody.aop.annotationMatchingPointcut.ClassLevelAnnotation;
import com.melody.aop.annotationMatchingPointcut.MethodLevelAnnotation;
import org.junit.Test;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class GenericTargetObjectTest {

    @Test
    public void test(){
        // 类级别的注解---com.melody.aop.annotationMatchingPointcut.GenericTargetObject
        AnnotationMatchingPointcut pointcut = new AnnotationMatchingPointcut(ClassLevelAnnotation.class);
        System.out.println(pointcut.getMethodMatcher());

        // 类级别的注解---com.melody.aop.annotationMatchingPointcut.GenericTargetObject
        AnnotationMatchingPointcut pointcut1 = AnnotationMatchingPointcut.forClassAnnotation(ClassLevelAnnotation.class);

        // 方法级别的注解---com.melody.aop.annotationMatchingPointcut.GenericTargetObject gMethod1() gMethod2()
        AnnotationMatchingPointcut pointcut2 = AnnotationMatchingPointcut.forMethodAnnotation(MethodLevelAnnotation.class);

        // 同时满足类级别的注解和方法级别的注解---com.melody.aop.annotationMatchingPointcut.GenericTargetObject gMethod1()
        AnnotationMatchingPointcut pointcut3 = new AnnotationMatchingPointcut(ClassLevelAnnotation.class,MethodLevelAnnotation.class);
    }
}

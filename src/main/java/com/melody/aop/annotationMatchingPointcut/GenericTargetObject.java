package com.melody.aop.annotationMatchingPointcut;

import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

@ClassLevelAnnotation
public class GenericTargetObject {

    @MethodLevelAnnotation
    public void gMethod1(){
        System.out.println("gMethod1...");
    }

    public void gMethod2(){
        System.out.println("gMethod2...");
    }

}

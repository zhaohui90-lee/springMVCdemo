package com.melody.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author 40431
 */
@Aspect
public class Audience {

    /**
     * @Pointcut("execution(* Performance.perform(..))") 定义命名的切点
     */
    @Pointcut("execution(* com.melody.pojo.concert.Performance.perform(..))")
    public void performance(){}

    /**
     * 通知方法在调用之前使用
     */
    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("silence cell phones...");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    /**
     * 通知方法在调用返回之后调用
     */
    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP ...");
    }

    /**
     * 通知方法在抛出异常后调用
     */
    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("refund...");
    }

    /**
     * 环绕通知方法
     */
    /*@Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try {
            System.out.println("Silence...");
            System.out.println("take seats...");
            jp.proceed();
            System.out.println("ClAP CLAP...");
        } catch (Throwable throwable) {
            System.out.println("demanding a refund...");
        }
    }*/
}

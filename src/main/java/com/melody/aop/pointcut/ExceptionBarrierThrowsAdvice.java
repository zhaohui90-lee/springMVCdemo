package com.melody.aop.pointcut;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @Author: melody
 * @Date: 2020-03-25
 */
public class ExceptionBarrierThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Throwable t){
        // 普通异常处理逻辑
    }

    public void afterThrowing(RuntimeException e){
        // 运行时异常处理逻辑
    }

    /**
     * 处理应用程序时生成的异常
     * @param m 目标方法
     * @param args 参数
     * @param target 目标对象
     * @param e applicationException 事务异常
     */
    public void afterThrowing(Method m,Object[] args,Object target,Exception e){
    }
}

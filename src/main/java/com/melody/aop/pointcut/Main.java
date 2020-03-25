package com.melody.aop.pointcut;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.util.Assert;

/**
 * @Author: melody
 * @Date: 2020-03-25
 */
public class Main {


    public static void main(String[] args) {
        ControlFlowPointcut pointcut = new ControlFlowPointcut(TargetCaller.class,"callMethod");

//        Advice advice = ...

        TargetObject target = new TargetObject();

//        TargetObject targetObjectToUse = weaver.weave(advice).to(target).accordingto(pointcut);

        TargetCaller caller = new TargetCaller();
        caller.setTarget(target);
        caller.callMethod();

        Assert.isTrue(true,"123456");
    }
}

package com.melody.aop.perInstance;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DelegatePerTargetObjectIntroductionInterceptor;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @Author: melody
 * @Date: 2020-03-27
 */
public class Main {
    public static void main(String[] args) {
        Advice advice = new DelegatePerTargetObjectIntroductionInterceptor(TesterFeatureIntroductionInterceptor.class,ITester.class);
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(advice);
        advisor.setMappedName("methodName2Interceptor");

        advisor.setMappedNames("method1","method2");
    }
}

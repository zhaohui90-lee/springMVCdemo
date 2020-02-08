package com.melody.pojo.factorybean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class FXNewsProviderMethodReplacer implements MethodReplacer {

    private static final transient Log logger = LogFactory.getLog(FXNewsProviderMethodReplacer.class);

    @Override
    public Object reimplement(Object target, Method method, Object[] objects) throws Throwable {
        logger.info("before executing method[" + method.getName() + "] on Object[" +
                target.getClass().getName()+"].");
        System.out.println("sorry.....");
        logger.info("end executing method[" + method.getName() + "] on Object[" +
                target.getClass().getName()+"].");
        return null;
    }
}

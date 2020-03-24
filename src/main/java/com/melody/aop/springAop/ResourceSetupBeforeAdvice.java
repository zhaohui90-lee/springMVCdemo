package com.melody.aop.springAop;

import org.apache.logging.log4j.core.util.FileUtils;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.core.io.Resource;

import java.lang.reflect.Method;

/**
 * @author melody
 */
public class ResourceSetupBeforeAdvice implements MethodBeforeAdvice {
    private Resource resource;

    public ResourceSetupBeforeAdvice(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (!resource.exists()){
            FileUtils.mkdir(resource.getFile(),true);
        }
    }
}

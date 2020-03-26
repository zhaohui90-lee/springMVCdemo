package com.melody.aop.springAop;

import org.apache.logging.log4j.core.util.FileUtils;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.core.io.Resource;

import java.lang.reflect.Method;

/**
 * @author melody
 * before advice所实现的横切逻辑发生在相应的Joinpoint之前，在Before Advice执行完成之后，
 * 程序执行流程将从Joinpoint处继续执行，所以before advice通常不会打断程序的执行流程
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

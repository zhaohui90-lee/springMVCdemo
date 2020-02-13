package com.melody.aop.springAop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Spring AOP没有直接定义Around Advice，而是直接使用AOP Alliance的标准接口
 */
public class PerformanceMethodInterceptor implements MethodInterceptor {
    private final Log logger = LogFactory.getLog(this.getClass());
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            // 业务逻辑
            return methodInvocation.proceed();
        }finally {
            // 业务逻辑
            if (logger.isInfoEnabled()){
                logger.info("业务结束...");
            }
        }
    }
}

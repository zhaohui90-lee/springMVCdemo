package com.melody.aop.dynamicProxy;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class PKeySpecificQueryMethodPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        if (method.getName().startsWith("get") && aClass.getPackage().getName().startsWith("...dao")){
            if (!ArrayUtils.isEmpty(objects)){
                return StringUtils.equals("12345",objects[0].toString());
            }
        }
        return false;
    }
}

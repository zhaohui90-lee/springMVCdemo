package com.melody.aop.dynamicProxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: melody
 * @Date: 2020-03-24
 */
public class RequestCtrlCallback implements MethodInterceptor {
    private static final Log logger = LogFactory.getLog(RequestCtrlCallback.class);
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String keyRequest = "request";
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        if (keyRequest.equals(method.getName())){
            Date sysTime = df.parse(df.format(cal.getTime()));
            Date startTime = df.parse("00:00:00");
            Date endTime = df.parse("06:00:00");
            if (sysTime.before(startTime) && sysTime.after(endTime)){
                logger.warn("service is not available now...");
                return null;
            }
            return methodProxy.invokeSuper(o,objects);
        }
        return null;
    }
}

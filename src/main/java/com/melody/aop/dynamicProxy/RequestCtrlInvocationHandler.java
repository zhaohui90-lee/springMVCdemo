package com.melody.aop.dynamicProxy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RequestCtrlInvocationHandler implements InvocationHandler {
    private final Log logger = LogFactory.getLog(RequestCtrlInvocationHandler.class);
    private Object target;

    public RequestCtrlInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        if (method.getName().equals("request")){
            Date sysTime = df.parse(df.format(cal.getTime()));
            Date startTime = df.parse("00:00:00");
            Date endTime = df.parse("06:00:00");
            if (sysTime.before(startTime) && sysTime.after(endTime)){
                logger.warn("service is not available now...");
                return null;
            }
            return method.invoke(target,args);
        }
        return null;
    }
}

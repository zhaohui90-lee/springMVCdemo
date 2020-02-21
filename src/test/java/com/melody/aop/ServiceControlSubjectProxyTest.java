package com.melody.aop;

import com.melody.aop.dynamicProxy.RequestCtrlInvocationHandler;
import com.melody.aop.staticProxy.ISubject;
import com.melody.aop.staticProxy.SubjectImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServiceControlSubjectProxyTest {

    private final Log logger = LogFactory.getLog(ServiceControlSubjectProxyTest.class);

    @Test
    public void test(){
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        try {
            Date sysTime = df.parse(df.format(cal.getTime()));
            Date startTime = df.parse("10:00:00");
            Date endTime = df.parse("18:00:00");
            logger.info("sysTime: " + sysTime);
            logger.info("startTime: " + startTime);
            logger.info("endTime: " + endTime);
            if (sysTime.after(startTime) && sysTime.before(endTime)){
                System.out.println("proxy...");
            }else{
                System.out.println("error...");
            }
        } catch (ParseException e) {
            logger.error(e);
        }


    }

    @Test
    public void dynamicProxyTest(){
//        ISubject subject = Proxy.newProxyInstance(
//                ProxyRunner.class.getClassLoader(),
//                new Class[]{ISubject.class},
//                new RequestCtrlInvocationHandler(new SubjectImpl()));
//        subject.request();
    }
}
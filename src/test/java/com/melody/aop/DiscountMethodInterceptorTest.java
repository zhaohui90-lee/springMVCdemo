package com.melody.aop;

import com.melody.aop.springAop.DiscountMethodInterceptor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class DiscountMethodInterceptorTest {

    @Test
    public void test() throws ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("springAop.xml");
        DiscountMethodInterceptor interceptor = (DiscountMethodInterceptor) context.getBean("discountInterceptor");

//        interceptor.invoke(print());
    }
}

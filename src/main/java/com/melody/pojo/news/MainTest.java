package com.melody.pojo.news;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/news.xml");
        FXNewsProvider fx = (FXNewsProvider) context.getBean("newsProvider");
        System.out.println(fx);
    }
}

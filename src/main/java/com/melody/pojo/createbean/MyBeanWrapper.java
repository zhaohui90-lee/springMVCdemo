package com.melody.pojo.createbean;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class MyBeanWrapper {
    public static void main(String[] args) throws Exception{
        Object provider = Class.forName("com.melody.pojo.news.FXNewsProvider").getDeclaredConstructor().newInstance();
        Object listener = Class.forName("com.melody.pojo.news.DowJonesNewsListener").getDeclaredConstructor().newInstance();
        Object persist = Class.forName("com.melody.pojo.news.DowJonesNewsPersistener").getDeclaredConstructor().newInstance();

        BeanWrapper newsProvider = new BeanWrapperImpl(provider);
        newsProvider.setPropertyValue("newsListener",listener);
        newsProvider.setPropertyValue("newsPersist",persist);


    }
}

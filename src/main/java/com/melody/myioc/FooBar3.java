package com.melody.myioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ResourceLoader;

public class FooBar3 implements ApplicationContextAware {
    private ResourceLoader resourceLoader;
    public void foo(String location){
        System.out.println(getResourceLoader().getResource(location).getClass());
    }
    private ResourceLoader getResourceLoader(){
        return resourceLoader;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.resourceLoader = applicationContext;
    }
}

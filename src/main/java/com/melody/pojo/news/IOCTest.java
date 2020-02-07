package com.melody.pojo.news;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class IOCTest {
    public static void main(String[] args) {
        // Deprecated.
        // as of Spring 3.1 in favor of DefaultListableBeanFactory and XmlBeanDefinitionReader
        BeanFactory container = new XmlBeanFactory(new ClassPathResource("news.xml"));
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("newProvider");
        newsProvider.getAndPersistNews();
    }
}

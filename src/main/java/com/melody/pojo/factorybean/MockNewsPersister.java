package com.melody.pojo.factorybean;

import com.melody.pojo.news.FXNewsBean;
import com.melody.pojo.news.IFXNewsPersistener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class MockNewsPersister implements IFXNewsPersistener, BeanFactoryAware {
    private BeanFactory beanFactory;
    @Override
    public void persistentNews(FXNewsBean fxNewsBean) {
        persistNewes();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void persistNewes() {
        System.out.println("persist bean: " + getNewsBean());
    }

    public FXNewsBean getNewsBean() {
        return (FXNewsBean) beanFactory.getBean("newsBean");
    }
}

package com.melody.pojo.factorybean;

import com.melody.pojo.news.FXNewsBean;
import com.melody.pojo.news.IFXNewsPersistener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author 40431
 */
public class MockNewsPersister1 implements IFXNewsPersistener, BeanFactoryAware {
    private BeanFactory beanFactory;
    @Override
    public void persistentNews(FXNewsBean fxNewsBean) {
        persistentNews();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void persistentNews(){
        System.out.println("persist bean:" + getNewsBean());
    }

    private FXNewsBean getNewsBean() {
        return (FXNewsBean) beanFactory.getBean("newsBean");
    }
}

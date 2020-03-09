package com.melody.pojo.factorybean;

import com.melody.pojo.news.FXNewsBean;
import com.melody.pojo.news.IFXNewsPersistener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author 40431
 */
public class MockNewsPersister implements IFXNewsPersistener {
    private FXNewsBean newsBean;

    @Override
    public void persistentNews(FXNewsBean fxNewsBean) {
        persistentNews();
    }

    public void persistentNews(){
        System.out.println("persist bean:" + getNewsBean());
    }

    protected FXNewsBean getNewsBean() {
        return newsBean;
    }

    public void setNewsBean(FXNewsBean newsBean) {
        this.newsBean = newsBean;
    }
}

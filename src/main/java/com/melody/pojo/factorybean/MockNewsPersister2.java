package com.melody.pojo.factorybean;

import com.melody.pojo.news.FXNewsBean;
import com.melody.pojo.news.IFXNewsPersistener;
import org.springframework.beans.factory.ObjectFactory;

/**
 * @author 40431
 */
public class MockNewsPersister2 implements IFXNewsPersistener {

    private ObjectFactory<FXNewsBean> newsBeanFactory;
    @Override
    public void persistentNews(FXNewsBean fxNewsBean) {
        persistentNews();
    }

    public void persistentNews(){
        System.out.println("persist bean:" + getNewsBean());
    }

    private FXNewsBean getNewsBean() {
        return newsBeanFactory.getObject();
    }

    public void setNewsBeanFactory(ObjectFactory<FXNewsBean> newsBeanFactory) {
        this.newsBeanFactory = newsBeanFactory;
    }
}

package com.melody.pojo.news;

public class MockNewsPersister implements IFXNewsPersistener {
    private FXNewsBean fxNewsBean;
    @Override
    public void persistentNews(FXNewsBean fxNewsBean) {
        persistNewes();
    }

    public void persistNewes() {
        System.out.println("persist bean: " + getNewsBean());
    }

    public FXNewsBean getNewsBean() {
        return fxNewsBean;
    }

    public void setFxNewsBean(FXNewsBean fxNewsBean) {
        this.fxNewsBean = fxNewsBean;
    }
}

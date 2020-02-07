package com.melody.pojo.news;

public class DowJonesNewsPersistener implements IFXNewsPersistener {
    @Override
    public void persistentNews(FXNewsBean fxNewsBean) {
        System.out.println("DowJonesNewsPersistener");
    }
}

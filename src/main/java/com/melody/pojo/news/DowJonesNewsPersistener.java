package com.melody.pojo.news;

import org.springframework.stereotype.Component;

@Component
public class DowJonesNewsPersistener implements IFXNewsPersistener {
    @Override
    public void persistentNews(FXNewsBean fxNewsBean) {
        System.out.println("DowJonesNewsPersistener");
    }
}

package com.melody.pojo.news;

import org.springframework.stereotype.Component;

@Component
public class DowJonesNewsListener implements IFXNewsListener {
    @Override
    public String[] getAvailableNewsIds() {
        return new String[0];
    }

    @Override
    public FXNewsBean getNewsBeanPx(String id) {
        return null;
    }

    @Override
    public boolean postProcessIfNecessary(String newsId) {
        return false;
    }
}

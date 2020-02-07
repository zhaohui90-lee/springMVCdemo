package com.melody.pojo.news;

public interface IFXNewsListener {
    String[] getAvailableNewsIds();

    FXNewsBean getNewsBeanPx(String id);

    boolean postProcessIfNecessary(String newsId);
}

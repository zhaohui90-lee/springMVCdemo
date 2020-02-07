package com.melody.pojo.news;

import org.apache.commons.lang.ArrayUtils;

/**
 * 传统非IOC方式---FXNewsProvider和DowJonesNewsListener DowJonesNewsPersistener 紧密耦合在一起
 */
public class FXNewsProvider {
    private IFXNewsListener newsListener;
    private IFXNewsPersistener newsPersistener;

//    public FXNewsProvider(){
//        newsListener = new DowJonesNewsListener();
//        newsPersistener = new DowJonesNewsPersistener();
//    }
    public FXNewsProvider(IFXNewsListener newsListener,IFXNewsPersistener newsPersistener){
        this.newsListener = newsListener;
        this.newsPersistener = newsPersistener;
    }

    public void getAndPersistNews(){
        String[] ids = newsListener.getAvailableNewsIds();
        if (ArrayUtils.isEmpty(ids)){
            return;
        }
        for (String id : ids) {
            FXNewsBean newsBean = newsListener.getNewsBeanPx(id);
            newsPersistener.persistentNews(newsBean);
            newsListener.postProcessIfNecessary(id);
        }
    }
}

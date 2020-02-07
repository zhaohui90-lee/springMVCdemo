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

    /**
     * 构造方法注入
     * @param newsListener
     * @param newsPersistener
     */
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

    /**
     * setter方法注入
     * @param newsListener
     */
    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    /**
     * setter方法注入
     * @param newsPersistener
     */
    public void setNewsPersistener(IFXNewsPersistener newsPersistener) {
        this.newsPersistener = newsPersistener;
    }
}

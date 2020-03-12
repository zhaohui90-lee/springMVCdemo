package com.melody.pojo.news;

public class SpecificFXNewsProvider extends FXNewsProvider{
    private IFXNewsListener newsListener;
    private IFXNewsPersistener newsPersistener;

//    public SpecificFXNewsProvider() {
//    }

    public SpecificFXNewsProvider(IFXNewsListener newsListener, IFXNewsPersistener newsPersistener) {
        super(newsListener, newsPersistener);
    }

    public IFXNewsListener getNewsListener() {
        return newsListener;
    }

    @Override
    public void setNewsListener(IFXNewsListener newsListener) {
        this.newsListener = newsListener;
    }

    public IFXNewsPersistener getNewsPersistener() {
        return newsPersistener;
    }

    @Override
    public void setNewsPersistener(IFXNewsPersistener newsPersistener) {
        this.newsPersistener = newsPersistener;
    }
}

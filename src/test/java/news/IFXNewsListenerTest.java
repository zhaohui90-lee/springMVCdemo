package news;

import com.melody.pojo.news.FXNewsBean;
import com.melody.pojo.news.IFXNewsListener;
import org.junit.Test;

import static org.junit.Assert.*;

public class IFXNewsListenerTest implements IFXNewsListener{


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
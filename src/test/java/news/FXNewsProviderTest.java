package news;

import com.melody.pojo.news.FXNewsProvider;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FXNewsProviderTest extends TestCase {
    private FXNewsProvider newsProvider;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        newsProvider = new FXNewsProvider(new IFXNewsListenerTest(),new IFXNewsPersistenerTest());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
        newsProvider = null;
    }

    @Test
    public void getAndPersistNews() {
        newsProvider.getAndPersistNews();
        fail("since...");
    }
}
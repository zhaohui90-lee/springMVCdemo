package news;

import com.melody.pojo.news.MockNewsPersister;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MockNewsPersisterTest {

    @Test
    public void persistNewes() {
        ApplicationContext container1 = new ClassPathXmlApplicationContext("news.xml");
        MockNewsPersister persister1 = (MockNewsPersister) container1.getBean("mockNewsPersister");

        ApplicationContext container2 = new ClassPathXmlApplicationContext("news.xml");
        MockNewsPersister persister2 = (MockNewsPersister) container2.getBean("mockNewsPersister");

        persister1.persistNewes();
        persister2.persistNewes();
    }

    @Test
    public void persistNews1(){
        ApplicationContext container1 = new ClassPathXmlApplicationContext("news.xml");
        MockNewsPersister persister1 = (MockNewsPersister) container1.getBean("mockNewsPersister");
        persister1.persistNewes();
        persister1.persistNewes();
    }
}
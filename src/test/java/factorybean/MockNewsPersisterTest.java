package factorybean;

import com.melody.pojo.factorybean.MockNewsPersister;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MockNewsPersisterTest {

    @Test
    public void persistNewes() {
        ApplicationContext container = new ClassPathXmlApplicationContext("factorybean.xml");
        MockNewsPersister persister = (MockNewsPersister) container.getBean("mockPersister");
        persister.persistNewes();
        persister.persistNewes();
    }
}
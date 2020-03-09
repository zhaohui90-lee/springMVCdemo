package factorybean;

import com.melody.pojo.factorybean.MockNewsPersister;
import com.melody.pojo.factorybean.MockNewsPersister1;
import com.melody.pojo.factorybean.MockNewsPersister2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MockNewsPersisterTest {

    @Test
    public void persistNewes() {
        ApplicationContext container = new ClassPathXmlApplicationContext("META-INF/factorybean.xml");
        MockNewsPersister persister = (MockNewsPersister) container.getBean("mockPersister");
        persister.persistentNews();
        persister.persistentNews();
    }
    @Test
    public void persisterNews1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/factorybean.xml");
        MockNewsPersister1 persister1 = (MockNewsPersister1) context.getBean("mockPersister1");
        persister1.persistentNews();
        persister1.persistentNews();
    }

    @Test
    public void persisterNews2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/factorybean.xml");
        MockNewsPersister2 persister2 = (MockNewsPersister2) context.getBean("mockPersister2");
        persister2.persistentNews();
        persister2.persistentNews();
    }
}
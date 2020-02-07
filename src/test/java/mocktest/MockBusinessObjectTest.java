package mocktest;

import com.melody.pojo.mock.MockBusinessObject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MockBusinessObjectTest {

    @Test
    public void testToString() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mocktest.xml");
        MockBusinessObject mock1 = (MockBusinessObject) context.getBean("mock1");
        System.out.println(mock1);
    }
}
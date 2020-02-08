package mocktest;

import com.melody.pojo.mock.MockDemoObject;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MockDemoObjectTest {

    @Test
    public void testToString() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mocktest.xml");
        MockDemoObject obj = (MockDemoObject) context.getBean("mock2");
        System.out.println(obj);

        MockDemoObject demoObject = new MockDemoObject();
        List list = new ArrayList();
        list.add("something");
        list.add("12313");
        list.add("adasdsa");

        demoObject.setParam1(list);
        demoObject.setParam2(new String[]{"stringValue1","stringValue2"});

        System.out.println(demoObject);
    }
}
package factorybean;

import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

public class NextDayDateDisplayerTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("factorybean.xml");
        Object nextDayDate = context.getBean("&nextDayDate");
        System.out.println(nextDayDate);
        assertTrue(nextDayDate instanceof FactoryBean);
    }
}
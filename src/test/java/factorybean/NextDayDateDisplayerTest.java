package factorybean;

import com.melody.pojo.myfactory.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

public class NextDayDateDisplayerTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/factorybean.xml");
        Object nextDayDate = context.getBean("nextDayDate");
        // com.melody.pojo.myfactory.DateTime@666b83a4
        System.out.println(nextDayDate);
        assertTrue(nextDayDate instanceof DateTime);
    }
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/factorybean.xml");
        Object nextDayDate = context.getBean("&nextDayDate");
        // com.melody.pojo.myfactory.NextDayDateFactoryBean@4678a2eb
        System.out.println(nextDayDate);
        assertTrue(nextDayDate instanceof FactoryBean);
    }
}
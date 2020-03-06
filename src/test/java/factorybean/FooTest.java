package factorybean;

import com.melody.pojo.myfactory.Foo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FooTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/myfactory.xml");
        Foo foo = (Foo) context.getBean("foo1");
        System.out.println(foo);
    }
}

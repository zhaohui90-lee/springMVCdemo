package factorybean;

import com.melody.myioc.FooBar3;
import com.melody.pojo.myfactory.Foo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class FooTest {

    @Test
    public void test(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/myfactory.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath*:META-INF/myfactory.xml");
        Foo foo = (Foo) context.getBean("foo1");
        System.out.println(foo);
    }
    @Test
    public void fooBar3(){
//        ResourceLoader resourceLoader = new ClassPathXmlApplicationContext("META-INF/factorybean.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/factorybean.xml");
//        Resource resource = resourceLoader.getResource("fooBar3");
//        System.out.println(resource);
        FooBar3 fooBar3 = (FooBar3) context.getBean("fooBar3");
        fooBar3.foo("com.melody.pojo.User");
    }
}

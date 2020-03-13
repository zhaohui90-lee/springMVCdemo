package news;

import com.melody.pojo.news.DowJonesNewsListener;
import com.melody.pojo.news.DowJonesNewsPersistener;
import com.melody.pojo.news.FXNewsProvider;
import com.melody.pojo.postprocessor.PasswordDecodePostProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.*;

public class IOCTestTest {

    @Test
    public void main() {
//        ConfigurableBeanFactory container = new XmlBeanFactory(new ClassPathResource("META-INF/news.xml"));
//        container.addBeanPostProcessor(new PasswordDecodePostProcessor());
        ApplicationContext container = new ClassPathXmlApplicationContext("META-INF/news.xml");
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("newsProvider");
        newsProvider.getAndPersistNews();
        System.out.println(newsProvider);
        // 销毁对象
//        container.destroySingletons();
    }

    @Test
    public void test(){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("META-INF/news.xml");
//        FXNewsProvider newsProvider = (FXNewsProvider) context.getBean("newsProvider");
//        newsProvider.getAndPersistNews();
//        System.out.println(newsProvider);
        String title = (String) context.getBean("title");
        System.out.println(title);
        // 销毁对象
        context.registerShutdownHook();
    }

    @Test
    public void test_01(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanFactory container = bindViaXMLFile01(beanFactory);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("newsProvider");
        newsProvider.getAndPersistNews();
    }

    public static BeanFactory bindViaXMLFile01(BeanDefinitionRegistry registry){
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("META-INF/news.xml");
        return new XmlBeanFactory(new ClassPathResource("META-INF/news.xml"));
    }

    @Test
    public void test2(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCode(beanFactory);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
    }

    @Test
    public void test3(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanFactory container = bindViaPropertiesFile(beanFactory);
//        BeanFactory container = bindViaXmlFile(beanFactory);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("newsProvider");
        newsProvider.getAndPersistNews();
        System.out.println(newsProvider);
    }

    public static BeanFactory bindViaPropertiesFile(BeanDefinitionRegistry registry){
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("META-INF/news.properties");
        return (BeanFactory) registry;
    }

    public static BeanFactory bindViaXmlFile(BeanDefinitionRegistry registry){
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions(new ClassPathResource("META-INF/news.xml"));
        return (BeanFactory) registry;
    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry){
        // 容器启动工作
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class);
        AbstractBeanDefinition newsPersistener = new RootBeanDefinition(DowJonesNewsPersistener.class);
        // 将bean定义注册到容器中
        registry.registerBeanDefinition("djNewsProvider",newsProvider);
        registry.registerBeanDefinition("djListener",newsListener);
        registry.registerBeanDefinition("djPersistener",newsPersistener);
        // 指定依赖关系
        // 1.通过构造器注入
        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0,newsListener);
        argValues.addIndexedArgumentValue(1,newsPersistener);
        newsProvider.setConstructorArgumentValues(argValues);
        // 2.通过setter方法注入
//        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("newsListener",newsListener));
//        propertyValues.addPropertyValue(new PropertyValue("newsPersistener",newsPersistener));
//        newsProvider.setPropertyValues(propertyValues);
        // 绑定完成
        return (BeanFactory) registry;
    }


    @Test
    public void testBeanWrapper() throws Exception {
        Object provider = Class.forName("com.melody.pojo.news.FXNewsProvider").getDeclaredConstructor().newInstance();
        Object listener = Class.forName("com.melody.pojo.news.DowJonesNewsListener").getDeclaredConstructor().newInstance();
        Object persister = Class.forName("com.melody.pojo.news.DowJonesNewsPersistener").getDeclaredConstructor().newInstance();

        BeanWrapper newsProvider = new BeanWrapperImpl(provider);
        newsProvider.setPropertyValue("newsListener",listener);
        newsProvider.setPropertyValue("newsPersistener",persister);

        assertTrue(newsProvider.getWrappedInstance() instanceof FXNewsProvider);
        assertSame(provider,newsProvider.getWrappedClass());
        assertSame(listener,newsProvider.getPropertyValue("newsListener"));
        assertSame(persister,newsProvider.getPropertyValue("newsPersistener"));
    }
}
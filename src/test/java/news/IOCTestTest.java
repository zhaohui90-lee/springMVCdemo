package news;

import com.melody.pojo.news.DowJonesNewsListener;
import com.melody.pojo.news.DowJonesNewsPersistener;
import com.melody.pojo.news.FXNewsProvider;
import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.*;

public class IOCTestTest {

    @Test
    public void main() {
        BeanFactory container = new XmlBeanFactory(new ClassPathResource("news.xml"));
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("newProvider");
        newsProvider.getAndPersistNews();
    }

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("news.xml");
        FXNewsProvider newsProvider = (FXNewsProvider) context.getBean("FXNewsProvider");
        newsProvider.getAndPersistNews();
        System.out.println(newsProvider);
    }

    @Test
    public void test_01(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanFactory container = bindViaXMLFile(beanFactory);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("newProvider");
        newsProvider.getAndPersistNews();
    }

    public static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry){
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("news.xml");
        return new XmlBeanFactory(new ClassPathResource("news.xml"));
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
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
        System.out.println(newsProvider);
    }

    public static BeanFactory bindViaPropertiesFile(BeanDefinitionRegistry registry){
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(registry);
        reader.loadBeanDefinitions("news.properties");
        return (BeanFactory) registry;
    }

    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry){
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class);
        AbstractBeanDefinition newsPersistener = new RootBeanDefinition(DowJonesNewsPersistener.class);
        // 将bean定义注册到容器中
        registry.registerBeanDefinition("djNewsProvider",newsProvider);
        registry.registerBeanDefinition("djListener",newsListener);
        registry.registerBeanDefinition("djPersistener",newsPersistener);
        // 指定依赖关系
        // 1.通过构造器注入
//        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
//        argValues.addIndexedArgumentValue(0,newsListener);
//        argValues.addIndexedArgumentValue(1,newsPersistener);
//        newsProvider.setConstructorArgumentValues(argValues);
        // 2.通过setter方法注入
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newsListener",newsListener));
        propertyValues.addPropertyValue(new PropertyValue("newsPersistener",newsPersistener));
        newsProvider.setPropertyValues(propertyValues);
        // 绑定完成
        return (BeanFactory) registry;
    }
}
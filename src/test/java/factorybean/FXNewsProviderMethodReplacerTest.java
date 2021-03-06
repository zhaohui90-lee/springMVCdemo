package factorybean;

import com.melody.pojo.news.FXNewsProvider;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class FXNewsProviderMethodReplacerTest {

    @Test
    public void reimplement() {
        ApplicationContext container = new ClassPathXmlApplicationContext("META-INF/functionReplacer.xml");
        FXNewsProvider fxNewsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        fxNewsProvider.getAndPersistNews();
    }
}

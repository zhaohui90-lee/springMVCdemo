package myscope;

import com.melody.pojo.myscope.ThreadScope;
import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import static org.junit.Assert.*;

public class ThreadScopeTest {

    @Test
    public void scopeBean(){
        Scope threadScope = new ThreadScope();
        ConfigurableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerScope("thread",threadScope);
    }
}
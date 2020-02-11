package ioctest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class LoadConfigs {
    @Test
    public void loadConfigTest(){
        String[] locations = new String[]{"classpath:applicationEvent.xml","classpath:dateformat.xml","classpath:factorybean.xml"};
        ApplicationContext context = new FileSystemXmlApplicationContext(locations);
        System.out.println(context);
    }
}

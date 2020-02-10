package ioctest;

import com.melody.myioc.FooBar;
import com.melody.myioc.FooBar2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import static org.junit.Assert.*;

public class MyResourceLoaderTest {

    @Test
    public void test(){
        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource fakeFileResource = resourceLoader.getResource("E:\\text");
        assertTrue(fakeFileResource instanceof ClassPathResource);
        assertFalse(fakeFileResource.exists());

    }

    @Test
    public void fileTest(){
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource fileResource = resourceLoader.getResource("E:\\text");
        assertTrue(fileResource instanceof FileSystemResource);
        assertTrue(fileResource.exists());
    }

    /**
     * 批量查找的ResourceLoader
     */
    @Test
    public void resolverTest(){
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource fileResource = resourcePatternResolver.getResource("E:\\text");
        assertTrue(fileResource instanceof ClassPathResource);
        assertFalse(fileResource.exists());

        resourcePatternResolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());
        fileResource = resourcePatternResolver.getResource("E:\\text");
        assertTrue(fileResource instanceof FileSystemResource);
        assertTrue(fileResource.exists());

    }

    @Test
    public void fooBar(){
        ApplicationContext container = new ClassPathXmlApplicationContext("resourceLoader.xml");
        FooBar fooBar = (FooBar) container.getBean("fooBar");
        System.out.println(fooBar.getResourceLoader());// org.springframework.core.io.DefaultResourceLoader@4bef0fe3
    }

    @Test
    public void fooBar2(){
        ApplicationContext container = new ClassPathXmlApplicationContext("classpath:resourceLoader.xml");
        FooBar2 fooBar2 = (FooBar2) container.getBean("fooBar2");
        System.out.println("bean out--->" + fooBar2.getResourceLoader());// org.springframework.context.support.ClassPathXmlApplicationContext@35645047: startup date [Mon Feb 10 10:56:36 CST 2020]; root of context hierarchy
    }
}
package com.melody.config.spitter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * @author 40431
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 单个上传文件不超过2097152字节；整个请求不超过4194304字节
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration){
        registration.setMultipartConfig(
                new MultipartConfigElement("E:/IDEA/tmp/",
                        2097152,4194304,0)
        );
    }
}

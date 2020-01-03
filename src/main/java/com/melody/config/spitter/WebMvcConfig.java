package com.melody.config.spitter;

import com.melody.config.flows.WebFlowConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.List;


/**
 * @author 40431
 * EnableWebMvc 启用Spring MVC
 * ComponentScan 启用组件扫描
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.melody")
public class WebMvcConfig extends WebMvcConfigurerAdapter  {

    @Autowired
    private WebFlowConfig webFlowConfig;

    /**
     * InternalResourceViewResolver 支持jsp
     * 配置jsp视图解析器
     * @return resolver
     */
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Bean
    public FlowHandlerMapping flowHandlerMapping(){
        FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
        handlerMapping.setOrder(-1);
        handlerMapping.setFlowRegistry(this.webFlowConfig.flowRegister());
        return handlerMapping;
    }

    @Bean
    public FlowHandlerAdapter flowHandlerAdapter(){
        FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
        handlerAdapter.setFlowExecutor(this.webFlowConfig.flowExecutor());
        handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
        return handlerAdapter;
    }

    /**
     * TilesConfigurer
     * 配置Apache Tiles视图解析器
     * @return tiles
     */
//    @Bean
//    public TilesConfigurer tilesConfigurer(){
//        TilesConfigurer tiles = new TilesConfigurer();
//        // 指定tiles定义的位置
//        tiles.setDefinitions(new String[]{"/WEB-INF/layout/tiles.xml"});
//        // 启用刷新功能
//        tiles.setCheckRefresh(true);
//        return tiles;
//    }

    /**
     * tilesViewResolver apache tiles视图解析器
     * @return TilesViewResolver
     */
//    @Bean
//    public ViewResolver viewResolver(){
//        return new TilesViewResolver();
//    }

    /**
     * 设置视图解析器
     * @param templateEngine
     * @return ThymeleafViewResolver
     */
//    @Bean
//    public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine);
//        return resolver;
//    }

    /**
     * 设置模板引擎
     * @param templateResolver
     * @return SpringTemplateEngine
     */
//    @Bean
//    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setTemplateResolver(templateResolver);
//        return engine;
//    }

    /**
     * 模板解析引擎
     * @return SpringResourceTemplateResolver
     */
//    @Bean
//    public SpringResourceTemplateResolver templateResolver(){
//        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        //设置地址前缀
//        resolver.setPrefix("/WEB-INF/template/");
//        //设置后缀
//        resolver.setSuffix(".html");
//        //设置缓存
//        resolver.setCacheable(false);
//        resolver.setTemplateMode(TemplateMode.HTML);
//        return resolver;
//    }

    /**
     * 配置静态资源的处理
     * @param configurer 默认参数
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * servlet3.0容器以上使用 StandardServletMultipartResolver; 3.0一下使用Jakarta Commons FileUploads multipart
     * @return StandardServletMultipartResolver
     */
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}

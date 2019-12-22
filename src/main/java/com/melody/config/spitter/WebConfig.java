package com.melody.config.spitter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;


/**
 * @author 40431
 * EnableWebMvc 启用Spring MVC
 * ComponentScan 启用组件扫描
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.melody.controller.spitter")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * InternalResourceViewResolver 支持jsp
     * 配置jsp视图解析器
     * @return resolver
     */
//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver resolver =
//                new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }

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
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine);
        return resolver;
    }

    /**
     * 设置模板引擎
     * @param templateResolver
     * @return SpringTemplateEngine
     */
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);
        return engine;
    }

    /**
     * 模板解析引擎
     * @return SpringResourceTemplateResolver
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("/WEB-INF/template/");//设置地址前缀
        resolver.setSuffix(".html");//设置后缀
        resolver.setCacheable(false);//设置缓存
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;

    }

    /**
     * 配置静态资源的处理
     * @param configurer 默认参数
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}

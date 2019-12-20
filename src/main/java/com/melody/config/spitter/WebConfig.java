package com.melody.config.spitter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

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
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tiles = new TilesConfigurer();
        // 指定tiles定义的位置
        tiles.setDefinitions(new String[]{"/WEB-INF/layout/tiles.xml"});
        // 启用刷新功能
        tiles.setCheckRefresh(true);
        return tiles;
    }

    /**
     * tilesViewResolver apache tiles视图解析器
     * @return TilesViewResolver
     */
    @Bean
    public ViewResolver viewResolver(){
        return new TilesViewResolver();
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

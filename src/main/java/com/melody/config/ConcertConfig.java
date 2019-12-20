package com.melody.config;

import com.melody.aspect.Audience;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 40431
 * @EnableAspectJAutoProxy 启用AspectJ自动代理
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.melody.pojo.concert")
public class ConcertConfig {

    @Bean
    public Audience audience(){
        return new Audience();
    };
}

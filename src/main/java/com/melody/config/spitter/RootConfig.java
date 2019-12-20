package com.melody.config.spitter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author 40431
 */
@ContextConfiguration
@ComponentScan(basePackages = {"com.melody.config.spitter"},
            excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
            })
public class RootConfig {
}

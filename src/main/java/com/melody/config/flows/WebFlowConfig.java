package com.melody.config.flows;

import com.melody.config.spitter.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.convert.ConversionService;
import org.springframework.binding.convert.service.DefaultConversionService;
import org.springframework.binding.expression.ExpressionParser;
import org.springframework.binding.expression.el.ELExpressionParser;
import org.springframework.binding.expression.support.AbstractExpressionParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.ViewFactoryCreator;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.expression.el.WebFlowELExpressionParser;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;

import java.util.Collections;

/**
 * @author 40431
 */
@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

    @Autowired
    private WebConfig webMvcConfig;

    @Bean
    public FlowDefinitionRegistry flowRegister(){
        return getFlowDefinitionRegistryBuilder()
                .addFlowLocation("/WEB-INF/flows/pizza.xml","pizza")
                .addFlowLocation("/WEB-INF/flows/customer.xml","customer")
                .addFlowLocation("/WEB-INF/flows/order.xml","order")
                .build();
    }

    @Bean
    public FlowExecutor flowExecutor(){
        return getFlowExecutorBuilder(flowRegister())
                .build();
    }


    @Bean
    public FlowBuilderServices flowBuilderServices(){
        return getFlowBuilderServicesBuilder()
                .setViewFactoryCreator(mvcViewFactoryCreator())
                .build();
    }

    @Bean
    public ViewFactoryCreator mvcViewFactoryCreator() {
        MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
        factoryCreator.setViewResolvers(Collections.singletonList(this.webMvcConfig.viewResolver()));
        factoryCreator.setUseSpringBeanBinding(true);
        return factoryCreator;
    }


}

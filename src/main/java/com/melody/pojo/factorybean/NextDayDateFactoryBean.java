package com.melody.pojo.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.util.Date;

public class NextDayDateFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Date();
    }

    @Override
    public Class<?> getObjectType() {
        return Date.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

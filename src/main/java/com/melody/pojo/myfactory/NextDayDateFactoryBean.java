package com.melody.pojo.myfactory;

import org.springframework.beans.factory.FactoryBean;

import java.util.Date;

/**
 * 实现FactoryBean接口的DateTime类的工厂类
 * @author 40431
 */
public class NextDayDateFactoryBean implements FactoryBean<Date> {
    @Override
    public Date getObject() throws Exception {
        return new DateTime().plusDay(1);
    }

    @Override
    public Class<?> getObjectType() {
        return DateTime.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

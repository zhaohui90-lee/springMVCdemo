package com.melody.aop.springAop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Method;

/**
 * @author 40431
 */
public class TaskExecutionAfterReturningAdvice implements AfterReturningAdvice {
    private JdbcTemplate jdbcTemplate;
    @Override
    public void afterReturning(Object target, Method method, Object[] args, Object returnValue) throws Throwable {
        Class clazz = target.getClass();
        jdbcTemplate.update("BATCH.insertTaskStatus",clazz.getName());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

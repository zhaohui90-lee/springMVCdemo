package com.melody.aop.staticProxy;

/**
 * @author 40431
 */
public class SubjectImpl implements ISubject {
    @Override
    public String request() {
        return "ok";
    }
}

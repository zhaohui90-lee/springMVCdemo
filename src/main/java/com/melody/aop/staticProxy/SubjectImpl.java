package com.melody.aop.staticProxy;

public class SubjectImpl implements ISubject {
    @Override
    public String request() {
        return "ok";
    }
}

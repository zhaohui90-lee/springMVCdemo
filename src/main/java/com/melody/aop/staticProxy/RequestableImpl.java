package com.melody.aop.staticProxy;

public class RequestableImpl implements IRequestable {
    @Override
    public void request() {
        System.out.println("request processed in RequestableImpl");
    }
}

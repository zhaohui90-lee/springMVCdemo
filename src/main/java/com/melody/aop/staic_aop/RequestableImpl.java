package com.melody.aop.staic_aop;

public class RequestableImpl implements IRequestable {
    @Override
    public void request() {
        System.out.println("request processed in RequestableImpl");
    }
}

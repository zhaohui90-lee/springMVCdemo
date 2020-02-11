package com.melody.myioc.innerEvent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class MethodExecutionEventPublisher2 implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    public void setToMonitor(){
        MethodExecutionEvent2 beginEvt = new MethodExecutionEvent2(this,"methodToMonitor",MethodExecutionStatus.BEGIN);
        // 实际事件逻辑
        System.out.println("MethodExecutionEventPublisher2...");
        MethodExecutionEvent2 endEvt = new MethodExecutionEvent2(this,"methodToMonitor",MethodExecutionStatus.END);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}

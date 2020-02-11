package com.melody.myioc.innerEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MethodExecutionEventListener2 implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof MethodExecutionEvent2){
            // 执行处理逻辑
            System.out.println("MethodExecutionEventListener2...");
        }
    }
}

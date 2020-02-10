package com.melody.myioc.innerEvent;

import java.util.ArrayList;
import java.util.List;

public class MethodExecutionEventPublisher {
    private List<MethodExecutionEventPublisher> listener = new ArrayList<>();

    public void methodToMonitor(){
        MethodExecutionEvent event2Publish = new MethodExecutionEvent(this,"methodToMonitor");
        
    }
}

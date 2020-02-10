package com.melody.myioc.innerEvent;

import java.util.EventObject;

public class MethodExecutionEvent extends EventObject {
    private static final long serialVersionUID = -1L;
    private String methodName;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public MethodExecutionEvent(Object source) {
        super(source);
    }

    public MethodExecutionEvent(Object source,String methodName){
        super(source);
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}

package com.melody.myioc.innerEvent;

import org.springframework.context.ApplicationEvent;

public class MethodExecutionEvent2 extends ApplicationEvent {
    private String methodName;
    private MethodExecutionStatus methodExecutionStatus;
    public MethodExecutionEvent2(Object source) {
        super(source);
    }

    public MethodExecutionEvent2(Object source, String methodName, MethodExecutionStatus methodExecutionStatus) {
        super(source);
        this.methodName = methodName;
        this.methodExecutionStatus = methodExecutionStatus;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public MethodExecutionStatus getMethodExecutionStatus() {
        return methodExecutionStatus;
    }

    public void setMethodExecutionStatus(MethodExecutionStatus methodExecutionStatus) {
        this.methodExecutionStatus = methodExecutionStatus;
    }
}

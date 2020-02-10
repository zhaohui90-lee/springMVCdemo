package com.melody.myioc.innerEvent;

public class SimpleMethodEventListener implements MethodExecutionEventListener{

    @Override
    public void onMethodBegin(MethodExecutionEvent executionEvent) {
        String methodName = executionEvent.getMethodName();
        System.out.println("start to execute the method[" + methodName + "]");
    }

    @Override
    public void onMethodEnd(MethodExecutionEvent executionEvent) {
        String methodName = executionEvent.getMethodName();
        System.out.println("finished to execute the method[" + methodName + "]");
    }
}

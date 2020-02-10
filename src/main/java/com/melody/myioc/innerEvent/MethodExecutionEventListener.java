package com.melody.myioc.innerEvent;

import java.util.EventListener;

public interface MethodExecutionEventListener extends EventListener {
    /**
     * 处理方法开始的时候发布的MethodExecutionEvent事件
     * @param executionEvent
     */
    void onMethodBegin(MethodExecutionEvent executionEvent);

    /**
     * 处理方法开始的即将结束发布的MethodExecutionEvent事件
     * @param executionEvent
     */
    void onMethodEnd(MethodExecutionEvent executionEvent);
}

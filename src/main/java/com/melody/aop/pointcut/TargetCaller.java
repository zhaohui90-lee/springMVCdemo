package com.melody.aop.pointcut;

/**
 * @Author: melody
 * @Date: 2020-03-25
 */
public class TargetCaller {
    private TargetObject targetObject;

    public void callMethod(){
        targetObject.method1();
    }
    public void setTarget(TargetObject target){
        this.targetObject = target;
    }
}

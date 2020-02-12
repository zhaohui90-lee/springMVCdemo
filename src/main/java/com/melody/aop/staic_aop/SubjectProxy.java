package com.melody.aop.staic_aop;

public class SubjectProxy implements ISubject {
    private ISubject subject;
    @Override
    public String request() {
        // pre-process
        String originalResult = subject.request();
        // post-process
        return "Proxy:" + originalResult;
    }

    public ISubject getSubject() {
        return subject;
    }

    public void setSubject(ISubject subject) {
        this.subject = subject;
    }
}

package com.melody.pojo.mock;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MockDemoObject {
    private List param1;
    private String[] param2;
    private Map mapping;
    private Properties emailAddress;

    public Properties getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(Properties emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Map getMapping() {
        return mapping;
    }

    public void setMapping(Map mapping) {
        this.mapping = mapping;
    }

    public List getParam1() {
        return param1;
    }

    public void setParam1(List param1) {
        this.param1 = param1;
    }

    public String[] getParam2() {
        return param2;
    }

    public void setParam2(String[] param2) {
        this.param2 = param2;
    }

    @Override
    public String toString() {
        return "MockDemoObject{" +
                "param1=" + param1 +
                ", param2=" + Arrays.toString(param2) +
                '}';
    }
}

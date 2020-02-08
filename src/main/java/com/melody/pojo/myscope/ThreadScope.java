package com.melody.pojo.myscope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public class ThreadScope implements Scope {

    private final ThreadLocal threadScope = new ThreadLocal(){
        protected Object initialValue(){
            return new HashMap();
        }
    };

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map scope = (Map) threadScope.get();
        Object object = scope.get(name);
        if (object == null){
            object = objectFactory.getObject();
            scope.put(name,object);
        }
        return object;
    }

    @Override
    public Object remove(String name) {
        Map scope = (Map) threadScope.get();
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}

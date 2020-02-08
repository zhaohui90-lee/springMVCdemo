package com.melody.pojo.myfactory;

public class NonStaticInterfaceFactory {
    public BarInterface getInstance(String id){
        return new BarInterfaceImp(id);
    }
}

package com.melody.pojo.myfactory;

public class StaticBarInterfaceFactory {
    public static BarInterface getInstance(String id){
        return new BarInterfaceImp(id);
    }
}

package com.melody.pojo.myfactory;

public class Foo {
    private BarInterface barInterface;

    public Foo(){
//        barInterface = StaticBarInterfaceFactory.getInstance("id");
        NonStaticInterfaceFactory factory = new NonStaticInterfaceFactory();
        barInterface = factory.getInstance("id");
    }

    public void setBarInterface(BarInterface barInterface) {
        this.barInterface = barInterface;
    }
}

package com.melody.util.formatter;

import java.util.Formatter;

/**
 * @Author: melody
 * @Date: 2020-04-30
 */
public class Receipt {
    private double total = 0;
    private Formatter f= new Formatter(System.out);
    public void printTitle(){
        f.format("%-25s %5s %10s\n","Item","Qty","Price");
        f.format("%-25s %5s %10s\n","----","---","-----");
    }
    public void print(String name,int qty,double price){
        f.format("%-25.25s %5d %10.2f\n",name,qty,price);
        total+=price;
    }
    public void printTotal(){
        f.format("%-25s %5s %10.2f\n","Tax","",total*0.06);
        f.format("%-25s %5s %10s\n","","","-----");
        f.format("%-25s %5s %10.2f\n","Total","",total*0.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans",4,4.5);
        receipt.print("Jack's Magic Beans",4,4.5);
        receipt.print("Jack's Magic Beans",4,4.5);
        receipt.printTotal();
    }
}

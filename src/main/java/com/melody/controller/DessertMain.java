package com.melody.controller;

import com.melody.config.DessertConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 40431
 */
public class DessertMain {

    private DessertConfig dessert;


    public DessertConfig getDessert() {
        return dessert;
    }

    @Autowired
    public void setDessert(DessertConfig dessert) {
        this.dessert = dessert;
    }
}

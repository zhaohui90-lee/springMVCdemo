package com.melody.pojo.concert;

import org.springframework.stereotype.Component;

/**
 * @author 40431
 */
@Component
public class PianoPerformance implements Performance {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void perform() {
        System.out.println("start piano performance...");
    }
}

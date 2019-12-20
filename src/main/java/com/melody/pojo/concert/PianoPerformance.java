package com.melody.pojo.concert;

import org.springframework.stereotype.Component;

/**
 * @author 40431
 */
@Component
public class PianoPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("start piano performance...");
    }
}

package com.melody.aspect;

import org.springframework.stereotype.Component;

/**
 * @author 40431
 */
@Component
public class DefaultEncoreable implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println("encore....");
    }
}

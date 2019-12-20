package com.melody.controller;

import com.melody.pojo.concert.Performance;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 40431
 */
public class ConcertMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/concert.xml");
        Performance perform = context.getBean(Performance.class);
        perform.perform();
    }
}

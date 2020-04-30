package com.melody.util.model;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: melody
 * @Date: 2020-04-29
 */
@Component
public class Test {

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(String msg){
        System.out.println("msg" + msg);
        return "redirect:/readingList";
    }
}

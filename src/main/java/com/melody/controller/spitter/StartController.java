package com.melody.controller.spitter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 40431
 * @Controller 申明为一个控制器
 * @RequestMapping(method = RequestMethod.GET) 处理“/”的GET请求
 * @RequestMapping("/")
 */
@Controller
@RequestMapping(value = "/start")
public class StartController {

    @RequestMapping(method = RequestMethod.GET)
    public String start(){
        return "start";
    }
}

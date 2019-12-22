package com.melody.controller.spitter;

import com.melody.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author 40431
 * @Controller 申明为一个控制器
 * @RequestMapping(method = RequestMethod.GET) 处理“/”的GET请求
 * @RequestMapping("/")
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @RequestMapping(method = GET)
    public String home(Model model){
        model.addAttribute(new User("jack","green","melody","123456"));
        return "home";
    }

    @RequestMapping(method = POST)
    public String registerHome(@Valid User user,Errors errors){
        if (errors.hasErrors()){
            return "home";
        }
        return "redirect:start";
    }
}

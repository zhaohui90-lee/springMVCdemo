package com.melody.controller.spitter;

import com.melody.controller.spitter.data.SpittleRepository;
import com.melody.controller.spitter.data.UserNotFoundException;
import com.melody.pojo.Spittle;
import com.melody.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 40431
 */
@Controller
@RequestMapping(value = "/spittle")
public class SpitterController {

    private final Logger logger = LoggerFactory.getLogger(SpitterController.class);

    private SpittleRepository spittleRepository;

//    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE,10);

    public SpitterController(){}

    @Autowired
    public SpitterController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method=RequestMethod.GET,value = "/spittles/{spittleID}")
    public String spittles(@PathVariable long spittleID, Model model){

        // 不指定key值，key会根据值的对象类型腿短确定
//        model.addAttribute(spittleRepository.findSpittle(
//                Long.MAX_VALUE,20));

        // 显示指定类型
//        model.addAttribute("spittleList",spittleRepository.findSpittle(
//                Long.MAX_VALUE,20
//        model.addAttribute(spittleRepository.findSpittle(spittleID,10));
//        ));

        User user = spittleRepository.findOne(spittleID);
        if (user == null){
            throw new UserNotFoundException();
        }
        return "spittle";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittlesList(
            @RequestParam(value = "max",defaultValue = "") long max,
            @RequestParam(value = "count",defaultValue = "20") int count){
        return spittleRepository.findSpittle(max, count);
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(Model model){
        model.addAttribute(new User());
        logger.info("123456");
        return "registerForm";
    }

    @RequestMapping(value = "/uploads/user",method = RequestMethod.POST)
    public String processRegistration(@RequestPart("profileImage") MultipartFile file, @Valid User user,
                                      Errors errors){
        if (errors.hasErrors()){
            return "registerForm";
        }
        try {
            file.transferTo(new File("E:/IDEA/tmp/"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        spittleRepository.saveSpittle(user);

        return "redirect:/spittle/" + user.getUserName();
    }

    @RequestMapping(value = "/{userName}",method = RequestMethod.GET)
    public String showSpittleProfile(@PathVariable String userName,Model model){
        logger.info(userName);
        return "user/" + userName;
    }
}

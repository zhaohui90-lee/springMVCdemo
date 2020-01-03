package com.melody.controller.exception;

import com.melody.controller.pizza.service.CustomerNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * @author 40431
 */
@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler
    public String duplicateSpittleHandler(CustomerNotFoundException cus){
        return "error/duplicate";
    }
}

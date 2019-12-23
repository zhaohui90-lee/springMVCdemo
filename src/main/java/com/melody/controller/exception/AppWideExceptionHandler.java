package com.melody.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler
    public String duplicateSpittleHandler(){
        return "error/duplicate";
    }
}

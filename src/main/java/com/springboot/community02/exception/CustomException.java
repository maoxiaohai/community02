package com.springboot.community02.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomException {
    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(Model model,Throwable ex) {
        model.addAttribute("message","服务器炸了");
        return new ModelAndView("error");
    }
}

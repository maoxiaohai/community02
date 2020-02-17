package com.springboot.community02.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class IndexController {
    @GetMapping("/")
    public String Index(){
        return "index";
    }
}

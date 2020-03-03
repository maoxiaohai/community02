package com.springboot.community02.controller;


import com.springboot.community02.mapper.UserMapper;
import com.springboot.community02.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;
    @GetMapping("/")
    public String Index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user=userMapper.findByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user",user.getName());
                }
                break;
            }
        }
        return "index";
    }

}

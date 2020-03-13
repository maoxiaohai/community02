package com.springboot.community02.controller;


import com.springboot.community02.dto.QuestionDTO;
import com.springboot.community02.mapper.QuestionMapper;
import com.springboot.community02.mapper.UserMapper;
import com.springboot.community02.model.Question;
import com.springboot.community02.model.User;
import com.springboot.community02.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    QuestionService questionService;
    @GetMapping("/")
    public String Index(HttpServletRequest request,
                        Model model){
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
        List<QuestionDTO> questionList=questionService.list();
        for (QuestionDTO qu:questionList
             ) {
            qu.setDescription("des1221");
        }
        model.addAttribute("questions",questionList);
        return "index";
    }

}

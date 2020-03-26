package com.springboot.community02.controller;


import com.springboot.community02.dto.PaginationDTO;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionMapper questionMapper;
    @GetMapping("/")
    public String Index(HttpServletRequest request,
                        Model model,
                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "size", defaultValue = "2") Integer size) {
        //List<Question> list = questionMapper.list(0, 5);
        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination", pagination);

        return "index";
    }

}

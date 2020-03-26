package com.springboot.community02.controller;

import com.springboot.community02.mapper.QuestionMapper;
import com.springboot.community02.mapper.UserMapper;
import com.springboot.community02.model.Question;
import com.springboot.community02.model.User;
import com.springboot.community02.service.QuestionService;
import com.springboot.community02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @GetMapping("/publish/{id}")
    public String publish(@PathVariable("id")Integer id,
                          Model model){
        Question question=questionMapper.getById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("id",question.getId());
        return "publish";
    }
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            @RequestParam("id") Integer id,
            HttpServletRequest request,
            Model model) {
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);

        if (title==null||title=="") {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description==null||description=="") {
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if (tag==null||tag=="") {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }



        Cookie[] cookies = request.getCookies();
        User user=null;
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                user=userMapper.findByToken(token);
                if(user!=null){
                    request.getSession().setAttribute("user",user.getName());
                }
                break;
            }
        }
        if(user==null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setId(id);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());


        questionService.insertOrUpdate(question);
        //questionMapper.insert(question);
        return "redirect:/";
    }
}

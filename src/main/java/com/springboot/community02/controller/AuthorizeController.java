package com.springboot.community02.controller;


import com.springboot.community02.dto.AccesstokenDTO;
import com.springboot.community02.dto.GithubUser;
import com.springboot.community02.mapper.UserMapper;
import com.springboot.community02.model.User;
import com.springboot.community02.provider.GithubProvider;
import com.springboot.community02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@Controller
public class AuthorizeController {
    @Autowired
    GithubProvider githubProvider;

    @Autowired
    UserMapper userMapper;

    @Value("${github.client.id}")
    private String client_id;

    @Value("${github.client.secret}")
    private String client_secret;

    @Value("${github.redirect.uri}")
    private String redirct_uri;

    @Autowired
    private UserService userService;
    @GetMapping("callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response){

        AccesstokenDTO accesstoken = new AccesstokenDTO();
        accesstoken.setClient_id(client_id);
        accesstoken.setClient_secret(client_secret);
        accesstoken.setCode(code);
        accesstoken.setRedirect_uri(redirct_uri);
        accesstoken.setState(state);
        //get token
        String token = githubProvider.getAccessToken(accesstoken);
        //System.out.println(token);
        //get user1user
        GithubUser githubUser = githubProvider.getUser(token);
        //System.out.println(user1user.getLogin());
        if(githubUser==null){
            //验证失败
        }else{
            //验证成功
            request.getSession().setAttribute("user",githubUser.getLogin());
            User user = new User();
            String stoken = UUID.randomUUID().toString();
            response.addCookie(new Cookie("token",stoken));
            user.setToken(stoken);
            user.setAccountId(githubUser.getId().toString());
            user.setName(githubUser.getLogin());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userService.insertOrUpdate(user);
            //不需要每次都更新数据库
            //userMapper.insert(user);
            
        }
        return "redirect:/";
    }
    @GetMapping("logout")
    public String logout(HttpServletRequest req,
                         HttpServletResponse res){
        req.getSession().removeAttribute("user");
        Cookie token = new Cookie("token", null);
        token.setMaxAge(0);
        res.addCookie(token);
        return "redirect:/";
    }

}

package com.springboot.community02.controller;


import com.springboot.community02.dto.AccesstokenDTO;
import com.springboot.community02.dto.GithubUser;
import com.springboot.community02.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;


@Controller
public class AuthorizeController {
    @Autowired
    GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String client_id;
    @Value("${github.client.secret}")
    private String client_secret;
    @Value("${github.redirect.uri}")
    private String redirct_uri;
    @GetMapping("callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request){

        AccesstokenDTO accesstoken = new AccesstokenDTO();
        accesstoken.setClient__id(client_id);
        accesstoken.setClient_secret(client_secret);
        accesstoken.setCode(code);
        accesstoken.setRedirct_uri(redirct_uri);
        accesstoken.setState(state);
        //get token
        String token = githubProvider.getAccessToken(accesstoken);
        System.out.println(token);
        //get user
        GithubUser user = githubProvider.getUser(token);
        System.out.println(user.getLogin());
        if(user==null){
            //验证失败
        }else{
            //验证成功
            request.getSession().setAttribute("user",user);
        }
        return "index";
    }
}

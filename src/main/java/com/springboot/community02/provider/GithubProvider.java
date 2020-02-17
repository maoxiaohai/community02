package com.springboot.community02.provider;

import com.alibaba.fastjson.JSON;
import com.springboot.community02.dto.AccesstokenDTO;
import com.springboot.community02.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccesstokenDTO accesstoken){

        /*
        *使用OKhttp框架发送Post请求,得到TOKEN
        * */
        MediaType mediaType
                = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        String str=JSON.toJSONString(accesstoken);
        RequestBody body = RequestBody.create(JSON.toJSONString(accesstoken),mediaType);
        Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                //Github返回accesstoken
                String string = response.body().string();
                String token = string.split("&")[0].split("=")[1];
                return token;
            }catch (Exception e){
                e.printStackTrace();
            }
        return null;
    }

    /*
     * 通过得到的TOKEN去获取用户信息
     * */
    public GithubUser getUser(String token){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
            return JSON.parseObject(string,GithubUser.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

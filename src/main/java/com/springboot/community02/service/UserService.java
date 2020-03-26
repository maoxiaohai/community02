package com.springboot.community02.service;

import com.springboot.community02.mapper.UserMapper;
import com.springboot.community02.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void insertOrUpdate(User user) {
        List<User> list=userMapper.getByAccountId(user.getAccountId());
        User dbUser=null;
        if(list.size()>1)dbUser=list.get(0);
        //= userMapper.getByAccountId(user.getAccountId());
        if(dbUser==null){
            //插入动作
            userMapper.insert(dbUser);
            dbUser.setGmtCreate(System.currentTimeMillis());
            dbUser.setGmtModified(user.getGmtModified());
        }else{
            //更新动作
            dbUser.setGmtModified(System.currentTimeMillis());
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            userMapper.update(dbUser);

        }
    }
}

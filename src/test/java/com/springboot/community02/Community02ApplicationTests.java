package com.springboot.community02;

import com.springboot.community02.mapper.UserMapper;
import com.springboot.community02.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Community02ApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = new User();
        user.setGmtModified(Long.parseLong("12"));
        user.setName("zs");
        user.setGmtCreate(Long.parseLong("21"));
        user.setAccountId("12");
        user.setToken("token");
        user.setId(1);
        userMapper.insert(user);
    }

}

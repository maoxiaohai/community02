package com.springboot.community02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.community02.mapper")
public class Community02Application {
    public static void main(String[] args) {
        SpringApplication.run(Community02Application.class, args);
    }
}

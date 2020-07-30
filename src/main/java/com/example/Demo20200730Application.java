package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class Demo20200730Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo20200730Application.class, args);
    }

}

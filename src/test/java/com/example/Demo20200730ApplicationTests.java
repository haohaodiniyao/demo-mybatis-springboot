package com.example;

import com.example.datasource.DataSourceType;
import com.example.datasource.JdbcContextHolder;
import com.example.datasource.MyDataSource;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class Demo20200730ApplicationTests {
    @Resource
    private UserService userService;
    @Test
    void contextLoads() {
        //切换数据库
        JdbcContextHolder.putDataSource(DataSourceType.DRIVER_SERVICE_MASTER.getName());
        userService.add1();
//        userService.add2();
    }

}

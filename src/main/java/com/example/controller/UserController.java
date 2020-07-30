package com.example.controller;

import com.example.datasource.DataSourceType;
import com.example.datasource.MyDataSource;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;
    @MyDataSource(DataSourceType.DRIVER_SERVICE_SLAVE)
    @RequestMapping("/info")
    public List<User> userInfo(){
        return userMapper.selectByExample(null);
    }
}

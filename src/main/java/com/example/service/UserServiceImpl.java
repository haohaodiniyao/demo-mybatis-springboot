package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add1() {
        User user = new User();
        user.setUserName("姓名1");
        int row = userMapper.insert(user);
        log.info("userId={}",user.getUserId());
        add2();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add2() {
        User user = new User();
        user.setUserName("姓名2");
        int row = userMapper.insert(user);
        log.info("userId={}",user.getUserId());
        int a = 1/0;
    }
}

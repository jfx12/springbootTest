package com.xjf.demo.service;

import com.xjf.demo.dao.UserMapper;
import com.xjf.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User selectUserById(int id){
        return userMapper.selectById(id);
    }
}

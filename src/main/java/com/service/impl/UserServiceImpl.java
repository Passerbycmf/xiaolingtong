package com.service.impl;

import com.bean.User;
import com.dao.UserMapper;
import com.service.UserService;
import com.service.core.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl extends AbstractService<User,String> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByPhone(String userPhone) {
        return userMapper.getUserByPhone(userPhone);
    }



    @Override
    public User selectUserByOpenid(String openId) {
        return userMapper.selectUserByOpenid(openId);
    }





}

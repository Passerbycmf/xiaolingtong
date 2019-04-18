package com.dao;

import com.bean.User;
import com.service.core.BaseMapper;


import java.util.List;

public interface UserMapper extends BaseMapper<User,String> {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    @Override
    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUserByPhone(String userPhone);



    User selectUserByOpenid(String openId);




}
package com.service;

import com.bean.User;
import com.service.core.BaseService;


import java.util.List;


public interface UserService extends BaseService<User,String> {
    /**
     *
     * @param userPhone
     * @return
     */
    User getUserByPhone(String userPhone);


    /**
     *
     * @param openId
     * @return
     */
    User selectUserByOpenid(String openId);




}

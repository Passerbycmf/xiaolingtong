package com.controller;

import com.bean.User;
import com.common.BaseController;
import com.common.Result;

import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "isUser")
    @ResponseBody
    public Result personalRegister(String id) {
       return null;

    }



}

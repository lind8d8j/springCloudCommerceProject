package com.learnspringcloud.userprovider.controller;

import com.entity.User;
import com.learnspringcloud.userprovider.dao.UserDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserDao userDao;

    @GetMapping("/register")
    public int register(@RequestParam("uname") String uname,
                        @RequestParam("upassword") String upassword,
                        @RequestParam("usex") String usex){
        System.out.println("已进入注册user-provider");
        return userDao.register(uname,upassword,usex);
    }

    @GetMapping("/login")
    public User login(@RequestParam("uname")String uname){
        System.out.println("已进入登录user-provider");
        return userDao.login(uname);
    }
}

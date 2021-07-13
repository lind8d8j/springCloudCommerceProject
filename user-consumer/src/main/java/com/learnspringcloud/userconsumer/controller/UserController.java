package com.learnspringcloud.userconsumer.controller;

import com.entity.User;
import com.learnspringcloud.userconsumer.servcie.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/toregister")
    public String  toRegister(){
        return "register";
    }

    @GetMapping("/register")
    public String register(String uname,String upassword,String usex){
        if (userService.register(uname,upassword,usex) > 0){
            System.out.println("用户注册成功");
            return "login";
        }
        System.out.println("用户注册失败");
        return "register";

    }

    @GetMapping("/tologin")
    public String toLogin(){
        return "login";
    }

    @GetMapping("/login")
    public String login(String uname, String upassword, HttpServletRequest request){
        User user = userService.login(uname);
        if (!user.equals(null) && user.getUpassword().equals(upassword)){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            System.out.println("登录成功");
            return "redirect:http://localhost:8894/goods/getAll?uaccount="+user.getUaccount();
        }
        System.out.println("登录失败");
        return "login";
    }
}

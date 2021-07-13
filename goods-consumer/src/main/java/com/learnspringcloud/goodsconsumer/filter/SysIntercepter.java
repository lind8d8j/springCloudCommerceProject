package com.learnspringcloud.goodsconsumer.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SysIntercepter extends HandlerInterceptorAdapter {
    /**
     * 进入拦截器后首先进入的方法
     * 返回false则不在执行
     * 返回true则继续执行
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception{
        System.out.println("我是拦截器，我进来了");
        HttpSession session = request.getSession();
        String uid = (String) session.getAttribute("uaccount");
        if (uid == null ){
            System.out.println("用户未登录");
            response.sendRedirect(request.getContextPath()+"http://localhost:8893/admin/tologin");
            return false;
        }
        System.out.println("用户已登录");
        return true;
    }
}

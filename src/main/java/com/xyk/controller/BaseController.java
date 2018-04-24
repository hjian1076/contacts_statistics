package com.xyk.controller;


import com.xyk.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {
     /**
     * 获取当前登录的USER
     * @return
     */
    protected User getNowUser(){
        return (User)getSession().getAttribute("user");
    }
     public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
            System.out.println("getSession error...");
        }
        return session;
    }
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return attrs.getRequest();
    }
}

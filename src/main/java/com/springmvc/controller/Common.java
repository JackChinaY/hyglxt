package com.springmvc.controller;

import com.springmvc.entity.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Common {
    @Resource
    HttpServletRequest request;
    @Resource
    HttpSession session;

    public User getCurrentUser() {
        return (User) request.getSession().getAttribute("user");
    }
}

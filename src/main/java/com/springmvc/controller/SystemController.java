package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.SystemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统级的操作，如登录、注销
 */
@Controller //@Controller用于注解Controller层
public class SystemController {

    @Resource
    private SystemService systemService;

    /**
     * /，返回login.html页面
     * 参考：https://www.cnblogs.com/Alex-zqzy/p/9329482.html
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login0() {
        return "login";
    }

    /**
     * /login，返回login.html页面
     * 参考：https://www.cnblogs.com/Alex-zqzy/p/9329482.html
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * /index，返回index.html页面
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /**
     * 登录
     */
    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    @ResponseBody//处理 AJAX请求，返回响应的内容
    public Map<String, Object> loginIn(@RequestBody User user, HttpSession session) {
        System.out.println("用户名 :" + user.getUsername() + "密码 :" + user.getPassword());
        User result = systemService.login(user);
//        System.out.println("查询结果1 is:" + result.size());
//        System.out.println("查询结果2 is:" + result.get("COUNTS"));
        String flag;
        if (result != null) {
            flag = "1";//登录成功
            session.setAttribute("user", result);//在session中保存当前用户
//            System.out.println(result.toString());
//            System.out.println("session:" + session.getAttribute("user").toString());
        } else {
            flag = "0";//登录失败
//            System.out.println("无此用户");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", flag);
        map.put("username", user.getUsername());
        map.put("danwei", result.getDanwei());
        return map;
    }

    /**
     * 用户需要重新登录系统
     */
    @RequestMapping(value = "/relogin", method = RequestMethod.POST)
    @ResponseBody//处理 AJAX请求，返回响应的内容
    public Map<String, String> relogin() {
        System.out.println("用户需要重新登录系统");

        Map<String, String> map = new HashMap<String, String>();
        map.put("code", "0");
        return map;
    }

    /**
     * 注销
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public void loginOut(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (session == null) {
        } else {
            session.removeAttribute("username");
            session.invalidate();//清除session
            System.out.println("清除session成功");
        }
        //重定向到登录页面
        response.sendRedirect(request.getContextPath() + "/");
    }

}

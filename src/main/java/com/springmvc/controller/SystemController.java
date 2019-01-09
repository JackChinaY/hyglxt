package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.HQService;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SystemController {

    @Resource(name = "HQService")
    private HQService hqService;

    /**
     * /login，返回login.html页面
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
    public Map<String, String> loginIn(@RequestBody User user, HttpSession session) {
        System.out.println("已进入controller方法。。。。");
        System.out.println("username :" + user.getUsername());
        System.out.println("password :" + user.getPassword());
//        Map result = hqService.login(username, password);
//        System.out.println("查询结果1 is:" + result.size());
//        System.out.println("查询结果2 is:" + result.get("COUNTS"));
        String flag;
//        if (result.get("COUNTS").toString().equals("1")) {
//            flag = "1";//登录成功
//        session.setAttribute("username", user.getUsername());//在session中保存用户的id
//        } else {
//            flag = "0";//登录失败
//        }


        if (user.getUsername().equals("admin")) {
            flag = "1";//登录成功
            session.setAttribute("username", user.getUsername());//在session中保存用户的id
        } else {
            flag = "0";//登录失败
        }
        System.out.println("session:" + session.getAttribute("username"));
        Map<String, String> map = new HashMap<String, String>();
        map.put("code", flag);
        map.put("username", user.getUsername());
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

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * 用户登录系统
     */
//    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
//    public ModelAndView loginIn(@RequestParam("username") String username, @RequestParam("password") String password) {
//        System.out.println("已进入controller方法。。。。");
//        System.out.println("username is:" + username);
//        System.out.println("password is:" + password);
//        ModelAndView mv = new ModelAndView("index");
//        mv.addObject("msg", "正常ModelAndView的返回");
//        return mv;
//    }


    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/loginIn2", method = RequestMethod.POST)
    @ResponseBody//处理 AJAX请求，返回响应的内容，而不是 View Name
    public Map<String, String> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        System.out.println("你已通过springMVC进入controller方法。。。。");
        System.out.println("username is:" + username);
        System.out.println("password is:" + password);

        Map result = hqService.login(username, password);
//        System.out.println("查询结果1 is:" + result.size());
        System.out.println("查询结果2 is:" + result.get("COUNTS"));
        if (result == null) {
            System.out.println("查询结果是空");
        }

        String flag;
        if (result.get("COUNTS").toString().equals("1")) {
            flag = "1";//登录成功
            session.setAttribute("admin", username);//在session中保存用户的id
        } else {
            flag = "0";//登录失败
        }
        System.out.println("session:" + session.getAttribute("admin"));
        Map<String, String> map = new HashMap<String, String>();
        map.put("jsonObject", flag);
        map.put("username", username);
        return map;
    }
//    /**
//     * 注销
//     */
//    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
//    public String  loginOut( HttpSession session) {
//        if (session == null) {
//        }else {
//            session.removeAttribute("admin");
//            session.invalidate();//清除session
//        }
//            System.out.println("清除session成功");
//        return "login";
//    }


//    @RequestMapping(method = RequestMethod.GET)
//    public String index() {
////        currentLoginUser.getCurrentUser(session);
////		return "index";
//
//        return "login";
//    }


//    @RequestMapping("/index")
//    public String index() {
//
//        return "index";
//    }

    @RequestMapping("/user")
    @ResponseBody
    public Map<String, Object> find(User user, HttpServletRequest request) {

        Map<String, Object> map = new HashedMap();
        System.out.println("你已通过springMVC进入controller方法。。。。");
//        logger.info("你已通过springMVC进入controller方法。。。。");
        User loginuser = hqService.findByUsernameAndPwd(user.getUsername(), user.getPassword());
        if (loginuser != null) {
            map.put("result", "success");
        } else {
            map.put("result", "fail");
        }
        return map;
    }

    @RequestMapping("/success")
    public String success() {
        System.out.println("登录成功。。。。");
//        logger.info("登录成功。。。。");

        return "success";
    }

}

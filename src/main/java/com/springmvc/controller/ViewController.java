package com.springmvc.controller;

import com.springmvc.entity.User;
import com.springmvc.service.HQService;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//@RequestMapping("/admin")

@Controller
@RequestMapping("/admin")
public class ViewController {

//    private Logger logger = Logger.getLogger(ViewController.class);

    @Resource(name = "HQService")
    private HQService hqService;

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
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

    /**
     * 注销
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public Map<String, String> loginOut(HttpSession session) {
        if (session == null) {
        } else {
            session.removeAttribute("admin");
            session.invalidate();//清除session
            System.out.println("清除session成功");
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("jsonObject", "1");
        return map;
    }

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

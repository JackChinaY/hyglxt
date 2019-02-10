package com.springmvc.controller;

import com.springmvc.entity.Conference;
import com.springmvc.entity.Page;
import com.springmvc.entity.User;
import com.springmvc.service.YjlyService;
import com.springmvc.util.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 院记录员的操作接口
 */
@Controller
@RequestMapping("/yjly")
public class YjlyController extends Common {

    @Resource
    private YjlyService yjlyService;

    /**
     * 分页查询所有会议
     */
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody//处理 AJAX请求，返回响应的内容，如json数据
    public Map<String, Object> findByPage(@RequestBody Page page) {
        System.out.println("当前页 :" + page.getCurrPage() + "页大小 :" + page.getPageSize());
        //设置页码偏移量
        page.setOffSet((page.getCurrPage() - 1) * page.getPageSize());
        page.setUserId(getCurrentUser().getId());
        List<Conference> result = yjlyService.findByPage(page);
//        System.out.println(getCurrentUser().toString());
        int count = yjlyService.findCount(getCurrentUser());
//        System.out.println(result);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);//code，-1：登录失效；0：响应正常；
        map.put("count", count);
        map.put("data", result);
        return map;
    }

    /**
     * 新增会议
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody//处理 AJAX请求，返回响应的内容，如json数据
    public Map<String, Object> add(@RequestBody Conference conference) {
        System.out.println("数据 :" + conference.toString());
        conference.setId(UUID.randomUUID().toString());
        conference.setJlyid(getCurrentUser().getId());

//        page.setUserId(getCurrentUser().getId());
//        List<Conference> result = yjlyService.findByPage(page);
        System.out.println(conference.toString());
        int count = yjlyService.add(conference);
//        System.out.println(result);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);//code，-1：登录失效；0：响应正常；
        map.put("count", count);
//        map.put("data", result);
        return map;
    }

    /**
     * 根据会议id，查询单个会议
     */
    @RequestMapping(value = "/view", method = RequestMethod.POST)
    @ResponseBody//处理 AJAX请求，返回响应的内容，如json数据
    public Map<String, Object> view(@RequestBody Conference conference) {
        System.out.println("数据 :" + conference.toString());
        List<Conference> result = yjlyService.view(conference);
//        System.out.println(result);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);//code，-1：登录失效；0：响应正常；
        map.put("count", result.size());
        map.put("data", result.get(0));
        return map;
    }
    /**
     * 修改保存一个会议
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody//处理 AJAX请求，返回响应的内容，如json数据
    public Map<String, Object> save(@RequestBody Conference conference) {
        System.out.println("数据 :" + conference.toString());
        int count = yjlyService.save(conference);
//        System.out.println(result);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);//code，-1：登录失效；0：响应正常；
        map.put("count", count);
//        map.put("data", result);
        return map;
    }
}

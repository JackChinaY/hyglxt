package com.springmvc.controller;

import com.springmvc.entity.*;
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
//        System.out.println("当前页 :" + page.getCurrPage() + "页大小 :" + page.getPageSize());
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
        map.put("code", 0);//code，-1：登录失效；0：响应正常
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

    /**
     * 按单位查询所有教职工
     */
    @RequestMapping(value = "/findWorkersByDW", method = RequestMethod.POST)
    @ResponseBody//处理 AJAX请求，返回响应的内容，如json数据
    public Map<String, Object> findWorkersByDW(@RequestBody Worker worker) {
        System.out.println("数据 :" + worker.toString());
        List<Worker> result = yjlyService.findWorkersByDW(worker);
        //查询本单位所有存在的职务
        List<Worker> result4 = yjlyService.findZhiWuByDW(worker);
        //查询本单位所有存在的职称
        List<Worker> result5 = yjlyService.findZhiChengByDW(worker);
//        System.out.println(result);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);//code，-1：登录失效；0：响应正常；
        map.put("count", result.size());
        map.put("data", result);
        map.put("count4", result4.size());
        map.put("count5", result5.size());
        map.put("data4", result4);
        map.put("data5", result5);
        return map;
    }

    /**
     * 去重查询所有单位
     */
    @RequestMapping(value = "/findDW", method = RequestMethod.POST)
    @ResponseBody//处理 AJAX请求，返回响应的内容，如json数据
    public Map<String, Object> findDW(@RequestBody Worker worker) {
//        System.out.println("数据 :" + worker.toString());
        //查询所有的管理服务部门
        worker.setLevel1("管理服务部门");
        List<Worker> result1 = yjlyService.findDW(worker);
        //查询所有的教学科研单位
        worker.setLevel1("教学科研单位");
        List<Worker> result2 = yjlyService.findDW(worker);
        //查询本单位的教职工
        List<Worker> result3 = yjlyService.findWorkersByDW(worker);
        //查询本单位所有存在的职务
        List<Worker> result4 = yjlyService.findZhiWuByDW(worker);
        //查询本单位所有存在的职称
        List<Worker> result5 = yjlyService.findZhiChengByDW(worker);
//        System.out.println(result);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);//code，-1：登录失效；0：响应正常；
        map.put("count1", result1.size());
        map.put("count2", result2.size());
        map.put("count3", result3.size());
        map.put("count4", result4.size());
        map.put("count5", result5.size());
        map.put("data1", result1);
        map.put("data2", result2);
        map.put("data3", result3);
        map.put("data4", result4);
        map.put("data5", result5);
        return map;
    }

    /**
     * 去重查询所有单位 会议地点
     */
    @RequestMapping(value = "/findDWForHYDD", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findDWForHYDD(@RequestBody Place place) {
        System.out.println("数据 :" + place.toString());
        //按单位查询所有会议室
        Worker worker = new Worker();
        //查询所有的管理服务部门
        worker.setLevel1("管理服务部门");
        List<Worker> result1 = yjlyService.findDW(worker);
        //查询所有的教学科研单位
        worker.setLevel1("教学科研单位");
        List<Worker> result2 = yjlyService.findDW(worker);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);//code，-1：登录失效；0：响应正常；
        map.put("count1", result1.size());
        map.put("count2", result2.size());
        map.put("data1", result1);
        map.put("data2", result2);
        return map;
    }

    /**
     * 按单位查询所有会议室
     */
    @RequestMapping(value = "/findPlaceByDW", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findPlaceByDW(@RequestBody Place place) {
        System.out.println("数据 :" + place.toString());
        //按单位查询所有会议室
        List<Place> result = yjlyService.findPlaceByDW(place);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);//code，-1：登录失效；0：响应正常；
        map.put("count", result.size());
        map.put("data", result);
        return map;
    }

    /**
     * 查询所有配置项
     */
    @RequestMapping(value = "/findAllProperty", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findAllProperty() {

        //按单位查询所有会议室
        List<Property> result = yjlyService.findAllProperty();
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);//code，-1：登录失效；0：响应正常；
        map.put("count", result.size());
        map.put("data", result);
        return map;
    }
}

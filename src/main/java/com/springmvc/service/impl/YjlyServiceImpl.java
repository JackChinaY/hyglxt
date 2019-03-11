package com.springmvc.service.impl;

import com.springmvc.dao.PlaceDao;
import com.springmvc.dao.PropertyDao;
import com.springmvc.dao.WorkerDao;
import com.springmvc.dao.YjlyDao;
import com.springmvc.entity.*;
import com.springmvc.service.YjlyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 院记录员接口实现类
 */
@Service //@Service用于注解Service层
public class YjlyServiceImpl implements YjlyService {

    @Resource
    private YjlyDao yjlyDao;

    @Resource
    private WorkerDao workerDao;

    @Resource
    private PlaceDao placeDao;

    @Resource
    private PropertyDao propertyDao;

    /**
     * 分页查询所有会议
     */
    @Override
    public List<Conference> findByPage(Page page) {
        return yjlyDao.findByPage(page);
    }

    /**
     * 查询会议总数
     */
    @Override
    public int findCount(User user) {
        return yjlyDao.findCount(user);
    }

    /**
     * 新增会议
     */
    @Override
    public int add(Conference conference) {
        return yjlyDao.add(conference);
    }

    /**
     * 根据会议id，查询单个会议
     */
    @Override
    public List<Conference> view(Conference conference) {
        return yjlyDao.view(conference);
    }

    /**
     * 修改保存一个会议
     */
    @Override
    public int save(Conference conference) {
        return yjlyDao.save(conference);
    }

    /**
     * 删除一个会议
     */
    @Override
    public int delete(Conference conference) {
        return yjlyDao.delete(conference);
    }

    /**
     * 按单位查询所有教职工
     */
    @Override
    public List<Worker> findWorkersByDW(Worker worker) {
        return workerDao.findAll(worker);
    }

    /**
     * 去重查询所有单位
     */
    @Override
    public List<Worker> findDW(Worker worker) {
        return workerDao.findDW(worker);
    }

    /**
     * 查询本单位所有存在的职务
     */
    @Override
    public List<Worker> findZhiWuByDW(Worker worker) {
        List<Worker> resultList = new ArrayList<>();//结果集
        Set<String> tempSet = new HashSet<>();//临时集
        List<Worker> workerList = workerDao.findZhiWuByDW(worker);//查询集
        //遍历查询集
        for (int i = 0; i < workerList.size(); i++) {
            //如果该教职工的职务是唯一的
            if (!workerList.get(i).getZhiwu().contains("/")) {
                tempSet.add(workerList.get(i).getZhiwu());
            }
            //如果该教职工的职务不是唯一的，如：校长/校党委常委/校友会会长
            else {
                //分割该职务
                String sourceStr = workerList.get(i).getZhiwu();
                String[] sourceStrArray = sourceStr.split("/");
                //将分割后的单独职务循环存入临时集
                for (int j = 0; j < sourceStrArray.length; j++) {
                    tempSet.add(sourceStrArray[j]);
                }
            }
        }
        //将临时集转成结果集
        Iterator iterator = tempSet.iterator();
//        System.out.println(tempSet.size());
        while (iterator.hasNext()) {
            Worker w = new Worker();
            String s = (String) iterator.next();
//            System.out.println("字符串：" + s);
            w.setZhiwu(s.substring(1, s.length() - 1));
            resultList.add(w);
        }
        return resultList;
    }

    /**
     * 询本单位所有存在的职称
     */
    @Override
    public List<Worker> findZhiChengByDW(Worker worker) {
        List<Worker> resultList = new ArrayList<>();//结果集
        Set<String> tempSet = new HashSet<>();//临时集
        List<Worker> workerList = workerDao.findZhiChengByDW(worker);//查询集
        //遍历查询集
        for (int i = 0; i < workerList.size(); i++) {
            //如果该教职工的职称是唯一的
            if (!workerList.get(i).getZhicheng().contains("/")) {
                tempSet.add(workerList.get(i).getZhicheng());
            }
            //如果该教职工的职称不是唯一的，如：讲师/教授
            else {
                //分割该职务
                String sourceStr = workerList.get(i).getZhicheng();
                String[] sourceStrArray = sourceStr.split("/");
                //将分割后的单独职务循环存入结果集
                for (int j = 0; j < sourceStrArray.length; j++) {
                    tempSet.add(sourceStrArray[j]);
                }
            }
        }
        //将临时集转成结果集
        Iterator iterator = tempSet.iterator();
        while (iterator.hasNext()) {
            Worker w = new Worker();
            String s = (String) iterator.next();
            w.setZhicheng(s.substring(1, s.length() - 1));
            resultList.add(w);
        }
        return resultList;
    }

    /**
     * 按单位查询所有会议室
     */
    @Override
    public List<Place> findPlaceByDW(Place place) {
        return placeDao.findPlaceByDW(place);
    }

    /**
     * 查询所有配置项
     */
    @Override
    public List<Property> findAllProperty() {
        return propertyDao.findAllProperty();
    }


}
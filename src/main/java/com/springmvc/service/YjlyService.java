package com.springmvc.service;


import com.springmvc.entity.Conference;
import com.springmvc.entity.Page;
import com.springmvc.entity.User;
import com.springmvc.entity.Worker;

import java.util.List;
import java.util.Map;

/**
 * 院记录员接口
 */
public interface YjlyService {

    /**
     * 分页查询所有会议
     */
    List<Conference> findByPage(Page page);

    /**
     * 查询会议总数
     */
    int findCount(User user);

    /**
     * 新增会议
     */
    int add(Conference conference);

    /**
     * 根据会议id，查询单个会议
     */
    List<Conference> view(Conference conference);

    /**
     * 修改保存一个会议
     */
    int save(Conference conference);

    /**
     * 删除一个会议
     */
    int delete(Conference conference);

    /**
     * 按单位查询所有教职工
     */
    List<Worker> findWorkersByDW(Worker worker);

    /**
     * 去重查询所有单位
     */
    List<Worker> findDW(Worker worker);

    /**
     * 查询本单位所有存在的职务
     */
    List<Worker> findZhiWuByDW(Worker worker);

    /**
     * 询本单位所有存在的职称
     */
    List<Worker> findZhiChengByDW(Worker worker);
}

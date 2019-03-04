package com.springmvc.service.impl;

import com.springmvc.dao.WorkerDao;
import com.springmvc.dao.YjlyDao;
import com.springmvc.entity.Conference;
import com.springmvc.entity.Page;
import com.springmvc.entity.User;
import com.springmvc.entity.Worker;
import com.springmvc.service.YjlyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 院记录员接口实现类
 */
@Service //@Service用于注解Service层
public class YjlyServiceImpl implements YjlyService {

    @Resource
    private YjlyDao yjlyDao;

    @Resource
    private WorkerDao workerDao;

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
}
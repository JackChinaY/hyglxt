package com.springmvc.service.impl;

import com.springmvc.dao.YjlyDao;
import com.springmvc.entity.Conference;
import com.springmvc.entity.Page;
import com.springmvc.entity.User;
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
}
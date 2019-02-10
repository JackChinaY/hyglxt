package com.springmvc.service.impl;

import com.springmvc.dao.SystemDao;
import com.springmvc.entity.User;
import com.springmvc.service.SystemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * SystemService接口实现类
 */
@Service //@Service用于注解Service层
public class SystemServiceImpl implements SystemService {

    @Resource
    private SystemDao systemDao;

    @Override
    public User login(User user) {
        return systemDao.login(user);
    }

    public User findByUsernameAndPwd(String name, String pwd) {

        return systemDao.findByUsernameAndPwd(name, pwd);
    }

    public List<User> find(User user) {

        return systemDao.find(user);
    }


    public void add(User user) {

        systemDao.add(user);
    }

    public void update(User user) {

        systemDao.update(user);
    }

    public void delete(String id) {

        systemDao.delete(id);
    }
}
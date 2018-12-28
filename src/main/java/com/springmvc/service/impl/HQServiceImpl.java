package com.springmvc.service.impl;

import com.springmvc.dao.HQDao;
import com.springmvc.entity.User;
import com.springmvc.service.HQService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Vitelon on 2017-03-30
 * 用户service实现类
 */
@Service("HQService")
public class HQServiceImpl implements HQService {

    @Resource(name = "HQDao")
    private HQDao hqDao;

    @Override
    public Map<String, Object> login(String username, String password) {
        return hqDao.login(username,password);
    }

    public User findByUsernameAndPwd(String name, String pwd) {

        return hqDao.findByUsernameAndPwd(name, pwd);
    }

    public List<User> find(User user){

        return hqDao.find(user);
    }


    public void add(User user) {

        hqDao.add(user);
    }

    public void update(User user) {

        hqDao.update(user);
    }

    public void delete(String id) {

        hqDao.delete(id);
    }
}
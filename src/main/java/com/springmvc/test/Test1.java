package com.springmvc.test;
//import com.springmvc.entity.User;

import com.springmvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.annotation.Resource;

public class Test1 {
        @Test
    public void testUser() {
        // 1. 加载Spring配置文件，根据创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        // 2. 得到配置创建的对象
        User user = (User) context.getBean("user");
        System.out.println(user.toString());

    }

    @Resource(name = "user")
    User user;

    @Test
    public void testUser2() {

        // 1. 加载Spring配置文件，根据创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        // 2. 得到配置创建的对象

        System.out.println(user.toString());

    }
}

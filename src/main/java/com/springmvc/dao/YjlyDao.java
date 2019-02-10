package com.springmvc.dao;

import com.springmvc.entity.Conference;
import com.springmvc.entity.Page;
import com.springmvc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository //@Repository用于注解Dao层
public interface YjlyDao {

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
}
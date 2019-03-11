package com.springmvc.dao;

import com.springmvc.entity.Place;
import com.springmvc.entity.Property;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 配置项实体类:会议级别/会议分类/会议属性
 */
@Repository //@Repository用于注解Dao层
public interface PropertyDao {

    /**
     * 查询所有配置项
     */
    List<Property> findAllProperty();

}
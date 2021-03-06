package com.springmvc.dao;

import com.springmvc.entity.Place;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 配置项:会议级别/会议分类/会议属性
 */
@Repository //@Repository用于注解Dao层
public interface PlaceDao {

    /**
     * 按单位查询所有会议室
     */
    List<Place> findPlaceByDW(Place place);

}
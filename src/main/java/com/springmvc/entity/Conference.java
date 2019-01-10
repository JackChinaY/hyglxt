package com.springmvc.entity;

import java.util.Date;

/**
 * 会议实体类
 */
public class Conference {

    //会议ID 32位UUID
    private String id;
    //会议时间
    private Date time;
    //会议承办单位
    private String danwei;
    //会议类型
    private String type;
    //会议名称
    private String theme;
    //会议状态
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

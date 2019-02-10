package com.springmvc.entity;

import java.util.Date;

/**
 * 分页实体类
 */
public class Page {
    //当前页面
    private int currPage;
    //每页大小
    private int pageSize;
    //偏移量
    private int offSet;
    //用户id
    private String userId;

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffSet() {
        return offSet;
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

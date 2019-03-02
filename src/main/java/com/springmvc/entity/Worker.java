package com.springmvc.entity;

/**
 * 教职工实体类
 */
public class Worker {

    //用户ID 32位UUID
    private String id;
    //姓名
    private String name;
    //性别
    private String sex;
    //归属单位学院
    private String danwei;
    //职务
    private String zhiwu;
    //职称
    private String zhicheng;
    //分管领域
    private String fgly;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public String getZhiwu() {
        return zhiwu;
    }

    public void setZhiwu(String zhiwu) {
        this.zhiwu = zhiwu;
    }

    public String getZhicheng() {
        return zhicheng;
    }

    public void setZhicheng(String zhicheng) {
        this.zhicheng = zhicheng;
    }

    public String getFgly() {
        return fgly;
    }

    public void setFgly(String fgly) {
        this.fgly = fgly;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", danwei='" + danwei + '\'' +
                ", zhiwu='" + zhiwu + '\'' +
                ", zhicheng='" + zhicheng + '\'' +
                ", fgly='" + fgly + '\'' +
                '}';
    }
}

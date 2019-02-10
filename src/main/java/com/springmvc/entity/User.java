package com.springmvc.entity;

/**
 * 用户实体类
 */
//@Component(value = "user")
public class User {

//    private static final long serialVersionUID = 1L;

    //用户ID 32位UUID
    private String id;
    //用户名
    private String username;
    //密码
    private String password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", danwei='" + danwei + '\'' +
                ", zhiwu='" + zhiwu + '\'' +
                ", zhicheng='" + zhicheng + '\'' +
                ", fgly='" + fgly + '\'' +
                '}';
    }
}

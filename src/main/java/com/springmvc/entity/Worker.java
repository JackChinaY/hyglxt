package com.springmvc.entity;

/**
 * 教职工实体类
 */
public class Worker {

    //用户ID 32位UUID
    private String id;
    //工号
    private String number;
    //姓名
    private String name;
    //性别
    private String sex;
    //管理服务部门/教学科研单位/驻校单位
    private String level1;
    //党委部门/行政部门/群团组织/教辅部门/后勤产业部门/专业学院/独立学院/科研单位/驻校单位
    private String level2;
    //归属单位学院
    private String danwei;
    //职务
    private String zhiwu;
    //职称
    private String zhicheng;
    //分管领域
    private String fgly;
    //办公电话
    private String bgdh;
    //手机号码
    private String sjhm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
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

    public String getBgdh() {
        return bgdh;
    }

    public void setBgdh(String bgdh) {
        this.bgdh = bgdh;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", level1='" + level1 + '\'' +
                ", level2='" + level2 + '\'' +
                ", danwei='" + danwei + '\'' +
                ", zhiwu='" + zhiwu + '\'' +
                ", zhicheng='" + zhicheng + '\'' +
                ", fgly='" + fgly + '\'' +
                ", bgdh='" + bgdh + '\'' +
                ", sjhm='" + sjhm + '\'' +
                '}';
    }
}

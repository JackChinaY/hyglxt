package com.springmvc.entity;

/**
 * 会议室实体类
 */
public class Place {

    //ID 32位UUID(36位)
    private String id;
    //归属单位学院
    private String dw;
    //名称
    private String name;
    //座位数
    private int zws;
    //空调(有/无)
    private String kt;
    //投影仪(有/无)
    private String tyy;
    //是否有麦克风(有/无)
    private String mkf;
    //是否有音响(有/无)
    private String yx;
    //是否有演讲台(有/无)
    private String yjt;
    //是否有照明设备(有/无)
    private String zm;
    //会议室地址
    private String dz;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZws() {
        return zws;
    }

    public void setZws(int zws) {
        this.zws = zws;
    }

    public String getKt() {
        return kt;
    }

    public void setKt(String kt) {
        this.kt = kt;
    }

    public String getTyy() {
        return tyy;
    }

    public void setTyy(String tyy) {
        this.tyy = tyy;
    }

    public String getMkf() {
        return mkf;
    }

    public void setMkf(String mkf) {
        this.mkf = mkf;
    }

    public String getYx() {
        return yx;
    }

    public void setYx(String yx) {
        this.yx = yx;
    }

    public String getYjt() {
        return yjt;
    }

    public void setYjt(String yjt) {
        this.yjt = yjt;
    }

    public String getZm() {
        return zm;
    }

    public void setZm(String zm) {
        this.zm = zm;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id='" + id + '\'' +
                ", dw='" + dw + '\'' +
                ", name='" + name + '\'' +
                ", zws=" + zws +
                ", kt='" + kt + '\'' +
                ", tyy='" + tyy + '\'' +
                ", mkf='" + mkf + '\'' +
                ", yx='" + yx + '\'' +
                ", yjt='" + yjt + '\'' +
                ", zm='" + zm + '\'' +
                ", dz='" + dz + '\'' +
                '}';
    }
}

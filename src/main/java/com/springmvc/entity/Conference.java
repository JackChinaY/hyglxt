package com.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 会议实体类
 */
public class Conference {

    //会议ID 32位UUID
    private String id;
    //会议名称
    private String hymc;
    //与会人员
    private String yhry;
    //开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date kssj;
    //结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date jssj;
    //会议地点
    private String hydd;
    //承办单位
    private String cbdw;
    //会议级别
    private String hyjb;
    //会议分类
    private String hyfl;
    //会议属性
    private String hysx;
    //会议正文
    private String yhzw;
    //图片路径
    private String tplj;
    //文档路径
    private String wdlj;
    //音频路径
    private String yplj;
    //视频路径
    private String splj;
    //会议状态
    private String hyzt;
    //记录状态
    private String jlzt;
    //记录员id
    private String jlyid;
    //记录员姓名
    private String jlyxm;
    //审核员id
    private String shyid;
    //审核员姓名
    private String shyxm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHymc() {
        return hymc;
    }

    public void setHymc(String hymc) {
        this.hymc = hymc;
    }

    public String getYhry() {
        return yhry;
    }

    public void setYhry(String yhry) {
        this.yhry = yhry;
    }

    public Date getKssj() {
        return kssj;
    }

    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    public Date getJssj() {
        return jssj;
    }

    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    public String getHydd() {
        return hydd;
    }

    public void setHydd(String hydd) {
        this.hydd = hydd;
    }

    public String getCbdw() {
        return cbdw;
    }

    public void setCbdw(String cbdw) {
        this.cbdw = cbdw;
    }

    public String getHyjb() {
        return hyjb;
    }

    public void setHyjb(String hyjb) {
        this.hyjb = hyjb;
    }

    public String getHyfl() {
        return hyfl;
    }

    public void setHyfl(String hyfl) {
        this.hyfl = hyfl;
    }

    public String getHysx() {
        return hysx;
    }

    public void setHysx(String hysx) {
        this.hysx = hysx;
    }

    public String getYhzw() {
        return yhzw;
    }

    public void setYhzw(String yhzw) {
        this.yhzw = yhzw;
    }

    public String getTplj() {
        return tplj;
    }

    public void setTplj(String tplj) {
        this.tplj = tplj;
    }

    public String getWdlj() {
        return wdlj;
    }

    public void setWdlj(String wdlj) {
        this.wdlj = wdlj;
    }

    public String getYplj() {
        return yplj;
    }

    public void setYplj(String yplj) {
        this.yplj = yplj;
    }

    public String getSplj() {
        return splj;
    }

    public void setSplj(String splj) {
        this.splj = splj;
    }

    public String getHyzt() {
        return hyzt;
    }

    public void setHyzt(String hyzt) {
        this.hyzt = hyzt;
    }

    public String getJlzt() {
        return jlzt;
    }

    public void setJlzt(String jlzt) {
        this.jlzt = jlzt;
    }

    public String getJlyid() {
        return jlyid;
    }

    public void setJlyid(String jlyid) {
        this.jlyid = jlyid;
    }

    public String getJlyxm() {
        return jlyxm;
    }

    public void setJlyxm(String jlyxm) {
        this.jlyxm = jlyxm;
    }

    public String getShyid() {
        return shyid;
    }

    public void setShyid(String shyid) {
        this.shyid = shyid;
    }

    public String getShyxm() {
        return shyxm;
    }

    public void setShyxm(String shyxm) {
        this.shyxm = shyxm;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id='" + id + '\'' +
                ", hymc='" + hymc + '\'' +
                ", yhry='" + yhry + '\'' +
                ", kssj=" + kssj +
                ", jssj=" + jssj +
                ", hydd='" + hydd + '\'' +
                ", cbdw='" + cbdw + '\'' +
                ", hyjb='" + hyjb + '\'' +
                ", hyfl='" + hyfl + '\'' +
                ", hysx='" + hysx + '\'' +
                ", yhzw='" + yhzw + '\'' +
                ", tplj='" + tplj + '\'' +
                ", wdlj='" + wdlj + '\'' +
                ", yplj='" + yplj + '\'' +
                ", splj='" + splj + '\'' +
                ", hyzt='" + hyzt + '\'' +
                ", jlzt='" + jlzt + '\'' +
                ", jlyid='" + jlyid + '\'' +
                ", jlyxm='" + jlyxm + '\'' +
                ", shyid='" + shyid + '\'' +
                ", shyxm='" + shyxm + '\'' +
                '}';
    }
}

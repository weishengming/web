package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 文章DO
 */
@Entity
@Table(name = "wenzhang")
public class WenZhangDO extends BaseDO{

    private static final long serialVersionUID = 1L;
    private String fubiaoti;
    private String biaoti;
    private String laiyuan;
    private String zuozhe;
    private String paixu;
    private String gaishu;
    private String neirong;
    public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }
    public String getGaishu() {
        return gaishu;
    }
    public void setGaishu(String gaishu) {
        this.gaishu = gaishu;
    }
    public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
    public String getPaixu() {
        return paixu;
    }
    public void setPaixu(String paixu) {
        this.paixu = paixu;
    }
    public String getFubiaoti() {
        return fubiaoti;
    }
    public void setFubiaoti(String fubiaoti) {
        this.fubiaoti = fubiaoti;
    }

    public String getLaiyuan() {
        return laiyuan;
    }
    public void setLaiyuan(String laiyuan) {
        this.laiyuan = laiyuan;
    }
    public String getZuozhe() {
        return zuozhe;
    }
    public void setZuozhe(String zuozhe) {
        this.zuozhe = zuozhe;
    }
}

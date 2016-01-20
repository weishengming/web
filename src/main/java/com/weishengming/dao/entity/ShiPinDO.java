package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 视频DO
 */
@Entity
@Table(name = "shipin")
public class ShiPinDO extends BaseDO{
	private static final long serialVersionUID = 1L;
	private String tudousrc;// 土豆地址
	private String fubiaoti;//父标题
	private String biaoti;//标题
	private String miaoshu; //视频描述
    private String dijige;
	public String getTudousrc() {
		return tudousrc;
	}
	public void setTudousrc(String tudousrc) {
		this.tudousrc = tudousrc;
	}
	public String getFubiaoti() {
		return fubiaoti;
	}
	public void setFubiaoti(String fubiaoti) {
		this.fubiaoti = fubiaoti;
	}
	public String getBiaoti() {
		return biaoti;
	}
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	public String getMiaoshu() {
		return miaoshu;
	}
	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	public String getDijige() {
		return dijige;
	}
	public void setDijige(String dijige) {
		this.dijige = dijige;
	}
    

}

package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 我需要帮助
 */
@Entity
@Table(name = "bangzhu")
public class BangZhuDO extends BaseDO {
	private static final long serialVersionUID = 1L;
	private String openID; 
	private String nickname; 
	
	private Long   dixiongzimeiid;
	private String dixiongzimeixingming;
	
	private String biaoti;
	private String neirong;
	private String leixing; 
	private String zhuangtai;  //新发布的 已接近的  作废的
	
	
	public String getBiaoti() {
		return biaoti;
	}
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Long getDixiongzimeiid() {
		return dixiongzimeiid;
	}
	public void setDixiongzimeiid(Long dixiongzimeiid) {
		this.dixiongzimeiid = dixiongzimeiid;
	}
	public String getDixiongzimeixingming() {
		return dixiongzimeixingming;
	}
	public void setDixiongzimeixingming(String dixiongzimeixingming) {
		this.dixiongzimeixingming = dixiongzimeixingming;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	
	
	
}

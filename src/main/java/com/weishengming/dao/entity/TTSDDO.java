package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 谈天说地DO
 */
@Entity
@Table(name = "ttsd")
public class TTSDDO extends BaseDO{

	private static final long serialVersionUID = 1L;
	private String dijige;   //是第几个
	private String biaoti;   //2.捡石头
	private String fubiaoti; //心海拾贝
	private String neirong;
	private String maoji;//锚记 #jianshitong
	
	
	public String getDijige() {
		return dijige;
	}
	public void setDijige(String dijige) {
		this.dijige = dijige;
	}
	public String getMaoji() {
		return maoji;
	}
	public void setMaoji(String maoji) {
		this.maoji = maoji;
	}
	public String getBiaoti() {
		return biaoti;
	}
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	public String getFubiaoti() {
		return fubiaoti;
	}
	public void setFubiaoti(String fubiaoti) {
		this.fubiaoti = fubiaoti;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}  
}

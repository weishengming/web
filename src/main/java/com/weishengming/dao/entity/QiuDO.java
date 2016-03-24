package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 求
 */
@Entity
@Table(name = "qiu")
public class QiuDO extends BaseDO {
	private static final long serialVersionUID = 1L;
	private String openID; 
	private String neirong;
	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	
	
}

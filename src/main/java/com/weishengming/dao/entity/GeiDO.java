package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 给
 */
@Entity
@Table(name = "gei")
public class GeiDO extends BaseDO {
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

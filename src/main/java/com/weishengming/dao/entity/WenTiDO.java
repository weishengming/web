package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 问题
 */
@Entity
@Table(name = "wenti")
public class WenTiDO extends BaseDO{
	private static final long serialVersionUID = 1L;
	private String openID;
	private String nickname;
	private String wenti; //问题
	
	
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
	public String getWenti() {
		return wenti;
	}
	public void setWenti(String wenti) {
		this.wenti = wenti;
	}

}

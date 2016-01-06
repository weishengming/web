package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author 杨天赐
 * 地区表
 */
@Entity
@Table(name = "qq")
public class QQDO extends BaseDO{

	private static final long serialVersionUID = 1L;
	private String openID;
	private String nickname;
	private String gender;
	private String imgsrc30;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImgsrc30() {
		return imgsrc30;
	}
	public void setImgsrc30(String imgsrc30) {
		this.imgsrc30 = imgsrc30;
	}
	

}

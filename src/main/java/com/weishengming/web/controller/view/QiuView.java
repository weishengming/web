package com.weishengming.web.controller.view;

import java.io.Serializable;

public class QiuView implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String openID;
	private String neirong;
	private String nickname;
	private String imgsrc30;
	
	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getImgsrc30() {
		return imgsrc30;
	}
	public void setImgsrc30(String imgsrc30) {
		this.imgsrc30 = imgsrc30;
	}
	 
	
	

}		

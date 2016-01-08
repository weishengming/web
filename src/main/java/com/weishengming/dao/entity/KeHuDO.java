package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author 杨天赐
 * 客户表
 */
@Entity
@Table(name = "kehu")
public class KeHuDO extends BaseDO{
	private static final long serialVersionUID = 1L;
	private String   openID;           //openID
	private String   nickname;
	private String   xingming;       //姓名
	private String   shoujihao;     //手机号  //必填
	private String   qq;           //qq号  //必填
	private String   weixinhao;   //微信号
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
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	 
	public String getShoujihao() {
		return shoujihao;
	}
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixinhao() {
		return weixinhao;
	}
	public void setWeixinhao(String weixinhao) {
		this.weixinhao = weixinhao;
	}
}

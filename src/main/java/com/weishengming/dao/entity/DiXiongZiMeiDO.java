package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 弟兄姊妹
 */
@Entity
@Table(name = "dixiongzimei")
public class DiXiongZiMeiDO extends BaseDO{

	private static final long serialVersionUID = 1L;

	private String openID;           //openID
	private String nickname;
	
	private String xingbie; //性别
	private String shengri; //生日
	private String shoujihao;
	private String xingming;
	private String qq;
	private String weixinhao;
	private String weibohao;
	private String leixing; //程度
	
	private String beizhu;
	
	public String getXingbie() {
		return xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getShengri() {
		return shengri;
	}

	public void setShengri(String shengri) {
		this.shengri = shengri;
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

	public String getShoujihao() {
		return shoujihao;
	}

	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}

	public String getXingming() {
		return xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
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

	public String getWeibohao() {
		return weibohao;
	}

	public void setWeibohao(String weibohao) {
		this.weibohao = weibohao;
	}

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

}

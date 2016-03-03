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
	private String openID;           
	private String nickname;
	
	private String xingming;  
	private String xingbie;  
	private String nianling;  
	private String shoujihao;  
	private String qq;  
	private String weixinhao;  
	private String shenfen;  
	private String qita;  
	private String suoding;  
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
	public String getXingbie() {
		return xingbie;
	}
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	public String getNianling() {
		return nianling;
	}
	public void setNianling(String nianling) {
		this.nianling = nianling;
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
	public String getShenfen() {
		return shenfen;
	}
	public void setShenfen(String shenfen) {
		this.shenfen = shenfen;
	}
	public String getQita() {
		return qita;
	}
	public void setQita(String qita) {
		this.qita = qita;
	}
	public String getSuoding() {
		return suoding;
	}
	public void setSuoding(String suoding) {
		this.suoding = suoding;
	}
	
}

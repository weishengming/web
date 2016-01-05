package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author 杨天赐
 * 回答  一个问题对应多个回答
 */
@Entity
@Table(name = "huida")
public class HuiDaDO extends BaseDO{
	private static final long serialVersionUID = 1L;
	private Long   wentiid;            //这条问题id
	private String wenti;              //问题内容也不是很多,也直接拿过来把
	
	private Long   wentikehuid;        //问题的提问人id
	private String wentikehuzhanghao;  //问题提问人账号
	private Long   huidakehuid;        //问题回答人id
	private String huidakehuzhanghao;  //问题的回答人账号
	private String huida;              //回答
	
	public String getWenti() {
		return wenti;
	}
	public void setWenti(String wenti) {
		this.wenti = wenti;
	}
	public Long getWentiid() {
		return wentiid;
	}
	public void setWentiid(Long wentiid) {
		this.wentiid = wentiid;
	}
	public Long getWentikehuid() {
		return wentikehuid;
	}
	public void setWentikehuid(Long wentikehuid) {
		this.wentikehuid = wentikehuid;
	}
	public String getWentikehuzhanghao() {
		return wentikehuzhanghao;
	}
	public void setWentikehuzhanghao(String wentikehuzhanghao) {
		this.wentikehuzhanghao = wentikehuzhanghao;
	}
	public Long getHuidakehuid() {
		return huidakehuid;
	}
	public void setHuidakehuid(Long huidakehuid) {
		this.huidakehuid = huidakehuid;
	}
	public String getHuidakehuzhanghao() {
		return huidakehuzhanghao;
	}
	public void setHuidakehuzhanghao(String huidakehuzhanghao) {
		this.huidakehuzhanghao = huidakehuzhanghao;
	}
	public String getHuida() {
		return huida;
	}
	public void setHuida(String huida) {
		this.huida = huida;
	}
}

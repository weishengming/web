package com.weishengming.web.view;

import java.io.Serializable;

public class KeHuView implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String xingming;
	private String qq;
	private String shoujihao;
	private String zhanghao;
	public String getZhanghao() {
		return zhanghao;
	}
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getShoujihao() {
		return shoujihao;
	}
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
}

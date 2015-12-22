package com.weishengming.web.entity;

/**
 * @author 杨天赐
 * 跟客户的关系
 */
public class GuanXiDO {
	
	private String id;
	private String kehu_id;
	private String guanxi; //关系 [参考关系名称枚举]
	private String xingming; //姓名
	private String shoujihao;// 手机号
	private String shoujihao1;// 手机号1
	private String shoujihao2;// 手机号1
	private String qq;//qq号
	private String qq1;//qq号1
	private String qq2;//qq号1
	private String email;//email;
	private String email1;//email 1;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKehu_id() {
		return kehu_id;
	}
	public void setKehu_id(String kehu_id) {
		this.kehu_id = kehu_id;
	}
	public String getGuanxi() {
		return guanxi;
	}
	public void setGuanxi(String guanxi) {
		this.guanxi = guanxi;
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
	public String getShoujihao1() {
		return shoujihao1;
	}
	public void setShoujihao1(String shoujihao1) {
		this.shoujihao1 = shoujihao1;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getQq1() {
		return qq1;
	}
	public void setQq1(String qq1) {
		this.qq1 = qq1;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getShoujihao2() {
		return shoujihao2;
	}
	public void setShoujihao2(String shoujihao2) {
		this.shoujihao2 = shoujihao2;
	}
	public String getQq2() {
		return qq2;
	}
	public void setQq2(String qq2) {
		this.qq2 = qq2;
	}
	

}

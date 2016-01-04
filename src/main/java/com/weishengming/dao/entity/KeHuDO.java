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
	private String   zhanghao;             //手机号,qq
	private String   mima;                //密码
	private String   mimamd5;            //密码MD5
	
	private String   xingming;         //姓名
	private String   xingbie;         //性别 直接存  男 和 女
	private String   shengri;        //生日yyyy-mm-dd
	private String   shenfenzheng;  //身份证号
	
	private String   shoujihao;   //手机号  //必填
	private String   qq;         //qq号  //必填
	private String   weixinhao; //微信号
	
    private Boolean  enabled; // 是否有效

	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}

	public String getMima() {
		return mima;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}

	public String getMimamd5() {
		return mimamd5;
	}

	public void setMimamd5(String mimamd5) {
		this.mimamd5 = mimamd5;
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

	public String getShengri() {
		return shengri;
	}

	public void setShengri(String shengri) {
		this.shengri = shengri;
	}

	public String getShenfenzheng() {
		return shenfenzheng;
	}

	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
    
    
}

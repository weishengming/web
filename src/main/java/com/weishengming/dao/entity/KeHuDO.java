package com.weishengming.dao.entity;

import java.util.Date;

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
	private Long   areaid;   //默认地址
	private String zhanghao; // 手机号,邮箱,qq [openId]
	private String mima;     //密码
	private String mimamd5;  //密码MD5
	
	private String xingming;     //姓名
	private String nicheng;      //昵称
	private String xingbie;      //性别
	private String shengri;      //生日yyyy-mm-dd
	private String zhiye;        //职业 [参考职业类型]
	private String shenfenzheng; //身份证号
	private String email;        //邮箱
	
	
	private String shoujihao;  //手机号
	private String shoujihao1; //手机号

	private String qq;  //qq号
	private String qq1; //qq号
	
	private String weixinhao; //微信号
	private String weibohao; // 微博号
	
	private String    zhuangtai;        //客户状态  注册  基本信息提交   基本信息认证 通过
	private String zhuangtaistring;  //状态字符串
	
    private Boolean  enabled;   // 是否有效
	
	private String    leixing; //客户类型  [参考kehuliexing枚举]
	private String leixingstring; 
	private String beizhu;  //客户的自己备注信息 
	
	
	public Long getAreaid() {
		return areaid;
	}
	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}
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
	public String getNicheng() {
		return nicheng;
	}
	public void setNicheng(String nicheng) {
		this.nicheng = nicheng;
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
	public String getZhiye() {
		return zhiye;
	}
	public void setZhiye(String zhiye) {
		this.zhiye = zhiye;
	}
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
 
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	public String getZhuangtaistring() {
		return zhuangtaistring;
	}
	public void setZhuangtaistring(String zhuangtaistring) {
		this.zhuangtaistring = zhuangtaistring;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
 
	public String getLeixingstring() {
		return leixingstring;
	}
	public void setLeixingstring(String leixingstring) {
		this.leixingstring = leixingstring;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
}

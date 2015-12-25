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
	private String zhanghao;// 手机号,邮箱,qq [openId]
	private String mima;  //密码
	private String mima_md5;  //密码MD5
	
	private String xingming;  //姓名
	private String xingbie;   //性别
	private String nianling;  //年龄
	private String shengri;   //生日yyyy-mm-dd
	private String zhiye;     //职业 [参考职业类型]
	private String shenfenzheng; //身份证号
	private String email; //邮箱
	private String nicheng; //昵称
	
	private String shoujihao; //手机号
	private String shoujihao1; //手机号
	private String shoujihao2; //手机号

	private String qq; //qq号
	private String qq1; //qq号
	private String qq2; //qq号
	private String weixinhao; //微信号

	
	private String suozaiguo;//   所在国[默认中国]
	private String suozaisheng;//所在省
	private String suozaishi;//所在市
	private String suozaixian;//所在县/区
	private String suozaidixiangxi; //所在地详细地址
	
	private String yuanjiguo; //原籍国 [默认中国]
	private String yuanjisheng; //原籍省
	private String yuanjishi; //原籍市
	private String yuanjixian; //原籍县/区
	private String yuanjixiangxi; // 原籍详细地址
	
	private int zhuangtai;   //客户状态  注册  基本信息提交   基本信息认证 通过
	private String zhuangtai_string;  //状态字符串
	
    private Boolean  enabled;                                 // 是否有效
	
	private int leixing; //客户类型  [参考kehuliexing枚举]
	private String leixing_string; 
	private String beizhu;  //客户的自己备注信息 
	
	
	
 
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public int getLeixing() {
		return leixing;
	}
	public void setLeixing(int leixing) {
		this.leixing = leixing;
	}
	public String getLeixing_string() {
		return leixing_string;
	}
	public void setLeixing_string(String leixing_string) {
		this.leixing_string = leixing_string;
	}
	public int getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(int zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getZhuangtai_string() {
		return zhuangtai_string;
	}
	public void setZhuangtai_string(String zhuangtai_string) {
		this.zhuangtai_string = zhuangtai_string;
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
	public String getMima_md5() {
		return mima_md5;
	}
	public void setMima_md5(String mima_md5) {
		this.mima_md5 = mima_md5;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getNicheng() {
		return nicheng;
	}
	public void setNicheng(String nicheng) {
		this.nicheng = nicheng;
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
	public String getShoujihao2() {
		return shoujihao2;
	}
	public void setShoujihao2(String shoujihao2) {
		this.shoujihao2 = shoujihao2;
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
	public String getQq2() {
		return qq2;
	}
	public void setQq2(String qq2) {
		this.qq2 = qq2;
	}
	public String getWeixinhao() {
		return weixinhao;
	}
	public void setWeixinhao(String weixinhao) {
		this.weixinhao = weixinhao;
	}
	public String getSuozaiguo() {
		return suozaiguo;
	}
	public void setSuozaiguo(String suozaiguo) {
		this.suozaiguo = suozaiguo;
	}
	public String getSuozaisheng() {
		return suozaisheng;
	}
	public void setSuozaisheng(String suozaisheng) {
		this.suozaisheng = suozaisheng;
	}
	public String getSuozaishi() {
		return suozaishi;
	}
	public void setSuozaishi(String suozaishi) {
		this.suozaishi = suozaishi;
	}
	public String getSuozaixian() {
		return suozaixian;
	}
	public void setSuozaixian(String suozaixian) {
		this.suozaixian = suozaixian;
	}
	public String getSuozaidixiangxi() {
		return suozaidixiangxi;
	}
	public void setSuozaidixiangxi(String suozaidixiangxi) {
		this.suozaidixiangxi = suozaidixiangxi;
	}
	public String getYuanjiguo() {
		return yuanjiguo;
	}
	public void setYuanjiguo(String yuanjiguo) {
		this.yuanjiguo = yuanjiguo;
	}
	public String getYuanjisheng() {
		return yuanjisheng;
	}
	public void setYuanjisheng(String yuanjisheng) {
		this.yuanjisheng = yuanjisheng;
	}
	public String getYuanjishi() {
		return yuanjishi;
	}
	public void setYuanjishi(String yuanjishi) {
		this.yuanjishi = yuanjishi;
	}
	public String getYuanjixian() {
		return yuanjixian;
	}
	public void setYuanjixian(String yuanjixian) {
		this.yuanjixian = yuanjixian;
	}
	public String getYuanjixiangxi() {
		return yuanjixiangxi;
	}
	public void setYuanjixiangxi(String yuanjixiangxi) {
		this.yuanjixiangxi = yuanjixiangxi;
	}
 
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
}

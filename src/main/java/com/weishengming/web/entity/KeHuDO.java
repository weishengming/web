package com.weishengming.web.entity;

/**
 * @author 杨天赐
 * 客户表
 */
public class KeHuDO {
	
	private String id; 
	private String xingming;  //姓名
	private String nianling;  //年龄
	private String shengri;   //生日yyyy-mm-dd
	private String zhiye;     //职业 [参考职业类型]
	private String xingbie;   //性别
	private String zhuceshijian_string; //注册时间字符串
	private String xiugaishijian_string; //修改时间字符串
	private String shoujihao; //手机号
	private String shoujihao1; //手机号
	private String shoujihao2; //手机号
	private String shoujihao3; //手机号
	private String shenfenzheng; //身份证号
	private String qq; //qq号
	private String qq1; //qq号
	private String qq2; //qq号
	private String qq3; //qq号
	private String weixin; //微信号
	private String qqkongjiandizhi; //qq空间地址
	private String email; //邮箱
	private String nicheng; //昵称
	
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
	
	private String kehuleixing; //客户类型  [参考kehuliexing枚举]
	private String kehubeizhu;  //客户的自己备注信息  
	
	
	

}

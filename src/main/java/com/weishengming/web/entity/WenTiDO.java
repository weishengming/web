package com.weishengming.web.entity;

/**
 * @author 杨天赐
 * 客户提的问题   一个用户可以提多个问题.
 */
public class WenTiDO {
	private String id;
	private String tiwen_kehu_id;
	private String tiwen_biaoti; //标题
	private String tiwen_miaoshu; //描述
	private String tijiaoshijian_string;//提交时间
	
	private String huida_kehu_id; //回答人的id
	private String huida_nirong;  //回答人的内容

}

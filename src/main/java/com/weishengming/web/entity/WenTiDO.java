package com.weishengming.web.entity;

/**
 * @author 杨天赐
 * 客户提的问题   一个用户可以提多个问题.
 */
public class WenTiDO {
	private String id;
	private String tiwen_kehu_id;
	private String tiwen_biaoti; //标题
	private String wentileixing; //问题的类型 [参考问题类型 枚举]
	private String tiwen_miaoshu; //描述
	private String tijiaoshijian_string;//提交时间
	private String zhaojichengxu; //问题的着急程度 [1不着急,2很着急,3特别着急,4马上向得到答案]
	private String zhaojichengxu_string;
	private String weitizhuangtai; //问题状态 [1 已解决 2.正在解决 3 已解决] 数字用来排序
	private String weitizhuangtai_string;
	
	
	
 
	public String getWeitizhuangtai() {
		return weitizhuangtai;
	}
	public void setWeitizhuangtai(String weitizhuangtai) {
		this.weitizhuangtai = weitizhuangtai;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTiwen_kehu_id() {
		return tiwen_kehu_id;
	}
	public void setTiwen_kehu_id(String tiwen_kehu_id) {
		this.tiwen_kehu_id = tiwen_kehu_id;
	}
	public String getTiwen_biaoti() {
		return tiwen_biaoti;
	}
	public void setTiwen_biaoti(String tiwen_biaoti) {
		this.tiwen_biaoti = tiwen_biaoti;
	}
	public String getWentileixing() {
		return wentileixing;
	}
	public void setWentileixing(String wentileixing) {
		this.wentileixing = wentileixing;
	}
	public String getTiwen_miaoshu() {
		return tiwen_miaoshu;
	}
	public void setTiwen_miaoshu(String tiwen_miaoshu) {
		this.tiwen_miaoshu = tiwen_miaoshu;
	}
	public String getTijiaoshijian_string() {
		return tijiaoshijian_string;
	}
	public void setTijiaoshijian_string(String tijiaoshijian_string) {
		this.tijiaoshijian_string = tijiaoshijian_string;
	}
	public String getZhaojichengxu() {
		return zhaojichengxu;
	}
	public void setZhaojichengxu(String zhaojichengxu) {
		this.zhaojichengxu = zhaojichengxu;
	}
	
	

}

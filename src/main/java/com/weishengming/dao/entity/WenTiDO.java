package com.weishengming.dao.entity;

/**
 * @author 杨天赐
 * 客户提的问题   一个用户可以提多个问题.
 */
public class WenTiDO {
	private String id;
	private String wentileixing_id; //问题类型   [参照问题类型的表]
	private String kehu_id; //问题的发起人
	private String biaoti; //标题
	private String miaoshu; //描述
	private String zhaojichengdu; //问题的着急程度 [1不着急,2很着急,3特别着急,4马上向得到答案]
	private String zhaojichengdu_string;
	private String zhuangtai; //问题状态 [1 已解决 2.正在解决 3 已解决] 数字用来排序
	private String zhuangtai_string;
	private String tijiaoshijian_string;//提交时间
	private String xiugaishijian_string;
	
	public String getWentileixing_id() {
		return wentileixing_id;
	}
	public void setWentileixing_id(String wentileixing_id) {
		this.wentileixing_id = wentileixing_id;
	}
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
	public String getBiaoti() {
		return biaoti;
	}
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	public String getMiaoshu() {
		return miaoshu;
	}
	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	public String getTijiaoshijian_string() {
		return tijiaoshijian_string;
	}
	public void setTijiaoshijian_string(String tijiaoshijian_string) {
		this.tijiaoshijian_string = tijiaoshijian_string;
	}
	public String getZhaojichengdu() {
		return zhaojichengdu;
	}
	public void setZhaojichengdu(String zhaojichengdu) {
		this.zhaojichengdu = zhaojichengdu;
	}
	public String getZhaojichengdu_string() {
		return zhaojichengdu_string;
	}
	public void setZhaojichengdu_string(String zhaojichengdu_string) {
		this.zhaojichengdu_string = zhaojichengdu_string;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getZhuangtai_string() {
		return zhuangtai_string;
	}
	public void setZhuangtai_string(String zhuangtai_string) {
		this.zhuangtai_string = zhuangtai_string;
	}
	public String getXiugaishijian_string() {
		return xiugaishijian_string;
	}
	public void setXiugaishijian_string(String xiugaishijian_string) {
		this.xiugaishijian_string = xiugaishijian_string;
	}
	
	
	 
}

package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 类型表
 *
 */
@Entity
@Table(name = "leixing")
public class LeiXingDO extends BaseDO{

	private static final long serialVersionUID = 1L;
	private String mingcheng;
	private Long   fuid; //上级id
	private String fumingcheng; //上级名称
	private String jibie;  // 0 root  1 级类型 
	private String paixu;  //排序  0 1 2 3 4 5 6 
	private String shifouqiyong; //是否启用   1 启动   0 代表未启用
	public String getJibie() {
		return jibie;
	}
	public void setJibie(String jibie) {
		this.jibie = jibie;
	}
	public String getMingcheng() {
		return mingcheng;
	}
	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	public Long getFuid() {
		return fuid;
	}
	public void setFuid(Long fuid) {
		this.fuid = fuid;
	}
	public String getFumingcheng() {
		return fumingcheng;
	}
	public void setFumingcheng(String fumingcheng) {
		this.fumingcheng = fumingcheng;
	}
	public String getPaixu() {
		return paixu;
	}
	public void setPaixu(String paixu) {
		this.paixu = paixu;
	}
	public String getShifouqiyong() {
		return shifouqiyong;
	}
	public void setShifouqiyong(String shifouqiyong) {
		this.shifouqiyong = shifouqiyong;
	}

}

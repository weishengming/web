package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 数据字典
 */
@Entity
@Table(name = "shujuzidian")
public class ShuJuZiDianDO extends BaseDO{

	private static final long serialVersionUID = 1L;
	 
	private Long fuid;
	private String neirong;
	private String paixu;
	
	public Long getFuid() {
		return fuid;
	}
	public void setFuid(Long fuid) {
		this.fuid = fuid;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public String getPaixu() {
		return paixu;
	}
	public void setPaixu(String paixu) {
		this.paixu = paixu;
	}
	
	
}

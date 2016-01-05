package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 问题
 */
@Entity
@Table(name = "wenti")
public class WenTiDO extends BaseDO{
	private static final long serialVersionUID = 1L;
	private Long   kehuid;//客户的id
	private String kehuzhanghao; //客户账号
	private String wenti; //问题
	
	public Long getKehuid() {
		return kehuid;
	}
	public void setKehuid(Long kehuid) {
		this.kehuid = kehuid;
	}
	public String getKehuzhanghao() {
		return kehuzhanghao;
	}
	public void setKehuzhanghao(String kehuzhanghao) {
		this.kehuzhanghao = kehuzhanghao;
	}
	public String getWenti() {
		return wenti;
	}
	public void setWenti(String wenti) {
		this.wenti = wenti;
	}

}

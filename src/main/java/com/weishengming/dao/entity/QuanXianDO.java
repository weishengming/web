package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 权限表
 */
@Entity
@Table(name = "quanxian")
public class QuanXianDO extends BaseDO {

	private static final long serialVersionUID = 1L;
    private String            quanxianmingcheng;
    private Long              fujiedian_id;
	 
	 
	public Long getFujiedian_id() {
		return fujiedian_id;
	}
	public void setFujiedian_id(Long fujiedian_id) {
		this.fujiedian_id = fujiedian_id;
	}
	public String getQuanxianmingcheng() {
		return quanxianmingcheng;
	}
	public void setQuanxianmingcheng(String quanxianmingcheng) {
		this.quanxianmingcheng = quanxianmingcheng;
	}
	
	
	 

}

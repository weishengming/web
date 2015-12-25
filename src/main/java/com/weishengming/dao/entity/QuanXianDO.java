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
    private Long              parentid;
	 
	 
	 
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	public String getQuanxianmingcheng() {
		return quanxianmingcheng;
	}
	public void setQuanxianmingcheng(String quanxianmingcheng) {
		this.quanxianmingcheng = quanxianmingcheng;
	}
	
	
	 

}

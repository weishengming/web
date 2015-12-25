package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 角色表
 */
@Entity
@Table(name = "juese")
public class JueSeDO extends BaseDO {

	private static final long serialVersionUID = 1L;
	private String juesemingcheng; //角色名称 
    private Long   parentid;  //如果有的话 需要加上 父节点的id
	public String getJuesemingcheng() {
		return juesemingcheng;
	}
	public void setJuesemingcheng(String juesemingcheng) {
		this.juesemingcheng = juesemingcheng;
	}
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
 
	 

}

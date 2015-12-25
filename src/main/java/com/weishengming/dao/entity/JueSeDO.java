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
    private Long   fujiedian_id;  //如果有的话 需要加上 父节点的id
	public String getJuesemingcheng() {
		return juesemingcheng;
	}
	public void setJuesemingcheng(String juesemingcheng) {
		this.juesemingcheng = juesemingcheng;
	}
	public Long getFujiedian_id() {
		return fujiedian_id;
	}
	public void setFujiedian_id(Long fujiedian_id) {
		this.fujiedian_id = fujiedian_id;
	}
	 

}

package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 角色权限表    [客户账号 全局唯一]
 */
@Entity
@Table(name = "juese_quanxian") //一个角色 有多个权限
public class JueSeQuanXianDO extends BaseDO {

	private static final long serialVersionUID = 1L;
    private Long            juese_id;
    private Long            quanxian_id;
    private String          juesemingcheng;
    private String          quanxianmingcheng;   
	public String getJuesemingcheng() {
		return juesemingcheng;
	}
	public void setJuesemingcheng(String juesemingcheng) {
		this.juesemingcheng = juesemingcheng;
	}
	public Long getQuanxian_id() {
		return quanxian_id;
	}
	public void setQuanxian_id(Long quanxian_id) {
		this.quanxian_id = quanxian_id;
	}
	public String getQuanxianmingcheng() {
		return quanxianmingcheng;
	}
	public void setQuanxianmingcheng(String quanxianmingcheng) {
		this.quanxianmingcheng = quanxianmingcheng;
	}
	public Long getJuese_id() {
		return juese_id;
	}
	public void setJuese_id(Long juese_id) {
		this.juese_id = juese_id;
	}  
}

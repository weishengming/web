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
    private Long            jueseid;
    private Long            quanxianid;
    private String          juesemingcheng;
    private String          quanxianmingcheng;
	public Long getJueseid() {
		return jueseid;
	}
	public void setJueseid(Long jueseid) {
		this.jueseid = jueseid;
	}
	public Long getQuanxianid() {
		return quanxianid;
	}
	public void setQuanxianid(Long quanxianid) {
		this.quanxianid = quanxianid;
	}
	public String getJuesemingcheng() {
		return juesemingcheng;
	}
	public void setJuesemingcheng(String juesemingcheng) {
		this.juesemingcheng = juesemingcheng;
	}
	public String getQuanxianmingcheng() {
		return quanxianmingcheng;
	}
	public void setQuanxianmingcheng(String quanxianmingcheng) {
		this.quanxianmingcheng = quanxianmingcheng;
	}   
	 
}

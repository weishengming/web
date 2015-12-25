package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 角色  客户 表
 */
@Entity
@Table(name = "kehu_juese")   // 一个客户  可以 有多个角色
public class KeHuJueSeDO extends BaseDO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long              jueseid;
    private Long              kehuid;
    private String            kehuzhanghao;  //客户账号
    private String            kehuxingming;
    private String            juesemingcheng; //角色名称
    
    
 
	public Long getJueseid() {
		return jueseid;
	}
	public void setJueseid(Long jueseid) {
		this.jueseid = jueseid;
	}
	public Long getKehuid() {
		return kehuid;
	}
	public void setKehuid(Long kehuid) {
		this.kehuid = kehuid;
	}
	public String getKehuxingming() {
		return kehuxingming;
	}
	public void setKehuxingming(String kehuxingming) {
		this.kehuxingming = kehuxingming;
	}
	public String getJuesemingcheng() {
		return juesemingcheng;
	}
	public void setJuesemingcheng(String juesemingcheng) {
		this.juesemingcheng = juesemingcheng;
	}
	public String getKehuzhanghao() {
		return kehuzhanghao;
	}
	public void setKehuzhanghao(String kehuzhanghao) {
		this.kehuzhanghao = kehuzhanghao;
	}
 

}

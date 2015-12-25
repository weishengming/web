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
	private Long              juese_id;
    private Long              kehu_id;
    private String            kehuzhanghao;  //客户账号
    private String            juesemingcheng; //角色名称
    
    
	public Long getKehu_id() {
		return kehu_id;
	}
	public void setKehu_id(Long kehu_id) {
		this.kehu_id = kehu_id;
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
	public Long getJuese_id() {
		return juese_id;
	}
	public void setJuese_id(Long juese_id) {
		this.juese_id = juese_id;
	}

}

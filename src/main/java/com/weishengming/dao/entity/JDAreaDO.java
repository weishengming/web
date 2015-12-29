package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * @author 杨天赐
 * 
 */
@Entity
@Table(name = "jd_area")
public class JDAreaDO  extends BaseDO {
	private static final long serialVersionUID = 1L;
	private String parentId;
	private String areaId;
	private String areaName;
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}

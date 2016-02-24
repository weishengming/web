package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 教堂表
 */
@Entity
@Table(name = "jiaotang")
public class JiaoTangDO extends BaseDO{
	private static final long serialVersionUID = 1L;
	
	private String openID;           //openID
	private String nickname;         // 这两个字段代表 前台人员维护数据
	
	private Long dixiongzimeiid;
	private String dixiongzimeixingming; //这两个字段 代表 后台人员维护数据
	
	private String leixing;
	private String leixingstring; //三级教堂
	
	private String name; //名称
	
	private String areaId;   //省
	private String areaName;
	
	private String area1Id;   //市
	private String area1Name;
	
	private String area2Id;   //县/区
	private String area2Name;
	
	private String area3Id;   //乡/镇
	private String area3Name;
	
	private String xiangxidizhi;//详细地址
	
	private String beizhu;//备注信息

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public String getLeixingstring() {
		return leixingstring;
	}

	public void setLeixingstring(String leixingstring) {
		this.leixingstring = leixingstring;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getArea1Id() {
		return area1Id;
	}

	public void setArea1Id(String area1Id) {
		this.area1Id = area1Id;
	}

	public String getArea1Name() {
		return area1Name;
	}

	public void setArea1Name(String area1Name) {
		this.area1Name = area1Name;
	}

	public String getArea2Id() {
		return area2Id;
	}

	public void setArea2Id(String area2Id) {
		this.area2Id = area2Id;
	}

	public String getArea2Name() {
		return area2Name;
	}

	public void setArea2Name(String area2Name) {
		this.area2Name = area2Name;
	}

	public String getArea3Id() {
		return area3Id;
	}

	public void setArea3Id(String area3Id) {
		this.area3Id = area3Id;
	}

	public String getArea3Name() {
		return area3Name;
	}

	public void setArea3Name(String area3Name) {
		this.area3Name = area3Name;
	}

	public String getXiangxidizhi() {
		return xiangxidizhi;
	}

	public void setXiangxidizhi(String xiangxidizhi) {
		this.xiangxidizhi = xiangxidizhi;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getOpenID() {
		return openID;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Long getDixiongzimeiid() {
		return dixiongzimeiid;
	}

	public void setDixiongzimeiid(Long dixiongzimeiid) {
		this.dixiongzimeiid = dixiongzimeiid;
	}

	public String getDixiongzimeixingming() {
		return dixiongzimeixingming;
	}

	public void setDixiongzimeixingming(String dixiongzimeixingming) {
		this.dixiongzimeixingming = dixiongzimeixingming;
	}
	
	

}

package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;

public class BangZhuParam extends MapperQuery {
	private static final long serialVersionUID = 0L;

	private Long id;
	private Date createDate;
	private Date updateDate;
	private Long version;
	private String biaoti;
	private Long dixiongzimeiid;
	private String dixiongzimeixingming;
	private String leixing;
	private String neirong;
	private String nickname;
	private String openID;
	private String zhuangtai;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getVersion() {
		return version;
	}

	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}

	public String getBiaoti() {
		return biaoti;
	}

	public void setDixiongzimeiid(Long dixiongzimeiid) {
		this.dixiongzimeiid = dixiongzimeiid;
	}

	public Long getDixiongzimeiid() {
		return dixiongzimeiid;
	}

	public void setDixiongzimeixingming(String dixiongzimeixingming) {
		this.dixiongzimeixingming = dixiongzimeixingming;
	}

	public String getDixiongzimeixingming() {
		return dixiongzimeixingming;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public String getLeixing() {
		return leixing;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	public String getNeirong() {
		return neirong;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setOpenID(String openID) {
		this.openID = openID;
	}

	public String getOpenID() {
		return openID;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

	public String getZhuangtai() {
		return zhuangtai;
	}
}

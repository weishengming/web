package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;

public class WenZhangParam extends MapperQuery {
	private static final long serialVersionUID = 0L;

	private Long id;
	private Date createDate;
	private Date updateDate;
	private Long version;
	private String biaoti;
	private String fubiaoti;
	private String gaishu;
	private String laiyuan;
	private String neirong;
	private String paixu;
	private String zuozhe;

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

	public void setFubiaoti(String fubiaoti) {
		this.fubiaoti = fubiaoti;
	}

	public String getFubiaoti() {
		return fubiaoti;
	}

	public void setGaishu(String gaishu) {
		this.gaishu = gaishu;
	}

	public String getGaishu() {
		return gaishu;
	}

	public String getLaiyuan() {
		return laiyuan;
	}

	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	public String getNeirong() {
		return neirong;
	}

	public void setPaixu(String paixu) {
		this.paixu = paixu;
	}

	public String getPaixu() {
		return paixu;
	}

	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}

	public String getZuozhe() {
		return zuozhe;
	}
}

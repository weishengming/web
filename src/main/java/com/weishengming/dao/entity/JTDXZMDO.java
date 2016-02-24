package com.weishengming.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author 杨天赐
 * 教堂弟兄姊妹关联表
 */
@Entity
@Table(name = "jtdxzm")
public class JTDXZMDO extends BaseDO{

	private static final long serialVersionUID = 1L;

	private String openID;//客户的id
	private String nickname;//客户账号
	
	private Long   dixiongzimeiid;
	private String dixiongzimeixingming;
	
	private Long   jiaotangid;
	private String jiaotangmingzi;
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
	public Long getJiaotangid() {
		return jiaotangid;
	}
	public void setJiaotangid(Long jiaotangid) {
		this.jiaotangid = jiaotangid;
	}
	public String getJiaotangmingzi() {
		return jiaotangmingzi;
	}
	public void setJiaotangmingzi(String jiaotangmingzi) {
		this.jiaotangmingzi = jiaotangmingzi;
	}
	
	

}

package com.weishengming.user.dao.param;

import com.weishengming.dao.query.MapperQuery;

public class UserParam extends MapperQuery {
	private static final long serialVersionUID = 0L;

	private Long user_id; 
	private String truename; 
	private String id_card; 
	private String sex; 
	private String school; 
	private String ruxuenianfen; 
	private String zhuanye; 
	private String xuezhi; 
	private String banji; 
	private String sushedizhi; 
	private String yuanjidizhi; 
	private String bankname; 
	private String bankaddr; 
	private String bankcardnum; 
	private String mobilePwd; 
	private String xuexinwang; 
	private String xuexinwangPwd; 
	private String xueli; 
	private String taobao_username; 
	private String taobao_password; 
	private String jd_username; 
	private String jd_password; 
	private String weixinhaoma; 
	private String qq; 
	private String xingming1; 
	private String guanxi1; 
	private String phone1; 
	private String xingming2; 
	private String guanxi2; 
	private String phone2; 
	private String daoyuanxingming; 
	private String daoyuandianhua; 
	private String tongxuexingming1; 
	private String sushedianhua1; 
	private String tongxuexingming2; 
	private String sushedianhua2; 
	private String tongxuexingming3; 
	private String sushedianhua3; 
	private String guanxi1_zt; 
	private String guanxi1_zt_dailiname; 
	private String guanxi1_zt_shijian; 
	private String guanxi2_zt; 
	private String guanxi2_zt_dailiname; 
	private String guanxi2_zt_shijian; 
	private String sushedianhua1_zt; 
	private String sushedianhua1_zt_dailiname; 
	private String sushedianhua1_ztshijian; 
	private String sushedianhua2_zt; 
	private String sushedianhua2_zt_dailiname; 
	private String sushedianhua2_ztshijian; 
	private String sushedianhua3_zt; 
	private String sushedianhua3_zt_dailiname; 
	private String sushedianhua3_ztshijian; 
	private String mtime; 
	private String email; 
	private String email_password; 
	private String appemail_key; 
	private String em_last_time;

	
	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getTaobao_username() {
		return taobao_username;
	}

	public void setTaobao_username(String taobao_username) {
		this.taobao_username = taobao_username;
	}

	public String getTaobao_password() {
		return taobao_password;
	}

	public void setTaobao_password(String taobao_password) {
		this.taobao_password = taobao_password;
	}

	public String getJd_username() {
		return jd_username;
	}

	public void setJd_username(String jd_username) {
		this.jd_username = jd_username;
	}

	public String getJd_password() {
		return jd_password;
	}

	public void setJd_password(String jd_password) {
		this.jd_password = jd_password;
	}

	public String getGuanxi1_zt() {
		return guanxi1_zt;
	}

	public void setGuanxi1_zt(String guanxi1_zt) {
		this.guanxi1_zt = guanxi1_zt;
	}

	public String getGuanxi1_zt_dailiname() {
		return guanxi1_zt_dailiname;
	}

	public void setGuanxi1_zt_dailiname(String guanxi1_zt_dailiname) {
		this.guanxi1_zt_dailiname = guanxi1_zt_dailiname;
	}

	public String getGuanxi1_zt_shijian() {
		return guanxi1_zt_shijian;
	}

	public void setGuanxi1_zt_shijian(String guanxi1_zt_shijian) {
		this.guanxi1_zt_shijian = guanxi1_zt_shijian;
	}

	public String getGuanxi2_zt() {
		return guanxi2_zt;
	}

	public void setGuanxi2_zt(String guanxi2_zt) {
		this.guanxi2_zt = guanxi2_zt;
	}

	public String getGuanxi2_zt_dailiname() {
		return guanxi2_zt_dailiname;
	}

	public void setGuanxi2_zt_dailiname(String guanxi2_zt_dailiname) {
		this.guanxi2_zt_dailiname = guanxi2_zt_dailiname;
	}

	public String getGuanxi2_zt_shijian() {
		return guanxi2_zt_shijian;
	}

	public void setGuanxi2_zt_shijian(String guanxi2_zt_shijian) {
		this.guanxi2_zt_shijian = guanxi2_zt_shijian;
	}

	public String getSushedianhua1_zt() {
		return sushedianhua1_zt;
	}

	public void setSushedianhua1_zt(String sushedianhua1_zt) {
		this.sushedianhua1_zt = sushedianhua1_zt;
	}

	public String getSushedianhua1_zt_dailiname() {
		return sushedianhua1_zt_dailiname;
	}

	public void setSushedianhua1_zt_dailiname(String sushedianhua1_zt_dailiname) {
		this.sushedianhua1_zt_dailiname = sushedianhua1_zt_dailiname;
	}

	public String getSushedianhua1_ztshijian() {
		return sushedianhua1_ztshijian;
	}

	public void setSushedianhua1_ztshijian(String sushedianhua1_ztshijian) {
		this.sushedianhua1_ztshijian = sushedianhua1_ztshijian;
	}

	public String getSushedianhua2_zt() {
		return sushedianhua2_zt;
	}

	public void setSushedianhua2_zt(String sushedianhua2_zt) {
		this.sushedianhua2_zt = sushedianhua2_zt;
	}

	public String getSushedianhua2_zt_dailiname() {
		return sushedianhua2_zt_dailiname;
	}

	public void setSushedianhua2_zt_dailiname(String sushedianhua2_zt_dailiname) {
		this.sushedianhua2_zt_dailiname = sushedianhua2_zt_dailiname;
	}

	public String getSushedianhua2_ztshijian() {
		return sushedianhua2_ztshijian;
	}

	public void setSushedianhua2_ztshijian(String sushedianhua2_ztshijian) {
		this.sushedianhua2_ztshijian = sushedianhua2_ztshijian;
	}

	public String getSushedianhua3_zt() {
		return sushedianhua3_zt;
	}

	public void setSushedianhua3_zt(String sushedianhua3_zt) {
		this.sushedianhua3_zt = sushedianhua3_zt;
	}

	public String getSushedianhua3_zt_dailiname() {
		return sushedianhua3_zt_dailiname;
	}

	public void setSushedianhua3_zt_dailiname(String sushedianhua3_zt_dailiname) {
		this.sushedianhua3_zt_dailiname = sushedianhua3_zt_dailiname;
	}

	public String getSushedianhua3_ztshijian() {
		return sushedianhua3_ztshijian;
	}

	public void setSushedianhua3_ztshijian(String sushedianhua3_ztshijian) {
		this.sushedianhua3_ztshijian = sushedianhua3_ztshijian;
	}

	public String getEmail_password() {
		return email_password;
	}

	public void setEmail_password(String email_password) {
		this.email_password = email_password;
	}

	public String getAppemail_key() {
		return appemail_key;
	}

	public void setAppemail_key(String appemail_key) {
		this.appemail_key = appemail_key;
	}

	public String getEm_last_time() {
		return em_last_time;
	}

	public void setEm_last_time(String em_last_time) {
		this.em_last_time = em_last_time;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getTruename() {
		return truename;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setRuxuenianfen(String ruxuenianfen) {
		this.ruxuenianfen = ruxuenianfen;
	}

	public String getRuxuenianfen() {
		return ruxuenianfen;
	}

	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}

	public String getZhuanye() {
		return zhuanye;
	}

	public void setXuezhi(String xuezhi) {
		this.xuezhi = xuezhi;
	}

	public String getXuezhi() {
		return xuezhi;
	}

	public void setBanji(String banji) {
		this.banji = banji;
	}

	public String getBanji() {
		return banji;
	}

	public void setSushedizhi(String sushedizhi) {
		this.sushedizhi = sushedizhi;
	}

	public String getSushedizhi() {
		return sushedizhi;
	}

	public void setYuanjidizhi(String yuanjidizhi) {
		this.yuanjidizhi = yuanjidizhi;
	}

	public String getYuanjidizhi() {
		return yuanjidizhi;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankaddr(String bankaddr) {
		this.bankaddr = bankaddr;
	}

	public String getBankaddr() {
		return bankaddr;
	}

	public void setBankcardnum(String bankcardnum) {
		this.bankcardnum = bankcardnum;
	}

	public String getBankcardnum() {
		return bankcardnum;
	}

	public void setMobilePwd(String mobilePwd) {
		this.mobilePwd = mobilePwd;
	}

	public String getMobilePwd() {
		return mobilePwd;
	}

	public void setXuexinwang(String xuexinwang) {
		this.xuexinwang = xuexinwang;
	}

	public String getXuexinwang() {
		return xuexinwang;
	}

	public void setXuexinwangPwd(String xuexinwangPwd) {
		this.xuexinwangPwd = xuexinwangPwd;
	}

	public String getXuexinwangPwd() {
		return xuexinwangPwd;
	}

	public void setXueli(String xueli) {
		this.xueli = xueli;
	}

	public String getXueli() {
		return xueli;
	}

	public void setWeixinhaoma(String weixinhaoma) {
		this.weixinhaoma = weixinhaoma;
	}

	public String getWeixinhaoma() {
		return weixinhaoma;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getQq() {
		return qq;
	}

	public void setXingming1(String xingming1) {
		this.xingming1 = xingming1;
	}

	public String getXingming1() {
		return xingming1;
	}

	public void setGuanxi1(String guanxi1) {
		this.guanxi1 = guanxi1;
	}

	public String getGuanxi1() {
		return guanxi1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setXingming2(String xingming2) {
		this.xingming2 = xingming2;
	}

	public String getXingming2() {
		return xingming2;
	}

	public void setGuanxi2(String guanxi2) {
		this.guanxi2 = guanxi2;
	}

	public String getGuanxi2() {
		return guanxi2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setDaoyuanxingming(String daoyuanxingming) {
		this.daoyuanxingming = daoyuanxingming;
	}

	public String getDaoyuanxingming() {
		return daoyuanxingming;
	}

	public void setDaoyuandianhua(String daoyuandianhua) {
		this.daoyuandianhua = daoyuandianhua;
	}

	public String getDaoyuandianhua() {
		return daoyuandianhua;
	}

	public void setTongxuexingming1(String tongxuexingming1) {
		this.tongxuexingming1 = tongxuexingming1;
	}

	public String getTongxuexingming1() {
		return tongxuexingming1;
	}

	public void setSushedianhua1(String sushedianhua1) {
		this.sushedianhua1 = sushedianhua1;
	}

	public String getSushedianhua1() {
		return sushedianhua1;
	}

	public void setTongxuexingming2(String tongxuexingming2) {
		this.tongxuexingming2 = tongxuexingming2;
	}

	public String getTongxuexingming2() {
		return tongxuexingming2;
	}

	public void setSushedianhua2(String sushedianhua2) {
		this.sushedianhua2 = sushedianhua2;
	}

	public String getSushedianhua2() {
		return sushedianhua2;
	}

	public void setTongxuexingming3(String tongxuexingming3) {
		this.tongxuexingming3 = tongxuexingming3;
	}

	public String getTongxuexingming3() {
		return tongxuexingming3;
	}

	public void setSushedianhua3(String sushedianhua3) {
		this.sushedianhua3 = sushedianhua3;
	}

	public String getSushedianhua3() {
		return sushedianhua3;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	public String getMtime() {
		return mtime;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
}

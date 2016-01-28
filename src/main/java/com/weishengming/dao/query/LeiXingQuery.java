package com.weishengming.dao.query;



public class LeiXingQuery extends MapperQuery{
    private static final long serialVersionUID = 0L;
    private String mingcheng;
    private String fumingcheng;
    private String jibie;
    
	public String getJibie() {
		return jibie;
	}
	public void setJibie(String jibie) {
		this.jibie = jibie;
	}
	public String getMingcheng() {
		return mingcheng;
	}
	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	public String getFumingcheng() {
		return fumingcheng;
	}
	public void setFumingcheng(String fumingcheng) {
		this.fumingcheng = fumingcheng;
	}
}

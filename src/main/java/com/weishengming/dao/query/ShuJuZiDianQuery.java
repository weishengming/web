package com.weishengming.dao.query;

public class ShuJuZiDianQuery extends MapperQuery{
    private static final long serialVersionUID = 0L;
    private String neirong;
    private Long fuid;
    
	 
	public Long getFuid() {
		return fuid;
	}
	public void setFuid(Long fuid) {
		this.fuid = fuid;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
}

package com.weishengming.dao.query;



public class DiXiongZiMeiQuery extends MapperQuery{
    private static final long serialVersionUID = 0L;
    private String xingming;
    private String shoujihao;
    private String shenfen;
    private String suoding;
    
    
    
	public String getShenfen() {
		return shenfen;
	}
	public void setShenfen(String shenfen) {
		this.shenfen = shenfen;
	}
	public String getSuoding() {
		return suoding;
	}
	public void setSuoding(String suoding) {
		this.suoding = suoding;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getShoujihao() {
		return shoujihao;
	}
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
    
}

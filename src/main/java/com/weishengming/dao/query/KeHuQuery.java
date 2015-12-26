package com.weishengming.dao.query;



public class KeHuQuery extends MapperQuery{
    private static final long serialVersionUID = 0L;
    private String xingming;
    private String shoujihao;
    private String qq;
    
    
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

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	private String zhanghao;

	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
}

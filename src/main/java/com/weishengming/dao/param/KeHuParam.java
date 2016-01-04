package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class KeHuParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private Boolean enabled;
        private String mima;
        private String mimamd5;
        private String qq;
        private String shenfenzheng;
        private String shengri;
        private String shoujihao;
        private String weixinhao;
        private String xingbie;
        private String xingming;
        private String zhanghao;
        
    
        public void  setId(Long id){
    	this.id=id;
    }
    
    public Long getId(){
    	return id;
    }
        public void  setCreateDate(Date createDate){
    	this.createDate=createDate;
    }
    
    public Date getCreateDate(){
    	return createDate;
    }
        public void  setUpdateDate(Date updateDate){
    	this.updateDate=updateDate;
    }
    
    public Date getUpdateDate(){
    	return updateDate;
    }
        public void  setVersion(Long version){
    	this.version=version;
    }
    
    public Long getVersion(){
    	return version;
    }
        public void  setEnabled(Boolean enabled){
    	this.enabled=enabled;
    }
    
    public Boolean getEnabled(){
    	return enabled;
    }
        public void  setMima(String mima){
    	this.mima=mima;
    }
    
    public String getMima(){
    	return mima;
    }
        public void  setMimamd5(String mimamd5){
    	this.mimamd5=mimamd5;
    }
    
    public String getMimamd5(){
    	return mimamd5;
    }
        public void  setQq(String qq){
    	this.qq=qq;
    }
    
    public String getQq(){
    	return qq;
    }
        public void  setShenfenzheng(String shenfenzheng){
    	this.shenfenzheng=shenfenzheng;
    }
    
    public String getShenfenzheng(){
    	return shenfenzheng;
    }
        public void  setShengri(String shengri){
    	this.shengri=shengri;
    }
    
    public String getShengri(){
    	return shengri;
    }
        public void  setShoujihao(String shoujihao){
    	this.shoujihao=shoujihao;
    }
    
    public String getShoujihao(){
    	return shoujihao;
    }
        public void  setWeixinhao(String weixinhao){
    	this.weixinhao=weixinhao;
    }
    
    public String getWeixinhao(){
    	return weixinhao;
    }
        public void  setXingbie(String xingbie){
    	this.xingbie=xingbie;
    }
    
    public String getXingbie(){
    	return xingbie;
    }
        public void  setXingming(String xingming){
    	this.xingming=xingming;
    }
    
    public String getXingming(){
    	return xingming;
    }
        public void  setZhanghao(String zhanghao){
    	this.zhanghao=zhanghao;
    }
    
    public String getZhanghao(){
    	return zhanghao;
    }
    }

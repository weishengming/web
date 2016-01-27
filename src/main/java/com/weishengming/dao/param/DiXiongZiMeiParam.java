package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class DiXiongZiMeiParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private String beizhu;
        private String leixing;
        private String nickname;
        private String openID;
        private String qq;
        private String shengri;
        private String shoujihao;
        private String weibohao;
        private String weixinhao;
        private String xingbie;
        private String xingming;
        
    
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
        public void  setBeizhu(String beizhu){
    	this.beizhu=beizhu;
    }
    
    public String getBeizhu(){
    	return beizhu;
    }
        public void  setLeixing(String leixing){
    	this.leixing=leixing;
    }
    
    public String getLeixing(){
    	return leixing;
    }
        public void  setNickname(String nickname){
    	this.nickname=nickname;
    }
    
    public String getNickname(){
    	return nickname;
    }
        public void  setOpenID(String openID){
    	this.openID=openID;
    }
    
    public String getOpenID(){
    	return openID;
    }
        public void  setQq(String qq){
    	this.qq=qq;
    }
    
    public String getQq(){
    	return qq;
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
        public void  setWeibohao(String weibohao){
    	this.weibohao=weibohao;
    }
    
    public String getWeibohao(){
    	return weibohao;
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
    }

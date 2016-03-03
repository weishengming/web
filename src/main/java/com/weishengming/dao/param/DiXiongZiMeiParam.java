package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class DiXiongZiMeiParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private String nianling;
        private String nickname;
        private String openID;
        private String qita;
        private String qq;
        private String shenfen;
        private String shoujihao;
        private String suoding;
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
        public void  setNianling(String nianling){
    	this.nianling=nianling;
    }
    
    public String getNianling(){
    	return nianling;
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
        public void  setQita(String qita){
    	this.qita=qita;
    }
    
    public String getQita(){
    	return qita;
    }
        public void  setQq(String qq){
    	this.qq=qq;
    }
    
    public String getQq(){
    	return qq;
    }
        public void  setShenfen(String shenfen){
    	this.shenfen=shenfen;
    }
    
    public String getShenfen(){
    	return shenfen;
    }
        public void  setShoujihao(String shoujihao){
    	this.shoujihao=shoujihao;
    }
    
    public String getShoujihao(){
    	return shoujihao;
    }
        public void  setSuoding(String suoding){
    	this.suoding=suoding;
    }
    
    public String getSuoding(){
    	return suoding;
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

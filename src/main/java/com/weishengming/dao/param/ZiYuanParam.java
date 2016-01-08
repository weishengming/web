package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class ZiYuanParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private String beizhu;
        private String dizhi;
        private String nickname;
        private String openID;
        private String type;
        
    
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
        public void  setDizhi(String dizhi){
    	this.dizhi=dizhi;
    }
    
    public String getDizhi(){
    	return dizhi;
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
        public void  setType(String type){
    	this.type=type;
    }
    
    public String getType(){
    	return type;
    }
    }

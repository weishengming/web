package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class JTDXZMParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private Long dixiongzimeiid;
        private String dixiongzimeixingming;
        private Long jiaotangid;
        private String jiaotangmingzi;
        private String nickname;
        private String openID;
        
    
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
        public void  setDixiongzimeiid(Long dixiongzimeiid){
    	this.dixiongzimeiid=dixiongzimeiid;
    }
    
    public Long getDixiongzimeiid(){
    	return dixiongzimeiid;
    }
        public void  setDixiongzimeixingming(String dixiongzimeixingming){
    	this.dixiongzimeixingming=dixiongzimeixingming;
    }
    
    public String getDixiongzimeixingming(){
    	return dixiongzimeixingming;
    }
        public void  setJiaotangid(Long jiaotangid){
    	this.jiaotangid=jiaotangid;
    }
    
    public Long getJiaotangid(){
    	return jiaotangid;
    }
        public void  setJiaotangmingzi(String jiaotangmingzi){
    	this.jiaotangmingzi=jiaotangmingzi;
    }
    
    public String getJiaotangmingzi(){
    	return jiaotangmingzi;
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
    }

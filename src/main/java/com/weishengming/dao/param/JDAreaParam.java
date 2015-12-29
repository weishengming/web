package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class JDAreaParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private String areaId;
        private String areaName;
        private String parentId;
        
    
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
        public void  setAreaId(String areaId){
    	this.areaId=areaId;
    }
    
    public String getAreaId(){
    	return areaId;
    }
        public void  setAreaName(String areaName){
    	this.areaName=areaName;
    }
    
    public String getAreaName(){
    	return areaName;
    }
        public void  setParentId(String parentId){
    	this.parentId=parentId;
    }
    
    public String getParentId(){
    	return parentId;
    }
    }

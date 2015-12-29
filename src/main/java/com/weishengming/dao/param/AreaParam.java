package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class AreaParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private String code;
        private String level;
        private String name;
        private Long parentId;
        private String status;
        private String zipCode;
        
    
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
        public void  setCode(String code){
    	this.code=code;
    }
    
    public String getCode(){
    	return code;
    }
        public void  setLevel(String level){
    	this.level=level;
    }
    
    public String getLevel(){
    	return level;
    }
        public void  setName(String name){
    	this.name=name;
    }
    
    public String getName(){
    	return name;
    }
        public void  setParentId(Long parentId){
    	this.parentId=parentId;
    }
    
    public Long getParentId(){
    	return parentId;
    }
        public void  setStatus(String status){
    	this.status=status;
    }
    
    public String getStatus(){
    	return status;
    }
        public void  setZipCode(String zipCode){
    	this.zipCode=zipCode;
    }
    
    public String getZipCode(){
    	return zipCode;
    }
    }

package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class ShuJuZiDianParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private Long fuid;
        private String neirong;
        private String paixu;
        
    
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
        public void  setFuid(Long fuid){
    	this.fuid=fuid;
    }
    
    public Long getFuid(){
    	return fuid;
    }
        public void  setNeirong(String neirong){
    	this.neirong=neirong;
    }
    
    public String getNeirong(){
    	return neirong;
    }
        public void  setPaixu(String paixu){
    	this.paixu=paixu;
    }
    
    public String getPaixu(){
    	return paixu;
    }
    }

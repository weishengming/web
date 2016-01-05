package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class WenTiParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private Long kehuid;
        private String kehuzhanghao;
        private String wenti;
        
    
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
        public void  setKehuid(Long kehuid){
    	this.kehuid=kehuid;
    }
    
    public Long getKehuid(){
    	return kehuid;
    }
        public void  setKehuzhanghao(String kehuzhanghao){
    	this.kehuzhanghao=kehuzhanghao;
    }
    
    public String getKehuzhanghao(){
    	return kehuzhanghao;
    }
        public void  setWenti(String wenti){
    	this.wenti=wenti;
    }
    
    public String getWenti(){
    	return wenti;
    }
    }

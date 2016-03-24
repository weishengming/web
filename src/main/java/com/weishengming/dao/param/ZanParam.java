package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class ZanParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private String leixing;
        private Long objid;
        private String openID;
        private String zhuangtai;
        
    
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
        public void  setLeixing(String leixing){
    	this.leixing=leixing;
    }
    
    public String getLeixing(){
    	return leixing;
    }
        public void  setObjid(Long objid){
    	this.objid=objid;
    }
    
    public Long getObjid(){
    	return objid;
    }
        public void  setOpenID(String openID){
    	this.openID=openID;
    }
    
    public String getOpenID(){
    	return openID;
    }
        public void  setZhuangtai(String zhuangtai){
    	this.zhuangtai=zhuangtai;
    }
    
    public String getZhuangtai(){
    	return zhuangtai;
    }
    }

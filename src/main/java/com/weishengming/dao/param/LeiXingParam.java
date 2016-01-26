package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class LeiXingParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private Long fuid;
        private String fumingcheng;
        private String jibie;
        private String mingcheng;
        private String paixu;
        private String shifouqiyong;
        
    
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
        public void  setFumingcheng(String fumingcheng){
    	this.fumingcheng=fumingcheng;
    }
    
    public String getFumingcheng(){
    	return fumingcheng;
    }
        public void  setJibie(String jibie){
    	this.jibie=jibie;
    }
    
    public String getJibie(){
    	return jibie;
    }
        public void  setMingcheng(String mingcheng){
    	this.mingcheng=mingcheng;
    }
    
    public String getMingcheng(){
    	return mingcheng;
    }
        public void  setPaixu(String paixu){
    	this.paixu=paixu;
    }
    
    public String getPaixu(){
    	return paixu;
    }
        public void  setShifouqiyong(String shifouqiyong){
    	this.shifouqiyong=shifouqiyong;
    }
    
    public String getShifouqiyong(){
    	return shifouqiyong;
    }
    }

package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class SJZLParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private String biaoti;
        private String dijige;
        private String fubiaoti;
        private String miaoshu;
        private String tudousrc;
        
    
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
        public void  setBiaoti(String biaoti){
    	this.biaoti=biaoti;
    }
    
    public String getBiaoti(){
    	return biaoti;
    }
        public void  setDijige(String dijige){
    	this.dijige=dijige;
    }
    
    public String getDijige(){
    	return dijige;
    }
        public void  setFubiaoti(String fubiaoti){
    	this.fubiaoti=fubiaoti;
    }
    
    public String getFubiaoti(){
    	return fubiaoti;
    }
        public void  setMiaoshu(String miaoshu){
    	this.miaoshu=miaoshu;
    }
    
    public String getMiaoshu(){
    	return miaoshu;
    }
        public void  setTudousrc(String tudousrc){
    	this.tudousrc=tudousrc;
    }
    
    public String getTudousrc(){
    	return tudousrc;
    }
    }

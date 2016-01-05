package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class JueSeQuanXianParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private Long jueseid;
        private String juesemingcheng;
        private Long quanxianid;
        private String quanxianmingcheng;
        
    
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
        public void  setJueseid(Long jueseid){
    	this.jueseid=jueseid;
    }
    
    public Long getJueseid(){
    	return jueseid;
    }
        public void  setJuesemingcheng(String juesemingcheng){
    	this.juesemingcheng=juesemingcheng;
    }
    
    public String getJuesemingcheng(){
    	return juesemingcheng;
    }
        public void  setQuanxianid(Long quanxianid){
    	this.quanxianid=quanxianid;
    }
    
    public Long getQuanxianid(){
    	return quanxianid;
    }
        public void  setQuanxianmingcheng(String quanxianmingcheng){
    	this.quanxianmingcheng=quanxianmingcheng;
    }
    
    public String getQuanxianmingcheng(){
    	return quanxianmingcheng;
    }
    }
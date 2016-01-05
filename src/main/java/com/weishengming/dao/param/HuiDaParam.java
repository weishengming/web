package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class HuiDaParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private String huida;
        private Long huidakehuid;
        private String huidakehuzhanghao;
        private String wenti;
        private Long wentiid;
        private Long wentikehuid;
        private String wentikehuzhanghao;
        
    
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
        public void  setHuida(String huida){
    	this.huida=huida;
    }
    
    public String getHuida(){
    	return huida;
    }
        public void  setHuidakehuid(Long huidakehuid){
    	this.huidakehuid=huidakehuid;
    }
    
    public Long getHuidakehuid(){
    	return huidakehuid;
    }
        public void  setHuidakehuzhanghao(String huidakehuzhanghao){
    	this.huidakehuzhanghao=huidakehuzhanghao;
    }
    
    public String getHuidakehuzhanghao(){
    	return huidakehuzhanghao;
    }
        public void  setWenti(String wenti){
    	this.wenti=wenti;
    }
    
    public String getWenti(){
    	return wenti;
    }
        public void  setWentiid(Long wentiid){
    	this.wentiid=wentiid;
    }
    
    public Long getWentiid(){
    	return wentiid;
    }
        public void  setWentikehuid(Long wentikehuid){
    	this.wentikehuid=wentikehuid;
    }
    
    public Long getWentikehuid(){
    	return wentikehuid;
    }
        public void  setWentikehuzhanghao(String wentikehuzhanghao){
    	this.wentikehuzhanghao=wentikehuzhanghao;
    }
    
    public String getWentikehuzhanghao(){
    	return wentikehuzhanghao;
    }
    }

package com.weishengming.dao.param;

import java.util.Date;

import com.weishengming.dao.query.MapperQuery;


public class DiZhiParam extends MapperQuery{
    private static final long serialVersionUID = 0L;

	    private Long id;
        private Date createDate;
        private Date updateDate;
        private Long version;
        private String area1Id;
        private String area1Name;
        private String area2Id;
        private String area2Name;
        private String area3Id;
        private String area3Name;
        private String areaId;
        private String areaName;
        private String dixiongzimeiid;
        private String dixiongzimeixingming;
        private String leixing;
        private String nickname;
        private String openID;
        private String xiangxidizhi;
        
    
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
        public void  setArea1Id(String area1Id){
    	this.area1Id=area1Id;
    }
    
    public String getArea1Id(){
    	return area1Id;
    }
        public void  setArea1Name(String area1Name){
    	this.area1Name=area1Name;
    }
    
    public String getArea1Name(){
    	return area1Name;
    }
        public void  setArea2Id(String area2Id){
    	this.area2Id=area2Id;
    }
    
    public String getArea2Id(){
    	return area2Id;
    }
        public void  setArea2Name(String area2Name){
    	this.area2Name=area2Name;
    }
    
    public String getArea2Name(){
    	return area2Name;
    }
        public void  setArea3Id(String area3Id){
    	this.area3Id=area3Id;
    }
    
    public String getArea3Id(){
    	return area3Id;
    }
        public void  setArea3Name(String area3Name){
    	this.area3Name=area3Name;
    }
    
    public String getArea3Name(){
    	return area3Name;
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
        public void  setDixiongzimeiid(String dixiongzimeiid){
    	this.dixiongzimeiid=dixiongzimeiid;
    }
    
    public String getDixiongzimeiid(){
    	return dixiongzimeiid;
    }
        public void  setDixiongzimeixingming(String dixiongzimeixingming){
    	this.dixiongzimeixingming=dixiongzimeixingming;
    }
    
    public String getDixiongzimeixingming(){
    	return dixiongzimeixingming;
    }
        public void  setLeixing(String leixing){
    	this.leixing=leixing;
    }
    
    public String getLeixing(){
    	return leixing;
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
        public void  setXiangxidizhi(String xiangxidizhi){
    	this.xiangxidizhi=xiangxidizhi;
    }
    
    public String getXiangxidizhi(){
    	return xiangxidizhi;
    }
    }

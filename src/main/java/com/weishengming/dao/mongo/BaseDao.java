package com.weishengming.dao.mongo;

import java.util.List;

import com.weishengming.dao.mongo.query.MongoQuery;
import com.weishengming.dao.mongo.query.ResultMongoPage;

public interface BaseDao {  
	  
    <T> T findById(Class<T> entityClass, String id);  
  
    <T> List<T> findAll(Class<T> entityClass);  
  
    void remove(Object obj);  
  
    void add(Object obj);  
  
    void saveOrUpdate(Object obj); 
    
    <T> ResultMongoPage<T> findPageByQuery(Class<T> entityClass,MongoQuery query);
}  

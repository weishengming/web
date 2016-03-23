package com.weishengming.dao.mongo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.weishengming.dao.mongo.query.MongoQuery;
import com.weishengming.dao.mongo.query.ResultMongoPage;

 
/**
 * @author 杨天赐
 *
 */
@Repository(value = "mongoDB")
public class MongoDB implements BaseDao {
	@Autowired
	@Qualifier("mongoTemplate")
	protected MongoTemplate mongoTemplate;

	/**
	 * 根据主键id返回对象
	 * 
	 * @param id唯一标识
	 * @return T 对象
	 */
	public <T> T findById(Class<T> entityClass, String id) {
		return this.mongoTemplate.findById(id, entityClass);
	}

	/**
	 * 根据类获取全部的对象列表
	 * 
	 * @param entityClass
	 *            返回类型
	 * @return List<T> 返回对象列表
	 */
	public <T> List<T> findAll(Class<T> entityClass) {
		return this.mongoTemplate.findAll(entityClass);
	}

	/**
	 * 删除一个对象
	 * 
	 * @param obj
	 *            要删除的Mongo对象
	 */
	public void remove(Object obj) {
		this.mongoTemplate.remove(obj);
	}

	/**
	 * 添加对象
	 * 
	 * @param obj
	 *            要添加的Mongo对象
	 */
	public void add(Object obj) {
		this.mongoTemplate.insert(obj);

	}

	/**
	 * 修改对象
	 * 
	 * @param obj
	 *            要修改的Mongo对象
	 */
	public void saveOrUpdate(Object obj) {
		this.mongoTemplate.save(obj);
	}

	/**
	 * 查询并分页
	 * @param entityClass 对象类型
	 * @param query 查询条件
	 * @return
	 */
	@Override
	public <T> ResultMongoPage<T> findPageByQuery(Class<T> entityClass, MongoQuery query){
		Criteria criatira = new Criteria();
		Field[] field = query.getClass().getDeclaredFields();
		try {
			for (int j = 0; j < field.length; j++) { // 遍历所有属性
	            String name = field[j].getName(); // 获取属性的名字
	            String type = field[j].getGenericType().toString();
	            name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
	            if (!name.equals("SerialVersionUID")&& !name.equals("serialVersionUID")&& !name.equals("")) { //排除一些属性
	                Method m = query.getClass().getMethod("get" + name);
	                	String value = (String) m.invoke(query); // 调用getter方法获取属性值
		                if(StringUtils.isNotBlank(value)){
		                criatira.andOperator(Criteria.where(name).is(value));
		                }
	            }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		query.addCriteria(criatira);
		
		Long count = this.count(entityClass, query);
		query.setCount(count);
		int pageNumber = query.getPageNumber();
		int pageSize = query.getPageSize();
		query.skip((pageNumber - 1) * pageSize).limit(pageSize);
		List<T> list=this.mongoTemplate.find(query, entityClass);
		ResultMongoPage<T> result=new ResultMongoPage<T>(list, query);
        int total = count.intValue();
        int totalPage = total / result.getPageSize();
        if (totalPage != 0 && total % result.getPageSize() != 0) {
            totalPage += 1;
        }
        result.setCount(count); //设置总条数
        result.setTotal(totalPage); //谁知总页数
		
        return result;
	}
	

	/**
	 * 
	 * @param entityClass
	 *            查询对象
	 * @param query
	 *            查询条件
	 * @return
	 */
	public <T> Long count(Class<T> entityClass, Query query) {
		return this.mongoTemplate.count(query, entityClass);
	}

	/**
	 * 批量插入
	 * 
	 * @param entityClass
	 *            对象类
	 * @param collection
	 *            要插入的对象集合
	 */
	public <T> void addCollection(Class<T> entityClass, Collection<T> collection) {
		this.mongoTemplate.insert(collection, entityClass);
	}
	 

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
	

}

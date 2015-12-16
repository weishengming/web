package com.weishengming.web.test;

import java.util.List;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.weishengming.web.dao.CollectionConstants;
import com.weishengming.web.dao.MongoDB;


/**
 * @author 杨天赐
 * 测试MongoDB
 */
public class MongoDBTest {
	
	
	public void add(){
		BasicDBObject bdb=new BasicDBObject();
		bdb.put("xingming", "王素伟");
		bdb.put("nicheng", "新生命");
		bdb.put("shoujihao", "15711018186");
		MongoDB.addObject(CollectionConstants.KEHU, bdb);
	}
	@Test
	public void find(){
		List<DBObject> list=MongoDB.findList(CollectionConstants.KEHU, null, null);
		System.out.println(list);
		
	}

}

package com.weishengming.web.mongo.dao;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

 
/**
 * @author 杨天赐
 * MongoDB连接
 */
public class MongoDB {
	public static Mongo m = null;
	public static DB db = null;
	
	public static String MONGO_SERVER = "127.0.0.1";
	public static int MONGO_PORT = 27017;
	public static String MONGO_USERNAME = "";
	public static String MONGO_PASSWORD = "";
	public static String DBNAME = "weishengming";
	
	static {
		try {
			m = new Mongo(MONGO_SERVER, MONGO_PORT);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		db = m.getDB(DBNAME);
	}
	
	/**
	 * 添加一个对象 到数据库
	 * @param collname 集合名字
	 * @param bdb 对象.
	 */
	public static void addObject(String collname, BasicDBObject bdb) {
		DBCollection coll = db.getCollection(collname);
		coll.insert(bdb);
	}
	
	/**
	 * 添加N个对象到 数据库
	 * @param collname
	 * @param bdbs
	 */
	public static void addObjects(String collname, List<DBObject> bdbs) {
		DBCollection coll = db.getCollection(collname);
		coll.insert(bdbs);
	}
	
	/**
	 * 更新
	 * @param collname
	 * @param bdb
	 */
	public static void update(String collname, BasicDBObject bdb) {
		DBCollection coll = db.getCollection(collname);
		System.out.println(bdb.get("_id"));
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("d:/log.txt", true));
			pw.println(new Date() + " update: " + collname + "\t" + bdb);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BasicDBObject id = new BasicDBObject("_id", (ObjectId) bdb.get("_id"));
		coll.update(id, bdb);
	}

	/**
	 * 更新
	 * @param collname
	 * @param object
	 */
	public static void updatePartKey(String collname, BasicDBObject object) {
		DBCollection coll = db.getCollection(collname);
		BasicDBObject id = new BasicDBObject("_id", new ObjectId(object.getString("_id")));
		ObjectId objectId = new ObjectId(object.getString("_id"));
		object.remove("_id");
		coll.update(id, new BasicDBObject("$set", object));
		object.put("_id", objectId);
	}

	/**
	 * 获得数量
	 * @param collname
	 * @param bdb
	 * @return
	 */
	public static long count(String collname, BasicDBObject bdb) {
		DBCollection coll = db.getCollection(collname);
		return coll.count(bdb);
	}
	
	/**
	 * 获得一个对象
	 * @param collname
	 * @param bdb
	 * @return
	 */
	public static DBObject findOne(String collname, BasicDBObject bdb) {
		DBCollection coll = db.getCollection(collname);
		if (bdb == null) {
			return coll.findOne();
		} else {
			return coll.findOne(bdb);
		}
	}
	
	/**
	 * 通过Id获得一个对象
	 * @param collname
	 * @param _id
	 * @return 对象
	 */
	public static BasicDBObject findOne(String collname, String _id) {
		DBCollection coll = db.getCollection(collname);
		try {
			return (BasicDBObject) coll.findOne(new BasicDBObject("_id",
					new ObjectId(_id)));
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 获得N个对象 带排序
	 * @param collname
	 * @param sort 排序字段
	 * @param bdb
	 * @return
	 */
	public static List<DBObject> findList(String collname, String sort,BasicDBObject bdb) {
		DBCollection coll = db.getCollection(collname);
		if (bdb == null) {
			if (sort != null) {
				return coll.find().sort(new BasicDBObject(sort, -1)).toArray();
			}
			return coll.find().toArray();
		} else {
			if (sort != null) {
				return coll.find(bdb).sort(new BasicDBObject(sort, -1)).toArray();
			}
			return coll.find(bdb).toArray();
		}
	}
	
	/**
	 * 排序并分页
	 * @param collname
	 * @param sort
	 * @param bdb
	 * @param limit
	 * @param order
	 * @return
	 */
	public static List<DBObject> findListLimit(String collname, String sort,BasicDBObject bdb, int limit, int order) {
		DBCollection coll = db.getCollection(collname);
		if (bdb == null) {
			if (sort != null) {
				return coll.find().sort(new BasicDBObject(sort, order)).limit(limit).toArray();
			}
			return coll.find().toArray();
		} else {
			if (sort != null) {
				return coll.find(bdb).sort(new BasicDBObject(sort, order)).limit(limit).toArray();
			}
			return coll.find(bdb).toArray();
		}
	}
	
	/**
	 * Like查询
	 * @param collname
	 * @param field
	 * @param key
	 * @param sort
	 * @return
	 */
	public static List<DBObject> findListLike(String collname, String field,String key, String sort) {
		Pattern pattern = Pattern.compile(".*" + key + ".*",Pattern.CASE_INSENSITIVE);
		DBCollection coll = db.getCollection(collname);
		if (sort != null) {
			return coll.find(new BasicDBObject(field, pattern)).sort(new BasicDBObject(sort, 1)).toArray();
		} else {
			return coll.find(new BasicDBObject(field, pattern)).toArray();
		}
	}
	
	/**
	 * 分页
	 * @param collname
	 * @param sort
	 * @param bdb
	 * @param order
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	public static List<DBObject> findListForPage(String collname, String sort,BasicDBObject bdb, int order, long pageSize, long pageNum) {
		DBCollection coll = db.getCollection(collname);
		int limit = (int) pageSize;
		int skip = (int) ((pageNum - 1) * pageSize);
		if (bdb == null) {
			if (sort != null) {
				return coll.find().sort(new BasicDBObject(sort, order)).skip(skip).limit(limit).toArray();
			}
			return coll.find().toArray();
		} else {
			if (sort != null) {
				return coll.find(bdb).sort(new BasicDBObject(sort, order)).skip(skip).limit(limit).toArray();
			}
			return coll.find(bdb).toArray();
		}
	}
}


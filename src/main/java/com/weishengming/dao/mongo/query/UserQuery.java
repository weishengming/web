package com.weishengming.dao.mongo.query;

public class UserQuery extends MongoQuery{
	private static final long serialVersionUID = 1L;
	private String name;
	private String age;
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 

}

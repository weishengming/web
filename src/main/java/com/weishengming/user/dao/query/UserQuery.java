package com.weishengming.user.dao.query;

import com.weishengming.dao.query.MapperQuery;


public class UserQuery extends MapperQuery{
    private static final long serialVersionUID = 0L;
    private String sex;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
    
}

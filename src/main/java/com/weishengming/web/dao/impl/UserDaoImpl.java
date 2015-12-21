package com.weishengming.web.dao.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.weishengming.web.dao.UserDao;
import com.weishengming.web.entity.UserDO;

public class UserDaoImpl implements UserDao{
	private JdbcTemplate jdbcTemplate;  

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<UserDO> findAll() {
		String sql="SELECT * FROM USER";
		return (List<UserDO>)jdbcTemplate.query(sql, new BeanPropertyRowMapper(UserDO.class));
	}
	 
	/**
	 * 获得行数
	 * @return
	 */
	public int count(){
		String sql="SELECT * FROM USER";
		SqlRowSet sqlRowSet=jdbcTemplate.queryForRowSet(sql);
		return sqlRowSet.getRow();
	}
	
 
    public int insert(UserDO user) {  
        return jdbcTemplate.update(" insert into user (id,name) value(?,?)", new Object[] { user.getId(),user.getName() });  
    } 
    
 
    public int update(UserDO user) {  
        return jdbcTemplate.update(" update user set name=? where id=? ", new Object[] { user.getName(), user.getId() });  
    }  
    
    /** 
     * 删除 
     * @param     
     * @return 
     */  
    public int delete(UserDO user) {  
        return jdbcTemplate.update(" delete from user where id = ? ", new Object[] { user.getId() });  
    }  

}

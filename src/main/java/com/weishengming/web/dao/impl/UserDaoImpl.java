package com.weishengming.web.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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

}

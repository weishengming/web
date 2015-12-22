package com.weishengming.web.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.weishengming.web.dao.KeHuDao;

public class KeHuDaoImpl implements KeHuDao{
	private JdbcTemplate jdbcTemplate;  

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

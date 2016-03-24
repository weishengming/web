package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.QQDO;


public interface QQMapper extends BaseMapper<QQDO, Long> {
	public List<QQDO> findOpenID(String openID);

}
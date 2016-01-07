package com.weishengming.dao.mapper;

import com.weishengming.dao.entity.QQDO;


public interface QQMapper extends BaseMapper<QQDO, Long> {
	public QQDO findOpenID(String openID);

}
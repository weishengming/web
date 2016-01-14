package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.TTSDDO;


public interface TTSDMapper extends BaseMapper<TTSDDO, Long> {
	public List<TTSDDO> findListByFubiaoti(String fubiaoti);

}
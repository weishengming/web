package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.QMZXDO;


public interface QMZXMapper extends BaseMapper<QMZXDO, Long> {
	public List<QMZXDO> findListByFubiaoti(String fubiaoti);

}
package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.SJZLDO;


public interface SJZLMapper extends BaseMapper<SJZLDO, Long> {
	public List<SJZLDO> findListByFubiaoti(String fubiaoti);

}
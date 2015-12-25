package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.JueSeQuanXianDO;


public interface JueSeQuanXianMapper extends BaseMapper<JueSeQuanXianDO, Long> {
	
	List<JueSeQuanXianDO> findListByJueSeId(Long id);

}
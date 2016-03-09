package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.ShuJuZiDianDO;


public interface ShuJuZiDianMapper extends BaseMapper<ShuJuZiDianDO, Long> {
	
	public List<ShuJuZiDianDO> findListByFuId(Long id);

}
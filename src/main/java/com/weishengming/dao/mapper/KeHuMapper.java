package com.weishengming.dao.mapper;

import com.weishengming.dao.entity.KeHuDO;


public interface KeHuMapper extends BaseMapper<KeHuDO, Long> {
	public KeHuDO findOneByOpenID(String openID);
	

}
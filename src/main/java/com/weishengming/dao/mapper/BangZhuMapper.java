package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.BangZhuDO;


public interface BangZhuMapper extends BaseMapper<BangZhuDO, Long> {
	
	public List<BangZhuDO> findListByOpenID(String openID);

}
package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.DiZhiDO;


public interface DiZhiMapper extends BaseMapper<DiZhiDO, Long> {
	List<DiZhiDO> findListByOpenID(String openID);
	List<DiZhiDO> findListByDixiongzimeiid(Long dixiongzimeiid);
	

}
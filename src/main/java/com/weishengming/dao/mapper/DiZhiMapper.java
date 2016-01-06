package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.DiZhiDO;


public interface DiZhiMapper extends BaseMapper<DiZhiDO, Long> {
	List<DiZhiDO> findListByKehuZhangHao(String kehuZhanghao);
	List<DiZhiDO> findListByKehuid(Long kehuid);
	

}
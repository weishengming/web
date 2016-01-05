package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.WenTiDO;


public interface WenTiMapper extends BaseMapper<WenTiDO, Long> {
	
	List<WenTiDO> findListByKehuZhangHao(String kehuZhanghao);

}
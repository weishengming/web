package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.ShiPinDO;


public interface ShiPinMapper extends BaseMapper<ShiPinDO, Long> {
	public List<ShiPinDO> findListByFubiaoti(String fubiaoti);
}
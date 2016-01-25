package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.WenZhangDO;


public interface WenZhangMapper extends BaseMapper<WenZhangDO, Long> {
	public List<WenZhangDO> findListByFubiaoti(String fubiaoti);

}
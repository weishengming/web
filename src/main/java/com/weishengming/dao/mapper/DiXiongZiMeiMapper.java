package com.weishengming.dao.mapper;

import com.weishengming.dao.entity.DiXiongZiMeiDO;


public interface DiXiongZiMeiMapper extends BaseMapper<DiXiongZiMeiDO, Long> {
	public DiXiongZiMeiDO findOneByOpenID(String openID);

}
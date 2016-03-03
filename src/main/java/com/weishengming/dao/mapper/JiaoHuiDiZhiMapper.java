package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.JiaoHuiDiZhiDO;


public interface JiaoHuiDiZhiMapper extends BaseMapper<JiaoHuiDiZhiDO, Long> {
	List<JiaoHuiDiZhiDO> findListByOpenID(String openID);
	List<JiaoHuiDiZhiDO> findListByDixiongzimeiid(Long dixiongzimeiid);
	

}
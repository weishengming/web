package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.KeHuJueSeDO;


public interface KeHuJueSeMapper extends BaseMapper<KeHuJueSeDO, Long> {
	/**通过账号 获得所有的 角色**/
	List<KeHuJueSeDO> findListByZhangHao(String zhanghao);

}
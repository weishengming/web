package com.weishengming.dao.mapper;

import java.util.List;

import com.weishengming.dao.entity.WenTiDO;


public interface WenTiMapper extends BaseMapper<WenTiDO, Long> {
	
	/**
	 * 自己的问题
	 * @param kehuZhanghao
	 * @return
	 */
	List<WenTiDO> findListByKehuZhangHao(String kehuZhanghao);
	
	/**
	 * 别人的问题
	 * @param kehuZhanghao
	 * @return
	 */
	List<WenTiDO> findListByNotKehuZhangHao(String kehuZhanghao);

}
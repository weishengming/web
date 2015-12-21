package com.weishengming.web.dao;

import java.util.List;

import com.weishengming.web.entity.UserDO;

public interface UserDao {
	
	/**
	 * 查找所有
	 * @return
	 */
	public List<UserDO> findAll();
	
	/**
	 * 获得行数
	 * @return
	 */
	public int count();
	
	/** 
     * 插入 
     * @param  
     * @return 
     */
	public int insert(UserDO user);
	
	/** 
     * 更新 
     * @param  
     * @return 
     */  
	public int update(UserDO user);
	
	/** 
     * 删除 
     * @param     
     * @return 
     */
	public int delete(UserDO user);

}

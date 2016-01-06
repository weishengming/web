package com.weishengming.common.security;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 杨天赐
 * 获得登陆后的账号
 */
public interface QQHolder {
	
	 public String getName(HttpServletRequest request);
	 public String getOpenID(HttpServletRequest request);

}

package com.weishengming.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.weishengming.common.exception.ServiceException;
import com.weishengming.common.security.QQHolder;

/**
 * @author 杨天赐
 * 安全控制   暂时 不加入 CSRF  等以后有时间 加入.
 */
@Controller
public class SecurityController implements QQHolder {
	protected Logger logger;

	public SecurityController() {
		this.logger = LoggerFactory.getLogger(super.getClass());
	}

	 

	 

	@ExceptionHandler({ Throwable.class })
	public ModelAndView handleException(Model m,HttpServletRequest request, HttpServletResponse response, Object handler, Throwable ex) {
		this.logger.error("访问页面 " + request.getRequestURI() + " 时发生异常，信息如下：",ex);
		ModelAndView view = new ModelAndView();
		m.addAttribute("ex", ex);
		
		view.setViewName("/index/error");
		return view;
	}





	@Override
	public String getName(HttpServletRequest request) {
		if(request.getSession()!=null){
			if(request.getSession().getAttribute("name")!=null){
				return request.getSession().getAttribute("name").toString();
			}
		}
		return null;
	}





	@Override
	public String getOpenID(HttpServletRequest request) {
		if(request.getSession()!=null){
			if(request.getSession().getAttribute("openID")!=null){
				return request.getSession().getAttribute("openID").toString();
			}
		}
		return null;
	}

	 
}

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

import com.weishengming.service.exception.ServiceException;
import com.weishengming.web.security.ZhangHaoHolder;

/**
 * @author 杨天赐
 * 安全控制   暂时 不加入 CSRF  等以后有时间 加入.
 */
@Controller
public class SecurityController implements ZhangHaoHolder {
	protected Logger logger;

	public SecurityController() {
		this.logger = LoggerFactory.getLogger(super.getClass());
	}

	private UserDetails getUserDetails() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if ((authentication != null)&& (authentication.getPrincipal() instanceof UserDetails))
			return ((UserDetails) authentication.getPrincipal());
		return null;
	}

	protected boolean isLogin() {
		UserDetails userDetails = getUserDetails();
		return ((userDetails != null) && (!(userDetails.getUsername().equals(""))));
	}

	public String getZhangHao() {
		if (isLogin())
			return getUserDetails().getUsername();

		return null;
	}

	@ExceptionHandler({ Throwable.class })
	public ModelAndView handleException(Model m,HttpServletRequest request, HttpServletResponse response, Object handler, Throwable ex) {
		this.logger.error("访问页面 " + request.getRequestURI() + " 时发生异常，信息如下：",ex);
		ModelAndView view = new ModelAndView();
		m.addAttribute("ex", ex);
		
		view.setViewName("/index/error");
		return view;
	}

	protected void checkCsrfToken(HttpServletRequest request) {
		CsrfToken csrfToken = (CsrfToken) request
				.getSession()
				.getAttribute(
						"org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository.CSRF_TOKEN");
		if ((csrfToken == null) || (StringUtils.isBlank(csrfToken.getToken())))
			throw new ServiceException("csrfToken is null");

		request.getSession()
				.setAttribute(
						"org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository.CSRF_TOKEN",
						null);
	}
}

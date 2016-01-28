package com.weishengming.web.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weishengming.service.WenZhangService;

/**
 * @author 杨天赐  文章管理控制层接口
 */
@Controller
@RequestMapping(value = "wenzhang")
public class WenZhangController  extends SecurityController {
	Logger logger = LoggerFactory.getLogger(WenZhangController.class);
	@Resource
	private WenZhangService wenzhangService;
	 
	public WenZhangService getWenzhangService() {
		return wenzhangService;
	}
	public void setWenzhangService(WenZhangService wenzhangService) {
		this.wenzhangService = wenzhangService;
	}
	

}

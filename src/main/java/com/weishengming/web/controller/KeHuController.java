package com.weishengming.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 杨天赐
 * 客户控制
 */
@Controller
@RequestMapping(value="kehu")
public class KeHuController {
	
	/**
	 * @return
	 * 进入客户信息页面
	 */
	@RequestMapping(value="kehuxinxiPage")
	public String kehuxinxiPage(){
		return "kehu/kehuxinxi";
	}
	
	 

}

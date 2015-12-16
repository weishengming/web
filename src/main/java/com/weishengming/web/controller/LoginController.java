package com.weishengming.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 杨天赐
 * 登陆控制
 */
@Controller
public class LoginController {
	Logger  logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="login",method=RequestMethod.POST)  
    public String index_jsp(Model model){  
		System.out.println("test");
		logger.info("test:{}","test");
        model.addAttribute("tianci", "天赐你好"); 
        
        return "/index/index";  
    } 
	 
	@RequestMapping(value="loginPage")
	public String loginPage(){
		logger.info("进入login页面");
		return "/index/login";
	}
	
	@RequestMapping(value="doLogin",method=RequestMethod.POST) 
	public String doLogin(String name,String password,Model model){
		logger.info("用户名:{},密码:{}",name,password);
		model.addAttribute("name",name);
		return "/index/index";
	}
}

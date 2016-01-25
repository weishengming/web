package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.dao.entity.TTSDDO;
import com.weishengming.service.TTSDService;

/**
 * @author 杨天赐  文章管理控制层接口
 */
@Controller
@RequestMapping(value = "ttsd")
public class WenZhangController  extends SecurityController {
	Logger logger = LoggerFactory.getLogger(WenZhangController.class);
	@Resource
	private TTSDService ttsdService;

	@RequestMapping(value="ttsdindex",method=RequestMethod.GET)  
    public String page0(Model model){
        return "/ttsd/ttsdindex";  
    }
	@RequestMapping(value="1-48",method=RequestMethod.GET)  
    public String page1(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("智慧人生");
		model.addAttribute("resultList", resultList);
        return "/ttsd/1-48";  
    }
	
	@RequestMapping(value="ttsdend",method=RequestMethod.GET)  
    public String page13(Model model){
        return "/ttsd/ttsdend";  
    }
	
	public TTSDService getTtsdService() {
		return ttsdService;
	}
	public void setTtsdService(TTSDService ttsdService) {
		this.ttsdService = ttsdService;
	}

}

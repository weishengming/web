package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.dao.entity.QMZXDO;
import com.weishengming.service.QMZXService;

/**
 * @author 杨天赐
 * 奇妙真相控制层接口
 */
@Controller
@RequestMapping(value = "qmzx")
public class QMZXController extends SecurityController{
	Logger logger = LoggerFactory.getLogger(QMZXController.class);
	@Resource
	private QMZXService qmzxService;
	
	@RequestMapping(value="qmzxindex",method=RequestMethod.GET)  
    public String pageqmzxindex(Model model){
        return "/qmzx/qmzxindex";  
    }
	@RequestMapping(value="1",method=RequestMethod.GET)  
	public String page1(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("宇宙之战");
		model.addAttribute("resultList", resultList);
        return "/qmzx/1";  
    }
	@RequestMapping(value="2",method=RequestMethod.GET)  
	public String page2(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("最重要的问题");
		model.addAttribute("resultList", resultList);
        return "/qmzx/2";  
    }
	@RequestMapping(value="3",method=RequestMethod.GET)  
	public String page3(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("最高的目标");
		model.addAttribute("resultList", resultList);
        return "/qmzx/3";  
    }
	@RequestMapping(value="4",method=RequestMethod.GET)  
	public String page4(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("奇妙探险");
		model.addAttribute("resultList", resultList);
        return "/qmzx/4";  
    }
	@RequestMapping(value="5",method=RequestMethod.GET)  
	public String page5(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("信仰方程式");
		model.addAttribute("resultList", resultList);
        return "/qmzx/5";  
    }
	@RequestMapping(value="6",method=RequestMethod.GET)  
	public String page6(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("永远的福音I");
		model.addAttribute("resultList", resultList);
        return "/qmzx/6";  
    }
	@RequestMapping(value="7",method=RequestMethod.GET)  
	public String page7(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("永远的福音II");
		model.addAttribute("resultList", resultList);
        return "/qmzx/7";  
    }
	@RequestMapping(value="8",method=RequestMethod.GET)  
	public String page8(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("十诫系列");
		model.addAttribute("resultList", resultList);
        return "/qmzx/8";  
    }
	@RequestMapping(value="9",method=RequestMethod.GET)  
	public String page9(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("亲近上帝");
		model.addAttribute("resultList", resultList);
        return "/qmzx/9";  
    }
	@RequestMapping(value="10",method=RequestMethod.GET)  
	public String page10(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("最奇妙的圣经预言");
		model.addAttribute("resultList", resultList);
        return "/qmzx/10";  
    }
	@RequestMapping(value="11",method=RequestMethod.GET)  
	public String page11(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("天启概要");
		model.addAttribute("resultList", resultList);
        return "/qmzx/11";  
    }
	@RequestMapping(value="12",method=RequestMethod.GET)  
	public String page12(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("预言的地标");
		model.addAttribute("resultList", resultList);
        return "/qmzx/12";  
    }
	@RequestMapping(value="13",method=RequestMethod.GET)  
	public String page13(Model model){
		List<QMZXDO> resultList=qmzxService.findListByFubiaoti("信心的勇士");
		model.addAttribute("resultList", resultList);
        return "/qmzx/13";  
    }
	@RequestMapping(value="qmzxend",method=RequestMethod.GET)  
	public String pageqmzxend(Model model){
        return "/qmzx/qmzxend";  
    }
	 
	
	
}

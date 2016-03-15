package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.dao.entity.SJZLDO;
import com.weishengming.service.SJZLService;

/**
 * @author 杨天赐
 * 圣经纵览控制层接口
 */
@Controller
@RequestMapping(value = "sjzl")
public class SJZLController extends SecurityController{
	Logger logger = LoggerFactory.getLogger(SJZLController.class);
	@Resource
	private SJZLService sjzlService;
	
	@RequestMapping(value="sjzlindex",method=RequestMethod.GET)  
    public String pagesjzlindex(Model model){
        return "/sjzl/sjzlindex";  
    }
	@RequestMapping(value="1-5",method=RequestMethod.GET)  
	public String page1(Model model){
		List<SJZLDO> resultList=sjzlService.findListByFubiaoti("律法书");
		model.addAttribute("resultList", resultList);
        return "/sjzl/1-5";  
    }
	
	@RequestMapping(value="6-17",method=RequestMethod.GET)  
	public String page2(Model model){
		List<SJZLDO> resultList=sjzlService.findListByFubiaoti("历史书");
		model.addAttribute("resultList", resultList);
        return "/sjzl/6-17";  
    }
	@RequestMapping(value="18-22",method=RequestMethod.GET)  
	public String page3(Model model){
		List<SJZLDO> resultList=sjzlService.findListByFubiaoti("诗歌智慧书");
		model.addAttribute("resultList", resultList);
        return "/sjzl/18-22";  
    }
	@RequestMapping(value="23-39",method=RequestMethod.GET)  
	public String page4(Model model){
		List<SJZLDO> resultList=sjzlService.findListByFubiaoti("先知书");
		model.addAttribute("resultList", resultList);
        return "/sjzl/23-39";  
    }
	
	@RequestMapping(value="40-43",method=RequestMethod.GET)  
	public String page5(Model model){
		List<SJZLDO> resultList=sjzlService.findListByFubiaoti("四福音书");
		model.addAttribute("resultList", resultList);
        return "/sjzl/40-43";  
    }
	@RequestMapping(value="44",method=RequestMethod.GET)  
	public String page6(Model model){
		List<SJZLDO> resultList=sjzlService.findListByFubiaoti("使徒行传");
		model.addAttribute("resultList", resultList);
        return "/sjzl/44";  
    }
	@RequestMapping(value="45-65",method=RequestMethod.GET)  
	public String page7(Model model){
		List<SJZLDO> resultList=sjzlService.findListByFubiaoti("保罗书信");
		model.addAttribute("resultList", resultList);
        return "/sjzl/45-65";  
    }
	@RequestMapping(value="66",method=RequestMethod.GET)  
	public String page8(Model model){
		List<SJZLDO> resultList=sjzlService.findListByFubiaoti("启示录");
		model.addAttribute("resultList", resultList);
        return "/sjzl/66";  
    }
	 
	@RequestMapping(value="sjzlend",method=RequestMethod.GET)  
	public String pagesjzlend(Model model){
        return "/sjzl/sjzlend";  
    }
	 
	
	
}

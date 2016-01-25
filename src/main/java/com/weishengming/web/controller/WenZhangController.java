package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.dao.entity.WenZhangDO;
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

	/*****人性的弱点 START*******/
	@RequestMapping(value="ttsdindex",method=RequestMethod.GET)  
    public String rxdrd0(Model model){
        return "/ttsd/ttsdindex";  
    }
	@RequestMapping(value="/rxdrd/1",method=RequestMethod.GET)  
    public String rxdrd1(Model model){
		List<WenZhangDO> resultList=wenzhangService.findListByFubiaoti("待人的基本技巧");
		model.addAttribute("resultList", resultList);
        return "/rxdrd/1";  
    }
	@RequestMapping(value="/rxdrd/1",method=RequestMethod.GET)  
    public String rxdrd2(Model model){
		List<WenZhangDO> resultList=wenzhangService.findListByFubiaoti("使人喜欢你的六种方法");
		model.addAttribute("resultList", resultList);
        return "/rxdrd/1";  
    }
	@RequestMapping(value="/rxdrd/1",method=RequestMethod.GET)  
    public String rxdrd3(Model model){
		List<WenZhangDO> resultList=wenzhangService.findListByFubiaoti("使得人同意于你的十二种方法");
		model.addAttribute("resultList", resultList);
        return "/rxdrd/1";  
    }
	@RequestMapping(value="/rxdrd/1",method=RequestMethod.GET)  
    public String rxdrd4(Model model){
		List<WenZhangDO> resultList=wenzhangService.findListByFubiaoti("智慧人生");
		model.addAttribute("resultList", resultList);
        return "/rxdrd/1";  
    }
	@RequestMapping(value="/rxdrd/1",method=RequestMethod.GET)  
    public String rxdrd5(Model model){
		List<WenZhangDO> resultList=wenzhangService.findListByFubiaoti("智慧人生");
		model.addAttribute("resultList", resultList);
        return "/rxdrd/1";  
    }
	@RequestMapping(value="/rxdrd/6",method=RequestMethod.GET)  
    public String rxdrd6(Model model){
		List<WenZhangDO> resultList=wenzhangService.findListByFubiaoti("智慧人生");
		model.addAttribute("resultList", resultList);
        return "/rxdrd/1";  
    }
	/*****人性的弱点 END*******/
	public WenZhangService getWenzhangService() {
		return wenzhangService;
	}
	public void setWenzhangService(WenZhangService wenzhangService) {
		this.wenzhangService = wenzhangService;
	}
	

}

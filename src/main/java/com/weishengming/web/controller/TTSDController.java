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
 * @author 杨天赐 谈天说地控制层接口
 */
@Controller
@RequestMapping(value = "ttsd")
public class TTSDController  extends SecurityController {
	Logger logger = LoggerFactory.getLogger(TTSDController.class);
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
	@RequestMapping(value="49-93",method=RequestMethod.GET)  
    public String page2(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("人际金律");
		model.addAttribute("resultList", resultList);
        return "/ttsd/49-93";  
    }
	@RequestMapping(value="94-137",method=RequestMethod.GET)  
    public String page3(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("心灵故事");
		model.addAttribute("resultList", resultList);
        return "/ttsd/94-137";  
    }
	@RequestMapping(value="138-185",method=RequestMethod.GET)  
    public String page4(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("爱的诗歌");
		model.addAttribute("resultList", resultList);
        return "/ttsd/138-185";  
    }
	@RequestMapping(value="164-183",method=RequestMethod.GET)  
    public String page5(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("伊甸风云");
		model.addAttribute("resultList", resultList);
        return "/ttsd/164-183";  
    }
	@RequestMapping(value="186-207",method=RequestMethod.GET)  
    public String page6(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("欲海警笛");
		model.addAttribute("resultList", resultList);
        return "/ttsd/186-207";  
    }
	@RequestMapping(value="208-299",method=RequestMethod.GET)  
    public String page7(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("夜半歌声");
		model.addAttribute("resultList", resultList);
        return "/ttsd/208-299";  
    }
	@RequestMapping(value="230-244",method=RequestMethod.GET)  
    public String page8(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("与神同行");
		model.addAttribute("resultList", resultList);
        return "/ttsd/230-244";  
    }
	@RequestMapping(value="245-266",method=RequestMethod.GET)  
    public String page9(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("尽忠天职");
		model.addAttribute("resultList", resultList);
        return "/ttsd/245-266";  
    }
	@RequestMapping(value="267-290",method=RequestMethod.GET)  
    public String page10(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("溪边捡石");
		model.addAttribute("resultList", resultList);
        return "/ttsd/267-290";  
    }
	@RequestMapping(value="291-341",method=RequestMethod.GET)  
    public String page11(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("心海拾贝");
		model.addAttribute("resultList", resultList);
        return "/ttsd/291-341";  
    }
	@RequestMapping(value="342-365",method=RequestMethod.GET)  
    public String page12(Model model){
		List<TTSDDO> resultList=ttsdService.findListByFubiaoti("永恒之恋");
		model.addAttribute("resultList", resultList);
        return "/ttsd/342-365";  
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

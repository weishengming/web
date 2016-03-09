package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.dao.entity.ShiPinDO;
import com.weishengming.service.ShiPinService;

/**
 * @author 杨天赐
 * 视频控制层接口
 */
@Controller
@RequestMapping(value = "shipin")
public class ShiPinController extends SecurityController{
	Logger logger = LoggerFactory.getLogger(ShiPinController.class);
	@Resource
	private ShiPinService shipinService;
	
	
	
	/******麦希真牧师   START******/
	@RequestMapping(value="shipingmrs",method=RequestMethod.GET)  
    public String shipingmrs(Model model){
		List<ShiPinDO> resultList=shipinService.findListByFubiaoti("光明人生");
		model.addAttribute("resultList", resultList);
        return "/shipin/shipingmrs";  
    }
	@RequestMapping(value="shipinxfrs",method=RequestMethod.GET)  
    public String shipinxfrs(Model model){
		List<ShiPinDO> resultList=shipinService.findListByFubiaoti("幸福人生");
		model.addAttribute("resultList", resultList);
        return "/shipin/shipinxfrs";  
    }
	@RequestMapping(value="shipinffrs",method=RequestMethod.GET)  
    public String shipinffrs(Model model){
		List<ShiPinDO> resultList=shipinService.findListByFubiaoti("丰富人生");
		model.addAttribute("resultList", resultList);
        return "/shipin/shipinffrs";  
    }
	/******麦希真牧师   END******/

}

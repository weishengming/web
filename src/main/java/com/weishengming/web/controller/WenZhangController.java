package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	/**
	 * 进入到文章首页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="wenzhang",method=RequestMethod.GET)  
    public String wenzhang(Model model){
		List<WenZhangDO> wenzhanglist=wenzhangService.findAll();
		model.addAttribute("resultList", wenzhanglist);
        return "/wenzhang/wenzhang";  
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/wenzhangxiangxi/{id}")
    public String wenzhangedit(@PathVariable Long id, Model model) {
        final WenZhangDO wenzhangDO = wenzhangService.findOne(id);
        model.addAttribute("model", wenzhangDO);
        return "/wenzhang/wenzhangxiangxi"; 
    }
	 
	public WenZhangService getWenzhangService() {
		return wenzhangService;
	}
	public void setWenzhangService(WenZhangService wenzhangService) {
		this.wenzhangService = wenzhangService;
	}
	

}

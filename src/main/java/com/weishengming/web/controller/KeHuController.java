package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.service.KeHuService;

/**
 * @author 杨天赐
 * 客户控制
 */
@Controller
@RequestMapping(value="kehu")
public class KeHuController {
	@Resource
	private KeHuService kehuService;
	
	/**
	 * @return
	 * 进入客户信息页面
	 */
	@RequestMapping(value="kehuxinxiPage")
	public String kehuxinxiPage(){
		return "kehu/kehuxinxi";
	}
	
	/**
	 * 进入到客户列表页面
	 * @return
	 */
	@RequestMapping(value="kehulistPage")
	public String kehulistPage(Model m){
		// 查询客户的信息
		List<KeHuDO> list=kehuService.findAll();
		m.addAttribute("kehulist", list);
		return "kehu/kehulist";
	}
	

}

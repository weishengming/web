package com.weishengming.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.weishengming.web.dao.CollectionConstants;
import com.weishengming.web.dao.MongoDB;

/**
 * @author 杨天赐
 * 客户控制
 */
@Controller
@RequestMapping(value="kehu")
public class KeHuController {
	
	
	/**
	 * 显示列表信息
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="list",method=RequestMethod.GET)  
	public String list(Model model){
		BasicDBObject kehu = new BasicDBObject();			
//		kehu.put("xingming",null);
//		kehu.put("nicheng", null);// 查询字段
		List kehulist=MongoDB.findList(CollectionConstants.KEHU, CollectionConstants.KEHU_XINGMING, kehu);
		model.addAttribute("kehulist", kehulist);
		return "kehu/kehulist";   
	}
	@RequestMapping(value="edit",method=RequestMethod.GET)  
	public String edit(){
		return "edit";
	}

}

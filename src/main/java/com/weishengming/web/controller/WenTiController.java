package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.WenTiDO;
import com.weishengming.service.WenTiService;

/**
 * @author 杨天赐 问题控制层接口
 */
@Controller
@RequestMapping(value = "wenti")
public class WenTiController extends SecurityController {
	Logger logger = LoggerFactory.getLogger(WenTiController.class);
	private final String UPDATE_ACTION = "redirect:/wenti/wentiupdate";
	private final String WENTI_VIEW_PATH = "/wenti/";
	@Resource
	private WenTiService wentiService;

	@RequestMapping(method = RequestMethod.GET, value = "/wentiupdate")
	public String update(HttpServletRequest request, Model model) {
        if(getName(request)==null){
        	request.getSession().setAttribute("redirectURL", "/wenti/wentiupdate");
        	return "redirect:/qqLogin";
        }
        logger.info("进入到问题页面");
		List<WenTiDO> weiTiViewList = wentiService.findListByOpenID(getOpenID(request));
		model.addAttribute("resultViewList", weiTiViewList);
		return WENTI_VIEW_PATH + "wentiupdate";
        
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model,HttpServletRequest request) {
    	final WenTiDO wentiDO=wentiService.findOne(id);
    	model.addAttribute("model",wentiDO);
    	
    	List<WenTiDO> weiTiViewList = wentiService.findListByOpenID(getOpenID(request));
		model.addAttribute("resultViewList", weiTiViewList);
		
        return WENTI_VIEW_PATH+"wentiupdate";
    } 
	    
	 /**
	 * 更新
	 * @param entity
	 * @return
	 */
   @RequestMapping(method = RequestMethod.POST, value = "/update")
   public String put(WenTiDO entity) {
	   if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	wentiService.create(entity);
	   }else{
		    wentiService.update(entity);
	   }
	
	   return UPDATE_ACTION;
   }
	   
   @RequestMapping(value = "/delete/{id}")
   public String delete(@PathVariable Long id) {
	   wentiService.delete(id);
	   return UPDATE_ACTION;
   }
	

	public WenTiService getWentiService() {
		return wentiService;
	}

	public void setWentiService(WenTiService wentiService) {
		this.wentiService = wentiService;
	}

}

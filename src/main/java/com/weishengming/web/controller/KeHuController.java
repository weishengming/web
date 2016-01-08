package com.weishengming.web.controller;

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
import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.service.KeHuService;

/**
 * @author 杨天赐
 * 客户控制 
 */
@Controller
@RequestMapping(value="kehu")
public class KeHuController extends SecurityController{
	Logger  logger = LoggerFactory.getLogger(KeHuController.class);
    private final String UPDATE_ACTION = "redirect:/kehu/kehuupdate";
    private final String KEHU_VIEW_PATH = "/kehu/";
	
	@Resource
	private KeHuService kehuService;
	@RequestMapping(method = RequestMethod.GET, value = "/kehuupdate")
	public String update(HttpServletRequest request, Model model) {
        if(getName(request)==null){
        	request.getSession().setAttribute("redirectURL", "/kehu/kehuupdate");
        	return "redirect:/qqLogin";
        }
        logger.info("进入到客户页面");
		KeHuDO kehuDO = kehuService.findOneByOpenID(getOpenID(request));
		model.addAttribute("model", kehuDO);
		return KEHU_VIEW_PATH + "kehuupdate";
        
		
	}
	 /**
	 * 更新
	 * @param entity
	 * @return
	 */
   @RequestMapping(method = RequestMethod.POST, value = "/update")
   public String put(KeHuDO entity) {
	   if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	kehuService.create(entity);
	   }else{
		   kehuService.update(entity);
	   }
	
	   return UPDATE_ACTION;
   }

	public KeHuService getKehuService() {
		return kehuService;
	}

	public void setKehuService(KeHuService kehuService) {
		this.kehuService = kehuService;
	}

}

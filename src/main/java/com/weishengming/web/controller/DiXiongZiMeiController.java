package com.weishengming.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.DiXiongZiMeiDO;
import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.service.DiXiongZiMeiService;
import com.weishengming.service.KeHuService;

/**
 * @author 杨天赐
 * 弟兄姊妹控制层 
 */
@Controller
@RequestMapping(value="dixiongzimei")
public class DiXiongZiMeiController extends SecurityController{
	Logger  logger = LoggerFactory.getLogger(DiXiongZiMeiController.class);
    private final String UPDATE_ACTION = "redirect:/dixiongzimei/dixiongzimeiupdate";
    private final String DIXIONGZIMEI_VIEW_PATH = "/dixiongzimei/";
	
	@Resource
	private DiXiongZiMeiService dixiongzimeiService;
	@RequestMapping(method = RequestMethod.GET, value = "/dixiongzimeiupdate")
	public String update(HttpServletRequest request, Model model) {
        if(getName(request)==null){
        	request.getSession().setAttribute("redirectURL", "/dixiongzimei/dixiongzimeiupdate");
        	return "redirect:/qqLogin";
        }
        logger.info("进入到弟兄姊妹页面");
		DiXiongZiMeiDO dixiongzimeiDO = dixiongzimeiService.findOneByOpenID(getOpenID(request));
		model.addAttribute("model", dixiongzimeiDO);
		return DIXIONGZIMEI_VIEW_PATH + "dixiongzimeiupdate";
        
		
	}
	 /**
	 * 更新
	 * @param entity
	 * @return
	 */
   @RequestMapping(method = RequestMethod.POST, value = "/update")
   public String put(DiXiongZiMeiDO entity) {
	   if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	dixiongzimeiService.create(entity);
	   }else{
		    dixiongzimeiService.update(entity);
	   }
	
	   return UPDATE_ACTION;
   }
	public DiXiongZiMeiService getDixiongzimeiService() {
		return dixiongzimeiService;
	}
	public void setDixiongzimeiService(DiXiongZiMeiService dixiongzimeiService) {
		this.dixiongzimeiService = dixiongzimeiService;
	}
}

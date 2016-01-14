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
import com.weishengming.dao.entity.ZiYuanDO;
import com.weishengming.service.ZiYuanService;

@Controller
@RequestMapping(value = "ziyuan")
public class ZiYuanController  extends SecurityController {
	Logger  logger = LoggerFactory.getLogger(ZiYuanController.class);
    private final String UPDATE_ACTION = "redirect:/ziyuan/ziyuanupdate";
    private final String ZIYUAN_VIEW_PATH = "/ziyuan/";
    @Resource
    private ZiYuanService ziyuanService;
    

	@RequestMapping(method = RequestMethod.GET, value = "/ziyuanupdate")
	public String update(HttpServletRequest request, Model model) {
       if(getName(request)==null){
        	request.getSession().setAttribute("redirectURL", "/ziyuan/ziyuanupdate");
        	return "redirect:/qqLogin";
        }
        logger.info("进入到资源页面");
		List<ZiYuanDO> ziYuanViewList = ziyuanService.findAll();
		model.addAttribute("resultViewList", ziYuanViewList);
		return ZIYUAN_VIEW_PATH + "ziyuanupdate";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model,HttpServletRequest request) {
    	final ZiYuanDO ZiYuanDO=ziyuanService.findOne(id);
    	model.addAttribute("model",ZiYuanDO);
    	
    	List<ZiYuanDO> ziYuanViewList = ziyuanService.findAll();
		model.addAttribute("resultViewList", ziYuanViewList);
		
        return ZIYUAN_VIEW_PATH+"ziyuanupdate";
    } 
	    
	 /**
	 * 更新
	 * @param entity
	 * @return
	 */
   @RequestMapping(method = RequestMethod.POST, value = "/update")
   public String put(ZiYuanDO entity) {
	   if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	ziyuanService.create(entity);
	   }else{
		    ziyuanService.update(entity);
	   }
	
	   return UPDATE_ACTION;
   }
	   
   @RequestMapping(value = "/delete/{id}")
   public String delete(@PathVariable Long id) {
	   ziyuanService.delete(id);
	   return UPDATE_ACTION;
   }
	
	
    
	
    public ZiYuanService getZiyuanService() {
		return ziyuanService;
	}

	public void setZiyuanService(ZiYuanService ziyuanService) {
		this.ziyuanService = ziyuanService;
	}
    

}

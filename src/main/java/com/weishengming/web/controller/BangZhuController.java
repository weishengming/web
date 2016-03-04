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
import com.weishengming.dao.entity.BangZhuDO;
import com.weishengming.dao.entity.DiXiongZiMeiDO;
import com.weishengming.service.BangZhuService;
import com.weishengming.service.DiXiongZiMeiService;

/**
 * @author 杨天赐
 * 帮助controller
 */
@Controller
@RequestMapping(value="bangzhu")
public class BangZhuController extends SecurityController{
	Logger  logger = LoggerFactory.getLogger(BangZhuController.class);
	
	@Resource
	private BangZhuService bangzhuService;
	
	@Resource
	private DiXiongZiMeiService dixiongzimeiService;
	
	/**
	 * 进入弟兄姊妹地址页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/bangzhu")
	public String bangzhu(HttpServletRequest request, Model model) {
//        if(getName(request)==null){
//        	request.getSession().setAttribute("redirectURL", "/bangzhu/bangzhu");
//        	return "redirect:/qqLogin";
//        }
        logger.info("进入帮助页面");
        //EBEDEDF615FEE34A4DCCA75BEE2EAAA3
//        List<BangZhuDO> bangzhuList=bangzhuService.findListByOpenID(getOpenID(request));
        List<BangZhuDO> bangzhuList=bangzhuService.findListByOpenID("EBEDEDF615FEE34A4DCCA75BEE2EAAA3");
        model.addAttribute("resultViewList", bangzhuList);
//        DiXiongZiMeiDO dixiongzimeiDO=dixiongzimeiService.findOneByOpenID(getOpenID(request));
        DiXiongZiMeiDO dixiongzimeiDO=dixiongzimeiService.findOneByOpenID("EBEDEDF615FEE34A4DCCA75BEE2EAAA3");
        model.addAttribute("dixiongzimei", dixiongzimeiDO);
        return "/bangzhu/bangzhu";
	}
    
    /**
   	 * 添加
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/bangzhugengxin")
    public String bangzhugengxin(BangZhuDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	bangzhuService.create(entity);
	   }else{
		    bangzhuService.update(entity);
	   }
   	   return "redirect:/bangzhu/bangzhu";
    }
   	
   	/**
   	 * 删除
   	 * @param id
   	 * @return
   	 */
   	@RequestMapping(value = "/bangzhudelete/{id}")
    public String bangzhudelete(@PathVariable Long id) {
   		bangzhuService.delete(id);
 	  return "redirect:/bangzhu/bangzhu";
    }

	public BangZhuService getBangzhuService() {
		return bangzhuService;
	}

	public void setBangzhuService(BangZhuService bangzhuService) {
		this.bangzhuService = bangzhuService;
	}

	public DiXiongZiMeiService getDixiongzimeiService() {
		return dixiongzimeiService;
	}

	public void setDixiongzimeiService(DiXiongZiMeiService dixiongzimeiService) {
		this.dixiongzimeiService = dixiongzimeiService;
	}
	
	
	 
}

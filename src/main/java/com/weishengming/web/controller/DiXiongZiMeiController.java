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
import com.weishengming.service.DiXiongZiMeiService;
import com.weishengming.service.DiZhiService;
import com.weishengming.service.JDAreaService;

/**
 * @author 杨天赐
 * 弟兄姊妹控制层 
 */
@Controller
@RequestMapping(value="dixiongzimei")
public class DiXiongZiMeiController extends SecurityController{
	Logger  logger = LoggerFactory.getLogger(DiXiongZiMeiController.class);
	
	@Resource
	private DiXiongZiMeiService dixiongzimeiService;
	@Resource
	private DiZhiService dizhiService;
	@Resource
	private JDAreaService jdAreaService;
	
	/**
	 * 进入弟兄姊妹页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/dixiongzimei")
	public String update(HttpServletRequest request, Model model) {
//        if(getName(request)==null){
//        	request.getSession().setAttribute("redirectURL", "/dixiongzimei/dixiongzimeiedit");
//        	return "redirect:/qqLogin";
//        }
		String openid="EBEDEDF615FEE34A4DCCA75BEE2EAAA3";
		String nickname="微生命";
        logger.info("进入到弟兄姊妹页面");
//		DiXiongZiMeiDO dixiongzimeiDO = dixiongzimeiService.findOneByOpenID(getOpenID(request));
		DiXiongZiMeiDO dixiongzimeiDO = dixiongzimeiService.findOneByOpenID(openid);
		model.addAttribute("model", dixiongzimeiDO);
        if(dixiongzimeiDO==null){
        	dixiongzimeiDO=new DiXiongZiMeiDO();
//        	dixiongzimeiDO.setNickname(getName(request));
//        	dixiongzimeiDO.setOpenID(getOpenID(request));
        	dixiongzimeiDO.setNickname(nickname);
        	dixiongzimeiDO.setOpenID(openid);
        	model.addAttribute("model", dixiongzimeiDO);
        }
        return "/dixiongzimei/dixiongzimei";
	}
	
	 /**
	 * 更新弟兄姊妹信息
	 * @param entity
	 * @return
	 */
   @RequestMapping(method = RequestMethod.POST, value = "/dixiongzimeigengxin")
   public String put(DiXiongZiMeiDO entity) {
	   if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	dixiongzimeiService.create(entity);
	   }else{
		    dixiongzimeiService.update(entity);
	   }
	   return "redirect:/dixiongzimei/dixiongzimei";
   }
   
	public DiXiongZiMeiService getDixiongzimeiService() {
		return dixiongzimeiService;
	}
	public void setDixiongzimeiService(DiXiongZiMeiService dixiongzimeiService) {
		this.dixiongzimeiService = dixiongzimeiService;
	}
}

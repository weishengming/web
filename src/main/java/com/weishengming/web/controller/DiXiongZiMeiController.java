package com.weishengming.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.converter.Converter;
import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.DiXiongZiMeiDO;
import com.weishengming.dao.query.DiXiongZiMeiQuery;
import com.weishengming.dao.query.ResultPage;
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
	
	/**
	 * 进入弟兄姊妹页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/dixiongzimei")
	public String dixiongzimei(HttpServletRequest request, Model model) {
        if(getName(request)==null){
        	request.getSession().setAttribute("redirectURL", "/dixiongzimei/dixiongzimei");
        	return "redirect:/qqLogin";
        }
        logger.info("进入到弟兄姊妹页面");
		DiXiongZiMeiDO dixiongzimeiDO = dixiongzimeiService.findOneByOpenID(getOpenID(request));
		model.addAttribute("model", dixiongzimeiDO);
        if(dixiongzimeiDO==null){
        	dixiongzimeiDO=new DiXiongZiMeiDO();
        	dixiongzimeiDO.setNickname(getName(request));
        	dixiongzimeiDO.setOpenID(getOpenID(request));
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
   public String dixiongzimeigengxin(DiXiongZiMeiDO entity) {
	   if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	dixiongzimeiService.create(entity);
	   }else{
		    dixiongzimeiService.update(entity);
	   }
	   return "redirect:/dixiongzimei/dixiongzimei";
   }
   
    /**
	 * 进入弟兄列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/dixiong")
	public String dixiong(Model model, DiXiongZiMeiQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到牧师列表页面");
        query.putPnIntoPageNumber(pn);
        query.setXingbie("男");
        query.putPnIntoPageSize(changePageSize);
        ResultPage<DiXiongZiMeiDO> result = dixiongzimeiService.findPage(query);
        String pageUrl = "/dixiongzimei/dixionglist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
		return "/dixiongzimei/dixionglist";
	}
	
    /**
	 * 进入姊妹列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/zimei")
	public String zimei(Model model, DiXiongZiMeiQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到信徒列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        query.setXingbie("女");
        ResultPage<DiXiongZiMeiDO> result = dixiongzimeiService.findPage(query);
        String pageUrl = "/dixiongzimei/zimeilist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
       return "/dixiongzimei/zimeilist";
	}
   
	public DiXiongZiMeiService getDixiongzimeiService() {
		return dixiongzimeiService;
	}
	public void setDixiongzimeiService(DiXiongZiMeiService dixiongzimeiService) {
		this.dixiongzimeiService = dixiongzimeiService;
	}
}

package com.weishengming.web.admin.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.converter.Converter;
import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.DiXiongZiMeiDO;
import com.weishengming.dao.query.DiXiongZiMeiQuery;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.service.DiXiongZiMeiService;
import com.weishengming.web.controller.SecurityController;

/**
 * @author 杨天赐
 * 弟兄姊妹后台管理
 */
@Controller
@RequestMapping(value = "/admin/dixiongzimei")
public class AdminDiXiongZiMeiController extends SecurityController{
	Logger logger = LoggerFactory.getLogger(AdminDiXiongZiMeiController.class);

	@Resource
	private DiXiongZiMeiService dixiongzimeiService;
	
	/**
	 * 进入到弟兄姊妹列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/dixiongzimeilist")
    public String dixiongzimeilist(Model model, DiXiongZiMeiQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到弟兄姊妹管理列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<DiXiongZiMeiDO> result = dixiongzimeiService.findPage(query);
        String pageUrl = "/admin/dixiongzimei/dixiongzimeilist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/dixiongzimei/dixiongzimeilist";
    }
	
	
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/dixiongzimei_ajax/{id}")
    public String dixiongzimei_ajax(String id, Model model) {
        final DiXiongZiMeiDO dixiongzimeiDO = dixiongzimeiService.findOne(Long.parseLong(id));
        model.addAttribute("model", dixiongzimeiDO);
        return "/admin/dixiongzimei/dixiongzimei_ajax";
    }
	
	
	
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dixiongzimeiedit/{id}")
    public String dixiongzimeiedit(@PathVariable Long id, Model model) {
        final DiXiongZiMeiDO dixiongzimeiDO = dixiongzimeiService.findOne(id);
        model.addAttribute("model", dixiongzimeiDO);
        return "/admin/dixiongzimei/dixiongzimeiupdate";
    }
	 
 
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/dixiongzimeiupdate")
    public String dixiongzimeiupdate(DiXiongZiMeiDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	dixiongzimeiService.create(entity);
	   }else{
		    dixiongzimeiService.update(entity);
	   }
   		return "redirect:/admin/dixiongzimei/dixiongzimeilist";
    }
   	
	@RequestMapping(value = "/dixiongzimeidelete/{id}")
    public String dixiongzimeidelete(@PathVariable Long id) {
	   dixiongzimeiService.delete(id);
   	   return "redirect:/admin/dixiongzimei/dixiongzimeilist";
    }
   	
   	public DiXiongZiMeiService getDixiongzimeiService() {
		return dixiongzimeiService;
	}

	public void setDixiongzimeiService(DiXiongZiMeiService dixiongzimeiService) {
		this.dixiongzimeiService = dixiongzimeiService;
	}
	
}

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
import com.weishengming.dao.entity.LeiXingDO;
import com.weishengming.dao.query.LeiXingQuery;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.service.LeiXingService;
import com.weishengming.web.controller.SecurityController;

/**
 * @author 杨天赐
 * 类型管理
 */
@Controller
@RequestMapping(value = "/admin/leixing")
public class AdminLeiXingController extends SecurityController{
	
	Logger logger = LoggerFactory.getLogger(AdminLeiXingController.class);
	@Resource
	private LeiXingService leixingService;
	
	/**
	 * 进入到类型列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/leixinglist")
    public String leixinglist(Model model, LeiXingQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到类型列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<LeiXingDO> result = leixingService.findPage(query);
        String pageUrl = "/admin/leixing/leixinglist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/leixing/leixinglist";
    }
	
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/leixingedit/{id}")
    public String leixingedit(@PathVariable Long id, Model model) {
        final LeiXingDO leixingDO = leixingService.findOne(id);
        model.addAttribute("model", leixingDO);
        return "/admin/leixing/leixingupdate";
    }
    
    /**
     * 
     * 编辑子类型 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/zileixingedit/{id}")
    public String zileixingedit(@PathVariable Long id, Model model) {
        final LeiXingDO leixingDO = leixingService.findOne(id);
        model.addAttribute("model", leixingDO);
        return "/admin/leixing/zileixingupdate";
    }
    
    /**
     * 删除类型
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/leixingdelete/{id}")
    public String leixingdelete(@PathVariable Long id){
   		if(id!=null){
   			leixingService.delete(id);
   			return "redirect:/admin/leixing/leixinglist";
   		}
   		return null;
   	}
	 
 
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/leixingupdate")
    public String leixingupdate(LeiXingDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	leixingService.create(entity);
	   }else{
		   leixingService.update(entity);
	   }
   		return "redirect:/admin/leixing/leixinglist";
    }
    /**
   	 * 添加子类型
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/zileixingupdate")
    public String zileixingupdate(LeiXingDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	leixingService.create(entity);
	   }else{
		   leixingService.update(entity);
	   }
   		return "redirect:/admin/leixing/leixinglist";
    }
   	public LeiXingService getLeixingService() {
		return leixingService;
	}

	public void setLeixingService(LeiXingService leixingService) {
		this.leixingService = leixingService;
	}
}

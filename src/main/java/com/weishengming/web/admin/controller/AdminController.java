package com.weishengming.web.admin.controller;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.converter.Converter;
import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.DiZhiDO;
import com.weishengming.dao.entity.JDAreaDO;
import com.weishengming.dao.entity.QMZXDO;
import com.weishengming.dao.entity.TTSDDO;
import com.weishengming.dao.query.QMZXQuery;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.TTSDQuery;
import com.weishengming.service.DiZhiService;
import com.weishengming.service.JDAreaService;
import com.weishengming.service.QMZXService;
import com.weishengming.service.TTSDService;
import com.weishengming.web.controller.SecurityController;
/**
 * @author 杨天赐
 * web控制数据接口  只有 OPENID=杨天赐 才可以访问这个功能
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController  extends SecurityController {
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Resource
	private TTSDService ttsdService;
	
	@Resource
	private QMZXService qmzxService;
	
	
	/**
	 * 进入到后台首页
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/adminindex")
	public String adminindex(){
		return "/admin/adminindex";
	}
	
	/**********奇妙真相管理START**************/
	/**
	 * 进入到奇妙真相列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/qmzx/qmzxlist")
    public String qmzxlist(Model model, QMZXQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到奇妙真相列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<QMZXDO> result = qmzxService.findPage(query);
        String pageUrl = "/admin/qmzx/qmzxlist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/qmzx/qmzxlist";
    }
	
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/qmzx/qmzxedit/{id}")
    public String qmzxedit(@PathVariable Long id, Model model) {
        final QMZXDO qmzxDO = qmzxService.findOne(id);
        model.addAttribute("model", qmzxDO);
        return "/admin/qmzx/qmzxupdate";
    }
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/qmzx/qmzxupdate")
    public String qmzxupdate(QMZXDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	qmzxService.create(entity);
	   }else{
		    qmzxService.update(entity);
	   }
   		return "redirect:/admin/qmzx/qmzxlist";
    }
	
	public QMZXService getQmzxService() {
		return qmzxService;
	}

	public void setQmzxService(QMZXService qmzxService) {
		this.qmzxService = qmzxService;
	}
	
	/**********奇妙真相管理END**************/
	
	
	
	/**********谈天说地管理 START***************/
	/**
	 * 进入到谈天说地列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/ttsd/ttsdlist")
    public String ttsdlist(Model model, TTSDQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到谈天说地列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<TTSDDO> result = ttsdService.findPage(query);
        String pageUrl = "/admin/ttsd/ttsdlist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/ttsd/ttsdlist";
    }
	
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/ttsd/ttsdedit/{id}")
    public String ttsdedit(@PathVariable Long id, Model model) {
        final TTSDDO ttsdDO = ttsdService.findOne(id);
        model.addAttribute("model", ttsdDO);
        return "/admin/ttsd/ttsdupdate";
    }
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/ttsd/ttsdupdate")
    public String ttsdupdate(TTSDDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	ttsdService.create(entity);
	   }else{
		    ttsdService.update(entity);
	   }
   		return "redirect:/admin/ttsd/ttsdlist";
    }

	public TTSDService getTtsdService() {
		return ttsdService;
	}

	public void setTtsdService(TTSDService ttsdService) {
		this.ttsdService = ttsdService;
	}
   	
   	/**********谈天说地管理 END***************/
	

}

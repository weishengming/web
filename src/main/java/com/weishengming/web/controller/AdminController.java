package com.weishengming.web.controller;
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
import com.weishengming.dao.entity.TTSDDO;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.TTSDQuery;
import com.weishengming.service.TTSDService;
/**
 * @author 杨天赐
 * web控制数据接口  只有 OPENID=杨天赐 才可以访问这个功能
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController  extends SecurityController {
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	private final String UPDATE_ACTION = "redirect:/admin/adminlist";
	private final String ADMIN_VIEW_PATH = "/admin/";
	
	@Resource
	private TTSDService ttsdService;
	
	/**
	 * 进入到后台首页
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/adminindex")
	public String adminindex(){
		return "/admin/adminindex";
	}
	
	/**
	 * 进入到客户列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/ttsd/ttsdlist")
    public String ttsdlist(Model model, TTSDQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到客户列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<TTSDDO> result = ttsdService.findPage(query);

       /* List<KeHuView> keHuViewList = new ArrayList<KeHuView>();
        for (KeHuDO sourceKeHu : result.getResult()) {
        	KeHuView targetKeHu = new KeHuView();
            BeanUtils.copyProperties(sourceKeHu, targetKeHu);
            keHuViewList.add(targetKeHu);
        }*/
        String pageUrl = "/admin/ttsdttsd/list?" + Converter.covertToQueryStr(query);
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
	

}

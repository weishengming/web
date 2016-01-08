package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.DiZhiDO;
import com.weishengming.dao.entity.JDAreaDO;
import com.weishengming.service.DiZhiService;
import com.weishengming.service.JDAreaService;

/**
 * @author 杨天赐
 * 地址的控制层接口
 */
@Controller
@RequestMapping(value="dizhi")
public class DiZhiController extends SecurityController{
	Logger  logger = LoggerFactory.getLogger(DiZhiController.class);
    private final String UPDATE_ACTION = "redirect:/dizhi/dizhiupdate";
    private final String DIZHI_VIEW_PATH = "/dizhi/";
    @Resource
	private JDAreaService jdAreaService;
	@Resource
	private DiZhiService dizhiService;
    

    
    /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dizhiupdate")
    public String update(HttpServletRequest request,Model model) {
        if(getName(request)==null){
        	request.getSession().setAttribute("redirectURL", "/dizhi/dizhiupdate");
        	return "redirect:/qqLogin";
        }
        logger.info("进入到地址页面");
        List<DiZhiDO> dizhiViewList=dizhiService.findListByOpenID(getOpenID(request));
        model.addAttribute("resultViewList", dizhiViewList);
        return DIZHI_VIEW_PATH+"dizhiupdate";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model,HttpServletRequest request) {
    	final DiZhiDO dizhiDO=dizhiService.findOne(id);
    	model.addAttribute("model",dizhiDO);
    	
    	List<DiZhiDO> dizhiViewList=dizhiService.findListByOpenID(getOpenID(request));
        model.addAttribute("resultViewList", dizhiViewList);
        return DIZHI_VIEW_PATH+"dizhiupdate";
    }

    
	 /**
	 * 更新
	 * @param entity
	 * @return
	 */
   @RequestMapping(method = RequestMethod.POST, value = "/update")
   public String put(DiZhiDO entity) {
	   if(StringUtils.isBlank(entity.getArea3Name())&&StringUtils.isNotBlank(entity.getArea3Id())){
	   		JDAreaDO jdarea=jdAreaService.findOneByAreaId(entity.getArea3Id());
	   		if(jdarea!=null){
	   			entity.setArea3Name(jdarea.getAreaName());
	   		}
   	   }
	   if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	dizhiService.create(entity);
	   }else{
		   dizhiService.update(entity);
	   }
	
	   return UPDATE_ACTION;
   }
   
   @RequestMapping(value = "/delete/{id}")
   public String delete(@PathVariable Long id) {
	   dizhiService.delete(id);
       return UPDATE_ACTION;
   }
    
  

	public DiZhiService getDizhiService() {
		return dizhiService;
	}

	public void setDizhiService(DiZhiService dizhiService) {
		this.dizhiService = dizhiService;
	}

}

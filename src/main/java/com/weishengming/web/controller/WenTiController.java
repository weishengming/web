package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.DiZhiDO;
import com.weishengming.dao.entity.JDAreaDO;
import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.dao.entity.WenTiDO;
import com.weishengming.dao.query.KeHuQuery;
import com.weishengming.service.KeHuService;
import com.weishengming.service.WenTiService;
import com.weishengming.web.view.KeHuView;

/**
 * @author 杨天赐 问题控制层接口
 */
@Controller
@RequestMapping(value = "wenti")
public class WenTiController extends SecurityController {
	Logger logger = LoggerFactory.getLogger(WenTiController.class);
	private final String LIST_ACTION = "redirect:/wenti/wentilist";
	private final String WENTI_VIEW_PATH = "/wenti/";
	@Resource
	private KeHuService kehuService;
	@Resource
	private WenTiService wentiService;

	@RequestMapping(method = RequestMethod.GET, value = "/wentilist")
	public String list(HttpServletResponse response, Model model,
			KeHuQuery query, Integer changePageSize, Integer pn) {
		logger.info("进入到问题列表页面");
		final KeHuDO keHuDO = kehuService.findKeHuByZhangHao(getZhangHao());
		KeHuView keHuView = new KeHuView();
		BeanUtils.copyProperties(keHuDO, keHuView);
		model.addAttribute("kehu", keHuView);
		List<WenTiDO> weiTiViewList = wentiService.findListByKehuZhangHao(getZhangHao());
		model.addAttribute("resultViewList", weiTiViewList);
		return WENTI_VIEW_PATH + "wentilist";
	}
	
	
	 @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
	    public String edit(@PathVariable Long id, Model model) {
	    	final WenTiDO wentiDO=wentiService.findOne(id);
	    	model.addAttribute("model",wentiDO);
	    	
	    	final KeHuDO keHuDO = kehuService.findKeHuByZhangHao(getZhangHao());
			KeHuView keHuView = new KeHuView();
			BeanUtils.copyProperties(keHuDO, keHuView);
			model.addAttribute("kehu", keHuView);
			List<WenTiDO> weiTiViewList = wentiService.findListByKehuZhangHao(getZhangHao());
			model.addAttribute("resultViewList", weiTiViewList);
			
	        return WENTI_VIEW_PATH+"wentilist";
	    }
	    
		 /**
		 * 更新
		 * @param entity
		 * @return
		 */
	   @RequestMapping(method = RequestMethod.POST, value = "/update")
	   public String put(WenTiDO entity) {
		   if(entity.getId()==null){
			    entity.setCreateDate(DateUtil.getCurrentDate());
		    	entity.setUpdateDate(DateUtil.getCurrentDate());
		    	wentiService.create(entity);
		   }else{
			    wentiService.update(entity);
		   }
		
		   return LIST_ACTION;
	   }
	   
	   @RequestMapping(value = "/delete/{id}")
	   public String delete(@PathVariable Long id) {
		   wentiService.delete(id);
	       return LIST_ACTION;
	   }
	
	
	

	public KeHuService getKehuService() {
		return kehuService;
	}

	public void setKehuService(KeHuService kehuService) {
		this.kehuService = kehuService;
	}

	public WenTiService getWentiService() {
		return wentiService;
	}

	public void setWentiService(WenTiService wentiService) {
		this.wentiService = wentiService;
	}

}

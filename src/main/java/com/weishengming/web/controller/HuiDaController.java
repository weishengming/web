package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.dao.entity.WenTiDO;
import com.weishengming.dao.query.KeHuQuery;
import com.weishengming.service.HuiDaService;
import com.weishengming.service.KeHuService;
import com.weishengming.web.view.KeHuView;

/**
 * @author 杨天赐
 * 回答的控制层接口
 */
@Controller
@RequestMapping(value = "huida")
public class HuiDaController extends SecurityController {
	Logger  logger = LoggerFactory.getLogger(HuiDaController.class);
    private final String LIST_ACTION = "redirect:/huida/huidalist";
    private final String HUIDA_VIEW_PATH = "/huida/";

    @Resource
	private KeHuService kehuService;
    
    @Resource
    private HuiDaService huidaService;

	@RequestMapping(method = RequestMethod.GET, value = "/huidalist")
	public String list(HttpServletResponse response, Model model) {
		logger.info("进入到回答列表页面");
		return HUIDA_VIEW_PATH + "huidalist";
	}
    
    
    
    
    
    
    
    
    
    

	public KeHuService getKehuService() {
		return kehuService;
	}

	public void setKehuService(KeHuService kehuService) {
		this.kehuService = kehuService;
	}
	public HuiDaService getHuidaService() {
		return huidaService;
	}

	public void setHuidaService(HuiDaService huidaService) {
		this.huidaService = huidaService;
	}

	

}

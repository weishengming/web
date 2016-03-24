package com.weishengming.web.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.converter.Converter;
import com.weishengming.dao.entity.GeiDO;
import com.weishengming.dao.query.GeiQuery;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.service.GeiService;

/**
 * @author 杨天赐
 * 给
 */
@Controller
@RequestMapping(value="gei")
public class GeiController extends SecurityController{
	Logger  logger = LoggerFactory.getLogger(GeiController.class);
	
	@Resource
	private GeiService geiService;
	
	
	@RequestMapping(method = RequestMethod.GET,value="/gei")
    public String gei(Model model, GeiQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到给的列表");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<GeiDO> result = geiService.findPage(query);
        String pageUrl = "/gei/gei?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/gei/gei";
    }
	
	public GeiService getGeiService() {
		return geiService;
	}

	public void setGeiService(GeiService geiService) {
		this.geiService = geiService;
	}

}

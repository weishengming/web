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
import com.weishengming.dao.entity.ShiPinDO;
import com.weishengming.dao.entity.WenZhangDO;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.ShiPinQuery;
import com.weishengming.dao.query.WenZhangQuery;
import com.weishengming.service.ShiPinService;
import com.weishengming.service.WenZhangService;
import com.weishengming.web.controller.SecurityController;

/**
 * @author 杨天赐 
 * 视频管理
 */
@Controller
@RequestMapping(value = "/admin/shipin")
public class AdminShiPinController extends SecurityController {

	Logger logger = LoggerFactory.getLogger(AdminShiPinController.class);
	
	@Resource
	private ShiPinService shipinService;

	/**
	 * 进入到视频列表页面
	 * 
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/shipinlist")
	public String shipinlist(Model model, ShiPinQuery query,
			Integer changePageSize, Integer pn) {
		logger.info("进入到视频列表页面");
		query.putPnIntoPageNumber(pn);
		query.putPnIntoPageSize(changePageSize);
		ResultPage<ShiPinDO> result = shipinService.findPage(query);
		String pageUrl = "/admin/shipin/shipinlist?"
				+ Converter.covertToQueryStr(query);
		model.addAttribute("pageUrl", pageUrl);
		model.addAttribute("resultViewList", result.getResult());
		model.addAttribute("query", query);
		model.addAttribute("result", result);
		model.addAttribute("changePageSize", changePageSize);// 把这个pageSize放到前台
		return "/admin/shipin/shipinlist";
	}

	/**
	 * 通过id
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/shipinedit/{id}")
	public String shipinedit(@PathVariable Long id, Model model) {
		final ShiPinDO shipinDO = shipinService.findOne(id);
		model.addAttribute("model", shipinDO);
		return "/admin/shipin/shipinupdate";
	}

	/**
	 * 更新
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/shipinupdate")
	public String shipinupdate(ShiPinDO entity) {
		if (entity.getId() == null) {
			entity.setCreateDate(DateUtil.getCurrentDate());
			entity.setUpdateDate(DateUtil.getCurrentDate());
			shipinService.create(entity);
		} else {
			shipinService.update(entity);
		}
		return "redirect:/admin/shipin/shipinlist";
	}

	public ShiPinService getShipinService() {
		return shipinService;
	}

	public void setShipinService(ShiPinService shipinService) {
		this.shipinService = shipinService;
	}
}

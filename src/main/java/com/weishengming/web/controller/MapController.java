package com.weishengming.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 杨天赐
 * 地图控制接口
 */
@Controller
@RequestMapping(value="map")
public class MapController {
	Logger  logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value="mapPage",method=RequestMethod.GET)  
	public String mapPage(){
		logger.info("进入到map页面");
		return "map/map";
	}

}

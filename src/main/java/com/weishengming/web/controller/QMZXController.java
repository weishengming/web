package com.weishengming.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.dao.entity.WenTiDO;


/**
 * @author 杨天赐
 * 奇妙真相控制层接口
 */
@Controller
@RequestMapping(value="qmzx")
public class QMZXController extends SecurityController{
	
	Logger  logger = LoggerFactory.getLogger(KeHuController.class);
    private final String LIST_ACTION = "redirect:/qmzx/qmzxlist";
    private final String QMZX_VIEW_PATH = "/qmzx/";
    
    @RequestMapping(method = RequestMethod.GET, value = "/qmzxlist")
	public String list(HttpServletRequest request, Model model) {
        /*if(getName(request)==null){
        	request.getSession().setAttribute("redirectURL", "/wenti/wentiupdate");
        	return "redirect:/qqLogin";
        }*/
		return QMZX_VIEW_PATH + "qmzxlist";
	}

}

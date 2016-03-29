package com.weishengming.web.user.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.converter.Converter;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.user.dao.entity.UserDO;
import com.weishengming.user.dao.query.UserQuery;
import com.weishengming.user.service.UserService;
import com.weishengming.web.controller.SecurityController;


@Controller
@RequestMapping(value = "/user")
public class UserController extends SecurityController{
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	
	/**
	 * 进入到用户列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/userlist")
    public String userlist(Model model, UserQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到用户列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<UserDO> result = userService.findPage(query);
        String pageUrl = "/user/userlist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/user/userlist";
    }
	
	
	/**
	 * 进入到用户后台首页
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/userindex")
	public String adminindex(){
		return "/user/userindex";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

}

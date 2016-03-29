package com.weishengming.web.admin.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.converter.Converter;
import com.weishengming.mongo.MongoDB;
import com.weishengming.mongo.entity.Users;
import com.weishengming.mongo.query.ResultMongoPage;
import com.weishengming.mongo.query.UsersQuery;
import com.weishengming.web.controller.SecurityController;


@Controller
@RequestMapping(value = "/admin/users")
public class AdminUsersController  extends SecurityController{
	Logger logger = LoggerFactory.getLogger(AdminUsersController.class);
	
	@Resource(name = "mongoDB") 
	MongoDB mongoDB;
	
	
	
	
	@RequestMapping(method = RequestMethod.GET,value="/userslist")
    public String userslist(Model model, UsersQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到用户管理列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultMongoPage<Users> result = mongoDB.findPageByQuery(Users.class, query);
        String pageUrl = "/admin/users/userslist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/users/userslist";
    }
	 
	
}

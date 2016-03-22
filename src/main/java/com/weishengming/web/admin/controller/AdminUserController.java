package com.weishengming.web.admin.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.dao.mongo.MongoDB;
import com.weishengming.dao.mongo.entity.User;
import com.weishengming.web.controller.SecurityController;


@Controller
@RequestMapping(value = "/admin/user")
public class AdminUserController  extends SecurityController{
	Logger logger = LoggerFactory.getLogger(AdminUserController.class);
	
	@Resource(name = "mongoDB") 
	MongoDB mongoDB;
	
	  /** 
     * 插入单条数据，id自定义 
     */  
	@RequestMapping(method = RequestMethod.GET, value = "/add")
    public void testAdd() {  
        User user = new User();  
        Date creatTime = new Date();  
        user.setCreateTime(creatTime);  
        user.setAge(10);  
        user.setUsername("福東江a");  
        this.mongoDB.add(user);  
    }  
	
}

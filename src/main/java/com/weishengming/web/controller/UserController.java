package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.web.dao.UserDao;
import com.weishengming.web.entity.UserDO;

/**
 * @author 杨天赐
 * 用户Controller
 */
@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Resource
	private UserDao userDao;
	
	@RequestMapping(value="userlist")  
	public String findUser(Model m){
		List<UserDO> users=userDao.findAll();
		m.addAttribute("users", users);
		return "user/userlist";
	}

}

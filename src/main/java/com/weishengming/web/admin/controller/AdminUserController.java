package com.weishengming.web.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.ajax.AjaxOutputTool;
import com.weishengming.common.converter.Converter;
import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.DiXiongZiMeiDO;
import com.weishengming.dao.mongo.MongoDB;
import com.weishengming.dao.mongo.entity.User;
import com.weishengming.dao.mongo.query.ResultMongoPage;
import com.weishengming.dao.mongo.query.UserQuery;
import com.weishengming.web.controller.SecurityController;


@Controller
@RequestMapping(value = "/admin/user")
public class AdminUserController  extends SecurityController{
	Logger logger = LoggerFactory.getLogger(AdminUserController.class);
	
	@Resource(name = "mongoDB") 
	MongoDB mongoDB;
	
	
	
	
	@RequestMapping(method = RequestMethod.GET,value="/userlist")
    public String userlist(Model model, UserQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到用户管理列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultMongoPage<User> result = mongoDB.findPageByQuery(User.class, query);
        String pageUrl = "/admin/user/userlist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/user/userlist";
    }
	
    @RequestMapping(method = RequestMethod.POST, value = "/user_ajax")
    public String user_ajax(String id, Model model) {
    	if(StringUtils.isNotBlank(id)){
         User user = mongoDB.findById(User.class, id);
          model.addAttribute("model", user);
    	}
        return "/admin/user/user_ajax";
    }
    
    /**
   	 * 更新
   	 * @param  
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/user_update_ajax")
    public void user_update_ajax(HttpServletResponse response,User user) {
   		if(StringUtils.isBlank(user.getId())){
   			user.setId(null);
   			user.setCreateDate(DateUtil.getCurrentDate());
   			user.setUpdateDate(DateUtil.getCurrentDate());
   			this.mongoDB.add(user); 
	    	AjaxOutputTool.writeData(response, "添加成功");
	   }else{
		    User target=this.mongoDB.findById(User.class, user.getId());
		    mergeUser(user, target);
		    this.mongoDB.saveOrUpdate(target);
		    AjaxOutputTool.writeData(response, "更新成功");
	   }
    }
   	
  	@RequestMapping(method = RequestMethod.POST, value = "/user_delete_ajax")
    public void user_delete_ajax(HttpServletResponse response,String id) {
  		if(StringUtils.isNotBlank(id)){
  			User u=new User();
  			u.setId(id);
  		    mongoDB.remove(u);
	    	AjaxOutputTool.writeData(response, "删除成功");
  		}
    }
    private void mergeUser(User source,User target){
    	target.setName(source.getName());
    	target.setAge(source.getAge());
    	target.setUpdateDate(DateUtil.getCurrentDate());
    }
	
}

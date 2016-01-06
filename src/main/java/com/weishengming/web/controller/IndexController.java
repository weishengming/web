package com.weishengming.web.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import com.weishengming.service.KeHuService;

/**
 * @author 杨天赐
 * indexController 负责 登陆 注册 重置密码 
 */
@Controller
public class IndexController extends SecurityController{
	Logger  logger = LoggerFactory.getLogger(IndexController.class);
	@Resource
	private KeHuService keHuService;
	/**
	 * 默认进入到首页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="index",method=RequestMethod.GET)  
    public String indexPage(Model model){
        return "/index/index";  
    } 
	/**
	 * 进入QQ登陆
	 * @param request
	 * @param response
	 * @param m
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="qqLogin")
	public String qqLogin(HttpServletRequest request,HttpServletResponse response,Model m) throws Exception{
		logger.info("qqLogin");
		logger.info("URL{},",new Oauth().getAuthorizeURL(request));
		return "redirect:"+new Oauth().getAuthorizeURL(request);
	}
	
	/**
	 * qq登陆回调
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="qqcallback")
	public String qqcallback(HttpServletRequest request,HttpServletResponse response,Model m)  {
		 try {
			 AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
	         String accessToken   = null;
	         String openID        = null;
	         long tokenExpireIn = 0L;
	         if (accessTokenObj.getAccessToken().equals("")) {
	        	 logger.info("没有获取到响应参数");
	         } else {
	             accessToken = accessTokenObj.getAccessToken();
	             tokenExpireIn = accessTokenObj.getExpireIn();
	             request.getSession().setAttribute("demo_access_token", accessToken);
	             request.getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));
	             // 利用获取到的accessToken 去获取当前用的openid -------- start
	             OpenID openIDObj =  new OpenID(accessToken);
	             openID = openIDObj.getUserOpenID();
	             logger.info("欢迎你，代号为 " + openID + " 的用户!");
	             request.getSession().setAttribute("demo_openid", openID);
	             // 利用获取到的accessToken 去获取当前用户的openid --------- end
	             logger.info("<p> start -----------------------------------利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 ---------------------------- start </p>");
	             UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
	             UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
	             logger.info("<br/>");
	             if (userInfoBean.getRet() == 0) {
	                 logger.info(userInfoBean.getNickname() + "<br/>");
	                 logger.info(userInfoBean.getGender() + "<br/>");
	                 logger.info("<image src=" + userInfoBean.getAvatar().getAvatarURL30() + "/><br/>");
	             } else {
	                 logger.info("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
	             }
	             logger.info("<p> end -----------------------------------利用获取到的accessToken,openid 去获取用户在微博的昵称等信息 ---------------------------- end </p>");
	             request.getSession().setAttribute("imgsrc", userInfoBean.getAvatar().getAvatarURL30());
	             request.getSession().setAttribute("name", userInfoBean.getNickname());
	             request.getSession().setAttribute("openID", openID);
	          }
			} catch (Exception e) {
			}
		 
		return "index/index";
	}
}

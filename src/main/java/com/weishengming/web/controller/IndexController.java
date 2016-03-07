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
import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.QQDO;
import com.weishengming.service.DiXiongZiMeiService;
import com.weishengming.service.QQService;

/**
 * @author 杨天赐
 * indexController 
 */
@Controller
public class IndexController extends SecurityController{
	Logger  logger = LoggerFactory.getLogger(IndexController.class);
	@Resource
	private QQService qqService;
	
	@Resource
	private DiXiongZiMeiService dixiongzimeiService;
	
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
	 * 爱上帝
	 * @param model
	 * @return
	 */
	@RequestMapping(value="aishangdi",method=RequestMethod.GET)  
    public String aishangdiPage(HttpServletRequest request,Model model){
        return "/index/aishangdi";  
    } 
	/**
	 * 爱他人
	 * @param model
	 * @return
	 */
	@RequestMapping(value="aitaren",method=RequestMethod.GET)  
    public String aitarenPage(HttpServletRequest request,Model model){
        return "/index/aitaren";  
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
	             request.getSession().setAttribute("demo_openid", openID);
	             // 利用获取到的accessToken 去获取当前用户的openid --------- end
	             UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
	             UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
	             if (userInfoBean.getRet() == 0) {
	                 logger.info(userInfoBean.getNickname());
	                 logger.info(userInfoBean.getGender());
	                 logger.info(userInfoBean.getAvatar().getAvatarURL30());
	             } else {
	                 logger.info("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
	             }
	             logger.info("<p> end -----------------------------------利用获取到的accessToken,openid 去获取用户在微博的昵称等信息 ---------------------------- end </p>");
	             request.getSession().setAttribute("imgsrc", userInfoBean.getAvatar().getAvatarURL30());
	             request.getSession().setAttribute("name", userInfoBean.getNickname());
	             request.getSession().setAttribute("openID", openID);
	             QQDO qqDO=qqService.findOpenID(openID);
	             logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>{}",openID);
	             logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<{}",qqDO);
	             if(qqDO==null){
	            	 QQDO entity=new QQDO();
	            	 entity.setCreateDate(DateUtil.getCurrentDate());
	            	 entity.setUpdateDate(DateUtil.getCurrentDate());
	            	 entity.setNickname(userInfoBean.getNickname());
	            	 entity.setOpenID(openID);
	            	 entity.setImgsrc30(userInfoBean.getAvatar().getAvatarURL30());
	            	 entity.setGender(userInfoBean.getGender());
	            	 qqService.create(entity);
	             }
	          }
			} catch (Exception e) {
				logger.info("{}",e);
			}
		 String redirectURL=null;
		 if(request.getSession().getAttribute("redirectURL")!=null){
			 redirectURL=request.getSession().getAttribute("redirectURL").toString();
		 }else{
			 redirectURL="/index";
		 }
		return "redirect:"+redirectURL;
	}
	
	
	
	/**
	 * 关于我们
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="guanyuwomen",method=RequestMethod.GET)  
    public String guanyuwomen(HttpServletRequest request,Model model){
        return "/weishengming/guanyuwomen";  
    }
	
	@RequestMapping(value="lianxiwomen",method=RequestMethod.GET)  
    public String lianxiwomen(HttpServletRequest request,Model model){
        return "/weishengming/lianxiwomen";  
    }
	
	
	public QQService getQqService() {
		return qqService;
	}

	public void setQqService(QQService qqService) {
		this.qqService = qqService;
	}
	
}

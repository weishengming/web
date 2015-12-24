package com.weishengming.web.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.PageFans;
import com.qq.connect.api.qzone.Topic;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.GeneralResultBean;
import com.qq.connect.javabeans.qzone.PageFansBean;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.javabeans.weibo.Company;
import com.qq.connect.oauth.Oauth;
import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.service.KeHuService;
import com.weishengming.utils.CalendarUtil;

/**
 * @author 杨天赐
 * indexController 负责 登陆 注册 重置密码 
 */
@Controller
public class IndexController {
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
		logger.info("test:{}","test");
        model.addAttribute("tianci", "天赐你好"); 
        return "/index/index";  
    } 
	 
	/**
	 * 进入登陆页面
	 * @return
	 */
	@RequestMapping(value="loginPage")
	public String loginPage(){
		logger.info("进入login页面");
		return "/index/login";
	}
	
	/**
	 * 进入到注册页面
	 * @return
	 */
	@RequestMapping(value="regPage")
	public String regPage(){
		logger.info("进入注册页面");
		return "index/reg";
	}
	
	/**
	 * 进入重置密码页面
	 * @return
	 */
	@RequestMapping(value="resetPwdPage")
	public String resetPwdPage(){
		logger.info("进入找回密码页面");
		return "index/resetpwd";
	}
	/**
	 * 账号密码登陆
	 * @param name
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value="doLogin",method=RequestMethod.POST) 
	public String doLogin(String name,String password,Model model){
		logger.info("用户名:{},密码:{}",name,password);
		// 判断用户名和密码是否正确
		model.addAttribute("name",name);
		return "/index/index";
	}
	/**
	 * 注册成功,跳转到登陆页面
	 * @param name
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value="doReg",method=RequestMethod.POST) 
	public String doReg(String zhanghao,String mima,Model model){
		//获得用户的 账号和密码
		KeHuDO kehuDo =new KeHuDO();
		kehuDo.setZhanghao(zhanghao);
		kehuDo.setMima(mima);
		kehuDo.setCreateDate(CalendarUtil.getCurrentDate());
		kehuDo.setUpdateDate(CalendarUtil.getCurrentDate());
		keHuService.create(kehuDo);
		logger.info("注册用户名:{}与密码:{}",zhanghao,mima);
		return "/index/login";
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
	             logger.info("<a href=" + "/shuoshuoDemo.html" +  " target=\"_blank\">去看看发表说说的demo吧</a>");
	             // 利用获取到的accessToken 去获取当前用户的openid --------- end
	             logger.info("<p> start -----------------------------------利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 ---------------------------- start </p>");
	             UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
	             UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
	             logger.info("<br/>");
	             if (userInfoBean.getRet() == 0) {
	                 logger.info(userInfoBean.getNickname() + "<br/>");
	                 logger.info(userInfoBean.getGender() + "<br/>");
	                 logger.info("黄钻等级： " + userInfoBean.getLevel() + "<br/>");
	                 logger.info("会员 : " + userInfoBean.isVip() + "<br/>");
	                 logger.info("黄钻会员： " + userInfoBean.isYellowYearVip() + "<br/>");
	                 logger.info("<image src=" + userInfoBean.getAvatar().getAvatarURL30() + "/><br/>");
	                 logger.info("<image src=" + userInfoBean.getAvatar().getAvatarURL50() + "/><br/>");
	                 logger.info("<image src=" + userInfoBean.getAvatar().getAvatarURL100() + "/><br/>");
	             } else {
	                 logger.info("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
	             }
	             logger.info("<p> end -----------------------------------利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 ---------------------------- end </p>");
	             logger.info("<p> start ----------------------------------- 验证当前用户是否为认证空间的粉丝------------------------------------------------ start <p>");
	             PageFans pageFansObj = new PageFans(accessToken, openID);
	             PageFansBean pageFansBean = pageFansObj.checkPageFans("97700000");
	             if (pageFansBean.getRet() == 0) {
	                 logger.info("<p>验证您" + (pageFansBean.isFans() ? "是" : "不是")  + "QQ空间97700000官方认证空间的粉丝</p>");
	             } else {
	                 logger.info("很抱歉，我们没能正确获取到您的信息，原因是： " + pageFansBean.getMsg());
	             }
	             logger.info("<p> end ----------------------------------- 验证当前用户是否为认证空间的粉丝------------------------------------------------ end <p>");
	             logger.info("<p> start -----------------------------------利用获取到的accessToken,openid 去获取用户在微博的昵称等信息 ---------------------------- start </p>");
	             com.qq.connect.api.weibo.UserInfo weiboUserInfo = new com.qq.connect.api.weibo.UserInfo(accessToken, openID);
	             com.qq.connect.javabeans.weibo.UserInfoBean weiboUserInfoBean = weiboUserInfo.getUserInfo();
	             if (weiboUserInfoBean.getRet() == 0) {
	                 //获取用户的微博头像----------------------start
	                 logger.info("<image src=" + weiboUserInfoBean.getAvatar().getAvatarURL30() + "/><br/>");
	                 logger.info("<image src=" + weiboUserInfoBean.getAvatar().getAvatarURL50() + "/><br/>");
	                 logger.info("<image src=" + weiboUserInfoBean.getAvatar().getAvatarURL100() + "/><br/>");
	                 //获取用户的微博头像 ---------------------end
	                 //获取用户的生日信息 --------------------start
	                 logger.info("<p>尊敬的用户，你的生日是： " + weiboUserInfoBean.getBirthday().getYear()
	                             +  "年" + weiboUserInfoBean.getBirthday().getMonth() + "月" +
	                             weiboUserInfoBean.getBirthday().getDay() + "日");
	                 //获取用户的生日信息 --------------------end
	                 StringBuffer sb = new StringBuffer();
	                 sb.append("<p>所在地:" + weiboUserInfoBean.getCountryCode() + "-" + weiboUserInfoBean.getProvinceCode() + "-" + weiboUserInfoBean.getCityCode()
	                          + weiboUserInfoBean.getLocation());
	                 //获取用户的公司信息---------------------------start
	                 ArrayList<Company> companies = weiboUserInfoBean.getCompanies();
	                 if (companies.size() > 0) {
	                     //有公司信息
	                     for (int i=0, j=companies.size(); i<j; i++) {
	                         sb.append("<p>曾服役过的公司：公司ID-" + companies.get(i).getID() + " 名称-" +
	                         companies.get(i).getCompanyName() + " 部门名称-" + companies.get(i).getDepartmentName() + " 开始工作年-" +
	                         companies.get(i).getBeginYear() + " 结束工作年-" + companies.get(i).getEndYear());
	                     }
	                 } else {
	                     //没有公司信息
	                 }
	                 //获取用户的公司信息---------------------------end
	                 logger.info(sb.toString());

	             } else {
	                 logger.info("很抱歉，我们没能正确获取到您的信息，原因是： " + weiboUserInfoBean.getMsg());
	             }
	             logger.info("<p> end -----------------------------------利用获取到的accessToken,openid 去获取用户在微博的昵称等信息 ---------------------------- end </p>");
	             m.addAttribute("name", userInfoBean.getNickname());
	         }
			} catch (Exception e) {
			}
		 
		return "index/index";
	}
	
	public KeHuService getKeHuService() {
		return keHuService;
	}

	public void setKeHuService(KeHuService keHuService) {
		this.keHuService = keHuService;
	}
	
	
	 
	
}

package com.weishengming.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.converter.Converter;
import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.QQDO;
import com.weishengming.dao.entity.QiuDO;
import com.weishengming.dao.query.QiuQuery;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.service.QQService;
import com.weishengming.service.QiuService;
import com.weishengming.web.controller.view.QiuView;

/**
 * @author 杨天赐
 * 地址的控制层接口
 */
@Controller
@RequestMapping(value="qiu")
public class QiuController extends SecurityController{
	Logger  logger = LoggerFactory.getLogger(QiuController.class);
	
	@Resource
	private QiuService qiuService;
	@Resource
	private QQService qqService;

	@RequestMapping(method = RequestMethod.GET,value="/qiu")
    public String qiu(Model model, QiuQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到求的列表");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<QiuDO> result = qiuService.findPage(query);
        /**我记录了 OPENID***/
        // 怎么能查询出来 昵称 和 照片
        List<QiuDO> qiuDOList=result.getResult();
        List<QiuView> resultViewList=new ArrayList<QiuView>();
        for (QiuDO qiu : qiuDOList) {
        	QiuView qiuView=new QiuView();
        	QQDO qq=qqService.findOpenID(qiu.getOpenID());
        	qiuView.setId(qiu.getId());
        	qiuView.setNeirong(qiu.getNeirong());
        	qiuView.setOpenID(qiu.getOpenID());
        	qiuView.setNickname(qq.getNickname());
        	qiuView.setImgsrc30(qq.getImgsrc30());
        	resultViewList.add(qiuView);
		}
        
        
        String pageUrl = "/qiu/qiu?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", resultViewList);
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/qiu/qiu";
    }
	
	 /**
   	 * 添加
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/qiugengxin")
    public String qiugengxin(HttpServletRequest request,QiuDO entity) {
   		if(getName(request)==null){
        	request.getSession().setAttribute("redirectURL", "/qiu/qiu");
        	return "redirect:/qqLogin";
        }
   		if(entity.getId()==null){
   			entity.setOpenID(getOpenID(request));
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	qiuService.create(entity);
	   }else{
		    qiuService.update(entity);
	   }
   	   return "redirect:/qiu/qiu";
    }
   	
   	@RequestMapping(value = "/qiudelete/{id}")
    public String dixiongzimeidizhidelete(@PathVariable Long id) {
 	   qiuService.delete(id);
 	  return "redirect:/dixiongzimeidizhi/dixiongzimeidizhi";
    }
	
	


	public QiuService getQiuService() {
		return qiuService;
	}

	public void setQiuService(QiuService qiuService) {
		this.qiuService = qiuService;
	}
	public QQService getQqService() {
		return qqService;
	}

	public void setQqService(QQService qqService) {
		this.qqService = qqService;
	}
	
    
}

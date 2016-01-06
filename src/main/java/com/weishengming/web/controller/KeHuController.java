package com.weishengming.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weishengming.common.converter.Converter;
import com.weishengming.dao.entity.DiZhiDO;
import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.dao.query.KeHuQuery;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.service.DiZhiService;
import com.weishengming.service.KeHuService;
import com.weishengming.web.view.KeHuView;

/**
 * @author 杨天赐
 * 客户控制 
 */
@Controller
@RequestMapping(value="kehu")
public class KeHuController extends SecurityController{
	Logger  logger = LoggerFactory.getLogger(KeHuController.class);
    private final String LIST_ACTION = "redirect:/kehu/kehulist";
    private final String KEHU_VIEW_PATH = "/kehu/";
	
	@Resource
	private KeHuService kehuService;
	@Resource
	private DiZhiService dizhiService;
	

	/*@RequestMapping(method = RequestMethod.GET, value = "/editByZhanghao")
	 public String eidtByZhanghao(Model model) {
	     final KeHuDO keHuDO = kehuService.findKeHuByZhangHao(getZhangHao());
	     KeHuView keHuView = new KeHuView();
	     BeanUtils.copyProperties(keHuDO, keHuView);
	     model.addAttribute("model", keHuView);
	     return KEHU_VIEW_PATH+"kehuupdate";
	 }*/
	 
	 /**
	  * ajax 请求
	  * 
	 * @param kehuid
	 * @param model
	 * @return
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(method = RequestMethod.GET, value = "/kehuinfo/{kehuzhanghao}")
	 public void kehuinfo(@PathVariable String kehuzhanghao, HttpServletRequest request,HttpServletResponse response) {
		try {
		  JSONObject json = new JSONObject();
		  JSONArray  array = new JSONArray();
		  final KeHuDO keHuDO = kehuService.findKeHuByZhangHao(kehuzhanghao);
		  List<DiZhiDO> dizhiList=dizhiService.findListByKehuZhangHao(kehuzhanghao);
		  array.addAll(dizhiList);
	      KeHuView keHuView = new KeHuView();
	      BeanUtils.copyProperties(keHuDO, keHuView);
	      json.put("success", Boolean.TRUE);
          json.put("kehu", json.toJSON(keHuView));
          json.put("dizhi",array);
		  request.setCharacterEncoding("utf-8");
	      response.setContentType("text/html;charset=utf-8");
	      response.setHeader("Cache-Control", "no-cache");  
	      response.getWriter().print(json.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}   
         
	 }
	 
	 /**
	 * 更新
	 * @param entity
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/update")
    public String put(KeHuDO entity) {
		kehuService.update(entity);
        return "redirect:/kehu/editByZhanghao";  //更新完成后 继续在编辑页面
    }
	
	
	
/*	*//**
	 * 进入到客户列表页面
	 * @param model
	 * @param query
	 * @return
	 *//*
	@RequestMapping(method = RequestMethod.GET,value="/kehulist")
    public String list(HttpServletResponse response,Model model, KeHuQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到客户列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<KeHuDO> result = kehuService.findPage(query);

        List<KeHuView> keHuViewList = new ArrayList<KeHuView>();
        for (KeHuDO sourceKeHu : result.getResult()) {
        	KeHuView targetKeHu = new KeHuView();
            BeanUtils.copyProperties(sourceKeHu, targetKeHu);
            keHuViewList.add(targetKeHu);
        }
        response.setContentType("charset=UTF-8");
        String pageUrl = "/kehu/kehulist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", keHuViewList);
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        model.addAttribute("zhanghao", getZhangHao());//把账号放到前台 用来编辑当前账号的人
        return KEHU_VIEW_PATH + "kehulist";
    }*/
	
	
	
   /*   *//**
     * 通过id 
     * @param id
     * @param model
     * @return
     *//*
    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        final KeHuDO keHuDO = kehuService.findOne(id);
        KeHuView keHuView = new KeHuView();
        BeanUtils.copyProperties(keHuDO, keHuView);
        model.addAttribute("model", keHuView);
        return KEHU_VIEW_PATH+"kehuupdate";
    }*/

    /**
     * 删除
     * @param id
     * @return
     *//*
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
    	kehuService.delete(id);
        return LIST_ACTION;
    }

    *//**
     * 添加页面
     * @return
     *//*
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String add() {
        return "add";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(KeHuDO entity) {
    	kehuService.create(entity);
        return LIST_ACTION;
    }*/

	public KeHuService getKehuService() {
		return kehuService;
	}

	public void setKehuService(KeHuService kehuService) {
		this.kehuService = kehuService;
	}
	
	public DiZhiService getDizhiService() {
		return dizhiService;
	}

	public void setDizhiService(DiZhiService dizhiService) {
		this.dizhiService = dizhiService;
	}
    

}

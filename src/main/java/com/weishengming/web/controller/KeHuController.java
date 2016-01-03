package com.weishengming.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
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

import com.weishengming.common.converter.Converter;
import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.dao.query.KeHuQuery;
import com.weishengming.dao.query.ResultPage;
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
	
	/**
	 * 进入到客户列表页面
	 * @param model
	 * @param query
	 * @return
	 */
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
    }
	 
    /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        final KeHuDO keHuDO = kehuService.findOne(id);
        KeHuView keHuView = new KeHuView();
        BeanUtils.copyProperties(keHuDO, keHuView);
        model.addAttribute("model", keHuView);
        return KEHU_VIEW_PATH+"kehuupdate";
    }
	 /**
	 * 更新
	 * @param entity
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/update")
    public String put(KeHuDO entity) {
		 kehuService.update(entity);
        return LIST_ACTION;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
    	kehuService.delete(id);
        return LIST_ACTION;
    }

    /**
     * 添加页面
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String add() {
        return "add";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(KeHuDO entity) {
    	kehuService.create(entity);
        return LIST_ACTION;
    }
    
    
    
	/**
	 * 进入到客户列表页面
	 * @return
	 */
	@RequestMapping(value="kehulistPage")
	public String kehulistPage(Model m){
		// 查询客户的信息
		List<KeHuDO> list=kehuService.findAll();
		m.addAttribute("kehulist", list);
		return "kehu/kehulist";
	}
	/**
	 * @return
	 * 进入客户信息页面
	 */
	@RequestMapping(value="kehuxinxiPage")
	public String kehuxinxiPage(HttpSession seesion,Model m){
		String zhanghao=getZhangHao();
		KeHuDO kehuDo=kehuService.findKeHuByZhangHao(zhanghao);
		m.addAttribute("model", kehuDo);
		logger.info(zhanghao);
		logger.info("kehu:{}",kehuDo);
		return "kehu/kehuxinxi";
	}


}

package com.weishengming.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.converter.Converter;
import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.WenZhangDO;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.WenZhangQuery;
import com.weishengming.service.WenZhangService;

/**
 * @author 杨天赐
 * 文章管理
 */
@Controller
//@RequestMapping(value = "/admin/wenzhang")
public class AdminWenZhangController extends SecurityController {

    Logger                  logger = LoggerFactory.getLogger(AdminWenZhangController.class);
    @Resource
    private WenZhangService wenzhangService;

    /**
     * 进入到文章列表页面
     * @param model
     * @param query
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/wenzhanglist")
    public String wenzhanglist(Model model, WenZhangQuery query, Integer changePageSize, Integer pn) {
        logger.info("进入到文章列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<WenZhangDO> result = wenzhangService.findPage(query);
        String pageUrl = "/admin/wenzhang/wenzhanglist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/wenzhang/wenzhanglist";
    }

    /**
    * 通过id 
    * @param id
    * @param model
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/wenzhangedit/{id}")
    public String wenzhangedit(@PathVariable Long id, Model model) {
        final WenZhangDO wenzhangDO = wenzhangService.findOne(id);
        model.addAttribute("model", wenzhangDO);
        return "/admin/wenzhang/wenzhangupdate";
    }

    /**
     * 更新
     * @param entity
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/wenzhangupdate")
    public String wenzhangupdate(WenZhangDO entity) {
        if (entity.getId() == null) {
            entity.setCreateDate(DateUtil.getCurrentDate());
            entity.setUpdateDate(DateUtil.getCurrentDate());
            wenzhangService.create(entity);
        } else {
            wenzhangService.update(entity);
        }
        return "redirect:/admin/wenzhang/wenzhanglist";
    }

    public WenZhangService getWenzhangService() {
        return wenzhangService;
    }

    public void setWenzhangService(WenZhangService wenzhangService) {
        this.wenzhangService = wenzhangService;
    }

}

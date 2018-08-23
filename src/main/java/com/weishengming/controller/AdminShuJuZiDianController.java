package com.weishengming.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weishengming.common.ajax.AjaxOutputTool;
import com.weishengming.common.converter.Converter;
import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.ShuJuZiDianDO;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.ShuJuZiDianQuery;
import com.weishengming.service.ShuJuZiDianService;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 杨天赐
 * 数据字典控制层
 */
@Controller
@RequestMapping(value = "/admin/shujuzidian")
public class AdminShuJuZiDianController extends SecurityController {
    Logger                     logger = LoggerFactory.getLogger(AdminShuJuZiDianController.class);
    @Resource
    private ShuJuZiDianService shujuzidianService;

    @RequestMapping(method = RequestMethod.GET, value = "/shujuzidianlist")
    public String shujuzidianlist(Model model, ShuJuZiDianQuery query, Integer changePageSize, Integer pn) {
        logger.info("进入到数据字典列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        query.setFuid(0L);
        ResultPage<ShuJuZiDianDO> result = shujuzidianService.findPage(query);
        String pageUrl = "/admin/shujuzidian/shujuzidianlist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/shujuzidian/shujuzidianlist";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/shujuzidian_ajax")
    public String shujuzidian_ajax(String id, Model model) {
        if (StringUtils.isNotBlank(id)) {
            final ShuJuZiDianDO shujuzidianDO = shujuzidianService.findOne(Long.parseLong(id));
            model.addAttribute("model", shujuzidianDO);
        }
        return "/admin/shujuzidian/shujuzidian_ajax";
    }

    /**
      	 * 更新
      	 * @param entity
      	 * @return
      	 */
    @RequestMapping(method = RequestMethod.POST, value = "/shujuzidian_update_ajax")
    public void shujuzidian_update_ajax(HttpServletResponse response, ShuJuZiDianDO entity) {
        if (entity.getId() == null) {
            entity.setCreateDate(DateUtil.getCurrentDate());
            entity.setUpdateDate(DateUtil.getCurrentDate());
            entity.setFuid(0L);
            entity.setPaixu("0");
            shujuzidianService.create(entity);
            AjaxOutputTool.writeData(response, "添加数据字典成功");
        } else {
            shujuzidianService.update(entity);
            AjaxOutputTool.writeData(response, "更新数据字典成功");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/shujuzidian_delete_ajax")
    public void shujuzidian_delete_ajax(HttpServletResponse response, String id) {
        if (StringUtils.isNotBlank(id)) {
            List<ShuJuZiDianDO> shujuzidianList = shujuzidianService.findListByFuId(Long.parseLong(id));
            for (ShuJuZiDianDO shuJuZiDianDO : shujuzidianList) {
                shujuzidianService.delete(shuJuZiDianDO.getId());
            }
            shujuzidianService.delete(Long.parseLong(id));
            AjaxOutputTool.writeData(response, "删除数据字典成功");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/shujuzidian_zi_ajax")
    public String shujuzidian_zi_ajax(String id, Model model) {
        if (StringUtils.isNotBlank(id)) {
            final ShuJuZiDianDO shujuzidianDO = shujuzidianService.findOne(Long.parseLong(id));
            ShuJuZiDianDO shujuzidianView = new ShuJuZiDianDO();
            shujuzidianView.setFuid(shujuzidianDO.getId());
            shujuzidianView.setNeirong(shujuzidianDO.getNeirong());
            model.addAttribute("model", shujuzidianView);
            List<ShuJuZiDianDO> shujuzidianList = shujuzidianService.findListByFuId(Long.parseLong(id));
            model.addAttribute("resultList", shujuzidianList);
        }
        return "/admin/shujuzidian/shujuzidian_zi_ajax";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/shujuzidian_zi_update_ajax")
    public void shujuzidian_zi_update_ajax(HttpServletResponse response, ShuJuZiDianDO entity) {
        if (entity.getId() == null) {
            entity.setCreateDate(DateUtil.getCurrentDate());
            entity.setUpdateDate(DateUtil.getCurrentDate());
            shujuzidianService.create(entity);
            AjaxOutputTool.writeData(response, "添加数据字典成功");
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/shujuzidian_zi_delete_ajax")
    public void shujuzidian_zi_delete_ajax(HttpServletResponse response, String id) {
        if (StringUtils.isNotBlank(id)) {
            shujuzidianService.delete(Long.parseLong(id));
            AjaxOutputTool.writeData(response, "删除数据字典成功");
        }
    }

    public ShuJuZiDianService getShujuzidianService() {
        return shujuzidianService;
    }

    public void setShujuzidianService(ShuJuZiDianService shujuzidianService) {
        this.shujuzidianService = shujuzidianService;
    }

}

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
import com.weishengming.dao.entity.WenZhangDO;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.WenZhangQuery;
import com.weishengming.service.WenZhangService;

/**
 * @author 杨天赐  文章管理控制层接口
 */
@Controller
@RequestMapping(value = "wenzhang")
public class WenZhangController  extends SecurityController {
    Logger logger = LoggerFactory.getLogger(WenZhangController.class);
    @Resource
    private WenZhangService wenzhangService;


    @RequestMapping(value="/wenzhang/{caidan}",method=RequestMethod.GET)
    public String wenzhang(Model model, WenZhangQuery query,@PathVariable String caidan,Integer changePageSize,Integer pn){
        if("kuangyehusheng".equals(caidan)){
            model.addAttribute("yetou","旷野呼声");
            model.addAttribute("miaoshu","www.kyhs.me" );
            query.setFubiaoti("旷野呼声");
        }

        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        query.setPageSize(3);
        ResultPage<WenZhangDO> result = wenzhangService.findPage(query);
        String pageUrl = "/wenzhang/wenzhang/"+caidan+"?"+Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);
        model.addAttribute("caidan", caidan);
        return "/wenzhang/wenzhang";
    }

    /**
     * 文章详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/wenzhangxiangxi/{id}")
    public String wenzhangxiangxi(@PathVariable Long id, Model model) {
        final WenZhangDO wenzhangDO = wenzhangService.findOne(id);
        model.addAttribute("model", wenzhangDO);
        return "/wenzhang/wenzhangxiangxi";
    }

    public WenZhangService getWenzhangService() {
        return wenzhangService;
    }
    public void setWenzhangService(WenZhangService wenzhangService) {
        this.wenzhangService = wenzhangService;
    }


}

package com.weishengming.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.dao.entity.HMGQDO;
import com.weishengming.service.HMGQService;

/**
 * @author 杨天赐 荒漠甘泉控制层接口
 */
@Controller
@RequestMapping(value = "hmgq")
public class HMGQController extends SecurityController {
    Logger              logger = LoggerFactory.getLogger(HMGQController.class);
    @Resource
    private HMGQService hmgqService;

    @RequestMapping(value = "1", method = RequestMethod.GET)
    public String page1(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第一月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/1";
    }

    @RequestMapping(value = "2", method = RequestMethod.GET)
    public String page2(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第二月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/2";
    }

    @RequestMapping(value = "3", method = RequestMethod.GET)
    public String page3(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第三月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/3";
    }

    @RequestMapping(value = "4", method = RequestMethod.GET)
    public String page4(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第四月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/4";
    }

    @RequestMapping(value = "5", method = RequestMethod.GET)
    public String page5(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第五月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/5";
    }

    @RequestMapping(value = "6", method = RequestMethod.GET)
    public String page6(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第六月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/6";
    }

    @RequestMapping(value = "7", method = RequestMethod.GET)
    public String page7(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第七月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/7";
    }

    @RequestMapping(value = "8", method = RequestMethod.GET)
    public String page8(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第八月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/8";
    }

    @RequestMapping(value = "9", method = RequestMethod.GET)
    public String page9(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第九月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/9";
    }

    @RequestMapping(value = "10", method = RequestMethod.GET)
    public String page10(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第十月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/10";
    }

    @RequestMapping(value = "11", method = RequestMethod.GET)
    public String page11(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第十一月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/11";
    }

    @RequestMapping(value = "12", method = RequestMethod.GET)
    public String page12(Model model) {
        List<HMGQDO> resultList = hmgqService.findListByFubiaoti("第十二月");
        model.addAttribute("resultList", resultList);
        return "/hmgq/12";
    }

    public HMGQService getTtsdService() {
        return hmgqService;
    }

    public void setTtsdService(HMGQService hmgqService) {
        this.hmgqService = hmgqService;
    }

}

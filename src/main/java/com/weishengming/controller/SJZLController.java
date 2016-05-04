package com.weishengming.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.converter.Converter;
import com.weishengming.dao.entity.SJZLDO;
import com.weishengming.dao.entity.WenZhangDO;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.SJZLQuery;
import com.weishengming.service.SJZLService;

/**
 * @author 杨天赐
 * 圣经纵览控制层接口
 */
@Controller
@RequestMapping(value = "sjzl")
public class SJZLController extends SecurityController{
	Logger logger = LoggerFactory.getLogger(SJZLController.class);
	@Resource
	private SJZLService sjzlService;
	
	@RequestMapping(value="sjzlindex",method=RequestMethod.GET)  
    public String pagesjzlindex(Model model){
        return "/sjzl/sjzlindex";  
    }
	@RequestMapping(value="1-5",method=RequestMethod.GET)  
	public String page1(Model model,SJZLQuery query,Integer changePageSize,Integer pn){
		query.setFubiaoti("律法书");
		query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        query.setPageSize(3);
		ResultPage<SJZLDO> result = sjzlService.findPage(query);
        String pageUrl = "/sjzl/1-5?"+Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);
        return "/sjzl/1-5";  
    }
	
	@RequestMapping(value="6-17",method=RequestMethod.GET)  
	public String page2(Model model,SJZLQuery query,Integer changePageSize,Integer pn){
		query.setFubiaoti("历史书");
		query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        query.setPageSize(3);
		ResultPage<SJZLDO> result = sjzlService.findPage(query);
        String pageUrl = "/sjzl/6-17?"+Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);
		
        return "/sjzl/6-17";  
    }
	@RequestMapping(value="18-22",method=RequestMethod.GET)  
	public String page3(Model model,SJZLQuery query,Integer changePageSize,Integer pn){
		query.setFubiaoti("诗歌智慧书");
		query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        query.setPageSize(3);
		ResultPage<SJZLDO> result = sjzlService.findPage(query);
        String pageUrl = "/sjzl/18-22?"+Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);
        return "/sjzl/18-22";  
    }
	@RequestMapping(value="23-39",method=RequestMethod.GET)  
	public String page4(Model model,SJZLQuery query,Integer changePageSize,Integer pn){
		query.setFubiaoti("先知书");
		query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        query.setPageSize(3);
		ResultPage<SJZLDO> result = sjzlService.findPage(query);
        String pageUrl = "/sjzl/23-39?"+Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);
        return "/sjzl/23-39";  
    }
	
	@RequestMapping(value="40-43",method=RequestMethod.GET)  
	public String page5(Model model,SJZLQuery query,Integer changePageSize,Integer pn){
		query.setFubiaoti("四福音书");
		query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        query.setPageSize(3);
		ResultPage<SJZLDO> result = sjzlService.findPage(query);
        String pageUrl = "/sjzl/40-43?"+Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);
        return "/sjzl/40-43";  
    }
	@RequestMapping(value="44",method=RequestMethod.GET)  
	public String page6(Model model,SJZLQuery query,Integer changePageSize,Integer pn){
		query.setFubiaoti("使徒行传");
		query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        query.setPageSize(3);
		ResultPage<SJZLDO> result = sjzlService.findPage(query);
        String pageUrl = "/sjzl/44?"+Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);
        return "/sjzl/44";  
    }
	@RequestMapping(value="45-65",method=RequestMethod.GET)  
	public String page7(Model model,SJZLQuery query,Integer changePageSize,Integer pn){
		query.setFubiaoti("书信");
		query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        query.setPageSize(3);
		ResultPage<SJZLDO> result = sjzlService.findPage(query);
        String pageUrl = "/sjzl/45-65?"+Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);
        return "/sjzl/45-65";  
    }
	@RequestMapping(value="66",method=RequestMethod.GET)  
	public String page8(Model model,SJZLQuery query,Integer changePageSize,Integer pn){
		query.setFubiaoti("启示录");
		query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        query.setPageSize(3);
		ResultPage<SJZLDO> result = sjzlService.findPage(query);
        String pageUrl = "/sjzl/66?"+Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);
        return "/sjzl/66";  
    }
	 
	@RequestMapping(value="sjzlend",method=RequestMethod.GET)  
	public String pagesjzlend(Model model){
        return "/sjzl/sjzlend";  
    }
	 
	
	
}

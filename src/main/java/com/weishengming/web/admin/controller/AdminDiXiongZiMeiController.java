package com.weishengming.web.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.ajax.AjaxOutputTool;
import com.weishengming.common.ajax.ErrorCode;
import com.weishengming.common.converter.Converter;
import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.DiXiongZiMeiDO;
import com.weishengming.dao.entity.DiZhiDO;
import com.weishengming.dao.entity.JDAreaDO;
import com.weishengming.dao.query.DiXiongZiMeiQuery;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.service.DiXiongZiMeiService;
import com.weishengming.service.DiZhiService;
import com.weishengming.service.JDAreaService;
import com.weishengming.web.controller.SecurityController;

/**
 * @author 杨天赐
 * 弟兄姊妹后台管理
 */
@Controller
@RequestMapping(value = "/admin/dixiongzimei")
public class AdminDiXiongZiMeiController extends SecurityController{
	Logger logger = LoggerFactory.getLogger(AdminDiXiongZiMeiController.class);

	@Resource
	private DiXiongZiMeiService dixiongzimeiService;
	
	@Resource
	private DiZhiService dizhiService;
	
	@Resource
	private JDAreaService jdAreaService;
	
	/**
	 * 进入到弟兄姊妹列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/dixiongzimeilist")
    public String dixiongzimeilist(Model model, DiXiongZiMeiQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到弟兄姊妹管理列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<DiXiongZiMeiDO> result = dixiongzimeiService.findPage(query);
        String pageUrl = "/admin/dixiongzimei/dixiongzimeilist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/dixiongzimei/dixiongzimeilist";
    }
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/dixiongzimei_ajax")
    public String dixiongzimei_ajax(String id, Model model) {
    	if(StringUtils.isNotBlank(id)){
        final DiXiongZiMeiDO dixiongzimeiDO = dixiongzimeiService.findOne(Long.parseLong(id));
        model.addAttribute("model", dixiongzimeiDO);
    	}
        return "/admin/dixiongzimei/dixiongzimei_ajax";
    }
	
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/dixiongzimei_update_ajax")
    public void dixiongzimei_update_ajax(HttpServletResponse response,DiXiongZiMeiDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	entity.setSuoding("解锁");
	    	dixiongzimeiService.create(entity);
	    	AjaxOutputTool.writeData(response, "添加弟兄姊妹成功");
	   }else{
		    dixiongzimeiService.update(entity);
		    AjaxOutputTool.writeData(response, "更新弟兄姊妹成功");
	   }
    }
   	
   	/*********弟兄姊妹地址管理*************/
   	
   	/**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/dixiongzimeidizhi_ajax")
    public String dixiongzimeidizhi_ajax(String id, Model model) {
   		if(StringUtils.isNotBlank(id)){
   	        List<DiZhiDO> dizhiList=dizhiService.findListByDixiongzimeiid(Long.parseLong(id));
   	        model.addAttribute("resultViewDiZhiList", dizhiList);
   	        DiXiongZiMeiDO dixiongzimeiDO=dixiongzimeiService.findOne(Long.parseLong(id));
   	        model.addAttribute("dixiongzimei", dixiongzimeiDO);
    	}
        return "/admin/dixiongzimei/dixiongzimeidizhi_ajax";
    }
   	
   	/**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/dixiongzimeidizhi_update_ajax")
    public void dixiongzimeidizhi_update_ajax(HttpServletResponse response,DiZhiDO entity) {
   	    if(StringUtils.isBlank(entity.getArea3Name())&&StringUtils.isNotBlank(entity.getArea3Id())){
	   		JDAreaDO jdarea=jdAreaService.findOneByAreaId(entity.getArea3Id());
	   		if(jdarea!=null){
	   			entity.setArea3Name(jdarea.getAreaName());
	   		}
	    }
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	dizhiService.create(entity);
	    	AjaxOutputTool.writeData(response, "添加弟兄姊妹地址成功");
	   } 
    }
   	
   	
  	@RequestMapping(method = RequestMethod.POST, value = "/dixiongzimeidizhi_delete_ajax")
    public void dixiongzimeidizhi_delete_ajax(HttpServletResponse response,String id) {
  		if(StringUtils.isNotBlank(id)){
  		    dizhiService.delete(Long.parseLong(id));
	    	AjaxOutputTool.writeData(response, "删除弟兄姊妹地址成功");
  		}
    }
   	
   	
   	public DiZhiService getDizhiService() {
		return dizhiService;
	}
	public void setDizhiService(DiZhiService dizhiService) {
		this.dizhiService = dizhiService;
	}
	public JDAreaService getJdAreaService() {
		return jdAreaService;
	}
	public void setJdAreaService(JDAreaService jdAreaService) {
		this.jdAreaService = jdAreaService;
	}
	public DiXiongZiMeiService getDixiongzimeiService() {
		return dixiongzimeiService;
	}

	public void setDixiongzimeiService(DiXiongZiMeiService dixiongzimeiService) {
		this.dixiongzimeiService = dixiongzimeiService;
	}
	
}

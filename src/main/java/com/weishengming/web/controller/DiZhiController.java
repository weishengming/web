package com.weishengming.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.DiZhiDO;
import com.weishengming.dao.entity.JDAreaDO;
import com.weishengming.dao.entity.KeHuDO;
import com.weishengming.dao.query.KeHuQuery;
import com.weishengming.service.DiZhiService;
import com.weishengming.service.JDAreaService;
import com.weishengming.service.KeHuService;
import com.weishengming.web.view.KeHuView;

/**
 * @author 杨天赐
 * 地址的控制层接口
 */
@Controller
@RequestMapping(value="dizhi")
public class DiZhiController extends SecurityController{
	Logger  logger = LoggerFactory.getLogger(DiZhiController.class);
    private final String DIZHI_VIEW_PATH = "/dizhi/";
    @Resource
	private KeHuService kehuService;
    @Resource
	private JDAreaService jdAreaService;
    
	@Resource
	private DiZhiService dizhiService;
    

    
    /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/editByZhanghao")
    public String editByZhanghao(Model model) {
    	final KeHuDO keHuDO = kehuService.findKeHuByZhangHao(getZhangHao());
        KeHuView keHuView = new KeHuView();
        BeanUtils.copyProperties(keHuDO, keHuView);
        model.addAttribute("kehu", keHuView);
        List<DiZhiDO> dizhiViewList=dizhiService.findListByKehuZhangHao(getZhangHao());
        model.addAttribute("resultViewList", dizhiViewList);
        return DIZHI_VIEW_PATH+"dizhiupdate";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
    	final DiZhiDO dizhiDO=dizhiService.findOne(id);
    	model.addAttribute("model",dizhiDO);
    	
    	final KeHuDO keHuDO = kehuService.findKeHuByZhangHao(dizhiDO.getKehuzhanghao());
        KeHuView keHuView = new KeHuView();
        BeanUtils.copyProperties(keHuDO, keHuView);
        model.addAttribute("kehu", keHuView);
    	List<DiZhiDO> dizhiViewList=dizhiService.findListByKehuZhangHao(dizhiDO.getKehuzhanghao());
        model.addAttribute("resultViewList", dizhiViewList);
        return DIZHI_VIEW_PATH+"dizhiupdate";
    }

    
	 /**
	 * 更新
	 * @param entity
	 * @return
	 */
   @RequestMapping(method = RequestMethod.POST, value = "/update")
   public String put(DiZhiDO entity) {
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
	   }else{
		   dizhiService.update(entity);
	   }
	
	   return "redirect:/dizhi/editByZhanghao";
   }
   
   @RequestMapping(value = "/delete/{id}")
   public String delete(@PathVariable Long id) {
	   dizhiService.delete(id);
       return "redirect:/dizhi/editByZhanghao";
   }
    
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

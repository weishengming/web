package com.weishengming.web.controller;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weishengming.common.converter.Converter;
import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.DiXiongZiMeiDO;
import com.weishengming.dao.entity.DiZhiDO;
import com.weishengming.dao.entity.JDAreaDO;
import com.weishengming.dao.entity.JiaoTangDO;
import com.weishengming.dao.entity.LeiXingDO;
import com.weishengming.dao.entity.QMZXDO;
import com.weishengming.dao.entity.ShiPinDO;
import com.weishengming.dao.entity.TTSDDO;
import com.weishengming.dao.entity.WenZhangDO;
import com.weishengming.dao.query.DiXiongZiMeiQuery;
import com.weishengming.dao.query.JiaoTangQuery;
import com.weishengming.dao.query.LeiXingQuery;
import com.weishengming.dao.query.QMZXQuery;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.ShiPinQuery;
import com.weishengming.dao.query.TTSDQuery;
import com.weishengming.dao.query.WenZhangQuery;
import com.weishengming.service.DiXiongZiMeiService;
import com.weishengming.service.DiZhiService;
import com.weishengming.service.JDAreaService;
import com.weishengming.service.JiaoTangService;
import com.weishengming.service.LeiXingService;
import com.weishengming.service.QMZXService;
import com.weishengming.service.ShiPinService;
import com.weishengming.service.TTSDService;
import com.weishengming.service.WenZhangService;
/**
 * @author 杨天赐
 * web控制数据接口  只有 OPENID=杨天赐 才可以访问这个功能
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController  extends SecurityController {
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Resource
	private TTSDService ttsdService;
	
	@Resource
	private WenZhangService wenzhangService;
	
	@Resource
	private QMZXService qmzxService;
	
	@Resource
	private ShiPinService shipinService;
	
	@Resource
	private JiaoTangService jiaotangService;
	
	@Resource
	private LeiXingService leixingService;
	
	@Resource
	private DiXiongZiMeiService dixiongzimeiService;
	
	@Resource
	private DiZhiService dizhiService;
	
	@Resource
	private JDAreaService jdAreaService;
	

	/**
	 * 进入到后台首页
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/adminindex")
	public String adminindex(){
		return "/admin/adminindex";
	}
	
	/***********弟兄姊妹地址管理START****************/
	
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/dixiongzimei/dixiongzimeidizhiedit/{id}")
    public String dixiongzimeidizhiedit(@PathVariable Long id, Model model) {
        DiZhiDO dizhiDO=dizhiService.findOne(id);
        model.addAttribute("dizhi", dizhiDO);
        final DiXiongZiMeiDO dixiongzimeiDO = dixiongzimeiService.findOne(dizhiDO.getDixiongzimeiid());
        model.addAttribute("model", dixiongzimeiDO);
      //还需要做一件事  查出来  这个 弟兄姊妹的地址信息
        List<DiZhiDO> dizhiList=dizhiService.findListByDixiongzimeiid(dixiongzimeiDO.getId());
        model.addAttribute("resultViewDiZhiList", dizhiList);
        return "/admin/dixiongzimei/dixiongzimeiupdate";
    }
    
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/dixiongzimei/dixiongzimeidizhiupdate")
    public String dixiongzimeidizhiupdate(DiZhiDO entity) {
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
   		return "redirect:/admin/dixiongzimei/dixiongzimeidizhiedit/"+entity.getId();
    }
   	
   	@RequestMapping(value = "/dixiongzimei/dixiongzimeidizhidelete/{id}")
    public String dixiongzimeidizhidelete(@PathVariable Long id) {
   	   DiZhiDO dizhiDO=dizhiService.findOne(id);
 	   dizhiService.delete(id);
 	   return "redirect:/admin/dixiongzimei/dixiongzimeiedit/"+dizhiDO.getDixiongzimeiid();
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
   	
	/***********弟兄姊妹地址管理END***************/
	
	/***********弟兄姊妹管理START****************/
	/**
	 * 进入到弟兄姊妹列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/dixiongzimei/dixiongzimeilist")
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
    @RequestMapping(method = RequestMethod.GET, value = "/dixiongzimei/dixiongzimeiedit/{id}")
    public String dixiongzimeiedit(@PathVariable Long id, Model model) {
        final DiXiongZiMeiDO dixiongzimeiDO = dixiongzimeiService.findOne(id);
        model.addAttribute("model", dixiongzimeiDO);
        //还需要做一件事  查出来  这个 弟兄姊妹的地址信息
        List<DiZhiDO> dizhiList=dizhiService.findListByDixiongzimeiid(dixiongzimeiDO.getId());
        model.addAttribute("resultViewDiZhiList", dizhiList);
        return "/admin/dixiongzimei/dixiongzimeiupdate";
    }
	 
 
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/dixiongzimei/dixiongzimeiupdate")
    public String dixiongzimeiupdate(DiXiongZiMeiDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	dixiongzimeiService.create(entity);
	   }else{
		    dixiongzimeiService.update(entity);
	   }
   		return "redirect:/admin/dixiongzimei/dixiongzimeilist";
    }
   	
	@RequestMapping(value = "/dixiongzimei/dixiongzimeidelete/{id}")
    public String dixiongzimeidelete(@PathVariable Long id) {
	   dixiongzimeiService.delete(id);
   	   List<DiZhiDO> dizhiList=dizhiService.findListByDixiongzimeiid(id);
   	   for (DiZhiDO diZhiDO2 : dizhiList) {
   		dizhiService.delete(diZhiDO2.getId());
	   }
   	   return "redirect:/admin/dixiongzimei/dixiongzimeilist";
    }
   	
   	public DiXiongZiMeiService getDixiongzimeiService() {
		return dixiongzimeiService;
	}

	public void setDixiongzimeiService(DiXiongZiMeiService dixiongzimeiService) {
		this.dixiongzimeiService = dixiongzimeiService;
	}
	 
	/***********弟兄姊妹管理END***************/
	
	
	

	/***********类型管理START****************/
	/**
	 * 进入到类型列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/leixing/leixinglist")
    public String leixinglist(Model model, LeiXingQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到类型列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<LeiXingDO> result = leixingService.findPage(query);
        String pageUrl = "/admin/leixing/leixinglist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/leixing/leixinglist";
    }
	
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/leixing/leixingedit/{id}")
    public String leixingedit(@PathVariable Long id, Model model) {
        final LeiXingDO leixingDO = leixingService.findOne(id);
        model.addAttribute("model", leixingDO);
        return "/admin/leixing/leixingupdate";
    }
    
    /**
     * 
     * 编辑子类型 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/leixing/zileixingedit/{id}")
    public String zileixingedit(@PathVariable Long id, Model model) {
        final LeiXingDO leixingDO = leixingService.findOne(id);
        model.addAttribute("model", leixingDO);
        return "/admin/leixing/zileixingupdate";
    }
    
    /**
     * 删除类型
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/leixing/leixingdelete/{id}")
    public String leixingdelete(@PathVariable Long id){
   		if(id!=null){
   			leixingService.delete(id);
   			return "redirect:/admin/leixing/leixinglist";
   		}
   		return null;
   	}
	 
 
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/leixing/leixingupdate")
    public String leixingupdate(LeiXingDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	leixingService.create(entity);
	   }else{
		   leixingService.update(entity);
	   }
   		return "redirect:/admin/leixing/leixinglist";
    }
    /**
   	 * 添加子类型
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/leixing/zileixingupdate")
    public String zileixingupdate(LeiXingDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	leixingService.create(entity);
	   }else{
		   leixingService.update(entity);
	   }
   		return "redirect:/admin/leixing/leixinglist";
    }
   	
   	
   	
   	public LeiXingService getLeixingService() {
		return leixingService;
	}

	public void setLeixingService(LeiXingService leixingService) {
		this.leixingService = leixingService;
	}
	
	 
	/***********类型管理END***************/
	

	/***********教堂管理START****************/
	/**
	 * 进入到视频列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/jiaotang/jiaotanglist")
    public String jiaotanglist(Model model, JiaoTangQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到教堂列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<JiaoTangDO> result = jiaotangService.findPage(query);
        String pageUrl = "/admin/jiaotang/jiaotanglist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/jiaotang/jiaotanglist";
    }
	
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/jiaotang/jiaotangedit/{id}")
    public String jiaotangedit(@PathVariable Long id, Model model) {
        final JiaoTangDO jiaotangDO = jiaotangService.findOne(id);
        model.addAttribute("model", jiaotangDO);
        return "/admin/jiaotang/jiaotangupdate";
    }
	 
 
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/jiaotang/jiaotangupdate")
    public String jiaotangupdate(JiaoTangDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	jiaotangService.create(entity);
	   }else{
		   jiaotangService.update(entity);
	   }
   		return "redirect:/admin/jiaotang/jiaotanglist";
    }
   	
   	public JiaoTangService getJiaotangService() {
		return jiaotangService;
	}

	public void setJiaotangService(JiaoTangService jiaotangService) {
		this.jiaotangService = jiaotangService;
	}
	
	 
	/***********教堂管理END***************/
	
	
	
	

	/***********视频管理START****************/
	/**
	 * 进入到视频列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/shipin/shipinlist")
    public String shipinlist(Model model, ShiPinQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到视频列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<ShiPinDO> result = shipinService.findPage(query);
        String pageUrl = "/admin/shipin/shipinlist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/shipin/shipinlist";
    }
	
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/shipin/shipinedit/{id}")
    public String shipinedit(@PathVariable Long id, Model model) {
        final ShiPinDO shipinDO = shipinService.findOne(id);
        model.addAttribute("model", shipinDO);
        return "/admin/shipin/shipinupdate";
    }
	 
 
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/shipin/shipinupdate")
    public String shipinupdate(ShiPinDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	shipinService.create(entity);
	   }else{
		    shipinService.update(entity);
	   }
   		return "redirect:/admin/shipin/shipinlist";
    }
   	
   	public ShiPinService getShipinService() {
		return shipinService;
	}

	public void setShipinService(ShiPinService shipinService) {
		this.shipinService = shipinService;
	}
	
	 
	/***********视频管理END***************/
	
	
	/**********奇妙真相管理START**************/
	
	/**
	 * 进入到奇妙真相列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/qmzx/qmzxlist")
    public String qmzxlist(Model model, QMZXQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到奇妙真相列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<QMZXDO> result = qmzxService.findPage(query);
        String pageUrl = "/admin/qmzx/qmzxlist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/qmzx/qmzxlist";
    }
	
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/qmzx/qmzxedit/{id}")
    public String qmzxedit(@PathVariable Long id, Model model) {
        final QMZXDO qmzxDO = qmzxService.findOne(id);
        model.addAttribute("model", qmzxDO);
        return "/admin/qmzx/qmzxupdate";
    }
	 
 
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/qmzx/qmzxupdate")
    public String qmzxupdate(QMZXDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	qmzxService.create(entity);
	   }else{
		    qmzxService.update(entity);
	   }
   		return "redirect:/admin/qmzx/qmzxlist";
    }
	
	public QMZXService getQmzxService() {
		return qmzxService;
	}

	public void setQmzxService(QMZXService qmzxService) {
		this.qmzxService = qmzxService;
	}
	
	/**********奇妙真相管理END**************/
	
	/**********文章管理 START***************/

	/**
	 * 进入到文章列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/wenzhang/wenzhanglist")
    public String wenzhanglist(Model model, WenZhangQuery query,Integer changePageSize,Integer pn) {
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
    @RequestMapping(method = RequestMethod.GET, value = "/wenzhang/wenzhangedit/{id}")
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
   	@RequestMapping(method = RequestMethod.POST, value = "/wenzhang/wenzhangupdate")
    public String wenzhangupdate(WenZhangDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	wenzhangService.create(entity);
	   }else{
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
   	
   	/**********文章管理 END***************/
	
	/**********谈天说地管理 START***************/



	/**
	 * 进入到谈天说地列表页面
	 * @param model
	 * @param query
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET,value="/ttsd/ttsdlist")
    public String ttsdlist(Model model, TTSDQuery query,Integer changePageSize,Integer pn) {
		logger.info("进入到谈天说地列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<TTSDDO> result = ttsdService.findPage(query);
        String pageUrl = "/admin/ttsd/ttsdlist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/ttsd/ttsdlist";
    }
	
	 /**
     * 通过id 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/ttsd/ttsdedit/{id}")
    public String ttsdedit(@PathVariable Long id, Model model) {
        final TTSDDO ttsdDO = ttsdService.findOne(id);
        model.addAttribute("model", ttsdDO);
        return "/admin/ttsd/ttsdupdate";
    }
	 
 
    /**
   	 * 更新
   	 * @param entity
   	 * @return
   	 */
   	@RequestMapping(method = RequestMethod.POST, value = "/ttsd/ttsdupdate")
    public String ttsdupdate(TTSDDO entity) {
   		if(entity.getId()==null){
		    entity.setCreateDate(DateUtil.getCurrentDate());
	    	entity.setUpdateDate(DateUtil.getCurrentDate());
	    	ttsdService.create(entity);
	   }else{
		    ttsdService.update(entity);
	   }
   		return "redirect:/admin/ttsd/ttsdlist";
    }

	public TTSDService getTtsdService() {
		return ttsdService;
	}

	public void setTtsdService(TTSDService ttsdService) {
		this.ttsdService = ttsdService;
	}
   	
   	/**********谈天说地管理 END***************/
	

}

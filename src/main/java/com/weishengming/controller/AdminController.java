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
import com.weishengming.dao.entity.HMGQDO;
import com.weishengming.dao.entity.QMZXDO;
import com.weishengming.dao.entity.SJZLDO;
import com.weishengming.dao.entity.TTSDDO;
import com.weishengming.dao.query.HMGQQuery;
import com.weishengming.dao.query.QMZXQuery;
import com.weishengming.dao.query.ResultPage;
import com.weishengming.dao.query.SJZLQuery;
import com.weishengming.dao.query.TTSDQuery;
import com.weishengming.service.HMGQService;
import com.weishengming.service.QMZXService;
import com.weishengming.service.SJZLService;
import com.weishengming.service.TTSDService;

/**
 * @author 杨天赐
 * web控制数据接口  只有 OPENID=杨天赐 才可以访问这个功能
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController extends SecurityController {
    Logger              logger = LoggerFactory.getLogger(AdminController.class);
    @Resource
    private TTSDService ttsdService;

    @Resource
    private QMZXService qmzxService;

    @Resource
    private SJZLService sjzlService;

    @Resource
    private HMGQService hmgqService;

    /**
     * 进入到后台首页
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/adminindex")
    public String adminindex() {
        return "/admin/adminindex";
    }

    /**********圣经纵览管理START**************/
    /**
     * 进入到圣经纵览管理列表页面
     * @param model
     * @param query
     * @return
     */
    // @RequestMapping(method = RequestMethod.GET, value = "/sjzl/sjzllist")
    public String sjzllist(Model model, SJZLQuery query, Integer changePageSize, Integer pn) {
        logger.info("进入到圣经纵览管理页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<SJZLDO> result = sjzlService.findPage(query);
        String pageUrl = "/admin/sjzl/sjzllist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/sjzl/sjzllist";
    }

    /**
    * 通过id 
    * @param id
    * @param model
    * @return
    */
    //@RequestMapping(method = RequestMethod.GET, value = "/sjzl/sjzledit/{id}")
    public String sjzledit(@PathVariable Long id, Model model) {
        final SJZLDO sjzlDO = sjzlService.findOne(id);
        model.addAttribute("model", sjzlDO);
        return "/admin/sjzl/sjzlupdate";
    }

    /**
     * 更新
     * @param entity
     * @return
     */
    // @RequestMapping(method = RequestMethod.POST, value = "/sjzl/sjzlupdate")
    public String sjzlupdate(SJZLDO entity) {
        if (entity.getId() == null) {
            entity.setCreateDate(DateUtil.getCurrentDate());
            entity.setUpdateDate(DateUtil.getCurrentDate());
            sjzlService.create(entity);
        } else {
            sjzlService.update(entity);
        }
        return "redirect:/admin/sjzl/sjzllist";
    }

    /**********圣经纵览管理END**************/

    public SJZLService getSjzlService() {
        return sjzlService;
    }

    public void setSjzlService(SJZLService sjzlService) {
        this.sjzlService = sjzlService;
    }

    /**********奇妙真相管理START**************/
    /**
     * 进入到奇妙真相列表页面
     * @param model
     * @param query
     * @return
     */
    //@RequestMapping(method = RequestMethod.GET, value = "/qmzx/qmzxlist")
    public String qmzxlist(Model model, QMZXQuery query, Integer changePageSize, Integer pn) {
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
    //@RequestMapping(method = RequestMethod.GET, value = "/qmzx/qmzxedit/{id}")
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
    //@RequestMapping(method = RequestMethod.POST, value = "/qmzx/qmzxupdate")
    public String qmzxupdate(QMZXDO entity) {
        if (entity.getId() == null) {
            entity.setCreateDate(DateUtil.getCurrentDate());
            entity.setUpdateDate(DateUtil.getCurrentDate());
            qmzxService.create(entity);
        } else {
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

    /**********谈天说地管理 START***************/
    /**
     * 进入到谈天说地列表页面
     * @param model
     * @param query
     * @return
     */
    //@RequestMapping(method = RequestMethod.GET, value = "/ttsd/ttsdlist")
    public String ttsdlist(Model model, TTSDQuery query, Integer changePageSize, Integer pn) {
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
    //@RequestMapping(method = RequestMethod.GET, value = "/ttsd/ttsdedit/{id}")
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
    //@RequestMapping(method = RequestMethod.POST, value = "/ttsd/ttsdupdate")
    public String ttsdupdate(TTSDDO entity) {
        if (entity.getId() == null) {
            entity.setCreateDate(DateUtil.getCurrentDate());
            entity.setUpdateDate(DateUtil.getCurrentDate());
            ttsdService.create(entity);
        } else {
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

    /**********荒漠甘泉管理 START***************/
    /**
     * 进入到谈天说地列表页面
     * @param model
     * @param query
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/hmgq/hmgqlist")
    public String ttsdlist(Model model, HMGQQuery query, Integer changePageSize, Integer pn) {
        logger.info("进入到荒漠甘泉列表页面");
        query.putPnIntoPageNumber(pn);
        query.putPnIntoPageSize(changePageSize);
        ResultPage<HMGQDO> result = hmgqService.findPage(query);
        String pageUrl = "/admin/hmgq/hmgqlist?" + Converter.covertToQueryStr(query);
        model.addAttribute("pageUrl", pageUrl);
        model.addAttribute("resultViewList", result.getResult());
        model.addAttribute("query", query);
        model.addAttribute("result", result);
        model.addAttribute("changePageSize", changePageSize);//把这个pageSize放到前台
        return "/admin/hmgq/hmgqlist";
    }

    /**
    * 通过id 
    * @param id
    * @param model
    * @return
    */
    @RequestMapping(method = RequestMethod.GET, value = "/hmgq/hmgqedit/{id}")
    public String hmgqedit(@PathVariable Long id, Model model) {
        final HMGQDO hmgqDO = hmgqService.findOne(id);
        model.addAttribute("model", hmgqDO);
        return "/admin/hmgq/hmgqupdate";
    }

    /**
     * 更新
     * @param entity
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/hmgq/hmgqupdate")
    public String hmgqupdate(HMGQDO entity) {
        if (entity.getId() == null) {
            entity.setCreateDate(DateUtil.getCurrentDate());
            entity.setUpdateDate(DateUtil.getCurrentDate());
            entity.setMaoji(entity.getDijige());
            entity.setFubiaoti("第三月");
            entity.setBiaoti("3月" + entity.getDijige() + "日");
            hmgqService.create(entity);
        } else {
            entity.setMaoji(entity.getDijige());
            entity.setFubiaoti("第三月");
            entity.setBiaoti("3月" + entity.getDijige() + "日");
            hmgqService.update(entity);
        }
        return "redirect:/admin/hmgq/hmgqlist";
    }

    public HMGQService getHmgqService() {
        return hmgqService;
    }

    public void setHmgqService(HMGQService hmgqService) {
        this.hmgqService = hmgqService;
    }

    /**********荒漠甘泉管理 END***************/

}

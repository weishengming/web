package com.weishengming.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.weishengming.common.util.DateUtil;
import com.weishengming.dao.entity.DiXiongZiMeiDO;
import com.weishengming.dao.entity.DiZhiDO;
import com.weishengming.dao.entity.JDAreaDO;
import com.weishengming.service.DiXiongZiMeiService;
import com.weishengming.service.DiZhiService;
import com.weishengming.service.JDAreaService;

/**
 * @author 杨天赐
 * 弟兄姊妹的地址管理
 */
@Controller
//@RequestMapping(value="dixiongzimeidizhi")
public class DiXiongZiMeiDiZhiController extends SecurityController {
    Logger                      logger = LoggerFactory.getLogger(DiXiongZiMeiDiZhiController.class);
    @Resource
    private DiZhiService        dizhiService;
    @Resource
    private JDAreaService       jdAreaService;
    @Resource
    private DiXiongZiMeiService dixiongzimeiService;

    /**
     * 进入弟兄姊妹地址页面
     * @param request
     * @param model
     * @return
     */
    //@RequestMapping(method = RequestMethod.GET, value = "/dixiongzimeidizhi")
    public String dixiongzimeidizhi(HttpServletRequest request, Model model) {
        if (getName(request) == null) {
            request.getSession().setAttribute("redirectURL", "/dixiongzimeidizhi/dixiongzimeidizhi");
            return "redirect:/qqLogin";
        }
        logger.info("进入到弟兄姊妹地址页面");
        //还需要做一件事  查出来  这个 弟兄姊妹的地址信息
        List<DiZhiDO> dizhiList = dizhiService.findListByOpenID(getOpenID(request));
        model.addAttribute("resultViewDiZhiList", dizhiList);
        DiXiongZiMeiDO dixiongzimeiDO = dixiongzimeiService.findOneByOpenID(getOpenID(request));
        model.addAttribute("dixiongzimei", dixiongzimeiDO);
        return "/dixiongzimeidizhi/dixiongzimeidizhi";
    }

    /**
     * 添加
     * @param entity
     * @return
     */
    //@RequestMapping(method = RequestMethod.POST, value = "/dixiongzimeidizhigengxin")
    public String dixiongzimeidizhigengxin(DiZhiDO entity) {
        if (StringUtils.isBlank(entity.getArea3Name()) && StringUtils.isNotBlank(entity.getArea3Id())) {
            JDAreaDO jdarea = jdAreaService.findOneByAreaId(entity.getArea3Id());
            if (jdarea != null) {
                entity.setArea3Name(jdarea.getAreaName());
            }
        }
        if (entity.getId() == null) {
            entity.setCreateDate(DateUtil.getCurrentDate());
            entity.setUpdateDate(DateUtil.getCurrentDate());
            dizhiService.create(entity);
        } else {
            dizhiService.update(entity);
        }
        return "redirect:/dixiongzimeidizhi/dixiongzimeidizhi";
    }

    //@RequestMapping(value = "/dixiongzimeidizhidelete/{id}")
    public String dixiongzimeidizhidelete(@PathVariable Long id) {
        dizhiService.delete(id);
        return "redirect:/dixiongzimeidizhi/dixiongzimeidizhi";
    }

    public DiZhiService getDizhiService() {
        return dizhiService;
    }

    public void setDizhiService(DiZhiService dizhiService) {
        this.dizhiService = dizhiService;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public JDAreaService getJdAreaService() {
        return jdAreaService;
    }

    public void setJdAreaService(JDAreaService jdAreaService) {
        this.jdAreaService = jdAreaService;
    }

}

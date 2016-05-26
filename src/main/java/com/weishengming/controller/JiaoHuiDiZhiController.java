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
import com.weishengming.dao.entity.JDAreaDO;
import com.weishengming.dao.entity.JiaoHuiDiZhiDO;
import com.weishengming.service.DiXiongZiMeiService;
import com.weishengming.service.JDAreaService;
import com.weishengming.service.JiaoHuiDiZhiService;

/**
 * @author 杨天赐
 * 教会的地址
 */
@Controller
//@RequestMapping(value="jiaohuidizhi")
public class JiaoHuiDiZhiController extends SecurityController {
    Logger                      logger = LoggerFactory.getLogger(JiaoHuiDiZhiController.class);
    @Resource
    private JDAreaService       jdAreaService;
    @Resource
    private DiXiongZiMeiService dixiongzimeiService;
    @Resource
    private JiaoHuiDiZhiService jiaohuidizhiService;

    /**
     * 进入到教会地址页面
     * @param request
     * @param model
     * @return
     */
    //@RequestMapping(method = RequestMethod.GET, value = "/jiaohuidizhi")
    public String jiaohuidizhi(HttpServletRequest request, Model model) {
        if (getName(request) == null) {
            request.getSession().setAttribute("redirectURL", "/jiaohuidizhi/jiaohuidizhi");
            return "redirect:/qqLogin";
        }
        logger.info("进入到教会地址页面");
        List<JiaoHuiDiZhiDO> jiaohuidizhiList = jiaohuidizhiService.findListByOpenID(getOpenID(request));

        model.addAttribute("resultViewJiaoHuiDiZhiList", jiaohuidizhiList);
        DiXiongZiMeiDO dixiongzimeiDO = dixiongzimeiService.findOneByOpenID(getOpenID(request));
        model.addAttribute("dixiongzimei", dixiongzimeiDO);
        return "/jiaohuidizhi/jiaohuidizhi";
    }

    //@RequestMapping(method = RequestMethod.POST, value = "/jiaohuidizhigengxin")
    public String jiaohuidizhigengxin(JiaoHuiDiZhiDO entity) {
        if (StringUtils.isBlank(entity.getArea3Name()) && StringUtils.isNotBlank(entity.getArea3Id())) {
            JDAreaDO jdarea = jdAreaService.findOneByAreaId(entity.getArea3Id());
            if (jdarea != null) {
                entity.setArea3Name(jdarea.getAreaName());
            }
        }
        if (entity.getId() == null) {
            entity.setCreateDate(DateUtil.getCurrentDate());
            entity.setUpdateDate(DateUtil.getCurrentDate());
            jiaohuidizhiService.create(entity);
        } else {
            jiaohuidizhiService.update(entity);
        }
        return "redirect:/jiaohuidizhi/jiaohuidizhi";
    }

    //@RequestMapping(value = "/jiaohuidizhidelete/{id}")
    public String jiaohuidizhidelete(@PathVariable Long id) {
        jiaohuidizhiService.delete(id);
        return "redirect:/jiaohuidizhi/jiaohuidizhi";
    }

    public JDAreaService getJdAreaService() {
        return jdAreaService;
    }

    public void setJdAreaService(JDAreaService jdAreaService) {
        this.jdAreaService = jdAreaService;
    }
}

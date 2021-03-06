package com.weishengming.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weishengming.dao.entity.JDAreaDO;
import com.weishengming.service.JDAreaService;

@Controller
@RequestMapping("/area")
public class JDAreaController extends SecurityController{

    @Resource
    private JDAreaService  jdAreaService;
   
    
    
    /**
     * 到四级菜单  省 市  区 镇
     * @param parentId
     * @param response
     */
    @RequestMapping("/load_JD_Area_by_parent_id/{parentId}")
    public void loadJDArea(@PathVariable String parentId,  HttpServletRequest request,HttpServletResponse response) {
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        try {
            List<JDAreaDO> list = jdAreaService.findByParentId(parentId);
            if(list!=null && list.size()>0){
            	 for (JDAreaDO item : list) {
                     JSONObject area = new JSONObject();
                     area.put("code", item.getAreaId());
                     area.put("name", item.getAreaName());
                     area.put("id", item.getId());
                     array.add(area);
                 }
            }
            json.put("success", Boolean.TRUE);
            json.put("data", array);
            request.setCharacterEncoding("utf-8");  //这里不设置编码会有乱码
            response.setContentType("text/html;charset=utf-8");
            response.setHeader("Cache-Control", "no-cache");  
            response.getWriter().print(json.toJSONString());
        } catch (IOException e) {
        	logger.error("com.weishengming.web.controller.AreaController.loadJDArea", e);
        }
    }
}

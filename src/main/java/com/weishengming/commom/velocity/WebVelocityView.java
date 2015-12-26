package com.weishengming.commom.velocity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.velocity.VelocityView;

import com.weishengming.commom.properties.CustomizedPropertyPlaceholderConfigurer;

public class WebVelocityView extends VelocityView {
	public static final String CONTEXT_PATH = "static_resource";
	protected void renderMergedTemplateModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 
		super.renderMergedTemplateModel(model, request, response);
	}

	protected void exposeHelpers(Map<String, Object> model,
			HttpServletRequest request) throws Exception {
		super.exposeHelpers(model, request);
		model.put(CONTEXT_PATH, getPropString("static_resource"));// 静态资源的路径
		model.put("baseUrl", request.getContextPath());
	}
	private String getPropString(String key) {
	        return ((String) CustomizedPropertyPlaceholderConfigurer.getContextProperty(key)).trim();
	}
 

	 
}

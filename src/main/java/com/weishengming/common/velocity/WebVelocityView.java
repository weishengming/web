package com.weishengming.common.velocity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.velocity.VelocityView;

import com.weishengming.common.properties.CustomizedPropertyPlaceholderConfigurer;

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
		if (isLogin(request).booleanValue()) {
			model.put("name",request.getSession().getAttribute("name"));
			model.put("imgsrc", request.getSession().getAttribute("imgsrc"));
			model.put("openID", request.getSession().getAttribute("openID"));
			request.getSession().setAttribute("ERROR_COUNT", Integer.valueOf(0));
		}

		model.put("baseUrl", request.getContextPath());
	}

	private String getPropString(String key) {
		return ((String) CustomizedPropertyPlaceholderConfigurer
				.getContextProperty(key)).trim();
	}

	protected Boolean isLogin(HttpServletRequest request) {
		String userName = getName(request);
		if ((userName == null) || (userName.equals("")))
			return Boolean.valueOf(false);

		return Boolean.valueOf(true);
	}

	protected String getName(HttpServletRequest request) {
		if(request.getSession()!=null){
			if(request.getSession().getAttribute("name")!=null){
				return request.getSession().getAttribute("name").toString();
			}
		}
		return null;
	}

}

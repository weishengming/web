package com.weishengming.common.velocity;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.view.velocity.VelocityView;

import com.weishengming.common.properties.CustomizedPropertyPlaceholderConfigurer;
import com.weishengming.service.KeHuService;

public class WebVelocityView extends VelocityView {
	private KeHuService kehuService=new KeHuService();

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
		if (isLogin().booleanValue()) {
			model.put("userName", getUserName());
			request.getSession().setAttribute("ERROR_COUNT", Integer.valueOf(0));
		}

		model.put("baseUrl", request.getContextPath());
	}

	private String getPropString(String key) {
		return ((String) CustomizedPropertyPlaceholderConfigurer
				.getContextProperty(key)).trim();
	}

	protected Boolean isLogin() {
		String userName = getUserName();
		if ((userName == null) || (userName.equals("")))
			return Boolean.valueOf(false);

		return Boolean.valueOf(true);
	}

	protected String getUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ((auth != null) && (!(auth instanceof AnonymousAuthenticationToken)))
			return auth.getName();
		return null;
	}

}

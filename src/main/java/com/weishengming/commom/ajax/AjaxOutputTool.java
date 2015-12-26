package com.weishengming.commom.ajax;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSONObject;

public class AjaxOutputTool {
	private static final String SUCCESS = "success";
	private static final String DATA = "data";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String ERROR_CODE = "errorCode";

	public static final void writeErrorCodeMsg(HttpServletResponse response,ErrorCode errorCode, String errorMsg) {
		write(response,buildJSONObject(Boolean.FALSE.booleanValue(), null, errorCode,errorMsg, null));
	}
	public static final void writeErrorMsg(HttpServletResponse response, String errorMsg) {
		write(response,buildJSONObject(Boolean.FALSE.booleanValue(), null, null,errorMsg, null));
	}

	public static final void writeErrorCode(HttpServletResponse response,ErrorCode errorCode) {
		write(response,buildJSONObject(Boolean.FALSE.booleanValue(), null, errorCode,null));
	}

	public static final void writeErrorCode(HttpServletResponse response,ErrorCode errorCode, String callback) {
		write(response,buildJSONObject(Boolean.FALSE.booleanValue(), null, errorCode,callback));
	}

	public static final void writeData(HttpServletResponse response, Object data) {
		write(response,buildJSONObject(Boolean.TRUE.booleanValue(), data, null, null));
	}

	public static final void writeData(HttpServletResponse response,Object data, String callback) {
		write(response,buildJSONObject(Boolean.TRUE.booleanValue(), data, null,callback));
	}

	private static String buildJSONObject(boolean success, Object data,ErrorCode errorCode, String callback) {
		return buildJSONObject(success, data, errorCode, "", callback);
	}

	private static String buildJSONObject(boolean success, Object data,ErrorCode errorCode, String errorMsg, String callback) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", Boolean.valueOf(success));
		if (data != null)
			jsonObject.put("data", data);

		if (errorCode != null) {
			jsonObject.put("errorCode", errorCode.getValue());

			jsonObject.put("errorMessage", errorMsg);
		}
		if (StringUtils.isNotBlank(callback))
			return callback + "(" + jsonObject.toString() + ")";

		return jsonObject.toString();
	}

	private static void write(HttpServletResponse response, String result) {
		try {
			response.getWriter().println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

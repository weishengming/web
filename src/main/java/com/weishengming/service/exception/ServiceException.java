package com.weishengming.service.exception;

import java.util.HashMap;
import java.util.Map;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 7676769241939527743L;
	private String invalidParam;
	private Map<String, Object> params = new HashMap();

	public ServiceException(String invalidParam, String firstFailedReason) {
		super(firstFailedReason);
		this.invalidParam = invalidParam;
	}

	public ServiceException(String nullParam) {
		super(nullParam);
	}

	public String getInvalidParam() {
		return this.invalidParam;
	}

	public Map<String, Object> getParams() {
		return this.params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}

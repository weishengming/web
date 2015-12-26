package com.weishengming.common.ajax;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCode {
	NOT_LOGIN_ERROR_CODE, INVALID_PARAM, SYSTEM_ERROR, TRIED_TOO_MANY_TIMES,ZHANGHAO_YICUNZAI;

	private final String value = "";
	private static final Map<String, ErrorCode> map;
	public String getValue() {
		return this.value;
	}
	public static final ErrorCode getEnum(String value) {
		return ((ErrorCode) map.get(value));
	}
	static {
		map = new HashMap();
		ErrorCode[] arr$ = values();
		int len$ = arr$.length;
		for (int i$ = 0; i$ < len$; ++i$) {
			ErrorCode item = arr$[i$];
			map.put(item.getValue(), item);
		}
	}
}

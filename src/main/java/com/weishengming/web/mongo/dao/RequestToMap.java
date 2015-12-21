package com.weishengming.web.mongo.dao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.mongodb.BasicDBObject;
public class RequestToMap {
	static String numZZ = "^\\d{1,6}(\\.\\d{1,2})?$";
	static String dateZZ = "^\\d{4}-\\d{1,2}-\\d{1,2}( \\d{1,2}:\\d{1,2}(:\\d{1,2})?)?$";

	static java.util.regex.Pattern numberPattern = Pattern.compile(numZZ);
	static java.util.regex.Pattern datePattern = Pattern.compile(dateZZ);
	static SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy-MM-dd");
	static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 从request参数中 转换成 Map对象
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static BasicDBObject getDBObject(HttpServletRequest request) {
		BasicDBObject dbo = new BasicDBObject();
		Map map = request.getParameterMap();
		Set keys = map.keySet();
		java.util.Iterator it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			String value = request.getParameter(key);
			Object vo = null;
			if (value != null) {
				if (numberPattern.matcher(value).find()) {
					vo = new Double(value);
				} else if (datePattern.matcher(value).find()) {
					Date date = null;
					try {
						if (value.length() < 11) {
							date = sdf0.parse(value);
						} else {
							date = sdf1.parse(value);
						}
					} catch (Exception e) {
						
					}
					vo = date;
				} else {
					vo = value;
				}
				dbo.put(key, vo);
			}
		}
		return dbo;
	}
}

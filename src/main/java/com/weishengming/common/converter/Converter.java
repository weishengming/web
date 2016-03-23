package com.weishengming.common.converter;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class Converter {
	public static Map<String, Object> covertToMap(Object bean) {
		Map result = new HashMap();
		Class clazz = bean.getClass();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
			PropertyDescriptor[] descriptors = beanInfo
					.getPropertyDescriptors();

			PropertyDescriptor[] arr$ = descriptors;
			int len$ = arr$.length;
			for (int i$ = 0; i$ < len$; ++i$) {
				PropertyDescriptor descriptor = arr$[i$];
				Method getter = descriptor.getReadMethod();
				Object returnValue = getter.invoke(bean, new Object[0]);
				if (returnValue != null) {
					if ("-1".equals(returnValue))
						break;

					label151: if (returnValue.getClass() == String.class) {
						if (StringUtils.isNotBlank(returnValue.toString()))
							result.put(descriptor.getName(), returnValue
									.toString().trim());

					} else
						result.put(descriptor.getName(), returnValue);
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String covertToQueryStr(Object bean) {
		String query = "";
		Class clazz = bean.getClass();
		try {
			StringBuilder sb = new StringBuilder();
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			PropertyDescriptor[] arr$ = descriptors;
			int len$ = arr$.length;
			for (int i$ = 0; i$ < len$; ++i$) {
				PropertyDescriptor descriptor = arr$[i$];
				Method getter = descriptor.getReadMethod();
				Object returnValue = getter.invoke(bean, new Object[0]);
				if (returnValue != null) {
					if ("-1".equals(returnValue))
						break;
			     if(!"meta".equals(descriptor.getName())
					&&!"queryObject".equals(descriptor.getName())
					&&!"restrictedTypes".equals(descriptor.getName())
					){
					label195: if (returnValue.getClass() == String.class) {
						if (StringUtils.isNotBlank(returnValue.toString())) {
							sb.append(descriptor.getName()).append("=").append(URLEncoder.encode(returnValue.toString().trim(), "UTF-8")).append("&");
						}

					} else {
						sb.append(descriptor.getName()).append("=").append(URLEncoder.encode(returnValue.toString().trim(), "UTF-8")).append("&");
					}
					}

				}

			}

			query = sb.toString();
			if (query.endsWith("&"))
				query = query.substring(0, sb.toString().lastIndexOf("&"));
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		return query;
	}
}

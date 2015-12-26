package com.weishengming.common.util;

import java.lang.reflect.Field;

/**
 * @author 杨天赐
 * ""  变成null
 */
public class NullUtil {
	
	public static void kongzifuchuanToNull(Object bean){
		   try {
			   Field[] fs = bean.getClass().getDeclaredFields();  
		       for(int i = 0 ; i < fs.length; i++){  
		    	   Field f = fs[i];  
		           f.setAccessible(true); //设置些属性是可以访问的  
				   Object val = f.get(bean);//得到此属性的值  
		           String type = f.getType().toString();//得到此属性的类型  
		           if (type.endsWith("String")) {  
		        	   if("".equals(val)){
		        		   f.set(bean,null) ;  
		        	   }
		           }
		       } 
		   } catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
		   }
	}

}

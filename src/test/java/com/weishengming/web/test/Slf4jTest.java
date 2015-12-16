package com.weishengming.web.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {
	
	static private Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
	/**
	 * 显示日志.
	 */
	@Test
	public void showLog(){
		// 记录error信息

		logger.error("[info message]");

		// 记录info，还可以传入参数

		logger.info("[info message]{},{},{},{}", "abc", false, 123,new Slf4jTest());

		// 记录deubg信息

		logger.debug("[debug message]");

		// 记录trace信息

		logger.trace("[trace message]");

		System.out.println("hello world");
		
	}

}

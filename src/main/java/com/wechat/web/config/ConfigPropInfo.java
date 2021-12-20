package com.wechat.web.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * @author w29530
 * @date 2021/11/11
 * @desc
 */
@Configuration
public class ConfigPropInfo {



	public static String COOKIE_FILE;

	public static long DRIVER_EXPLICIT_WAIT = 0;

	public static String DRIVER_DIR;

	public static String CHROME_PORT;

	public static boolean CHROME_PORT_IS_FIXED = StringUtils.isNotBlank(CHROME_PORT);



	static {
		Properties pro = new Properties();
		try {
			pro.load(ConfigPropInfo.class.getClassLoader().getResourceAsStream("application.properties"));

			COOKIE_FILE = pro.getProperty("test.cookie.file");

			DRIVER_EXPLICIT_WAIT= Long.parseLong(pro.getProperty("driver.explicit.wait"));

			DRIVER_DIR = pro.getProperty("test.driver.dir");

			CHROME_PORT = pro.getProperty("chrome.port");

			CHROME_PORT_IS_FIXED = StringUtils.isNotBlank(CHROME_PORT);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

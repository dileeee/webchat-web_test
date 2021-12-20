package com.wechat.web.core;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc
 */
public class DriverFactory {

	private static DriverFactory instance;

	private DriverFactory() {

	}

	public static DriverFactory getInstance() {
		return instance;
	}

	public static IDriver getDriver(){
		return new LocalDriver();
	}

}

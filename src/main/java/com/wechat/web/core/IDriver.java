package com.wechat.web.core;

import org.openqa.selenium.WebDriver;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc 生成driver的接口类
 */
public interface IDriver {

	/**
	 * 根据输入的浏览器，打开对应的driver
	 * @param browser	浏览器名称 chrome,firefox
	 * @return	WebDriver
	 */
	WebDriver getBrowser(String browser);
}

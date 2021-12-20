package com.wechat.web.model;

/**
 * @author w29530
 * @date 2021/12/14
 * @desc 浏览器对象
 */
public class Browser {

	private String browserName;

	public Browser() {
	}

	public Browser(String browserName) {
		this.browserName = browserName;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
}

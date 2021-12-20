package com.wechat.web.core;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc
 */
public enum DriverEnum {

	/**
	 * chrome浏览器
	 */
	CHROME("chrome", "chromedriver.exe"),
	/**
	 * firefox浏览器
	 */
	FIREFOX("firefox", "geckodriver.exe"),

	/**
	 * EDGE浏览器
	 */
	EDGE("edge", "msedgedriver.exe"),

	/**
	 * 默认使用chrome浏览器
	 */
	DEFAULT("chrome", "chromedriver.exe");

	private String browserName;

	private String driverVersion;

	public String getBrowserName() {
		return browserName;
	}

	public String getDriverVersion() {
		return driverVersion;
	}

	DriverEnum(String browserName, String driverVersion) {
		this.browserName = browserName;
		this.driverVersion = driverVersion;
	}

	public static DriverEnum getEnum(String browser){
		for (DriverEnum driverEnum : DriverEnum.values()) {
			if (driverEnum.getBrowserName().equalsIgnoreCase(browser)) {
				return driverEnum;
			}
		}

		return DEFAULT;
	}
}

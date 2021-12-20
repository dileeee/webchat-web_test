package com.wechat.web.core;

import com.wechat.web.config.ConfigPropInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc
 */
@Component
public class LocalDriver implements IDriver {

	private WebDriver driver;

	@Override
	public WebDriver getBrowser(String browser) {
		switch (DriverEnum.getEnum(browser)){
			case CHROME:
				System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, ConfigPropInfo.DRIVER_DIR + DriverEnum.getEnum(browser).getDriverVersion());
				ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
				builder = builder.usingDriverExecutable(new File(ConfigPropInfo.DRIVER_DIR + DriverEnum.CHROME.getDriverVersion()));
				// 设置chrome浏览器的端口
				if (ConfigPropInfo.CHROME_PORT_IS_FIXED){
					builder.usingPort(Integer.parseInt(ConfigPropInfo.CHROME_PORT));
				}else {
					builder.usingAnyFreePort();
				}

				ChromeDriverService chromeDriverService = builder.build();

				// 设置ChromeOptions
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--test-type", "--start-maximized","--ignore-certificate-errors",
						"--disable-popup-blocking");

				try {
					chromeDriverService.start();
					driver = new ChromeDriver(chromeDriverService, chromeOptions);
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			default:
				driver = new ChromeDriver();
				break;
		}

		return driver;
	}
}

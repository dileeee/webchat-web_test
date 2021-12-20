package com.wechat.web;

import com.wechat.web.core.DriverFactory;
import com.wechat.web.model.Browser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc  测试类的基类，初始化driver与关闭driver
 */
public class BaseTest {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeAll
	public static void init(Browser browser){
		driver = DriverFactory.getDriver().getBrowser(browser.getBrowserName());
	}

//	@AfterAll
	public static void tearDown(){
		driver.quit();
	}
}

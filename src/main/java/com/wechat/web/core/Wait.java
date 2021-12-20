package com.wechat.web.core;

import com.wechat.web.config.ConfigPropInfo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc
 */
public class Wait {

	private WebDriver driver;

	private WebDriverWait webDriverWait;

	public Wait(WebDriver driver) {
		this.driver = driver;
		this.webDriverWait = new WebDriverWait(this.driver, ConfigPropInfo.DRIVER_EXPLICIT_WAIT);
	}

	/**
	 * 获取js执行器
	 * @return	js执行器
	 */
	public JavascriptExecutor getJsExecutor() {
		return (JavascriptExecutor) driver;
	}

	/**
	 * 等待页面加载完成
	 */
	public void waitForPageLoad() {
		this.webDriverWait.until(isPageLoaded());
	}

	public Function<WebDriver, Boolean> isPageLoaded(){
		return webDriver -> Boolean.valueOf(getJsExecutor().executeScript("return document.readyState=='complete'").toString());
	}

	/**
	 * 等待元素可见
	 * @param element	元素
	 */
	public void waitElement(WebElement element){
		this.webDriverWait.until(ExpectedConditions.visibilityOf(element));
	}
}

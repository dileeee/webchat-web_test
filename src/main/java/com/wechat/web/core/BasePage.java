package com.wechat.web.core;

import com.wechat.web.config.ConfigPropInfo;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @author w2930
 * @date 2021/12/12
 * @desc 基础的类，所有的页面对象都需要继承这个类
 */
public abstract class BasePage {

	private WebDriver driver;

	private Actions actions;

	private Wait wait;


	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.wait = new Wait(driver);

		PageFactory.initElements(this.driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * 单击元素
	 * @param element 元素
	 */
	public void click(WebElement element){
		click(element, false);
	}

	/**
	 * 滚动到元素的位置，进行点击
	 * @param element	元素
	 * @param isScroll	是否进行滚动
	 */
	public void click(WebElement element, boolean isScroll){
		if (isScroll){
			scrollToElement(element);
		}

		click(element, 0L);
	}

	/**
	 * 等待元素可点击后进行点击
	 * @param element	元素
	 * @param waitTime	等待时间
	 */
	public void click(WebElement element, long waitTime){
		WebElement webElement = waitExplicit(waitTime).until(ExpectedConditions.elementToBeClickable(element));
		try{
			webElement.click();
		}catch (Exception e){
			throw new WebDriverException(e);
		}
	}

	public WebDriverWait waitExplicit(long waitTime) {
		WebDriverWait wait;
		if (waitTime == 0) {
			wait = new WebDriverWait(driver, ConfigPropInfo.DRIVER_EXPLICIT_WAIT);
		} else {
			wait = new WebDriverWait(driver, TimeUnit.MILLISECONDS.toSeconds(waitTime));
		}
		return wait;
	}

	/**
	 * 打开页面，默认最大化
	 */
	public void openPageByMax(String url){
		openPage(url, null, true);
	}


	/**
	 * 打开固定尺寸的窗口
	 * @param url	url
	 * @param dimension	尺寸
	 */
	public void openPageByDimension(String url, Dimension dimension){
		openPage(url, dimension, false);
	}

	/**
	 * 打开页面
	 *
	 * @param url	url
	 * @param size	尺寸
	 * @param isMax	是否最大化
	 */
	public void openPage(String url, Dimension size, boolean isMax){
		driver.get(url);
		if (isMax){
			driver.manage().window().maximize();
			this.wait.waitForPageLoad();
		}else {
			driver.manage().window().setSize(size);
		}
	}

	/**
	 * 刷新当前页面
	 */
	public void refreshPage(){
		driver.navigate().refresh();
	}

	/**
	 * 获取当前页面的所有cookie
	 * @return	Set<Cookie>
	 */
	public Set<Cookie> getCookies(){
		return driver.manage().getCookies();
	}

	/**
	 * 滑动到指定的元素处
	 * @param element	元素
	 */
	public void scrollToElement(WebElement element){
		actions.moveToElement(element);
	}


	/**
	 * 判断元素是否存在
	 * @param element	元素
	 * @return	存在返回true，不存在则返回false
	 */
	public boolean isElementExist(WebElement element){
		boolean flag = false;

		try {
			element.getTagName();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * 输入文本
	 * @param element 元素
	 * @param text	文本
	 */
	public void inputText(WebElement element, String text){
		if (isElementExist(element)){
			if (element.isDisplayed() && element.isEnabled()){
				element.clear();
				element.sendKeys(text);
			}
		}else {
			this.wait.waitElement(element);
			if (element.isEnabled() && element.isDisplayed()){
				element.clear();
				element.sendKeys();
			}
		}
	}
}

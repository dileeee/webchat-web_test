package com.wechat.web.page;

import com.wechat.web.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc 主页面
 */
public class HomePage extends BasePage {

	@FindBy(css = "[node-type='addmember']")
	private WebElement addMemberButton;

	@FindBy(id = "menu_contacts")
	private WebElement contactMenu;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * 单击添加成员按钮，进入通讯录管理页面
	 */
	public ContactPage contact(){
		click(addMemberButton, true);

		return new ContactPage(this.getDriver());
	}
}

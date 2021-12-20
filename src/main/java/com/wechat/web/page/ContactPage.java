package com.wechat.web.page;

import com.wechat.web.core.BasePage;
import com.wechat.web.model.Member;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc 通讯录管理页面
 */
public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
	}

	//===================添加部门信息============================

	@FindBy(linkText = "添加")
	private WebElement addBtn;

	@FindBy(linkText = "添加部门")
	private WebElement addDeptBtn;


	/**
	 * 部门名称
	 */
	@FindBy(name = "name")
	private WebElement departName;

	@FindBy(linkText = "选择所属部门")
	private WebElement selectDepartBtn;

	@FindBy(css = ".qui_dropdownMenu .jstree-anchor")
	private List<WebElement> parentDepartBtn;

	@FindBy(linkText = "确定")
	private WebElement confirmBtn;

	// ================添加部门信息===========================================

	//================修改部门信息==============================================


	@FindBy(xpath = "//a[contains(text(), '定向4期')]/span")
	private WebElement dropDownBtn;


	@FindBy(linkText = "修改名称")
	private WebElement updateDeptNameBtn;

	@FindBy(linkText = "删除")
	private WebElement deleteDeptBtn;

	//================修改部门信息=============================================

	// ================添加成员信息===========================================

	@FindBy(linkText = "selenium实战")
	private WebElement childDept;

	@FindBy(linkText = "添加成员")
	private WebElement addMemberButton;

	/**
	 * 姓名
	 */
	@FindBy(id = "username")
	private WebElement userName;

	/**
	 * 别名
	 */
	@FindBy(id = "memberAdd_english_name")
	private WebElement englishName;

	/**
	 * 账号
	 */
	@FindBy(id = "memberAdd_acctid")
	private WebElement acctId;

	/**
	 * 手机号
	 */
	@FindBy(id = "memberAdd_phone")
	private WebElement phone;

	/**
	 * 座机号
	 */
	@FindBy(id = "memberAdd_telephone")
	private WebElement telephone;

	/**
	 * 邮箱
	 */
	@FindBy(id = "memberAdd_mail")
	private WebElement mail;

	/**
	 * 地址
	 */
	@FindBy(id = "memberEdit_address")
	private WebElement address;

	/**
	 * 职务
	 */
	@FindBy(id = "memberAdd_title")
	private WebElement title;

	/**
	 * 身份
	 */
	@FindBy(name = "identity_stat")
	private List<WebElement> identityStats;

	/**
	 * 职务
	 */
	@FindBy(name = "extern_position_set")
	private List<WebElement> externPositionSets;

	/**
	 * 是否需要发送邮件或短信  默认发送
	 */
	@FindBy(name = "sendInvite")
	private WebElement sendInvite;

	@FindBy(linkText = "保存")
	private WebElement saveBtn;

	// ================添加成员信息===========================================

	// ================搜索相关================================================

	@FindBy(id = "memberSearchInput")
	private WebElement searchInput;

	@FindBy(css = ".js_party_info")
	private WebElement deptInfo;

	@FindBy(css = ".ww_icon_AddMember")
	private WebElement addMemberIcon;

	// ================搜索相关================================================

	/**
	 * 添加成员
	 * @param member 成员类
	 */
	public ContactPage addMember(Member member){
		click(childDept);
		click(addMemberButton);
		// 输入信息
		inputText(userName, member.getUserName());
		inputText(englishName, member.getEnglishName());
		inputText(acctId, member.getAcctId());
		inputText(phone, member.getPhone());
		inputText(telephone, member.getTelephone());
		inputText(mail, member.getMail());
		inputText(address, member.getAddress());
		inputText(title, member.getTitle());

		// 点击保存按钮
		click(saveBtn, true);

		return this;
	}


	/**
	 * 创建部门
	 * @return	ContactPage
	 */
	public ContactPage addDepart(String name){
		click(addBtn);
		click(addDeptBtn);
		inputText(departName, name);
		click(selectDepartBtn);
		click(parentDepartBtn.get(1));
		click(confirmBtn);

		return this;
	}

	/**
	 * 部门搜索
	 * @param name	搜索的名称
	 * @return	ContactPage
	 */
	public ContactPage searchInfo(String name){
		inputText(searchInput, name);
		click(deptInfo);
		click(addMemberIcon);

		return this;
	}

	/**
	 * 获取页面的文本内容
	 * @return 文本内容
	 */
	public String getDepartInfo(){
		return deptInfo.getText();
	}


	/**
	 * 修改部门名称
	 * @param newDepartName 新的名称
	 * @return	ContactPage
	 */
	public ContactPage updateDepartInfo(String oldDepartName,String newDepartName){

		click(dropDownBtn);
		click(updateDeptNameBtn);
		inputText(departName, newDepartName);
		click(saveBtn);

		return this;
	}


	/**
	 * 删除部门
	 * @return	ContactPage
	 */
	public ContactPage deletePartInfo(String departName){

		click(dropDownBtn);
		click(deleteDeptBtn);

		return this;
	}
}


package com.wechat.web;

import com.wechat.web.annotation.CsvToMember;
import com.wechat.web.model.Member;
import com.wechat.web.page.LoginPage;
import com.wechat.web.resolver.ChromeParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc 测试企业微信
 */
@ExtendWith(ChromeParameterResolver.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactPageTest extends BaseTest {

	private static WebDriver driver;

	@BeforeAll
	public static void initDriver(){
		driver = getDriver();
	}

	/**
	 * 创建用户
	 * @param member	用户对象
	 */
	@Order(1)
	@ParameterizedTest
	@CsvFileSource(resources = "data/testdata/wechat.csv", numLinesToSkip = 1)
	public void testAddMember(@CsvToMember Member member){
		try {
			// 添加用户
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login().contact().addMember(member);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建部门并搜索
	 * @param departName	部门名称
	 */
	@Order(2)
	@ParameterizedTest
	@ValueSource(strings = "测试")
	public void testAddDepartAndSearch(String departName){
		try {
			LoginPage loginPage = new LoginPage(driver);
			String departInfo = loginPage.login().contact().addDepart(departName).searchInfo(departName).getDepartInfo();
			assertTrue(departInfo.contains(departName));
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Order(3)
	@ParameterizedTest
	@CsvSource(value = {"测试","测试2"})
	public void testUpdateDepartName(String oldDepartName, String newDepartName){
		try {
			LoginPage loginPage = new LoginPage(driver);
			String departInfo = loginPage.login().contact().updateDepartInfo(oldDepartName, newDepartName).searchInfo(newDepartName).getDepartInfo();
			assertTrue(departInfo.contains(newDepartName));
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Order(4)
	@ParameterizedTest
	@ValueSource(strings = "测试2")
	public void testDeleteDepartInfo(String departName){
		try {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.login().contact().deletePartInfo(departName);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}

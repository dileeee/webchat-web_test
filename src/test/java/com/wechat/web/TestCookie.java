package com.wechat.web;

import com.wechat.web.page.LoginPage;
import com.wechat.web.resolver.ChromeParameterResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

/**
 * @author w29530
 * @date 2021/11/12
 * @desc
 */
@ExtendWith(ChromeParameterResolver.class)
public class TestCookie extends BaseTest {


	@Test
	public void testGenerateCookie(){
		LoginPage loginPage = new LoginPage(getDriver());
		try {
			loginPage.generateLoginCookie();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}
}

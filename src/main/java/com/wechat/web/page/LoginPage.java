package com.wechat.web.page;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.wechat.web.config.ConfigPropInfo;
import com.wechat.web.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc 登录页面
 */
public class LoginPage extends BasePage {

    private final ObjectMapper objectMapper;

    private File file;

    private static final String LOGIN_URL = "https://work.weixin.qq.com/wework_admin/frame";

    public LoginPage(WebDriver driver) {
        super(driver);
        objectMapper = new ObjectMapper(new YAMLFactory());
    }

    /**
     * 登录
     */
    public HomePage login() throws IOException, InterruptedException {
        if (cookieFileExist()) {
            openPageByMax(LOGIN_URL);
            TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {
            };
            List<HashMap<String, Object>> hashMapList = objectMapper.readValue(new File(ConfigPropInfo.COOKIE_FILE), typeReference);
            hashMapList.forEach(cookieMap -> {
                this.getDriver().manage().addCookie(new Cookie(cookieMap.get("name").toString(), cookieMap.get("value").toString()));
            });

            refreshPage();
        } else {
            generateLoginCookie();
        }
        if (!isLogin()) {
            getDriver().quit();
            generateLoginCookie();
        }
        return new HomePage(this.getDriver());

    }

    /**
     * 生成登录的cookie
     */
    public void generateLoginCookie() throws IOException, InterruptedException {
        if (cookieFileExist()) {
            file.delete();
        }
        openPageByMax(LOGIN_URL);

        // 扫码等待15秒
        Thread.sleep(15000);

        Set<Cookie> cookies = getCookies();
        objectMapper.writeValue(new File(ConfigPropInfo.COOKIE_FILE), cookies);
    }

    private Boolean isLogin() {
        try {
            this.getDriver().findElement(By.id("menu_index"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private Boolean cookieFileExist() {
        file = new File(ConfigPropInfo.COOKIE_FILE);
        return file.exists();
    }
}

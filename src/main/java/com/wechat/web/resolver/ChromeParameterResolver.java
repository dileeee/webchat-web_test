package com.wechat.web.resolver;

import com.wechat.web.model.Browser;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;

/**
 * @author w29530
 * @date 2021/12/12
 * @desc chrome浏览器
 */
public class ChromeParameterResolver extends BaseBrowserParameterResolver {

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return new Browser("chrome");
	}
}

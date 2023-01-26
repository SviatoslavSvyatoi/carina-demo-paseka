package com.qaprosoft.carina.demo.mobile.gui.pages.ios;

import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.ClassChain;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Predicate;

@DeviceType(pageType = Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

	@FindBy(xpath = "type = 'XCUIElementTypeTextField'")
	@Predicate
	private ExtendedWebElement nameInputField;

	@FindBy(xpath = "type = 'XCUIElementTypeSecureTextField'")
	@Predicate
	private ExtendedWebElement passwordInputField;

	@FindBy(xpath = "name = 'Male' AND type = 'XCUIElementTypeButton'")
	@Predicate
	private ExtendedWebElement maleRadioBtn;

	@FindBy(xpath = "**/XCUIElementTypeButton[`name == 'Female'`]")
	@ClassChain
	private ExtendedWebElement femaleRadioBtn;

	@FindBy(xpath = "**/XCUIElementTypeButton[`name CONTAINS 'checkbox'`]")
	@ClassChain
	private ExtendedWebElement privacyPolicyCheckbox;

	@FindBy(xpath = "name = 'LOGIN'")
	@Predicate
	private ExtendedWebElement loginBtn;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void typeName(String name) {
		nameInputField.type(name);
	}

	@Override
	public void typePassword(String password) {
		passwordInputField.type(password);
	}

	@Override
	public void selectSex(Sex sex) {
		maleRadioBtn.click();
	}

	@Override
	public void checkPrivacyPolicyCheckbox() {
		privacyPolicyCheckbox.click();
	}

	@Override
	public WebViewPageBase clickLoginBtn() {
		loginBtn.click();
		return initPage(getDriver(), WebViewPageBase.class);
	}

	@Override
	public boolean isLoginBtnActive() {
		return Boolean.parseBoolean(loginBtn.getAttribute("enabled"));
	}

	@Override
	public WebViewPageBase defaultLogin(){
		String username = "Test user";
		String password = RandomStringUtils.randomAlphabetic(10);
		typeName(username);
		typePassword(password);
		selectSex(Sex.MALE);
		checkPrivacyPolicyCheckbox();
		return clickLoginBtn();
	}

	@Override
	public boolean isSexRadioButtonChecked(Sex sex) {
		throw new NotImplementedException("This method hasn't realization on IOS");
	}

	@Override
	public String getTextInputField(InputField inputField) {
		throw new NotImplementedException("This method hasn't realization on IOS");
	}

	@Override
	public boolean isPrivacyPolicyCheckboxPresent() {
		throw new NotImplementedException("This method hasn't realization on IOS");
	}

	@Override
	public boolean isLoginButtonPresent() {
		throw new NotImplementedException("This method hasn't realization on IOS");
	}

	@Override
	public boolean isSexRadioButtonPresent(Sex sex) {
		throw new NotImplementedException("This method hasn't realization on IOS");
	}

	@Override
	public boolean isInputFieldPresent(InputField inputField) {
		throw new NotImplementedException("This method hasn't realization on IOS");
	}

	@Override
	public boolean isPrivacyPolicyCheckboxChecked() {
		throw new NotImplementedException("This method hasn't realization on IOS");
	}
}

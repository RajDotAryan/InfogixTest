package com.test.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath = "//a[@class='HeaderMenu-link no-underline mr-3']")
	private WebElement _signInButton;

	@FindBy(xpath = "//h1[contains(text(),'Sign in to GitHub')]")
	private WebElement _loginPageTitle;

	@FindBy(xpath = "//input[@name='commit']")
	private WebElement _loginButton;

	@FindBy(xpath = "//div[@class='container']")
	private WebElement _loginPageErrorMessage;

	@FindBy(xpath = "//a[@class='label-link']")
	private WebElement _loginPageForgotPasswordLink;

	public WebElement get_loginPageForgotPasswordLink() {
		return _loginPageForgotPasswordLink;
	}

	public WebElement get_loginPageErrorMessage() {
		return _loginPageErrorMessage;
	}

	public WebElement get_loginButton() {
		return _loginButton;
	}

	public WebElement get_loginPageTitle() {
		return _loginPageTitle;
	}

	public WebElement get_signInButton() {
		return _signInButton;
	}
}

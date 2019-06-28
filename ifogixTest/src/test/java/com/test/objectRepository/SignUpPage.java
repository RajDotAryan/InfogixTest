package com.test.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
	
	@FindBy(xpath = "//a[@class='HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1']")
	private WebElement _signUpButton;

	@FindBy(xpath = "//h1[contains(text(),'Join GitHub')]")
	private WebElement _signUpPageTitle;

	@FindBy(xpath = "//h2[contains(text(),'Create your personal account')]")
	private WebElement _createYourPersonalAccountHeader;

	@FindBy(xpath = "//button[@id='signup_button']")
	private WebElement _createAccountButton;

	@FindBy(xpath = "//input[@id='user_email']")
	private WebElement _userEmailId;

	@FindBy(xpath = "//p[text()='Email is invalid or already taken']")
	private WebElement _emailIdAlreadyExist;

	public WebElement get_emailIdAlreadyExist() {
		return _emailIdAlreadyExist;
	}

	public WebElement get_signUpButton() {
		return _signUpButton;
	}

	public WebElement get_signUpPageTitle() {
		return _signUpPageTitle;
	}

	public WebElement get_createYourPersonalAccountHeader() {
		return _createYourPersonalAccountHeader;
	}

	public WebElement get_createAccountButton() {
		return _createAccountButton;
	}

	public WebElement get_userEmailId() {
		return _userEmailId;
	}
}

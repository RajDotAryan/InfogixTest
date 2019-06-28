package com.test.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestPasswordPage {
	
	@FindBy(xpath = "//input[@id='email_field']")
	private WebElement _ResetPasswordPageEmailAddressField;

	@FindBy(xpath = "//input[@name='commit']")
	private WebElement _sendPasswordResetEmailButton;

	@FindBy(xpath = "//button[@class='flash-close js-flash-close']//*[@class='octicon octicon-x']")
	private WebElement _errorMessageCloseIcon;

	public WebElement get_errorMessageCloseIcon() {
		return _errorMessageCloseIcon;
	}

	public WebElement get_ResetPasswordPageEmailAddressField() {
		return _ResetPasswordPageEmailAddressField;
	}

	public WebElement get_sendPasswordResetEmailButton() {
		return _sendPasswordResetEmailButton;
	}
}

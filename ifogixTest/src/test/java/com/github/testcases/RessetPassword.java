package com.github.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.test.utilities.PropertyHandler;
import com.test.utilities.WebElementUtils;

public class RessetPassword extends WebElementUtils{

	@Test()
	public void verifyErrorMessageForInvalidUserName() {
		click(loginPage.get_signInButton());
		waitForElementClickable(loginPage.get_loginPageForgotPasswordLink());
		click(loginPage.get_loginPageForgotPasswordLink());
		waitForElementVisibility(restPasswordPage.get_ResetPasswordPageEmailAddressField());
		sendkeys(restPasswordPage.get_ResetPasswordPageEmailAddressField(), PropertyHandler.getPropertyValue("invalidUserName"));
		click(restPasswordPage.get_sendPasswordResetEmailButton());
		Assert.assertEquals(loginPage.get_loginPageErrorMessage().getText().trim(),"Can't find that email, sorry.","Expected to display error Message");
	}
	
	@Test(dependsOnMethods="verifyErrorMessageForInvalidUserName")
	public void verifyErrorMessageForEmptyUserName() {
		click(restPasswordPage.get_errorMessageCloseIcon());
		click(restPasswordPage.get_sendPasswordResetEmailButton());
		Assert.assertEquals(loginPage.get_loginPageErrorMessage().getText().trim(),"Can't find that email, sorry.","Expected to display error Message");
	}
	
	@Test(dependsOnMethods="verifyErrorMessageForEmptyUserName")
	public void verifyErrorMessageContainsCant() {
		Assert.assertEquals(loginPage.get_loginPageErrorMessage().getText().trim().substring(0, 5),"Can't","Expected to display Can't as starting error Message");
	}
	
	@AfterClass
	public void quit() {
		getDriver().quit();
	}
}

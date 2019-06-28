package com.github.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.test.utilities.WebElementUtils;

public class Login extends WebElementUtils{

	@Test
	public void verifyLoginPage() {
		click(loginPage.get_signInButton());
		waitForElementVisibility(loginPage.get_loginPageTitle());
		Assert.assertEquals(loginPage.get_loginPageTitle().getText().trim(),"Sign in to GitHub","Expected to display Login Page Title");
	}
	
	@Test(dependsOnMethods="verifyLoginPage")
	public void verifyMandatoryFields() {
		click(loginPage.get_loginButton());
		Assert.assertEquals(loginPage.get_loginPageErrorMessage().getText().trim(),"Incorrect username or password.","Expected to display error Message");
	}
	
	@AfterClass
	public void quit() {
		getDriver().quit();
	}
}

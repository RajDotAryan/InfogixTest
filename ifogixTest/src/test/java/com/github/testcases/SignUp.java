package com.github.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.test.utilities.PropertyHandler;
import com.test.utilities.WebElementUtils;

public class SignUp extends WebElementUtils{
	
	@Test
	public void verifySignUpPage() {
		click(signUpPage.get_signUpButton());
		waitForElementVisibility(signUpPage.get_signUpPageTitle());
		Assert.assertEquals(signUpPage.get_signUpPageTitle().getText().trim(),"Join GitHub","Expected to display Sign Page Title");
	}
	
	@Test(dependsOnMethods="verifySignUpPage")
	public void verifyCreateYourAccountHeader() {
		Assert.assertEquals(signUpPage.get_createYourPersonalAccountHeader().getText().trim(),"Create your personal account","Expected to display Create your personal account Header");
	}
	
	@Test(dependsOnMethods="verifySignUpPage")
	public void verifyCreateAnAccountButtonIsDisable() {
		sendkeys(signUpPage.get_userEmailId(), PropertyHandler.getPropertyValue("userName"));
		boolean flag = true;
		if(signUpPage.get_emailIdAlreadyExist().isDisplayed()) {
			if(signUpPage.get_createAccountButton().isEnabled()) {
				flag = false;
			}
			
		}
		Assert.assertTrue(flag,"Create An Account Button is enabled");
	}
	
	@AfterClass
	public void quit() {
		getDriver().quit();
	}

}

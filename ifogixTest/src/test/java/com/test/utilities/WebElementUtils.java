package com.test.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.test.objectRepository.LoginPage;
import com.test.objectRepository.RestPasswordPage;
import com.test.objectRepository.SignUpPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementUtils extends PageFactoryAbstract {
	
	WebDriver driver = null;
	public LoginPage loginPage = null;
	public RestPasswordPage restPasswordPage = null;
	public SignUpPage signUpPage = null;
	
	@BeforeClass
	public void initializeDriver() {
		if(PropertyHandler.getPropertyValue("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(PropertyHandler.getPropertyValue("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(PropertyHandler.getPropertyValue("browser").equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to(PropertyHandler.getPropertyValue("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		loginPage = loadObject(driver, new LoginPage());
		restPasswordPage = loadObject(driver, new RestPasswordPage());
		signUpPage = loadObject(driver, new SignUpPage());
	}

	public void click(WebElement element) {
		try {
			if (element.isDisplayed()) {
				element.click();
			}
		} catch (StaleElementReferenceException s) {
			driver.navigate().refresh();
			sleep(2000);
			if (element.isDisplayed()) {
				element.click();
			}
		}
	}

	public void sleep(long seconds) {
		try {
			Thread.sleep(seconds);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public <T> void sendkeys(WebElement element, T value) {
		try {
			if (value != null && element.isDisplayed()) {
				element.clear();
				element.sendKeys(value.toString());
			} else {
				element.clear();
			}
		} catch (StaleElementReferenceException s) {
			driver.navigate().refresh();
			sleep(2000);
			sendkeys(element, value, 0);
		}
	}

	public <T> void sendkeys(WebElement element, T value, int sendkeysCount){
		if (value != null && element.isDisplayed()) {
			element.clear();
			element.sendKeys(value.toString());
		} else {
			element.clear();
		}
	}

	public void waitForElementVisibility(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}

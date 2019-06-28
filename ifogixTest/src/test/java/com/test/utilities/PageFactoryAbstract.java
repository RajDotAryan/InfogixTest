package com.test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageFactoryAbstract {
	@SuppressWarnings("unchecked")
	public <T> T loadObject(WebDriver driver, T t){
		return (T) PageFactory.initElements( driver, t.getClass());
	}
}

package com.test.automation.salesForceLoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;
import com.test.automation.tests.base.BaseTest;

public class InvalidUsernamePwdPage extends BasePage {
	@FindBy(xpath = "//div[@id='error']") WebElement errorMsg;
	public InvalidUsernamePwdPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	public boolean foundErrorMessage()
	{
		waitExplicit(errorMsg);
		return isPresent(errorMsg);
	}

}

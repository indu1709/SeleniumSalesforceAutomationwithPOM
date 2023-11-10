package com.test.automation.salesForceLoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;
import com.test.automation.tests.base.BaseTest;

public class ForgotPasswordPage extends BasePage {

	@FindBy(xpath="//input[@id='un']") WebElement uname;
	@FindBy(xpath="//input[@id='continue']") WebElement cont;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterUname(String username)
	{
		waitExplicit(uname);
		enterText(uname,username,"userName");
	}
	public void clickOnContinue()
	{
		waitExplicit(cont);
		clickElement(cont,"continue button");
	}

}

package com.test.automation.salesForceLoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;
import com.test.automation.tests.base.BaseTest;

public class PwdErrorMsgLoginPage extends BasePage {
	@FindBy(xpath = "//div[@id='error']")
	WebElement error;

	public PwdErrorMsgLoginPage(WebDriver driver) {
		super(driver);
	}

	public boolean foundErrorMessage() {
		waitforVisibilty(error, 30, "login error");
		if (isPresent(error))
			return true;
		else
			return false;
	}

}

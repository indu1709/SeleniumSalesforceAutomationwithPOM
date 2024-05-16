package com.test.automation.pages.homepages;

import org.openqa.selenium.WebDriver;

import com.automation.pages.base.BasePage;

public class OpportunitiesPipeline extends BasePage {
	public OpportunitiesPipeline(WebDriver driver) {
		super(driver);
	}

	public String getThisPageTitle() {
		return getPageTitle();
	}
}

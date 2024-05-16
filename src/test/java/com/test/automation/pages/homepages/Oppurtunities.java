package com.test.automation.pages.homepages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;

import com.automation.pages.base.BasePage;

public class Oppurtunities  extends BasePage {

	@FindBy (id="fcf")
	 WebElement viewDropDown ; 
	@FindBy (xpath="//div[@class='lbBody']//a[text()='Opportunity Pipeline']") WebElement pipelineE ; 
	@FindBy(xpath="//div[@class='lbBody']//a[text()='Stuck Opportunities']") WebElement stuckOpportunites ; 
	@FindBy(xpath = "//input[contains(@title,'New')]")
	WebElement NewButton;
	@FindBy(xpath = "//input[@title='Run Report']")
	WebElement  RunReport;


	
	
	public Oppurtunities(WebDriver driver) {
		super(driver) ; 
	}
	
	public String getThisPageTitle() {
		return getPageTitle();
	}
	
	public  void validateDropDown( Object[] expected, String objectName) {
		validateDropDownwithSelectClass(viewDropDown, expected,  objectName);	
	}

	public WebDriver clickPipelineLink() {
		clickElement(pipelineE, "Pipeline Link");
		return driver;
	}
	public WebDriver clickStuckOpportunitiesLink() {
		clickElement(stuckOpportunites, "Stuck Opportunities Link");
		return driver;
	}
	
	
	public void clickOnNewButton() {
		waitExplicit(NewButton);
		NewButton.click();

	}

	
	public void clickOnRunReport() {
		waitExplicit(  RunReport);
		 RunReport.click();
	}

}



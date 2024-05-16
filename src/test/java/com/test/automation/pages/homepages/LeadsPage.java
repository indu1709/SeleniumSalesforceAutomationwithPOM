package com.test.automation.pages.homepages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.*;
import org.openqa.selenium.support.ui.Select;


import com.automation.pages.base.BasePage;

public class LeadsPage extends BasePage {

	
	@FindBy(xpath="//a[@title='Leads Tab']")
	WebElement LeadsTab;
	@FindBy(xpath="//select[@id='fcf']")
	WebElement LeadSelect;
	@FindBy(xpath="//input[@value=\" Go! \"]")
	WebElement Go;
	@FindBy( xpath="//input[@title='New']")
	  WebElement New;
	@FindBy(xpath="//input[@id='name_lastlea2']")
	WebElement LastName;
	@FindBy(xpath="//input[@id='lea3']")
	WebElement CompanyName;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement SaveButton;
	

	public LeadsPage(WebDriver driver) { // parameterized constructor
		super(driver);
	}

		public void clickOnLeadsTab() {
		waitForElement(Duration.ofSeconds(40), LeadsTab);
		LeadsTab.click();
		
	}
	public void clickOnLeadSelect() {
		waitForElement(Duration.ofSeconds(40), LeadSelect);
		LeadSelect.click();
		Select view = new Select(LeadSelect);
		view.selectByIndex(3);

	    //Get all options
	    List<WebElement> vew = view.getOptions();

	    //Get the length
	    System.out.println(vew.size());

	    // Loop to print one by one
	    for (int j = 0; j < vew.size(); j++) {
	        System.out.println(vew.get(j).getText());

	    }
	
	}
	
	
	  public void clickOnButton() { 
		  waitForElement(Duration.ofSeconds(40), Go); 
		  Go.click();
	  
	  }
	  public void clickOnNew() {
			waitForElement(Duration.ofSeconds(40), New); 
			New.click();
		}
		
		public void enterLastName(String lastname) {
			waitForElement(Duration.ofSeconds(40), LastName); 
			LastName.sendKeys(lastname);
		}
		public void enterCompantName(String name) {
			waitForElement(Duration.ofSeconds(40), CompanyName); 
			CompanyName.sendKeys(name);
			
		}
		public void clickOnSave() {
			waitForElement(Duration.ofSeconds(40), SaveButton);
			SaveButton.click();
		}
}
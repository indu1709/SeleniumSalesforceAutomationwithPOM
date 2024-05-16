package com.test.automation.pages.homepages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class ContactsPage extends BasePage {

	@FindBy(xpath = "//a[@title='Contacts Tab']")
	WebElement contact;
	@FindBy(xpath = "//input[contains(@title,'New')]")
	WebElement new_Element;
	@FindBy(xpath = "//input[@id='name_firstcon2']")
	WebElement first_Name;
	@FindBy(xpath = "//input[@id='name_lastcon2']")
	WebElement last_Name;
	@FindBy(xpath = " //td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement SaveButton;
	@FindBy(xpath = "//select[@id='fcf']")
	WebElement viewDropDown;
	@FindBy(xpath = "//a[contains(text(),'Create New View')]")

	WebElement createNewViewContactElement;
	
	@FindBy(xpath = "//input[@id='fname']")
     WebElement viewNameContactElement;
	@FindBy(xpath = "//input[@id='devname']")

	WebElement viewUniqueNameElement;
	
	@FindBy(xpath = " //div[@class='pbBottomButtons']//input[@title='Save']")
	WebElement SaveViewButton;

	@FindBy(xpath = " //div[@class='pbBottomButtons']//input[@title='Cancel']")
	WebElement CancelViewButton;


	public ContactsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickOnContacts() {
		waitForElement(Duration.ofSeconds(10), contact);
		contact.click();
	}

	public void clickOnNew() {
		waitForElement(Duration.ofSeconds(10), new_Element);
		new_Element.click();
	}

	public void enterIntoFirstname() {
		waitForElement(Duration.ofSeconds(10), first_Name);
		first_Name.sendKeys("Mango");
	}

	public void enterIntolastname() {
		waitForElement(Duration.ofSeconds(10), last_Name);
		last_Name.sendKeys("Trade");
	}

	public void clickOnSave() {
		waitForElement(Duration.ofSeconds(40), SaveButton);
		SaveButton.click();
	}

	public void validateDropDown(Object[] expected, String objectName) {
		validateDropDownwithSelectClass(viewDropDown, expected, objectName);
	}

	public void clickOnNewViewContacts() {

		waitForElement(Duration.ofSeconds(10), createNewViewContactElement);
		clickElement(createNewViewContactElement, "new  view link");

	}

	public void enterIntoViewname() {
		// TODO Auto-generated method stub
		waitForElement(Duration.ofSeconds(10), viewNameContactElement);
		enterText(viewNameContactElement, "Nandhini", "view name");

	}
	
	public void enterIntoUniqueViewname() {
		// TODO Auto-generated method stub
		waitForElement(Duration.ofSeconds(10), viewUniqueNameElement);
		enterText(viewUniqueNameElement, "aachu", "view name");

	}
	
	public void clickOnSaveViewButton() {
		waitForElement(Duration.ofSeconds(40), SaveViewButton);
		SaveViewButton.click();
	}

	public void checkRecentlyCreatedContact() {
		// TODO Auto-generated method stub
		WebElement createdContactListElement = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		selectTextByData(createdContactListElement, "Recently Created", "created Contact");
	
	}

	public void onclickdropdown() {
		// TODO Auto-generated method stub
		selectByVisibleText(viewDropDown, "My Contacts", "drop down list");
		

	}

	public String checkonErrorMsg() {
		// TODO Auto-generated method stub
		WebElement errorEle = driver.findElement(By.xpath("//div[@class='requiredInput']//div[@class='errorMsg']"));
		String errorText=errorEle.getText();
	return errorText;
	}

	public void clickOnCancelViewButton() {
		waitForElement(Duration.ofSeconds(40), CancelViewButton);
		CancelViewButton.click();
	// TODO Auto-generated method stub
		
	}
}

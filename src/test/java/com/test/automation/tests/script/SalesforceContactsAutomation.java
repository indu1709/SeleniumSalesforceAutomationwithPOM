package com.test.automation.tests.script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.Home.HomePage;
import com.test.automation.pages.homepages.AccountPage;
import com.test.automation.pages.homepages.ContactsPage;
import com.test.automation.salesForceLoginPages.LoginPage;
import com.test.automation.tests.base.BaseTest;

public class SalesforceContactsAutomation extends BaseTest {

	LoginPage loginPage;
	HomePage homepage;
	AccountPage account;
	 ContactsPage contacts;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		Thread.sleep(2000);
		loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		System.out.println(password);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();

		Thread.sleep(5000);
		String actualTitle = getPageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expected, "login Unsucessful");

		homepage = new HomePage(driver);
		contacts = new ContactsPage(driver);

	}

	@DataProvider(name = "dropdownOptions")
	public static Object[][] dropdownOptions() {
		return new Object[][] { { new String[] { "All Contacts", "Birthdays This Month", "Bulk SMS Contacts", "EFGH",
				"My Contacts", "New Last Week", "New This Week", "Recently Viewed Contacts" } } };
	}

	 @Test // TC25- Create new contact
	public void Createnewcontact() {
		contacts.clickOnContacts();
		contacts.clickOnNew();
		contacts.enterIntoFirstname();
		contacts.enterIntolastname();
		contacts.clickOnSave();
	}

	 @Test //TC26
	public void createNewViewContact() {
		contacts.clickOnContacts();
		contacts.clickOnNewViewContacts();
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		contacts.enterIntoViewname();
		contacts.enterIntoUniqueViewname();
		contacts.clickOnSaveViewButton();

	}

	@Test
	public void checkRecentlyCreatedContact() {
		contacts.clickOnContacts();
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		contacts.checkRecentlyCreatedContact();
		takescreenshot(driver);

	}

	 @Test(dataProvider = "dropdownOptions")

	public void verifyContactTC28(String[] expectedOptions) throws InterruptedException {

		contacts.clickOnContacts();
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		contacts.validateDropDown(expectedOptions, "validating Contacts drop down");

	}

	@Test
	public void viewContactTC29() throws InterruptedException {

		contacts.clickOnContacts();
		contacts.onclickdropdown();
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		takescreenshot(driver);
	}
	
	@Test
	public  void checkErrorViewTC30() {
		contacts.clickOnContacts();		
		contacts.clickOnNewViewContacts();
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		contacts.enterIntoUniqueViewname();
		contacts.clickOnSaveViewButton();
		takescreenshot(driver);
		 String errorText =contacts.checkonErrorMsg();
		 Assert.assertEquals(actualContacterrorText, errorText, "login Unsucessful");
		
	}
	
	@Test
	public  void checkCancelViewTC30() {
		contacts.clickOnContacts();		
		contacts.clickOnNewViewContacts();
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		contacts.enterIntoUniqueViewname();
		contacts.clickOnCancelViewButton();
		takescreenshot(driver);
		 		
	}



}

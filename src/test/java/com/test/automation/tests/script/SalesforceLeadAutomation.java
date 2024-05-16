package com.test.automation.tests.script;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.Home.HomePage;
import com.test.automation.pages.homepages.AccountPage;
import com.test.automation.pages.homepages.ContactsPage;
import com.test.automation.pages.homepages.LeadsPage;
import com.test.automation.salesForceLoginPages.LoginPage;
import com.test.automation.tests.base.BaseTest;

public class SalesforceLeadAutomation extends BaseTest {

	LoginPage loginPage;
	HomePage homepage;
	LeadsPage leads;

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
		leads=new LeadsPage(driver);
	}

	@Test // TC20-leadsTab
	public void leadsTab() {
		leads.clickOnLeadsTab();
	}

   @Test // TC21-leadsSelectView
	public void leadsSelectView() {
		leads.clickOnLeadsTab();
		leads.clickOnLeadSelect();
	}

  @Test // TC22-defaultView
	public void defaultView() {
		leads.clickOnLeadsTab();
		leads.clickOnLeadSelect();
		homepage.selectUsernameDropdown();
		homepage.logout();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);

		loginPage.clickLoginButton();
		leads.clickOnLeadsTab();
		// leads.clickOnButton(Go);
		leads.clickOnButton();
	}

	@Test // TC23-Todays Leads
	public void todaysLeads() {
		leads.clickOnLeadsTab();
		leads.clickOnLeadSelect();
		// leads.clickOnButton(Go);
		leads.clickOnButton();
	}

    @Test // TC24-New Lead creation
	public void newLeads() {
		leads.clickOnLeadsTab();
		// leads.clickObj(New, Newlead);
		leads.clickOnNew();
		leads.enterLastName("Saravana");
		leads.enterCompantName("Hexaware");
		leads.clickOnSave();
	}

}

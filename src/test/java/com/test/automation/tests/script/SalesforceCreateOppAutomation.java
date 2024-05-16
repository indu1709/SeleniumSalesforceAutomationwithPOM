package com.test.automation.tests.script;


import com.automation.pages.Home.HomePage;
import com.test.automation.pages.homepages.*;
import com.test.automation.tests.base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.test.automation.salesForceLoginPages.*;

public class SalesforceCreateOppAutomation extends BaseTest {

	LoginPage loginPage;
	HomePage homepage;
	Oppurtunities opp;
	OpportunitiesPipeline pipelinepage;

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

	}

	@DataProvider(name = "dropdownOptions")
	public static Object[][] dropdownOptions() {
		return new Object[][] { { new String[] { "Closing Next Month", "My Opportunities", "New Last Week",
				"New This Week", "Opportunity Pipeline", "Private", "Recently Viewed Opportunities", "Won" } } };
	}

	@Test(dataProvider = "dropdownOptions")

	public void CreateOptyTC15(String[] expectedOptions) throws InterruptedException {

		homepage.clickOpportunitiesTab();
		Thread.sleep(3000);

		opp = new Oppurtunities(driver);
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		opp.validateDropDown(expectedOptions, "validating oppurtunities drop down");

	}

	@Test // TC16 Create a new Opty
	public void CreateANewOpty() throws InterruptedException {
		homepage.clickOpportunitiesTab();
		Thread.sleep(3000);
		opp = new Oppurtunities(driver);
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		opp.clickOnNewButton();
	}

	@Test
	public void CreateOptyTC17() throws InterruptedException {
		// Login to Salesforce

		homepage.clickOpportunitiesTab();
		Thread.sleep(3000);

		opp = new Oppurtunities(driver);
		switchtoWindowHandle(driver.getWindowHandle(), driver);

		driver = opp.clickPipelineLink();
		Thread.sleep(3000);

		pipelinepage = new OpportunitiesPipeline(driver);

		String actTitle = pipelinepage.getThisPageTitle();

		Assert.assertEquals(actTitle, expOPPPipelineTitle);
		mylog.info("PASSED : Testcase passed ");

	}

	@Test
	public void CreateOptyTC18() throws InterruptedException {
		// Login to Salesforce

		homepage.clickOpportunitiesTab();
		Thread.sleep(3000);

		opp = new Oppurtunities(driver);
		switchtoWindowHandle(driver.getWindowHandle(), driver);

		opp.clickStuckOpportunitiesLink();

		String actualTitle2 = driver.getTitle();
		Assert.assertEquals(actualTitle2, expOppStuckTitle);
		mylog.info("PASSED >> Stuck Opportunities page loaded");

	}

	@Test // TC19 Test Quarterly Summary Report
	public void TestQuarterlySummaryReport() throws InterruptedException {
		Thread.sleep(2000);
		homepage.clickOpportunitiesTab();
		Thread.sleep(3000);

		opp = new Oppurtunities(driver);
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		opp.clickOnRunReport();
	}
}

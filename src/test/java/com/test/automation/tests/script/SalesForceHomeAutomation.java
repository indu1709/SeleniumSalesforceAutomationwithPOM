package com.test.automation.tests.script;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.Home.HomePage;
import com.test.automation.salesForceLoginPages.LoginPage;
import com.test.automation.tests.base.BaseTest;

public class SalesForceHomeAutomation extends BaseTest {

	LoginPage loginPage;
	HomePage homepage;

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
		return new Object[][] { { new String[] { "My Profile", "My Settings", "Developer Console",
				"Switch to Lightning Experience", "Logout" } } };
	}

	 @Test(dataProvider = "dropdownOptions")
	public void selectUserNameforDropdown(String[] expectedOptions) {
		homepage.selectUsernameDropdown();
		homepage.validateUserMenudropdown(expectedOptions);
		takescreenshot(driver);

	}

	 @Test //Test case-6
	public void selectMyProfile() {
		homepage.selectUsernameDropdown();
		homepage.selectMyProfile();
		homepage.edit();
		homepage.switchFrame();
		homepage.clickOnAbout();

	}

	@Test // Test Case-7
	public void selectMySettings() {
		homepage.selectUsernameDropdown();
		homepage.selectMySettings();
		homepage.clickOnPersonal();
		homepage.clickOnLoginHistory();
		homepage.clickOnLoginhistoryDownload();
		homepage.displayAndLayout();
		homepage.customizeTab();
		homepage.dropDown();
		homepage.availableTabsDropdown();
		homepage.clickOnAdd();
		homepage.clickOnEmail();
		homepage.cliclOnEmailSettings();
		homepage.enterName("Name");
		homepage.enterIntoEmail(email);
		homepage.clickOnRadioButton();
		homepage.clickOnCallenderAndReminder();
		homepage.clickOnActivityRemainder();
		homepage.clickOnTestRemainder();
	}

	
	@Test //Test Case-8
	public void selectDevelopersConsole() {
		homepage.selectUsernameDropdown();
		homepage.clickOnDeveloperConsole();
		takescreenshot(driver);

	}
	
	@Test  // Test case-09 Logout
	public void selectLogout() {
		homepage.selectUsernameDropdown();
		homepage.logout();
	}

	
}

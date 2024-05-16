package com.test.automation.tests.script;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.pages.Home.HomePage;
import com.test.automation.pages.homepages.AccountPage;
import com.test.automation.salesForceLoginPages.LoginPage;
import com.test.automation.tests.base.BaseTest;

public class SalesForceCreateAccount extends BaseTest {

	LoginPage loginPage;
	HomePage homepage;
	AccountPage account;

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
		account = new AccountPage(driver);

	}

	@Test // TC10 CreateAccount
	public void createAccount()  {
		account.clickOnCreateAccount();
		account.clickOnNewButton();
		account.enterAccountName(AccountName);
		account.clickOnSelectType();
		account.customerPriority();
		account.clickOnSaveButton();
	}

	@Test // TC11 Create New view
	public void createNewView() {

		account.clickOnCreateAccount();
		account.clickOnNewView();
		account.enterViewName(ViewName);
		account.enterUniqueViewName(UniqueViewName);
		account.clickOnViewSaveButton();

	}

	 @Test // TC12 Edit view
	public void editView()  {

		account.clickOnAccountTab();

		account.clickEdit();
		account.enterViewName("Saro");
		account.enterUniqueViewName("Mathi");
		account.selectByAccountName();
		account.selectOperator();
		account.enterValue(Value);
		account.ClickonSave();

	}

	@Test      //TC13 Merge Account
	public void mergeAccount() throws Exception  {
		account.clickOnAccountTab();
		switchtoWindowHandle(driver.getWindowHandle(), driver);
		account.mergeAccounts();
		account.mergeAccounts1();
	}

}

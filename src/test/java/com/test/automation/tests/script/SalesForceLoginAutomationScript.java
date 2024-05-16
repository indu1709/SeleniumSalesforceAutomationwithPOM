package com.test.automation.tests.script;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.pages.Home.HomePage;
import com.test.automation.salesForceLoginPages.ForgotPasswordPage;
import com.test.automation.salesForceLoginPages.InvalidUsernamePwdPage;
import com.test.automation.salesForceLoginPages.LoginPage;
import com.test.automation.salesForceLoginPages.PwdErrorMsgLoginPage;
import com.test.automation.salesForceLoginPages.ReturnToLoginPage;
import com.test.automation.tests.base.BaseTest;
import com.test.automation.tests.utility.PropertiesUtility;


public class SalesForceLoginAutomationScript extends BaseTest {

	
	@Test
	public static void login_To_SalesForce2() throws InterruptedException {

		System.out.println(
				"************* Test case SFDC (Login to Salesforce - 2 ) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);

		Thread.sleep(3000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();

		// HomePage homePage = new HomePage(driver);
		Thread.sleep(3000);
		String actualTitle = getPageTitle();

		Assert.assertEquals(actualTitle, expected, "test Case failed");

	}

	@Test
	public static void login_Error_Message1() throws InterruptedException

	{
		System.out.println(
				"************* Test case SFDC (Login Error Message - 1 ) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String expected = propUtility.getPropertyValue("Password.not.entered", prop);

		Thread.sleep(1000);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.clearPasswordNameElement();
		loginPage.clickLoginButton();

		Thread.sleep(1000);
		PwdErrorMsgLoginPage pwdErrorMsgLogin = new PwdErrorMsgLoginPage(driver);

		boolean loginErrorMsgActual = pwdErrorMsgLogin.foundErrorMessage();
		Assert.assertTrue(loginErrorMsgActual);

		
	}

	@Test
	public static void Check_RemeberMe3() throws InterruptedException {

		System.out.println(
				"************* Test case SFDC (Check Remember - 3 ) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String password = propUtility.getPropertyValue("login.valid.password", prop);
		String expected = propUtility.getPropertyValue("Home.page.title", prop);

		Thread.sleep(1000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.selectRememberMeChkbox();
		loginPage.clickLoginButton();
		
		Thread.sleep(3000);
		HomePage homePage = new HomePage(driver);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expected, " login Unsucessful");
		homePage.selectUserMenu();
			Thread.sleep(3000);

		boolean unameIsEmpty = loginPage.chkIfUnameEmpty();
		boolean rememberMeSelected = loginPage.chkIfRememberUnameSelected();
		Assert.assertFalse(unameIsEmpty);
		Assert.assertTrue(rememberMeSelected);

	}

	@Test
	public static void Forgot_Password4A() throws InterruptedException {
		System.out.println(
				"************* Test case SFDC (Forgot Password - 4 A ) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.valid.userid", prop);
		String expected = propUtility.getPropertyValue("forgot.password.error", prop);

		waitUntilPageLoads();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.forgotPwdLink();

		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

		forgotPasswordPage.enterUname(userName);
		loginPage.clickOnContinue();

		ReturnToLoginPage returntoLogin = new ReturnToLoginPage(driver);
		Thread.sleep(1000);
		String actual = returntoLogin.readMsg();

		Assert.assertEquals(actual, expected, "testCase failed");
	}

	@Test
	private static void Forgot_Password4B() throws InterruptedException {
		System.out.println(
				"************* Test case SFDC (Invalid Username Password - 4 B ) automation Script started **********************");

		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String userName = propUtility.getPropertyValue("login.invalid.userid", prop);
		String password = propUtility.getPropertyValue("login.invalid.password", prop);
		
		Thread.sleep(1000);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();

		InvalidUsernamePwdPage invalidUsernamePwdPage = new InvalidUsernamePwdPage(driver);
		Assert.assertTrue(invalidUsernamePwdPage.foundErrorMessage());

	}

}

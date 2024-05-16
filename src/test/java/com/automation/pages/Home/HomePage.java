package com.automation.pages.Home;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;

public class HomePage extends BasePage {
	@FindBy(xpath = "//span[@id='userNavLabel']")
	WebElement usermenu;
	@FindBy(linkText = "Logout")
	static WebElement logout_button;
	@FindBy(xpath = "//li[@id='Opportunity_Tab']/a")
	WebElement oppE;
	@FindBy(xpath = "//li[@id='Lead_Tab']/a")
	WebElement leadsE;

	@FindBy(id = "home_Tab")
	WebElement Home;

	@FindBy(xpath = "//a[@title='My Profile']")
	WebElement MyProfile;

	@FindBy(id = "name")
	WebElement Name;

	@FindBy(xpath = "//div[@id='userNav-arrow']")
	WebElement UserMenu;

	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	WebElement editProfile;

	@FindBy(xpath = "//iframe[@id='contactInfoContentId']")
	WebElement profileIframe;

	@FindBy(xpath = "//li[@id='aboutTab']")
	WebElement About;

	@FindBy(xpath = "//a[@title='My Settings']")
	WebElement MySettings;

	@FindBy(xpath = "//span[@id='PersonalInfo_font']")
	WebElement Personal;

	@FindBy(xpath = "//a[@id='LoginHistory_font']")
	WebElement loginHistory;

	@FindBy(xpath = "//a[contains(text(),'Download login history for last six months, includ')]")
	WebElement loginDownload;

	@FindBy(xpath = "//span[@id='DisplayAndLayout_font']")
	WebElement displayLayout;

	@FindBy(xpath = "//span[@id='CustomizeTabs_font']")
	WebElement CustomizeTab;

	@FindBy(id = "p4")
	WebElement dropdown;

	@FindBy(id = "duel_select_0")
	WebElement availableTabs;

	@FindBy(xpath = "//img[@class='rightArrowIcon']")
	WebElement Add_Aroow;

	@FindBy(id = "EmailSetup_font")
	WebElement Email;

	@FindBy(id = "EmailSettings_font")
	WebElement emailSetting;

	@FindBy(id = "sender_email")
	WebElement email;

	@FindBy(xpath = "//input[@id='sender_name']")
	WebElement senderName;

	@FindBy(xpath = "//input[@id='auto_bcc1']")
	WebElement RadioButton;

	@FindBy(id = "CalendarAndReminders_font")
	WebElement CalenderAndReminder;

	@FindBy(id = "Reminders_font")
	WebElement ActivityRemainder;

	@FindBy(xpath = "//input[@value='Open a Test Reminder']")
	WebElement Remainder;

	@FindBy(xpath = "//a[normalize-space()='Developer Console']")
	WebElement DeveloperConsole;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public static String getTextFromHomePage() throws InterruptedException {
		Thread.sleep(2000);
		return getPageTitle();
	}

	public void selectUserMenu() {
		// TODO Auto-generated method stub
		waitforVisibilty(usermenu, 35, "user menu label");
		moveandClickAction(usermenu, "mouse hover user menu");
		System.out.println("inside user menu ");
		logout();
	}

	public void logout() {

		// waitExplicit(logout_button);
		clickElement(logout_button, "log out ");
	}

	public WebDriver clickOpportunitiesTab() {
		clickElement(oppE, "Opportunities Tab");
		return driver;
	}

	public void clickOnDeveloperConsole() {
		DeveloperConsole.click();
	}

	public void clickOnTestRemainder() {
		Remainder.click();
	}

	public void clickOnActivityRemainder() {
		ActivityRemainder.click();
	}

	public void clickOnCallenderAndReminder() {

		CalenderAndReminder.click();
	}

	public void clickOnRadioButton() {
		RadioButton.click();
	}

	public void enterName(String Sname) {
		senderName.sendKeys(Sname);
	}

	public void enterIntoEmail(String stremail) {

		waitForElement(Duration.ofSeconds(30), email);
		email.clear();
		email.sendKeys(stremail);
	}

	public void cliclOnEmailSettings() {
		waitForElement(Duration.ofSeconds(30), emailSetting);
		emailSetting.click();
	}

	public void clickOnEmail() {
		waitForElement(Duration.ofSeconds(30), Email);
		Email.click();
	}

	public void clickOnAdd() {

		waitForElement(Duration.ofSeconds(10), Add_Aroow);

		Add_Aroow.click();
	}

	public void availableTabsDropdown() {

		waitForElement(Duration.ofSeconds(10), availableTabs);

		Select options = new Select(availableTabs);
		options.selectByVisibleText("Reports");
	}

	public void dropDown() {

		waitForElement(Duration.ofSeconds(10), dropdown);

		Select dropdownOptions = new Select(dropdown);
		dropdownOptions.selectByVisibleText("Salesforce Chatter");
	}

	public void customizeTab() {

		waitForElement(Duration.ofSeconds(10), CustomizeTab);

		CustomizeTab.click();
	}

	public void displayAndLayout() {
		waitForElement(Duration.ofSeconds(30), displayLayout);
		displayLayout.click();

	}

	public void clickOnLoginhistoryDownload() {
		waitForElement(Duration.ofSeconds(30), loginDownload);
		loginDownload.click();
	}

	public void clickOnLoginHistory() {
		waitForElement(Duration.ofSeconds(30), loginHistory);
		loginHistory.click();
	}

	public void clickOnPersonal() {
		waitForElement(Duration.ofSeconds(20), Personal);

		Personal.click();
	}

	public void selectMySettings() {
		MySettings.click();
	}

	public void clickOnAbout() {
		waitForElement(Duration.ofSeconds(30), About);

		About.click();
	}

	public void switchFrame() {

		waitForElement(Duration.ofSeconds(30), profileIframe);

		driver.switchTo().frame(profileIframe);

	}

	public void edit() {

		waitForElement(Duration.ofSeconds(20), editProfile);

		editProfile.click();

	}

	public void clickHome() {
		waitForElement(Duration.ofSeconds(20), Home);
		Home.click();

	}

	public void selectUsernameDropdown() {
		waitForElement(Duration.ofSeconds(30), UserMenu);
		UserMenu.click();
	}

	public void selectMyProfile() {

		waitForElement(Duration.ofSeconds(30), MyProfile);
		MyProfile.click();

	}

	public void validateUserMenudropdown(String[] expectedOptions) {
		// TODO Auto-generated method stub
		WebElement dropdown = driver.findElement(By.id("userNavMenu"));

		// Get all the option elements within the dropdown
		List<WebElement> optionElements = dropdown.findElements(By.tagName("a"));

		// Extract the text of each option element
		List<String> actualOptions = new ArrayList<>();
		for (WebElement optionElement : optionElements) {
			actualOptions.add(optionElement.getText());

		}

		Assert.assertEquals(actualOptions.toArray(new String[0]), expectedOptions,
				"Dropdown options do not match expected options");

	}

}

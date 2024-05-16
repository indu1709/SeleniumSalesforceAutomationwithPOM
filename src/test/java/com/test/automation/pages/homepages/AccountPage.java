package com.test.automation.pages.homepages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.pages.base.BasePage;

public class AccountPage extends BasePage {

	@FindBy(xpath = "//a[normalize-space()='Accounts']")
	WebElement CreateAccount;

	@FindBy(xpath = "//input[@value=' New ']")
	WebElement New;

	@FindBy(id = "acc2")
	WebElement AccountName;

	@FindBy(xpath = "//select[@id='acc6']")
	WebElement Type;

	@FindBy(xpath = "//select[@id='00NHr00000IHF9D']")
	WebElement Priority;

	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement save;

	@FindBy(xpath = "//a[normalize-space()='Create New View']")
	WebElement CreateNewView;

	@FindBy(id = "fname")
	WebElement ViewName;

	@FindBy(xpath = "//input[@value=' Save ']")
	WebElement ViewSave;
	@FindBy(xpath = "//a[@href=\"/merge/accmergewizard.jsp?retURL=%2F001%2Fo\"]")
	WebElement Mergeacc;
	@FindBy(xpath = "//input[@id='cid0']")
	WebElement Button1;
	@FindBy(xpath = "//a[@href=\"/001/o\"]")
	WebElement AccountTab;
	@FindBy(xpath = "(//input[@id='fval1'])[1]")
	WebElement Value;

	@FindBy(xpath = "(//input[@title='Save'])[2]")
	WebElement clickSave;

	@FindBy(id = "devname")
	WebElement UniqueViewName;

	@FindBy(xpath = "//select[@id='fcf']")
	WebElement SelectView;

	@FindBy(xpath = "//a[normalize-space()='Edit']")
	WebElement Edit;

	@FindBy(xpath = "(//select[@id='fcol1'])[1]")
	WebElement FilterField;
	@FindBy(xpath = "//select[@id='fop1']")
	WebElement operator;
	@FindBy(xpath="//div[@class='pbWizardBody']/input[@class='btn']")   WebElement FindAcc;


	public AccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void clickOnViewSaveButton() {
		ViewSave.click();
	}

	public void enterViewName(String strName) {

		waitforVisibilty(ViewName,driver,30,"ViewName");

		ViewName.sendKeys(strName);
	}

	
	public void selectByAccountName() {
			selectValueByData(FilterField,"ACCOUNT.NAME","ACCOUNT.NAME");
	}

	
	public void selectOperator() {
		
		selectValueByData(operator,"c","operator");
	}

	
	public void ClickonSave() {
		clickSave.click();
	}

	public void enterValue(String strValue) {
		waitForElement(Duration.ofSeconds(20), Value);

		Value.sendKeys(strValue);
	}

	public void clickEdit() {

		waitForElement(Duration.ofSeconds(10), Edit);

		Edit.click();
	}

	public void selectView() {
			selectValueByData(SelectView,"work","Select View");
	}

	public void enterUniqueViewName(String strUName) {
		waitForElement(Duration.ofSeconds(10), UniqueViewName);
		UniqueViewName.clear();
		UniqueViewName.sendKeys(strUName);
	}

	public void clickOnNewView() {
		waitForElement(Duration.ofSeconds(10), CreateNewView);

		CreateNewView.click();
	}

	public void clickOnSaveButton() {
		save.click();
	}

	public void customerPriority() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Priority);
        waitForElement(Duration.ofSeconds(10),Priority);


			selectValueByData(Priority,"High","Priority");
	}

	public void clickOnSelectType() {

		selectValueByData(Type,"Technology Partner","TYpe");
		
	}

	public void enterAccountName(String accName) {

		waitForElement(Duration.ofSeconds(10), AccountName);

		AccountName.sendKeys(accName);
	}

	public void clickOnNewButton() {
		waitForElement(Duration.ofSeconds(20), New);

		New.click();

	}

	public void clickOnCreateAccount() {
		waitForElement(Duration.ofSeconds(20), CreateAccount);
		CreateAccount.click();
	}

	
	public void clickOnAccountTab() {
		waitForElement(Duration.ofSeconds(30), AccountTab);
		AccountTab.click();

	}
	

	public void mergeAccounts1() throws Exception {

		WebElement fb = driver.findElement(By.id("srch"));
		fb.clear();

		enterText(fb, "Nandhini", "FindAccounts");
		waitForElement(Duration.ofSeconds(20), FindAcc);

		clickElement(FindAcc, "FindAcc");
		waitForElement(Duration.ofSeconds(20), Button1);
		Radiobutton(Button1, "RadioButton");
		WebElement Button2 = driver.findElement(By.xpath("//input[@id='cid1']"));
		Radiobutton(Button2, "RadioButton");
		//WebElement Button3 = driver.findElement(By.xpath("//input[@id='cid2']"));
		//Radiobutton(Button3, "RadioButton");
		WebElement Next = driver
				.findElement(By.xpath("//div[@class='pbWizardFooter']//div//input[@class='btn']"));
		Next.click();
		WebElement Merge = driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@title='Merge']"));
		Merge.click();
		switchtoAlert(driver);
		System.out.println("TC13_MergeAccounts is completed");
	}

	
	public void mergeAccounts() {

		waitForElement(Duration.ofSeconds(10), Mergeacc);

		clickElement(Mergeacc, "Mergeacc");
	}

	
}
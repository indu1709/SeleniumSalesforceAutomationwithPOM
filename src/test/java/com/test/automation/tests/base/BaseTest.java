package com.test.automation.tests.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.io.Files;
import com.test.automation.tests.utility.ExtentReportsUtility;
import com.test.automation.tests.utility.Log4JUtility;
import com.test.automation.tests.utility.PropertiesUtility;
import com.test.automation.tests.utility.Constants;

public class BaseTest {
	protected static WebDriver driver = null;
	protected static WebDriverWait wait = null;
	protected Log4JUtility logObject = Log4JUtility.getInstance();
	protected static Logger mylog;
	protected static ExtentReportsUtility report = ExtentReportsUtility.getInstance();
	protected static String userName;
	protected static String password;
	protected static String expected;
	protected static String expOPPPipelineTitle;
	protected static String expOppStuckTitle;
	protected static String AccountName;
	protected static String ViewName;
	protected static String UniqueViewName;
	protected static String Value;
	protected static String actualContacterrorText;
	protected static String email;

	@BeforeTest
	public void setUpBeforeTest() {
		mylog = logObject.getLogger();
	}

	@BeforeMethod
	@Parameters("browsername")
	public static void setUpBeforeTestMethod(@Optional("firefox") String browser_name) {
		PropertiesUtility propUtility = new PropertiesUtility();
		Properties prop = propUtility.createPropertyObject();
		propUtility.loadFile("applicationDataProperties", prop);
		String url = propUtility.getPropertyValue("url", prop);
		userName = propUtility.getPropertyValue("login.valid.userid", prop);
		password = propUtility.getPropertyValue("login.valid.password", prop);
		expected = propUtility.getPropertyValue("Home.page.title", prop);
		expOPPPipelineTitle = propUtility.getPropertyValue("opp.pipeline.title", prop);
		expOppStuckTitle = propUtility.getPropertyValue("Stuck.opp.title", prop);
		AccountName = propUtility.getPropertyValue("Account.Name", prop);
		ViewName = propUtility.getPropertyValue("View.Name", prop);
		UniqueViewName = propUtility.getPropertyValue("UniqueViewName", prop);
		Value = propUtility.getPropertyValue("Value", prop);
		actualContacterrorText=propUtility.getPropertyValue("actualContacterrorText", prop);
		email=propUtility.getPropertyValue("email", prop);
		launchbrowser(browser_name);
		maximizeBrowser();
		gotoUrl(url);

	}

	@AfterMethod
	public static void tearDownAfterTestMethod() {
		closeBrowser();
		mylog.info("*****************automation script closed ******************");
	}

	public static void launchbrowser(String browserName) {
		switch (browserName) {
		case "firefox":
			driver = new FirefoxDriver();
			mylog.info("firefox browser launched");
			break;
		case "chrome":
			driver = new ChromeDriver();
			mylog.info("Chrome browser launched");
			break;
		default:
			mylog.error("you have not entered the browser");
			break;
		}

	}

	public WebDriver getDriverInstance() {
		return driver;
	}

	public static void gotoUrl(String url) {
		driver.get(url);
		mylog.info(url + "is entered");

	}

	public static void maximizeBrowser() {

		driver.manage().window().maximize();
		mylog.info("maximize the window");
	}

	public static String getPageTitle() {
		return driver.getTitle();
	}

	public static void refreshPage() {
		driver.navigate().refresh();
		// report.logTestInfo("page is refreshed");
	}

	// ***************browser closed and quit ********************************8
	public static void closeBrowser() {
		driver.close();
		mylog.info("browser closed");
		// report.logTestInfo("browser closed");
	//	driver.quit();
		driver = null;

	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
		mylog.info("All the browsers are closed");
		// report.logTestInfo("browser closed");
		driver = null;

	}

	// ********************************************************************

	public static void enterText(WebElement givenWebElement, String data, String objectName) {
		if (givenWebElement.isDisplayed()) {
			clearElement(givenWebElement, objectName);
			givenWebElement.sendKeys(data);
			mylog.info(" data is entered in the " + objectName);
			// report.logTestInfo("Pass :" +objectName + "is entered to username feild");
		} else {
			mylog.error(objectName + " element is not displayed");
		}
	}

	protected static void clearElement(WebElement givenWebElement, String objectName) {
		if (givenWebElement.isDisplayed()) {
			givenWebElement.clear();
			mylog.info(objectName + " is cleared");
		} else {
			mylog.error(objectName + " is not displayed");
		}

	}

	public static void clickElementButton(WebElement buttonElement, String objectName) {
		if (buttonElement.isEnabled()) {
			buttonElement.click();
			mylog.info(objectName + " is clicked");
			// report.logTestInfo( objectName + " is clicked");
		} else {
			mylog.error(objectName + " element is not enabled");
		}

	}

	public static String getTextFromElement(WebElement element, String objectName) {
		String data = element.getText();
		mylog.info("text extracted from " + objectName);
		return data;
	}

	// *****************Unselect CheckBox******************************
	public static void clickOn(WebElement element) {
		Actions act = new Actions(driver);
		if (element.isEnabled()) {
			act.click(element).build().perform();
		}

	}

	public static void unselectCheckBox(WebElement element) {
		if (element.isSelected()) {
			clickOn(element);
		}
	}

	public static void selectCheckBox(WebElement element) {
		if (!(element.isSelected()))
			clickOn(element);

	}

	public static boolean isCheckBoxSelected(WebElement element) {
		return element.isSelected();
	}

	// **********************Building alert Reusable method
	// *********************************

	public static Alert switchToAlert() {

		Alert alert = driver.switchTo().alert();
		mylog.info(" switched to alert");
		return alert;

	}

	public static void AcceptAlert(Alert alert) {
		mylog.info(" Alert accepted");
		alert.accept();
	}

	public static String getAlertText(Alert alert, String objName) {
		System.out.println(" extracting text in the  " + objName + "alert");
		String text = alert.getText();
		System.out.println("text is extracted from alert box is  " + text);

		return text;
	}

	public static void dismissAlert() {
		Alert alert = switchToAlert();
		alert.dismiss();
		System.out.println("alert dismissed");
	}

	public static void sendDatatoAlert(WebElement element, String keys, String objectName) {

		driver.switchTo().alert().sendKeys(keys);

		System.out.println(objectName + " is clicked");

	}

	// *************************Action class reusable
	// methods*************************

	public static void waitUntilPageLoads() {
		mylog.info("waiting until page loads within 30 sec maximum");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	}

	public static void moveToElementAction(WebElement element, String objName) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		System.err.println("cursor moved to web element " + objName);
	}

	public static void ContextClickActions(WebElement elemenet, String objName) {
		Actions action = new Actions(driver);
		action.contextClick(elemenet).build().perform();
		System.out.println("right click performed on Web Element  " + objName);
	}
	// ************************Select class reusable
	// methods**************************************

	public static void selectByIndexData(WebElement element, int index, String objName) {
		waitforVisibilty(element, 5, objName);
		Select selectCity = new Select(element);
		selectCity.selectByIndex(index);
		System.out.println(objName + "  selected with index  " + index);
	}

	// ****************************************************************************************************************

	public static void waitforVisibilty(WebElement webElement, WebDriver driver, int time, String objectName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(webElement));
		System.out.println(objectName + "is waiting for visibility  for explicit wait");
	}

	public static void waitforVisibilty(WebElement element, WebDriver driver, int time, int pollingtime,
			String objectName) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(time)).pollingEvery(Duration.ofSeconds(pollingtime))
				.ignoring(ElementNotInteractableException.class);

		wait.until(ExpectedConditions.visibilityOf(element));

		mylog.info(objectName + "is waiting for visibility  for fluent wait");
	}

	public static void waitUntilPresenceofElementLocatedBy(By locator, String objName) {
		System.out.println("waiting for an web element " + objName + " for its visibility");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public static void waitUntilElementToBeClickable(By locator, String objName) {
		System.out.println("waiting for an web element " + objName + " to be clickable");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public static void waitforVisibilty(WebElement webElement, int time, String objectName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public static void waitForAlertPresent(int time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public static void switchToWindowOpened(String mainWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!mainWindowHandle.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
			}
		}

		System.out.println(" switch to new Window");
	}

	public static WebElement selectFromListUsingText(List<WebElement> list, String text) {
		WebElement element = null;
		for (WebElement ele : list) {
			if (ele.getText().equalsIgnoreCase(text)) {
				System.out.println(" selected = " + ele.getText());
				element = ele;
				break;
			}
		}

		return element;
	}

	public static void switchtoWindowHandle(String windowHandle, WebDriver driver) {
		// String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

	}

//*******************************************************************************************************************************	

	public static void takescreenshot(WebDriver driver, String filePath) throws IOException {
		TakesScreenshot screencapture = (TakesScreenshot) driver;
		File src = screencapture.getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath);
		Files.copy(src, destination);
	}

	public static void takescreenshotOfElement(WebElement Element, String filePath) throws IOException {

		File src = Element.getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath);
		Files.copy(src, destination);
	}

	public void takescreenshot(WebDriver driver) {
		ExtentReportsUtility extentUtility = ExtentReportsUtility.getInstance();

		try {
			TakesScreenshot screenCapture = (TakesScreenshot) driver;
			File src = screenCapture.getScreenshotAs(OutputType.FILE);
			Date currentDate = new Date();
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);

			// Initialize ExtentReportsUtility and start the report
			if (extentUtility == null) {
				throw new NullPointerException("ExtentReportsUtility instance is null");
			}
			extentUtility.startExtentReport();

			// Construct file paths for the screenshot
			String reportFilePath = Constants.CUR_DIR + Constants.FILE_SEPARATOR + Constants.SCREENSHOT_PATH;
			String fileName = "Saleforce" + timeStamp + ".png";
			String filepath = reportFilePath + Constants.FILE_SEPARATOR + fileName;
			
	        // Create the screenshot folder if it doesn't exist
	        File folder = new File(reportFilePath);
	        if (!folder.exists()) {
	            folder.mkdirs(); // Recursively create directories
	        }


			File destination = new File(filepath);
			Files.copy(src, destination);
			mylog.info("Captured the screen");
			extentUtility.logTestInfo("Captured the screen"); // Log success to the extent report
			extentUtility.logTestWithscreenshot(filepath); // Log the screenshot to the extent report

		} catch (Exception e) {
			e.printStackTrace();
			mylog.error("Failed to capture the screen");
			// Log failure with exception to the extent report if possible
			if (extentUtility != null) {
				extentUtility.logTestFailedWithException(e);
			} else {
				System.err.println("ExtentReportsUtility instance is null. Cannot log exception to extent report.");
			}

		} finally {
			// End the extent report
			if (extentUtility != null) {
				extentUtility.endReport();
			} else {
				System.err.println("ExtentReportsUtility instance is null. Cannot end extent report.");
			}
		}
	}
}

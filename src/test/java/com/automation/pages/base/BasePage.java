package com.automation.pages.base;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.automation.tests.utility.ExtentReportsUtility;
import com.test.automation.tests.utility.Log4JUtility;



public class BasePage
{
	protected static WebDriver driver;
	static WebDriverWait wait;
	protected Log4JUtility logObject=Log4JUtility.getInstance();
	protected static Logger myLog;
	protected ExtentReportsUtility report=ExtentReportsUtility.getInstance();
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
        report = ExtentReportsUtility.getInstance(); // Instantiate report object

	}
	
	public static String getPageTitle() {
		System.out.println("page tittle is returned");
		return driver.getTitle();
	}

	public void refreshPage() {
		driver.navigate().refresh();
		myLog.info("page is refreshed");

	}

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		System.out.println("extracted the text from" + objectName);
		return data;
	}

	public static void moveandClickAction(WebElement element, String objName) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
		System.out.println("cursor moved to web element " + objName);
	}


	public void enterText(WebElement ele, String data, String objectName) {
		waitforVisibilty(ele,30,objectName);
		if (ele.isDisplayed()) {
			clearElement(ele, objectName);
			ele.sendKeys(data);
			System.out.println("Pass:"+objectName+" is entered to the username filed");
		} else {
			System.out.println(objectName + " element is not displayed");
		}
	}

	public void clearElement(WebElement ele, String ObjectName) {
		waitforVisibilty(ele,30,ObjectName);
		if (ele.isDisplayed()) {
			ele.clear();
			System.out.println(ObjectName + " is cleared");
		} else {
			System.out.println(ObjectName + " element is not displayed");
		}
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			System.out.println(objectName + "button is clicked");
			
		} else {
			System.out.println("button element is not enabled");
			
		}
	}
	
	public  void selectCheckBox(WebElement element) 
	{
		if(!(element.isSelected()))	
			clickElement(element,"checkbox");

	}


	public static void waitforVisibilty(WebElement webElement, int time, String objectName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public static void checkBoxElement(WebElement element, String objName) {
		boolean isSelected = element.isSelected();

		if (isSelected == false) {
			element.click();
		}

	}
	public static boolean isCheckBoxSelected(WebElement element) {
		boolean isSelected = element.isSelected();

		if(isSelected)
		{
			isSelected=true;
		}
		return isSelected;
		
	}
	public static void waitExplicit(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}	
	
	public static void waitforVisibilty(WebElement webElement, WebDriver driver, int time, String objectName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(webElement));
		System.out.println(objectName + "is waiting for visibility  for explicit wait");
	}
	public static boolean isPresent(WebElement element)
	{
		if (element.isDisplayed())
			return true;
		else
			return false;

	}

	public  void validateDropDownwithSelectClass(WebElement element, Object[] expected, String objectName) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			Assert.assertEquals(options.get(i).getText(), expected[i]);
		}

	}
	
	public static void selectValueByData(WebElement element, String text, String objName) {
		waitforVisibilty(element, 5, objName);
		Select selectCity = new Select(element);
		selectCity.selectByValue(text);
		System.out.println(objName + "  selected ");
	}

	public  void waitForElement(Duration time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}   
	 public static void Radiobutton(WebElement obj, String objName) {
			
			if(obj.isDisplayed() ){
				obj.click();
				System.out.println("Pass: "+objName+" is clicked");
			}else {
				System.out.println("Fail:"+objName+" is not displayed .Please check your application");			
			}
		}
	  public static void switchtoAlert(WebDriver driver) {
			 driver.switchTo().alert().accept();
			 System.out.println("Pass: alert is present and accept");
		}
	  public static void selectTextByData(WebElement element, String text, String objName) {
			waitforVisibilty(element, 5, objName);
			Select selectCity = new Select(element);
			selectCity.selectByVisibleText(text);
			System.out.println(objName + "  selected  " + text);

		}
	  public static void selectByVisibleText(WebElement element, String data, String objName) {
			waitforVisibilty(element, 5, objName);
			Select selectElement = new Select(element);
			List<WebElement> op = selectElement.getOptions();
			int size = op.size();
			for (int i = 0; i < size; i++) {
				String options = op.get(i).getText();
				System.out.println(options);
				if (options.equals(data)) {
					selectElement.selectByVisibleText(data);

				}
			}
		}


}
package com.test.automation.tests.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.automation.tests.base.BaseTest;


public class TestEventListenersUtility extends BaseTest implements ITestListener{
	private static ExtentReportsUtility extentUtilityObject;

	@Override
	public void onTestStart(ITestResult result) { // before every @Test method called this method is executed
        extentUtilityObject.startSingleTestReport(result.getMethod().getMethodName());
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentUtilityObject.logTestpassed(result.getMethod().getMethodName()+" is passed");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentUtilityObject.logTestFailed(result.getMethod().getMethodName()+" is failed");
		Date currentDate = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
		
		String reportFilePath = Constants.CUR_DIR+Constants.FILE_SEPARATOR+Constants.SCREENSHOT_PATH;
		String fileName = "Saleforce"+timeStamp+".png";
	    String filepath = reportFilePath+Constants.FILE_SEPARATOR+fileName;
		takescreenshot(driver);
		extentUtilityObject.logTestWithscreenshot("./screenshots/"+fileName+".png");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		extentUtilityObject=ExtentReportsUtility.getInstance();
		System.out.println("report utility object created="+extentUtilityObject.toString());
		extentUtilityObject.startExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentUtilityObject.endReport();
	}
	
}
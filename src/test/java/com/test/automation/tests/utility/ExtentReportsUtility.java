package com.test.automation.tests.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.MediaEntityBuilder;


public class ExtentReportsUtility {
	public static ExtentReports report ;
	public static ExtentSparkReporter spark;
	public static ExtentTest testLogger;
	private static ExtentReportsUtility extentObject;
	
	private ExtentReportsUtility() {
	}
	
	public static ExtentReportsUtility getInstance() {
		if(extentObject==null) {
			extentObject=new ExtentReportsUtility();
		}

		return extentObject;
	}
	
	public void startExtentReport() {
		report= new ExtentReports();
		spark = new ExtentSparkReporter(Constants.SPARKS_HTML_REPORT_PATH);
		report.setSystemInfo("Host Name", "Salesforce");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Indu");
		
		spark.config().setDocumentTitle("Test Execution Report");
		spark.config().setReportName("firebase regression tests");
		spark.config().setTheme(Theme.DARK);
		report.attachReporter(spark);	
	}
	
	public void startSingleTestReport(String methodName) {
		testLogger=report.createTest(methodName);
	}
	public void endReport() {
		report.flush();
	}
	
	public void logTestInfo(String text) {
	    if (testLogger != null) {
	        testLogger.log(Status.INFO, text);
	    } else {
	        System.err.println("Extent test logger is null. Please start a test report before logging information.");
	    }
	}
	
	public void logTestpassed(String text) {
		testLogger.log(Status.PASS,MarkupHelper.createLabel(text, ExtentColor.GREEN));
	}
	
	public void logTestFailed(String text) {
		testLogger.log(Status.FAIL,MarkupHelper.createLabel(text, ExtentColor.RED));
	}
	
	public void logTestFailedWithException(Throwable e) {
	    if (testLogger != null) {
	        testLogger.log(Status.FAIL, e);
	    } else {
	        System.err.println("Extent test logger is null. Failed to log exception.");
	    }	
		}
	
	public void logTestWithscreenshot(String path) {
		//testLogger.addScreenCaptureFromBase64String(path);
		testLogger.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
	}
	
	
	

}

package com.Flifcart.Generic;

import java.io.IOException;
import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class IListenersImplementationClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestSkipped(ITestResult result) {

		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("on start");
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./Extent_Reports/Report.html");
		spark.config().setDocumentTitle("SafeZoo Test Reports");
		spark.config().setReportName("Report Name");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("operating system", "Windows 11");
		report.setSystemInfo("Browser", "Browser Name");
		report.setSystemInfo("Reporter Name", "Girish G");
		
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		 test = report.createTest(result.getMethod().getMethodName());
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{

		String testName = result.getMethod().getMethodName();
		Date d = new Date();
		String d1 = d.toString();
		String d2 = d1.replaceAll(":", ".");
		EventFiringWebDriver eDriver = new EventFiringWebDriver(WebDriverUtility.sDriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShot/"+testName+""+d2+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {

		}
		test.addScreenCaptureFromPath("dst");


	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		System.out.println("stop");
		
	}


}

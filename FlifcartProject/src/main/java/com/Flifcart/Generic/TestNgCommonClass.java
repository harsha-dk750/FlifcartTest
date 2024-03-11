package com.Flifcart.Generic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestNgCommonClass {
	
	protected WebDriver driver;
	protected WebDriverUtility webDrive;
	protected PropertyFileData pro;
	protected JavaUtility javaUtil;
	/**
	 * This method is used to launch the application
	 * @param browser
	 * @param timeout
	 * @param url
	 */
	@BeforeClass
	public void launchApplication()
	{
		webDrive = new WebDriverUtility(); 
		pro= new PropertyFileData();
		javaUtil = new JavaUtility();
		driver=webDrive.launchApplication(pro.getDataFromPropertyFile(PropertyFileKeys.BROWSER.convertToString()),javaUtil.timeOut() ,pro.getDataFromPropertyFile(PropertyFileKeys.URL.convertToString()) );	
	}


	/**
	 * This method is uses used to close the application
	 */
	@AfterClass
	public void closeApplication()
	{
		
		
			webDrive.closeApplication();
		
	}





}

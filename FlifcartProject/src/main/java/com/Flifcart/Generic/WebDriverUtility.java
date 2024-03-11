package com.Flifcart.Generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	private WebDriver driver;
	static WebDriver sDriver;


	/**
	 * This method is used to launch the application
	 * @param browser
	 * @param timeout
	 * @param url
	 * @return
	 */
	public WebDriver launchApplication(String browser, long timeout,String url)
	{
		if (browser.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browser.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if (browser.equals("ie")) 
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		sDriver=driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);

		return driver;
	}


	/**
	 * This method is used to close the application
	 */
	public void closeApplication()
	{
		//driver.quit();

	}

	/**
	 * this method is used to get the address of the driver
	 * @return
	 */
	public WebDriver getdriverAddress()
	{
		return driver;
	}
	
	
	public void ScrollAxisDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	public void JsScrollUpToElement(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void ClickUsingJavaScript(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", element);
	}
	

	/**
	 * This method is used to accept the alert popup
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();

	}


	/**
	 * This method is used to switch the control to alert popup
	 * @param driver
	 */
	public void switchToAlert(WebDriver driver)
	{
		driver.switchTo().alert();
	}


	/**
	 * This method is used to get the text from ALert Popup
	 * @param driver
	 * @return 
	 */
	public String getTextFromAlertPopup(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}




	/**
	 * This method is used to dismiss the alert popup
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();;

	}

	/**
	 * This method is used to Switch to Frame Window based on index
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}


	/**
	 * This method is used to Switch to Frame Window based on NameOrId
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,String NameOrId)
	{
		driver.switchTo().frame(NameOrId);
	}


	/**
	 * This method is used to Switch to Frame Window based on NameOrId
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,WebElement ElementAddress)
	{
		driver.switchTo().frame(ElementAddress);

	}
 

	/**
	 * This method is used to Switch to Parent Frame
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}


	/**
	 * This method is used to Switch to Default Content
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public void Explicitwait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement clickableElement = wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void ClickableExplicitwait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement clickable = wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	

}







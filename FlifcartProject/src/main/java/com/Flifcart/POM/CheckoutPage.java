package com.Flifcart.POM;

import java.util.Scanner;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class CheckoutPage {
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	private WebElement continuebutton;
	
	@FindBy(xpath="//input[@class='_2IX_2- _17N0em']")
	private WebElement emailtextfield;
	
	@FindBy(xpath="//div[@class='_2YsvKq o8qAfl']")
	private WebElement emailcontinuebutton;
	
	@FindBy(xpath="//input[@class='_2IX_2- _17N0em']")
	private WebElement mobilenotextfield;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _20xBvF _3AWRsL']/div/following-sibling::span[text()='CONTINUE']")
	private WebElement mobilenocontinuebutton;
	
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh _17N0em']")
	private WebElement enterotp;
	
	
	
	
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	
	public void ClickOnccontinuebutton(String email,WebDriver driver,String mobileno) {
		continuebutton.click();
		emailtextfield.sendKeys(email);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", emailcontinuebutton);
		
		 
	}
}

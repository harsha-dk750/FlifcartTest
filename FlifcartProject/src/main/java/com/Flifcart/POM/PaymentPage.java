package com.Flifcart.POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
	@FindBy(xpath="//div[@class='_1P2-0f']") private WebElement addnewaddres;
	@FindBy(xpath="//input[@name='name']") private WebElement entername;
	@FindBy(xpath="//input[@name='phone']") private WebElement entermobileno;
	@FindBy(xpath="///input[@name='pincode']") private WebElement enterpin;
	@FindBy(xpath="//input[@name='addressLine2']") private WebElement enterlocality;
	@FindBy(xpath="//textarea[@name='addressLine1']") private WebElement enteraddres;
	@FindBy(xpath="///input[@name='city']") private WebElement entercity;
	@FindBy(xpath="//select[@name='state']/option") private List<WebElement> enterstate;
	@FindBy(xpath="//input[@name='landmark']") private WebElement enterlandmark;
	@FindBy(xpath="//span[text()='Home (All day delivery)']") private WebElement clickonhomeadress;
	@FindBy(xpath="//button[text()='Save and Deliver Here']") private WebElement clickonDeliverhere;
	@FindBy(xpath="//button[text()='CONTINUE']") private WebElement Continuebutton;
	@FindBy(xpath="//button[text()='Accept & Continue']") private WebElement acceptandcontinue;
	@FindBy(xpath="//span[text()='Credit / Debit / ATM Card']") private WebElement creditcardpayment;
	
	public PaymentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonaddnewaddresandfilladdres(String name,String mobileno,String pincode,String locallity,String adress,String city,String satate,String landmark)
	{
		
		addnewaddres.click();
		entername.sendKeys(name);
		entermobileno.sendKeys(mobileno);
		enterpin.sendKeys(pincode);
		enterlocality.sendKeys(locallity);
		enteraddres.sendKeys(adress);
		entercity.sendKeys(city);
		List<WebElement> states = enterstate;
		for(WebElement allstates:states)
		{
			if(allstates.getText().equalsIgnoreCase(satate))
			{
				allstates.click();
			}
		}
		enterlandmark.sendKeys(landmark);
		clickonhomeadress.click();
		clickonDeliverhere.click();
		}
	public void ClickonContinue()
	{
		Continuebutton.click();
		acceptandcontinue.click();
	}
	public void Clickoncreditcardpayemnt()
	{
		creditcardpayment.click();
	}
	
	

}



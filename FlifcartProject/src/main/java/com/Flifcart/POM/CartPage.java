package com.Flifcart.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class CartPage {
	
	@FindBy(id="pincodeInputId")
	private WebElement pincodeTextField;
	
	@FindBy(xpath="//span[@class='_2P_LDn']")
	private WebElement checkbutoninstunt;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCart;

	
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
	
	public  WebElement getpincodeTextField() {
		 
		return pincodeTextField;
	}
	
	public  void Enterpincode(String pincode) 
	{
		 pincodeTextField.sendKeys(pincode);
		 
	}
	public  WebElement getCheckButtonInstaunt() {
		return checkbutoninstunt;
		 
	}
	public  void AddToCart() {
		
		addToCart.click();
		 
	}
	

}

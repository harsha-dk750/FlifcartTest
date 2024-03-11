package com.Flifcart.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {
	
	@FindBy(xpath="//input[@placeholder='Search for Products, Brands and More']")
	private WebElement searchproduct;
	
	@FindBy(xpath="(//div[@class='_4rR01T'])[1]")
	private WebElement firstproduct;

	

	public SearchProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Search the product in Search text bar
	 * @param driver
	 */
	public void Searchproduct(String productname)
	{
		searchproduct.sendKeys(productname);
		searchproduct.submit();
	}
	/**
	 * Click on Any First Product
	 */
	public void Firstproduct()
	{
		firstproduct.click();
	}
    

}

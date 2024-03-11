package BuyProductTestCase;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Flifcart.Generic.TestNgCommonClass;
import com.Flifcart.POM.*;
import com.mailosaur.models.Message;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Flifcart.Generic.*;

import java.io.IOException;
import java.util.ArrayList;
import com.mailosaur.models.*;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;

@Listeners(com.Flifcart.Generic.IListenersImplementationClass.class)

public class BuyProduct extends TestNgCommonClass{
	@Test
	public  void Test() throws InterruptedException, IOException, MailosaurException {
		//Object of Search product page
		SearchProductPage spro=new SearchProductPage(driver);
		
		//Search the product and Click on First Product
		spro.Searchproduct("laptop");
		spro.Firstproduct();
		
		//get the address of Parent window
		String parent = driver.getWindowHandle();
		
		//switch to window Child Window
		Set<String> twowindow = driver.getWindowHandles();
		for(String productwindow:twowindow)
		{
			if(!parent.equals(productwindow))
			{
				driver.switchTo().window(productwindow);
			}
		}
		
		//Object of CartPage
		CartPage cpage=new CartPage(driver);
		WebDriverUtility wutil=new WebDriverUtility();
		
		//Scroll Till Enter PinCode Element & Enter the All Possible PincCde near to Your Area
		WebElement element = cpage.getpincodeTextField();
	
		//wutil.JsScrollUpToElement(element,driver);
		Thread.sleep(3000);
		wutil.ScrollAxisDown(driver);
		
		
	    //Enter the Pin and check
		cpage.Enterpincode("560076");
		WebElement element1 = cpage.getCheckButtonInstaunt();
		wutil.ClickUsingJavaScript(element1,driver);
		
		//Add the product to to cart if valid
		Thread.sleep(3000);
		cpage.AddToCart();
		

		CheckoutPage ckpage=new CheckoutPage(driver);
		
		//Enter the Email & PhoneNo and Proceed to get OtpNo
		ckpage.ClickOnccontinuebutton("anything@ixuh5rhk.mailosaur.net",driver,"9481139352");
		
		//Mailosaur api keys
		String apiKey="1uqQILfQdZ9QeXRWRF6tdEe3nO12G6ca";
		String serverId="ixuh5rhk";
		String serverDomain="ixuh5rhk.mailosaur.net";
		
		MailosaurClient mailosaur = new MailosaurClient(apiKey);

	    MessageSearchParams params = new MessageSearchParams();
	    params.withServer(serverId);

	    SearchCriteria criteria = new SearchCriteria();
	    criteria.withSentTo("anything@"+serverDomain);

	    //Get the Mail Body
	    Message message = mailosaur.messages().get(params, criteria);
	    System.out.println(message.subject());
	    
	    //get the otp from email body
	    String subject=message.subject();
	    String Otp="";
		for(int i=0;i<subject.length();i++)
		{
		if(subject.charAt(i)>='0' && subject.charAt(i)<='9' )
		{
			Otp=Otp+subject.charAt(i);
		}
		}

		System.out.print(Otp);
		
		//Enter the otp  but im getting somthing error message and not able to proceed for payment
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh _17N0em']")).sendKeys(Otp);
	
}
}

	    
	
		
		 
		 
/**
	 for(int i=581310;i<581320;i++)
	 {
		 
		 ele.sendKeys(Integer.toString(i));
		 js.executeScript("arguments[0].click();", elee);
		 if(errorcode.getText().contains("Currently out of stock in this area")||errorcode.getText().contains("Not a valid pincode"))
		 {
			 System.out.println("'"");
			 ele.clear();
			 continue;
			// break;
		 }
		 else
		 {
			 driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		 }
	 }
	 */
		
	

		



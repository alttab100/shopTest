package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Config.CustomWait;

public class Continue_Shop {
	WebDriver driver = null;
	
	By Continue       = By.cssSelector("#checkout_page_container > div.slide1 > a > span");
	
	public Continue_Shop(WebDriver driver) {
		this.driver = driver;
	}
	    public void click_cont()
	{
		driver.findElement(Continue).click();
		//String text= driver.findElement(By.cssSelector("#wpsc_shopping_cart_container > form > div.secured-wrap > p")).getText();
		//	if (text.equals("SECURED CHECKOUT"))
		//{
		//	System.out.println("Secured checkout is displayed");
		//}
		//	else
		//	{
		//		System.out.println("Test failed");
		//	}
	}
}

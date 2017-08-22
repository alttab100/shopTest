package PageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Config.CustomWait;

public class searchProduct {
	WebDriver driver = null;
	By product       = By.name("s");
	//Apple iphone 5
	By item_price    = By.cssSelector("#grid_view_products_page_container > div > div.product_grid_item.product_view_32 > div.grid_product_info > div > p > span");
	By add_cart      = By.cssSelector("#grid_view_products_page_container > div > div.product_grid_item.product_view_32 > div.grid_more_info > form > div > div.input-button-buy > span > input");
	By continue_shop = By.cssSelector("#fancy_notification_content > a.continue_shopping");
	
	//Magic mouse
	By item_price2    = By.cssSelector("#grid_view_products_page_container > div > div > div.grid_product_info > div > p:nth-child(2) > span");
	By add_cart2      = By.cssSelector("#grid_view_products_page_container > div > div > div.grid_more_info > form > div > div.input-button-buy > span > input");
	By continue_shop2 = By.cssSelector("#fancy_notification_content > a.continue_shopping");
	
	//ipad
	By item_price3    = By.cssSelector("#grid_view_products_page_container > div > div > div.grid_product_info > div > p:nth-child(2) > span");
	By add_cart3      = By.cssSelector("#grid_view_products_page_container > div > div.product_grid_item.product_view_95 > div.grid_more_info > form > div > div.input-button-buy > span > input");
	By checkout       = By.cssSelector("#fancy_notification_content > a.go_to_checkout");
	
	By Continue       = By.cssSelector("#checkout_page_container > div.slide1 > a > span");
	
	public searchProduct(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectproduct(String value) {
		new CustomWait(driver).explicitWait(15,product);
		driver.findElement(product).sendKeys(value);
		driver.findElement(product).sendKeys(Keys.ENTER);
	    switch(value)
	    {
	    	case "iphone 5":
	    			String price = driver.findElement(item_price).getText();
	    			System.out.println("The price of the product "+ value + " is :"+ price);
	    			driver.findElement(add_cart).click();
	    			//new CustomWait(driver).explicitWait(50,add_cart);
	    			driver.findElement(continue_shop).click();
	    			break;
	    	case "Magic Mouse":
	    			String price2 = driver.findElement(item_price2).getText();
	    			System.out.println("The price of the product "+ value + " is :"+ price2);
	    			driver.findElement(add_cart2).click();
	    			//new CustomWait(driver).explicitWait(50,add_cart2);
	    			driver.findElement(continue_shop2).click();
	    		 	break;
	    	case "iPad":
	    			String price3 = driver.findElement(item_price3).getText();
	    			System.out.println("The price of the product "+ value + " is :"+ price3);
	    			driver.findElement(add_cart3).click();
	    			new CustomWait(driver).explicitWait(50,add_cart3);
	    			driver.findElement(checkout).click();
	    	
	    			break;
	    }
	    
	    	
	}
	public void click_cont()
	{
		driver.findElement(Continue).click();
	}
}

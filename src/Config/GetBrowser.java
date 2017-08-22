package Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GetBrowser {
	WebDriver driver=null;
	
	public WebDriver startBrowser(String browserName){
		String driverPath = System.getProperty("user.dir");
		
		if(browserName.equalsIgnoreCase("IE")){
			
			System.setProperty("webdriver.ie.driver", driverPath+"\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			
		}else if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", driverPath+"\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("Firefox")){
			driver= new FirefoxDriver();
		}
		return driver;
	}
	
}


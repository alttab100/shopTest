package Runner;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Config.Excel;
import Config.GetBrowser;
import Config.SnapShot;
import PageModel.Continue_Shop;
//import PageModel.Result;
//import PageModel.SearchPage;
//import PageModel.SearchResult;
//import config.*;
import PageModel.searchProduct;

public class TestSuite {
	final static Logger logger=Logger.getLogger(TestSuite.class);
	
	WebDriver driver=null;
	String[][] testdata=null;
	String testdataID=null;
	
	
	@BeforeTest
	public void tearUp(){
		DOMConfigurator.configure("log4j.xml");
		logger.info("**********Tear Up Activity Initiated**********");
		// Read Excel for Test data
		testdata = new Excel().readExcel();

		// Use for loop or data provider for each test data
		testdataID = testdata[1][0];
		logger.info("Test Data ID : " + testdataID);
		System.out.println(testdataID);

		// Initiate Driver
		String browserName = new Excel(testdata).getColValue("Browser_Name", testdataID);
		logger.info("Browser : " + browserName);
		driver = new GetBrowser().startBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("Tear Up Activity Completed");
	}
	
	@Test
	public void runSuite(){
		logger.info("");
		logger.info("**********Test Run Initiated**********");
		String siteURL = new Excel(testdata).getColValue("Site_URL", testdataID);
		driver.get(siteURL);
		//Maximize the window
		driver.manage().window().maximize();
		new SnapShot(driver).ScreenPrint();
		logger.info("Screenshot Captured");

		// Apple iphone
		logger.info("Working on Apple Iphone");
		String product_name = new Excel(testdata).getColValue("Product", testdataID);
		new searchProduct(driver).selectproduct(product_name) ;
		new SnapShot(driver).ScreenPrint();
		logger.info("Screenshot Captured");
		
		//Magic mouse
		logger.info("Working on Magic Mouse");
		String product_name2 = new Excel(testdata).getColValue("Product2", testdataID);
		new searchProduct(driver).selectproduct(product_name2) ;
		logger.info("Item Checked out");
		new SnapShot(driver).ScreenPrint();
		logger.info("Screenshot Captured");
		
		//ipad
		logger.info("Working on iPad");
		String product_name3 = new Excel(testdata).getColValue("Product3", testdataID);
		new searchProduct(driver).selectproduct(product_name3) ;
		logger.info("Item Checked out");
		
		new SnapShot(driver).ScreenPrint();
		logger.info("Screenshot Captured");
		
		//Method to continue to final page
		logger.info("Products updated and about to continue");
		new Continue_Shop(driver).click_cont() ;
		
		new SnapShot(driver).ScreenPrint();
		logger.info("Screenshot Captured");
		logger.info("Test Run Completed");		
	}
	
	@AfterTest
	public void tearDown(){
		logger.info("");
		logger.info("**********Tear Down Activity Initiated**********");
	    driver.quit();
		logger.info("Driver Closed");
		logger.info("Tear Down Activity Completed");
	}
}




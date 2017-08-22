package Config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SnapShot {
	WebDriver driver = null;

	public SnapShot(WebDriver driver) {
		this.driver = driver;
	}

	public void ScreenPrint() {
		String driverPath = System.getProperty("user.dir");
		String fileLocation = driverPath + "\\Screenshot";
		String fileAppend = "\\459361_";
		long timpStamp = System.currentTimeMillis();

		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(fileLocation + fileAppend + timpStamp+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}



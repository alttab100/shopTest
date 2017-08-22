package Config;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {
	WebDriver driver = null;

	public CustomWait(WebDriver driver) {
		this.driver = driver;
	}

	public void staticWait(int waitSec) {
		long loadTime = waitSec * 1000;
		try {
			Thread.sleep(loadTime);
		} catch (Exception e) {
		}
	}

	public void explicitWait(int waitSec, By element) {
		WebDriverWait wait = new WebDriverWait(driver, waitSec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void pageloadWait() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver wdriver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			});
		} catch (Exception e) {
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

}


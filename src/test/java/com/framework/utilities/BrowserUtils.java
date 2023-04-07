package com.framework.utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {
	private ReadConfig config = new ReadConfig();
	private WebDriver driver;
	public int timeout = Integer.parseInt(config.getTimeout());

	public BrowserUtils() {
		driver = DriverFactory.getInstance();
	}

	public void scrollToElement(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(timeout));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void switchToPreviousTab() {
	    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	    int currentTab = tabs.indexOf(driver.getWindowHandle());
	    int previousTab = currentTab - 1;
	    driver.close();
	    driver.switchTo().window(tabs.get(previousTab));
	}

	public void getCurrentTab() {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		new WebDriverWait(driver, Duration.ofSeconds(timeout));

	}

	public Alert getAlert() throws InterruptedException {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeout));
			Alert al = driver.switchTo().alert();
			return al;
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
			return null;
		}
	}

}
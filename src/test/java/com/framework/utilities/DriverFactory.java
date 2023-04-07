package com.framework.utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	private static WebDriver driver;

	public static WebDriver getInstance() {
		if (driver == null) {
			driver = BrowserFactory.getDriver();
		}
		return driver;
	}
}
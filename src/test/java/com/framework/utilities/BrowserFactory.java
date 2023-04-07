package com.framework.utilities;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	private static ChromeOptions options1 = new ChromeOptions();;
	private static ReadConfig config = new ReadConfig();
	private static String browserName = config.getBrowser();
	private static Logger logger;

	public static WebDriver getDriver() {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(options1.addArguments("--remote-allow-origins=*"));
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();

		default:
			logger.info("Invalid Browser Name");
			return null;
		}
	}
}
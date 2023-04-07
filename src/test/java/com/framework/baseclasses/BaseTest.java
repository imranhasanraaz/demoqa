package com.framework.baseclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import com.framework.utilities.DriverFactory;
import com.framework.utilities.ReadConfig;

public class BaseTest {

	public static Logger logger;
	protected static WebDriver driver;
	public static ReadConfig readConfig = new ReadConfig();

	@BeforeMethod
	public void SetUp() {
		driver = DriverFactory.getInstance();
		driver.manage().window().maximize();
		driver.get(readConfig.getBaseUrl());
		logger = LogManager.getLogger("Demoqa");
		logger.info("url opened");
	}

	@AfterTest
	public void Teardown() {
		driver.quit();
		logger = LogManager.getLogger("Demoqa");
		logger.info("Browser Closed");
	}

}
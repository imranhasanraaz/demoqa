package com.framework.baseclasses;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.utilities.BrowserUtils;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.ReadConfig;

public abstract class BaseElement {

	protected By locator;
	protected String name;
	private static ReadConfig config = new ReadConfig();
	public static int timeout = Integer.parseInt(config.getTimeout());
	BrowserUtils bu = new BrowserUtils();

	public BaseElement(By locator, String name) {
		this.locator = locator;
		this.name = name;
	}

	protected WebElement find() {
		WebElement element = DriverFactory.getInstance().findElement(locator);
		bu.scrollToElement(element);
		return element;

	}

	public boolean isDisplayed() {
		new WebDriverWait(DriverFactory.getInstance(), Duration.ofSeconds(timeout))
		.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return find().isDisplayed();
	}

	public void click() {
		new WebDriverWait(DriverFactory.getInstance(), Duration.ofSeconds(timeout))
				.until(ExpectedConditions.elementToBeClickable(locator));
		find().click();
	}

}
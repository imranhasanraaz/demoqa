package com.framework.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FrameSwitcher {

	public static void switchToFrame(By frameLocator) {
		WebElement frameElement = DriverFactory.getInstance().findElement(frameLocator);
		DriverFactory.getInstance().switchTo().frame(frameElement);
	}

	public static void switchToDefaultContent() {
		DriverFactory.getInstance().switchTo().defaultContent();
	}

}
package com.framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.framework.baseclasses.BaseElement;
import com.framework.utilities.DriverFactory;

public class TextElement extends BaseElement {

	public TextElement(By locator, String name) {
		super(locator, name);
	}

	public String getText() {
		return find().getText();
	}

	public WebElement getWebElement() {
		return DriverFactory.getInstance().findElement(locator);
	}

}
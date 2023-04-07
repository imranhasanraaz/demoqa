package com.framework.elements;

import org.openqa.selenium.By;

import com.framework.baseclasses.BaseElement;

public class InputElement extends BaseElement {

	public InputElement(By locator, String name) {
		super(locator, name);
	}

	public void sendText(String text) {
		find().sendKeys(text);
	}

	public String getText() {
		return find().getAttribute("value");
	}
}

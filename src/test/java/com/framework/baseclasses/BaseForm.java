package com.framework.baseclasses;

public abstract class BaseForm {
	private BaseElement uniqueElement;
	private String name;

	public BaseForm(BaseElement uniqueElement, String name) {
		this.uniqueElement = uniqueElement;
		this.name = name;
	}

	public boolean isDisplayed() {
		return uniqueElement.isDisplayed();
	}

}

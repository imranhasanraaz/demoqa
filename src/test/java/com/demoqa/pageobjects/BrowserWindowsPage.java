package com.demoqa.pageobjects;

import org.openqa.selenium.By;

import com.framework.baseclasses.BaseForm;
import com.framework.elements.ButtonElement;
import com.framework.elements.TextElement;

public class BrowserWindowsPage extends BaseForm {

	private ButtonElement browserWindows = new ButtonElement(
			By.xpath("//span[@class='text' and contains(text(), 'Browser Windows')]"), "browserWindows");
	private ButtonElement Elements = new ButtonElement(
			By.xpath("//div[@class='header-text' and contains(text(), 'Elements')]"),"Elements");
	private ButtonElement newTab = new ButtonElement(By.id("tabButton"),"newTab");
	private TextElement sampleHeading = new TextElement(By.xpath("//h1[contains(@id, 'sampleHeading')]"),"sampleHeading");

	public BrowserWindowsPage() {
		super(new TextElement(By.xpath("//div[@class='main-header' and contains(text(), 'Browser Windows')]"),"Header"),
				"browserWindows");
	}
	
	public void ClickBrowserWindowMenu() {
		browserWindows.click();
	}

	public void getNewTab() {
		newTab.click();
	}

	public String getSampleHeading() {
		return sampleHeading.getText();
	}

	public void getElements() {
		Elements.click();

	}

}
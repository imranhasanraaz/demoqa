package com.demoqa.pageobjects;

import org.openqa.selenium.By;

import com.framework.baseclasses.BaseForm;
import com.framework.elements.ButtonElement;
import com.framework.elements.TextElement;

public class LinksPage extends BaseForm {

	private ButtonElement Links = new ButtonElement(By.xpath("//span[@class='text' and contains(text(), 'Links')]"),
			"Links");
	private ButtonElement home = new ButtonElement(By.id("simpleLink"), "home");

	public LinksPage() {
		super(new TextElement(By.xpath("//div[@class='main-header' and contains(text(), 'Links')]"), "Links Header"),
				"Links");
	}

	public void getLinks() {
		Links.click();
	}

	public void getHome() {
		home.click();
	}

}
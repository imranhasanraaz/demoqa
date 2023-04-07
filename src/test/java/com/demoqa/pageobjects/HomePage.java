package com.demoqa.pageobjects;

import org.openqa.selenium.By;
import com.framework.baseclasses.BaseForm;
import com.framework.elements.ButtonElement;

public class HomePage extends BaseForm {
	public HomePage() {
		super(new ButtonElement(By.xpath("//img[@class='banner-image']"), "Banner"), "Homepage");
	}

	private ButtonElement alertAndWindows = new ButtonElement(
			By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]"), "Alerts, Frame & Windows");

	public void ClickAleartbutton() {
		alertAndWindows.click();
	}

}
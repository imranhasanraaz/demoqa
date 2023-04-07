package com.demoqa.pageobjects;

import org.openqa.selenium.By;

import com.framework.baseclasses.BaseForm;
import com.framework.elements.ButtonElement;
import com.framework.elements.TextElement;

public class AlertsPage extends BaseForm {

	public AlertsPage() {
		super(new TextElement(By.xpath("//div[@class='main-header' and contains(text(), 'Alerts')]"), "Alerts"),
				"AlertsPage");
	}

	private ButtonElement alerts = new ButtonElement(By.xpath("//span[@class='text' and contains(text(), 'Alerts')]"),
			"AlertMenu");
	private ButtonElement clickMeSeeAlert = new ButtonElement(By.id("alertButton"), "clickMeSeeAlert");
	private ButtonElement clickMeConfrimButton = new ButtonElement(By.id("confirmButton"), "clickMeConfrimButton");
	private ButtonElement clickMePromButton = new ButtonElement(By.id("promtButton"), "clickMePromButton");
	private TextElement confrimButtonResult = new TextElement(By.id("confirmResult"), "confrimButtonResult");
	private TextElement promptResult = new TextElement(By.id("promptResult"), "promptResult");

	public void clickAlertfromMenu() {
		alerts.click();
	}

	public void ClickOnAlertButton() {
		clickMeSeeAlert.click();
	}

	public void ClickMeConfrimButton() {
		clickMeConfrimButton.click();
	}

	public String getCnfrimButtonResult() {
		return confrimButtonResult.getText();
	}

	public void ClickMePromButton() {
		clickMePromButton.click();
	}

	public String getPromtResult() {
		String result = promptResult.getText();
		int secondSpaceIndex = result.indexOf(" ", result.indexOf(" ") + 1);
		return result.substring(secondSpaceIndex + 1);
	}

}

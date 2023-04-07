package com.demoqa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.pageobjects.AlertsPage;
import com.demoqa.pageobjects.HomePage;
import com.framework.baseclasses.BaseTest;
import com.framework.utilities.BrowserUtils;
import com.framework.utilities.JsonDataReader;
import com.framework.utilities.RandomText;

public class TC_Alerts extends BaseTest {
	private BrowserUtils browserUtils = new BrowserUtils();
	private HomePage homePage = new HomePage();
	private AlertsPage alertspage = new AlertsPage();
	private JsonDataReader testData = new JsonDataReader();
	private RandomText random = new RandomText();

	@Test()
	public void clickOnAlerts() throws Exception {
		logger.info("Alert Testing Strat");

		Assert.assertTrue(homePage.isDisplayed(), "Main page is not open");
		logger.info("Main page is open");
		homePage.ClickAleartbutton();
		alertspage.clickAlertfromMenu();
		Assert.assertTrue(alertspage.isDisplayed(), "Alerts form has not appeared on page");
		logger.info("Alerts form has appeared on page");

		alertspage.ClickOnAlertButton();
		browserUtils.getAlert();

		Assert.assertEquals(testData.getString("clickButton"), browserUtils.getAlert().getText(),
				"Alert with text You clicked a button is not open");
		browserUtils.getAlert().accept();
		logger.info("Alert has closed");

		alertspage.ClickMeConfrimButton();
		Assert.assertEquals(testData.getString("confrimButton"), browserUtils.getAlert().getText(),
				"Alert with text 'Do you confirm action?' is not open");
		logger.info("Alert with text Do you confirm action? has appeared");
		browserUtils.getAlert().accept();
		Assert.assertEquals(testData.getString("confrimButtonResult"), alertspage.getCnfrimButtonResult(),
				"Text 'You selected Ok' has not appeared on page");
		logger.info("Alert has closed Text You selected Ok has appeared on page");

		alertspage.ClickMePromButton();
		Assert.assertEquals(testData.getString("enterName"), browserUtils.getAlert().getText(),
				"Alert with text 'Please enter your name' is not open");
		String randomText = random.generateRandomText();
		browserUtils.getAlert().sendKeys(randomText);
		browserUtils.getAlert().accept();
		logger.info("Enter randomly generated text, clicked OK button");

		Assert.assertEquals(randomText, alertspage.getPromtResult(),
				"Appeared text is not equals to the one you've entered before");
		logger.info("Appeared text equals to the one you've entered before");

		logger.info("Alerts Tested Succesfully");
	}

}

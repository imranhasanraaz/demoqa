package com.demoqa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.pageobjects.BrowserWindowsPage;
import com.demoqa.pageobjects.HomePage;
import com.demoqa.pageobjects.LinksPage;
import com.framework.baseclasses.BaseTest;
import com.framework.utilities.BrowserUtils;
import com.framework.utilities.JsonDataReader;

public class TC_Handles extends BaseTest {
	private JsonDataReader testData = new JsonDataReader();
	private HomePage homepage = new HomePage();
	private LinksPage linkpage = new LinksPage();
	private BrowserWindowsPage browserwindows = new BrowserWindowsPage();
	private BrowserUtils browserutils = new BrowserUtils();

	@Test(enabled = true)
	public void Handles() {
		logger.info("Handles Testing Strat");
		Assert.assertTrue(homepage.isDisplayed(), "Homepage is not Open");
		logger.info("Homepage is Open");
		homepage.ClickAleartbutton();
		browserwindows.ClickBrowserWindowMenu();
		Assert.assertTrue(browserwindows.isDisplayed(), "Page with Browser Windows form is open");
		logger.info("Page with Browser Windows form is open");

		browserwindows.getNewTab();
		browserutils.getCurrentTab();
		Assert.assertEquals(testData.getString("simplePage"), browserwindows.getSampleHeading(),
				"New tab with sample page is not open");
		logger.info("New tab with sample page is open");
		browserutils.switchToPreviousTab();
		logger.info("New Tab Closed Page with Browser Windows form is open");

		browserwindows.getElements();
		linkpage.getLinks();

		Assert.assertTrue(linkpage.isDisplayed(), "Page with Links form is not open");
		logger.info("Page with Links form is open");
		linkpage.getHome();
		browserutils.getCurrentTab();
		Assert.assertTrue(homepage.isDisplayed(), "Homepage is not Open");
		logger.info("Homepage is Open");
		browserutils.switchToPreviousTab();
		Assert.assertTrue(linkpage.isDisplayed(), "Page with Links form is not open");
		logger.info("Page with Links form is open");
		logger.info("Handles Tested Successfully");

	}

}
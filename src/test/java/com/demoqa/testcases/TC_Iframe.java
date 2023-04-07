package com.demoqa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.pageobjects.FramePage;
import com.demoqa.pageobjects.HomePage;
import com.demoqa.pageobjects.NestedFramePage;
import com.framework.baseclasses.BaseTest;
import com.framework.utilities.FrameSwitcher;
import com.framework.utilities.JsonDataReader;

public class TC_Iframe extends BaseTest {
	private JsonDataReader testData = new JsonDataReader();
	private HomePage homepage = new HomePage();
	private NestedFramePage nestedFrame = new NestedFramePage();
	private FramePage frames = new FramePage();

	@Test()
	public void Frames() {
		logger.info("Frames Testing Strat");
		Assert.assertTrue(homepage.isDisplayed(), "Homepage is not Open");
		logger.info("Homepage is Open");
		homepage.ClickAleartbutton();
		nestedFrame.ClickNestedFramestMenu();

		Assert.assertTrue(nestedFrame.isDisplayed(), "Page with Nested Frames form is not open.");
		logger.info("Page with Nested Frames form is open.");
		nestedFrame.isDisplayed();
		nestedFrame.switchToParentFrame();
		logger.info("Switch to Parent Frame");
		String ActualParentFrameText = nestedFrame.getParentFrameText();
		String ExpectedParentFrameText = testData.getString("ParentFrameText");
		Assert.assertEquals(ActualParentFrameText, ExpectedParentFrameText, "Message not Found");
		logger.info("Parent Frame message found");
		nestedFrame.switchToChildFrame();
		logger.info("Switch to Child Frame");
		String ActualChildFrameText = nestedFrame.getChildFrameText();
		String ExpectedchildFrameText = testData.getString("ChildFrameText");
		Assert.assertEquals(ActualChildFrameText, ExpectedchildFrameText, "Message not Found");
		logger.info("Child IFrame message found");

		FrameSwitcher.switchToDefaultContent();
		frames.ClickFramestMenu();
		Assert.assertTrue(frames.isDisplayed(), "Frame page is not opened by an unique element");
		logger.info("Frame form is open");
		frames.switchToFirstFrame();
		logger.info("Switch to first frame");
		String firstFrameText = frames.getFirstFrameText();
		driver.switchTo().defaultContent();
		logger.info("Switch to Default Content");
		frames.switchToSecondFrame();
		logger.info("Switch to Second frame");
		String secondFrameText = frames.getSecondFrameText();
		Assert.assertEquals(firstFrameText, secondFrameText, "Upper frame has not same message in lower frame");
		logger.info("Same Frame message found");
		logger.info("Frames Tested Succesfully");

	}

}
package com.demoqa.pageobjects;

import org.openqa.selenium.By;

import com.framework.baseclasses.BaseForm;
import com.framework.elements.ButtonElement;
import com.framework.elements.TextElement;
import com.framework.utilities.FrameSwitcher;

public class NestedFramePage extends BaseForm {

	private static By parentFrame = By.xpath("//iframe[@id='frame1']");
	private TextElement parentFrameText = new TextElement(By.xpath("//body[contains(text(),'Parent frame')]"),
			"parentFrameText");
	private static By childFrame = By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']");
	private TextElement childFrameText = new TextElement(By.xpath("//p[contains(text(),'')]"), "childFrameText");
	private ButtonElement nestedFrames = new ButtonElement(
			By.xpath("//span[@class='text' and contains(text(), 'Nested Frames')]"), "nestedFrames");

	public NestedFramePage() {
		super(new TextElement(By.xpath("//div[@class='main-header' and contains(text(), 'Nested Frames')]"), "Header"),
				"Nested Frames");

	}

	public void ClickNestedFramestMenu() {
		nestedFrames.click();
	}

	public static void switchToParentFrame() {
		FrameSwitcher.switchToFrame(parentFrame);
	}

	public static void switchToChildFrame() {
		FrameSwitcher.switchToFrame(childFrame);
	}

	public String getParentFrameText() {
		return parentFrameText.getText();
	}

	public String getChildFrameText() {
		return childFrameText.getText();
	}

}
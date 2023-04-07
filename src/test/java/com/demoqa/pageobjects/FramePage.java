package com.demoqa.pageobjects;

import org.openqa.selenium.By;

import com.framework.baseclasses.BaseForm;
import com.framework.elements.ButtonElement;
import com.framework.elements.TextElement;
import com.framework.utilities.FrameSwitcher;

public class FramePage extends BaseForm {

	private ButtonElement frames = new ButtonElement(By.xpath("//span[@class='text'][text()='Frames']"), "frames");
	private static By firstFrame = By.xpath("//iframe[@id='frame1']");
	private static By secondFrame = By.xpath("//iframe[@id='frame2']");
	private TextElement firstFrameText = new TextElement(By.xpath("//h1[@id='sampleHeading']"), "firstFrameText");
	private TextElement secondFrameText = new TextElement(By.xpath("//h1[@id='sampleHeading']"), "secondFrameText");

	public FramePage() {
		super(new TextElement(By.xpath("//div[@class='main-header' and contains(text(), 'Frames')]"), "Header"),
				"Frames");

	}

	public void ClickFramestMenu() {
		frames.click();
	}

	public static void switchToFirstFrame() {
		FrameSwitcher.switchToFrame(firstFrame);
	}

	public String getFirstFrameText() {
		return firstFrameText.getText();
	}

	public static void switchToSecondFrame() {
		FrameSwitcher.switchToFrame(secondFrame);
	}

	public String getSecondFrameText() {
		return secondFrameText.getText();
	}

}
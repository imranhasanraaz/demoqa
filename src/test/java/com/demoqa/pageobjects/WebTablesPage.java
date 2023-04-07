package com.demoqa.pageobjects;

import org.openqa.selenium.By;
import com.framework.baseclasses.BaseForm;
import com.framework.elements.ButtonElement;
import com.framework.elements.InputElement;
import com.framework.elements.TextElement;

public class WebTablesPage extends BaseForm {
	private ButtonElement webTables = new ButtonElement(
			By.xpath("//span[@class='text' and contains(text(), 'Web Tables')]"), "webTables");
	private ButtonElement addRecordButton = new ButtonElement(By.id("addNewRecordButton"), "addRecordButton");
	private ButtonElement submit = new ButtonElement(By.id("submit"), "submit");
	private InputElement firstName = new InputElement(By.id("firstName"), "firstName");
	private InputElement lastName = new InputElement(By.id("lastName"), "lastName");
	private InputElement userEmail = new InputElement(By.id("userEmail"), "userEmail");
	private InputElement age = new InputElement(By.id("age"), "age");
	private InputElement salary = new InputElement(By.id("salary"), "salary");
	private InputElement department = new InputElement(By.id("department"), "department");
	private ButtonElement deleteButton = new ButtonElement(By.id("delete-record-4"), "deleteButton");
	private ButtonElement elements = new ButtonElement(By.xpath("//h5[contains(text(),'Elements')]"), "elements");

	public void getElements() {
		elements.click();
	}

	public WebTablesPage() {
		super(new TextElement(By.xpath("//div[@class='main-header' and contains(text(), 'Web Tables')]"), "Header"),
				"Web Tables");
	}

	public void setWebTables() {
		webTables.click();
	}

	public void setAddRecordButton() {
		addRecordButton.click();
	}

	public void setFirstName(String Name) {
		firstName.sendText(Name);
	}

	public void setLastName(String Name) {
		lastName.sendText(Name);
	}

	public void setUserEmail(String email) {
		userEmail.sendText(email);
	}

	public void setAge(String Age) {
		age.sendText(Age);
	}

	public void setSalary(String Sal) {
		salary.sendText(Sal);
	}

	public void setDepartment(String dept) {
		department.sendText(dept);
	}

	public void clickSubmitButton() {
		submit.click();
	}

	public boolean isDeleteButtonPresent() {
		return deleteButton.isDisplayed();
	}

	public void clickDeleteButton() {
		deleteButton.click();
	}
}
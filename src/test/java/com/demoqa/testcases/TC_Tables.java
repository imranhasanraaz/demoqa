package com.demoqa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.pageobjects.HomePage;
import com.demoqa.pageobjects.WebTablesPage;
import com.framework.baseclasses.BaseTest;
import com.framework.utilities.ReadXl;

public class TC_Tables extends BaseTest {
	private WebTablesPage webTablesPage = new WebTablesPage();
	private HomePage homepage = new HomePage();

	@Test(dataProvider = "RagistrationData", dataProviderClass = ReadXl.class)
	public void Tables(String UserNo, String firstName, String lastName, String email, String age, String salary,
			String dept) {
		Assert.assertTrue(homepage.isDisplayed(), "Homepage is not Open");
		logger.info("Homepage is Open");
		webTablesPage.getElements();
		logger.info("Clicked on Elements button");
		webTablesPage.setWebTables();
		logger.info("Page with Web Tables form is open");
		webTablesPage.setAddRecordButton();
		logger.info("Registration Form has appeared on page");
		webTablesPage.setFirstName(firstName);
		webTablesPage.setLastName(lastName);
		webTablesPage.setUserEmail(email);
		webTablesPage.setAge(age);
		webTablesPage.setSalary(salary);
		webTablesPage.setDepartment(dept);
		webTablesPage.setSubmitButton();
		
		Assert.assertTrue(webTablesPage.isDeleteButtonPresent(), "User Not Added");
		logger.info("Data of User has appeared in the table");
		webTablesPage.setDeleteButton();
		logger.info("Delete successful");
		logger.info("Number of records in table has changed");
		logger.info("Table Test finished successfully");

	}
}
package com.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadXl {

	@DataProvider(name = "RagistrationData")
	public String[][] getData() {
		File excelFile = new File("./src/main/resources/TestData.xlsx");
		FileInputStream fis = null;
		XSSFWorkbook excelWBook = null;
		try {
			fis = new FileInputStream(excelFile);
			excelWBook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		XSSFSheet sheet = excelWBook.getSheetAt(0);
		int totalRow = sheet.getPhysicalNumberOfRows();
		int totalColumns = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[totalRow - 1][totalColumns];
		for (int i = 0; i < totalRow - 1; i++) {
			for (int j = 0; j < totalColumns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}

		try {
			excelWBook.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;

	}

}
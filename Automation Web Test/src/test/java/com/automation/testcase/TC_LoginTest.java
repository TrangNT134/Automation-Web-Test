package com.automation.testcase;

import org.testng.annotations.Test;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import com.automation.base.DriverInstance;
import com.automation.pom.LoginPage;
import com.automation.utils.CaptureScreenshot;



public class TC_LoginTest extends DriverInstance {
	
	@Test(dataProvider = "data")
	public void LoginTest(String email, String password) throws Exception{
		LoginPage lg = new LoginPage(driver);
		lg.login(email, password);
		WebElement logout = driver.findElement(By.xpath("//a[@href='/logout']"));
		logout.click();
		Thread.sleep(2000);
	}
	
	@DataProvider(name = "data")
	public Object[][] getDataFromExel() throws Exception {
		FileInputStream fis = new FileInputStream("./data/assignment2_data_test.xlsx");
		Workbook wb = new XSSFWorkbook(fis);
		Sheet loginSheet = wb.getSheet("Login");
		int numberOfData = loginSheet.getPhysicalNumberOfRows();
		Object [][] testData = new Object[numberOfData][2];
		for(int i = 0; i < numberOfData; i++) {
			Row rw = loginSheet.getRow(i);
			Cell email = rw.getCell(0);
			Cell password = rw.getCell(1);
			testData [i][0] = email.getStringCellValue();
			testData [i][1] = password.getStringCellValue();
		}
		return testData;
	}
	
	
	@AfterMethod
 	public void takeScreenshot(ITestResult result) throws InterruptedException {
		Thread.sleep(1000);
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				CaptureScreenshot.takeScreenshot(driver, result.getName());
				System.out.println("Đã chụp màn hình: " + result.getName());
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
	}

}


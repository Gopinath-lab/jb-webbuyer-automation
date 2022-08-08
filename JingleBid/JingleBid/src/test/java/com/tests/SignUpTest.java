package com.tests;


import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.SignUpPage;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Test(testName = "SignUp Test", description = "Sign Up Functionality Testing")

public class SignUpTest extends BaseTest{
//	
//	public static SignUpPage Signuppage;
//	
//	String[][] data = null;
//	
//	@BeforeMethod
//	public void before() throws IOException {
//		Signuppage = new SignUpPage(driver);
//	}
//	
////  //*********Data Provider Method*********//
//	@DataProvider(name = "logindata")
//	public String[][] loginDataProvider() throws BiffException, IOException {
//		data = GetExcelData();
//		return data;
//	}
//	
//	public String[][] GetExcelData() throws IOException, BiffException {
//		FileInputStream m = new FileInputStream(excelpath);
//		Workbook excel = Workbook.getWorkbook(m);
//		Sheet sheet = excel.getSheet("signup");
//		int rowcount = sheet.getRows();
//		int columncount = sheet.getColumns();
//
//		String testdata[][] = new String[rowcount - 1][columncount - 1];
//		for (int i = 1; i < rowcount; i++) {
//			for (int j = 1; j < columncount; j++) {
//				testdata[i - 1][j - 1] = sheet.getCell(j, i).getContents();
//			}
//		}
//		return testdata;
//	}
//
//	@Test(dataProvider = "logindata")
//	public void logincheck(String uname, String email, String phnumber, String pwd, String otp) throws InterruptedException {
//		Signuppage.launchURL();
//		Signuppage.signUp(uname, email, phnumber, pwd, otp);
//
//	}
	
   // ***********Value getting from property method**********//	

	@Test
	public void SignUpPage ()throws Exception {
		SignUpPage SignUpPage = PageinstancesFactory.getInstance(SignUpPage.class);
		SignUpPage.launchURL().signUpusingReferral();
	}
}

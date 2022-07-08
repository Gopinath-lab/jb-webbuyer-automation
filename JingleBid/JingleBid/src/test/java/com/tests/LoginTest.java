package com.tests; 

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.helper.SeleniumHelper;
import com.pages.LoginPage;

/**
 * The Class Login Test.
 *
 * @author Omprakash darsi
 */

@Test(testName = "Login Test", description = "Validating Login Functionality")
public class LoginTest extends BaseTest {

	@Test
	public void loginPage() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().login();
		Thread.sleep(4000);
		loginPage.signout();
		Thread.sleep(3000);
		loginPage.viewProfile().LoginwithOTP();
		Thread.sleep(3000);
		loginPage.signout();
		Thread.sleep(2000);
		loginPage.viewProfile().passwordRecovery();
		
	}

}

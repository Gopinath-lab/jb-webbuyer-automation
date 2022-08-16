package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginOTPPage;

public class LoginOTPTest {

	@Test(testName = "10. Login with OTP", description = "Validating Login with OTP Functionality", priority = 9)
	
	public class LoginTest extends BaseTest {

		@Test (priority = 9)
		public void LoginwithOTP() throws Exception {
			LoginOTPPage loginPage = PageinstancesFactory.getInstance(LoginOTPPage.class);
			loginPage.launchURL().loginwithOTP();
				}
		}

	
}

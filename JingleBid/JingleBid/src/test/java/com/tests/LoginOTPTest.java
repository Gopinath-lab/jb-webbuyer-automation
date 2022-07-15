package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginOTPPage;

public class LoginOTPTest {

	
	@Test(testName = "Login with OTP Test", description = "Validating Login with OTP Functionality")
	public class LoginTest extends BaseTest {

		@Test
		public void loginPage() throws Exception {
			LoginOTPPage loginPage = PageinstancesFactory.getInstance(LoginOTPPage.class);
			loginPage.launchURL().loginwithOTP();
				}
		}

	
}

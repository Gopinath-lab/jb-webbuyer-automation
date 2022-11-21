package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginOTPPage;

	@Test(testName = "10. Login with OTP", description = "Validating Login with OTP Functionality")
	public class LoginOTPTest extends BaseTest {

		@Test 
		public void LoginwithOTP() throws Exception {
			LoginOTPPage loginPage = PageinstancesFactory.getInstance(LoginOTPPage.class);
			loginPage.launchURL().loginwithOTP();
				}
		}

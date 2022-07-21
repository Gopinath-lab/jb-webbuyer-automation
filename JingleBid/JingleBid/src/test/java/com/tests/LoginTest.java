package com.tests; 

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginPage;

@Test(testName = "Email/Password Login Test", description = "Validating Email/Pass Login Functionality")
public class LoginTest extends BaseTest {

	@Test
	public void loginPage() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpasslogin().logout();
			}
	}

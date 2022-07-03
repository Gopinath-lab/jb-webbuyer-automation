package com.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginPage;

/**
 * The Class Login Test.
 *
 * @author Omprakash darsi
 */

@Test(testName = "Login Test", description = "Validating Login Functionality")
public class LoginTest extends BaseTest {

	@Parameters({ "url", "username", "password" })
	@Test
	public void loginPage(String url, String username, String password) throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL(url).login(username, password);
	}

}

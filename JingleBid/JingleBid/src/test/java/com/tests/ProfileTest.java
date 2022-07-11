package com.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginPage;
import com.pages.ProfilePage;

@Test(testName = "Profile Test", description = "Validating Profile Functionality")
public class ProfileTest extends BaseTest{
	
	
	//@Parameters({ "url", "username", "password" })
	@Test
	public void profilepage() throws Exception {
		LoginPage	loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpasslogin();
		ProfilePage profilepage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilepage.profileupdate();
	}
	}
package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginPage;
import com.pages.ProfilePage;

@Test(testName = "Profile Test", description = "Validating Profile Functionality")
public class ProfileTest extends BaseTest{

	@Test
	public void profilepage() throws Exception {
		LoginPage	loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilepage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilepage.profileImageUpload();
	}
	}
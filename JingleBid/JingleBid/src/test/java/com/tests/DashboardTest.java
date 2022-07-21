package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.DashboardPage;
import com.pages.LoginPage;

@Test(testName = "Dashboard verification", description = "Verification and validation of Dashboard funcationalities")

public class DashboardTest extends BaseTest	{
	
	@Test
	
	public void DashboardPage () throws Exception{
		
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpasslogin();
		
		DashboardPage dashboardPage = PageinstancesFactory.getInstance(DashboardPage.class);
		dashboardPage.socialNetworkinFooter();
		
		
	}

}

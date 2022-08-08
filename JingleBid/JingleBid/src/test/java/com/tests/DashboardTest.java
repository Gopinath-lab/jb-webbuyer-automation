package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.DashBoardPage1;
import com.pages.DashboardPage;
import com.pages.LoginPage;

@Test(testName = "Dashboard verification", description = "Verification and validation of Dashboard funcationalities")

public class DashboardTest extends BaseTest	{
	
	@Test
	
	public void DashboardPage () throws Exception{
		
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		
		DashBoardPage1 dashboardPage = PageinstancesFactory.getInstance(DashBoardPage1.class);
		dashboardPage.hyperlinks1();
	//	dashboardPage.hyperlinks().bottomBannerAboutUs().footerJingleBidTv().policyinFooter().socialNetworkinFooter();
//		dashboardPage.contactUsFooter();
//		dashboardPage.addressinFooter();
//		dashboardPage.chatboxIcon();
//		dashboardPage.totalAuction().totalDeals();
//		dashboardPage.productRequest();
//		dashboardPage.referral();
		
	}

}

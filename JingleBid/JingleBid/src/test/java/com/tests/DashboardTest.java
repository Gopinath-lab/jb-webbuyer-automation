package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.DashBoardPage1;
import com.pages.DashboardPage;
import com.pages.LoginPage;

//@Test(testName = "Dashboard verification", description = "Verification and validation of Dashboard funcationalities")

public class DashboardTest extends BaseTest	{
	
	@Test(priority = -2, testName = "Dashboard Verification", description= "Verification and validation of Dashboard icon funcationalities")
	
	public void DashboardPage () throws Exception{
		
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		
		DashboardPage dashboardPage = PageinstancesFactory.getInstance(DashboardPage.class);
		dashboardPage.hyperlinks();
		dashboardPage.footerBannerAboutUs().footerJingleBidTv().policyinFooter().socialNetworkinFooter();
		dashboardPage.contactUsFooter().addressinFooter();
		dashboardPage.chatboxIcon();
		dashboardPage.referral();
		
	}
	@Test (priority = -1, testName = "Total Auction and Total Deals", description = "Total auction and Total Deals functionality verification")
	public void TotalAuctionAndTotalDeals () throws Exception {
//		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
//		loginPage.launchURL().emailpassLoginGeneral();

		DashboardPage dashboardPage = PageinstancesFactory.getInstance(DashboardPage.class);
		dashboardPage.totalAuction().totalDeals();
	}
	
	@Test (priority = 1, testName= "Product Request", description = "New Product request functionality verification")
	public void NewProductRequest () throws Exception {
	
//		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
//		loginPage.launchURL().emailpassLoginGeneral();

		DashboardPage dashboardPage = PageinstancesFactory.getInstance(DashboardPage.class);
		dashboardPage.productRequest();
	}

}

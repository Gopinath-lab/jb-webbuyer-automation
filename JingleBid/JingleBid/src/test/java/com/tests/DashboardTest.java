package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.DashBoardPage1;
import com.pages.DashboardPage;
import com.pages.LoginPage;

@Test(testName = "6. Dashboard verification")

public class DashboardTest extends BaseTest {

	@Test(priority = 0, description = "1. Top Bar Hyperlinks Check!")
	public void DashboardTopBar() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		DashboardPage dashboardPage = PageinstancesFactory.getInstance(DashboardPage.class);
		dashboardPage.Topbarhyperlinks();
	}

	@Test(priority = 1, description = "2. Bottom Banner Details & Links Check!")
	public void DashboardBottomBanner() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		DashboardPage dashboardPage = PageinstancesFactory.getInstance(DashboardPage.class);
		dashboardPage.footerBannerAboutUs().footerJingleBidTv().policyinFooter().socialNetworkinFooter();
		dashboardPage.contactUsFooter().addressinFooter();
		dashboardPage.chatboxIcon();
	}

	@Test(priority = 2, description = "3. Validate Product Request!")
	public void Productrequestcheck() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		DashboardPage dashboardPage = PageinstancesFactory.getInstance(DashboardPage.class);
		dashboardPage.productRequest();
	}
}

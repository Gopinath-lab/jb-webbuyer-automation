package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.CouponsPage;
import com.pages.LoginPage;
import com.pages.ShareableLink;

public class SharablelinkTest {
	
	@Test(testName = "7. Coupon verification", priority = 6)

	public class SharableLinkDemo extends BaseTest {

		@Test(priority = 0, description = "1. Referral Page Check!")
		public void ReferralPage() throws Exception {
			LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
			loginPage.launchURL().emailpassLoginGeneral();
			ShareableLink link = PageinstancesFactory.getInstance(ShareableLink.class);
			link.shareableURL();
		}
	} }

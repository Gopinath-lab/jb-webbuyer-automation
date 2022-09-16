package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginPage;
import com.pages.ShareableLink;

public class SharablelinkTest {
	
	@Test(testName = "7. Product search and referral page and related product visibility", priority = 6)

	public class SharableLink extends BaseTest {

		@Test(priority = 0, description = "1. Referral Page Check!")
		public void ReferralPage() throws Exception {
			LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
			loginPage.launchURL().emailpassLoginGeneral();
			ShareableLink link = PageinstancesFactory.getInstance(ShareableLink.class);
			link.shareableURL();
		}
		@Test(priority = 1, description = "2. Check for related product visibility!")
		public void RelatedProduct() throws Exception {
			LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
			loginPage.launchURL().emailpassLoginGeneral();
			ShareableLink link = PageinstancesFactory.getInstance(ShareableLink.class);
			link.relatedProductSearch();
		}
	} }

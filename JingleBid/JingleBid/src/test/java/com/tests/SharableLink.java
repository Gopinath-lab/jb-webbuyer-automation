package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginPage;
import com.pages.ShareableLink;
	
	@Test(testName = "9. Product search and referral page and related product visibility")
	public class SharableLink extends BaseTest {

		@Test(priority = 0, description = "1. Sharable URL check!")
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
	} 

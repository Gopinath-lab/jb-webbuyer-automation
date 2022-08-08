package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.BuyNowPage;
import com.pages.LoginPage;

@Test(testName = "Buy Now", description = "Buy Now and payment functionality")

public class BuyNowTest extends BaseTest {

	
	public void BuyNowPage () throws Exception {
				
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURLDev().emailpassLoginGeneral();
		
		BuyNowPage buyNowPage = PageinstancesFactory.getInstance(BuyNowPage.class);
		
//		buyNowPage.launchURL().searchProductandBuyNow();
//		buyNowPage.launchURL().MainCategoryandBuyNow();
		buyNowPage.launchURL().selectFromAllProductDropDownandBuyNow();
//		buyNowPage.launchURL().specialityStoreandBuyNow();
	
	}
}

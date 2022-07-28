package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.BuyNowPage;

@Test(testName = "Buy Now", description = "Buy Now and payment functionality")

public class BuyNowTest extends BaseTest {

	
	public void BuyNowPage () throws Exception {
				
		BuyNowPage buyNowPage = PageinstancesFactory.getInstance(BuyNowPage.class);
		
		buyNowPage.launchURL().searchProductandBuyNowWithNetBanking();	
//		buyNowPage.launchURL().MainCategoryandBuyNowWithCardPayment();
//		buyNowPage.launchURL().selectFromAllProductDropDownandCODPayment();
//		buyNowPage.launchURL().specialityStoreandBuyNowWalletPayment();
	
	}
}

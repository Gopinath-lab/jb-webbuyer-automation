package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.AutoBidPage;
import com.pages.LoginPage;

@Test(testName = "Auto Bid", description = "AutoBid and payment functionality")

public class AutoBidTest extends BaseTest {
	
	@Test
	
	public void AutoBidPage () throws Exception {
		
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassloginWithCorrectPhoneNo();
	// 	loginPage.launchURL().emailpasslogin(); 
		
		AutoBidPage autoBidPage = PageinstancesFactory.getInstance(AutoBidPage.class);
//		autoBidPage.searchAndStartAuctionInAutoBid();
//		autoBidPage.searchFromMainCategoryAndAutoBid();
//		autoBidPage.searchFromSpecialityStoreAndAutoBid();	
		autoBidPage.allProductsDropDownAutoBidandCODPayment();
		
				
	}

}

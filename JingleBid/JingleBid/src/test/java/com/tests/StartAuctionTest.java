package com.tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginOTPPage;
import com.pages.LoginPage;
import com.pages.StartAuctionpage;

@Test(testName = "Search product and start auction", description = "Search product and start Auction Functionality")

public class StartAuctionTest extends BaseTest{
	
	@Test
	
	public void StartAuctionPage() throws AWTException, InterruptedException {
		
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpasslogin();
	
		StartAuctionpage startAuction = PageinstancesFactory.getInstance(StartAuctionpage.class);
		startAuction.searchAndStartAuction().goToHome();
//		startAuction.startAuctionFromSpeciality().goToHome();
//		startAuction.selectMainCategoryAndStartAuction().goToHome();		
//		startAuction.selectFromAllProductDropDown();
	}

}

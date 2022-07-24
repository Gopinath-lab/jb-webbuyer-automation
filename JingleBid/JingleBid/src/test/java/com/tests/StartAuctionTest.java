package com.tests;

import java.awt.AWTException;
import org.testng.annotations.Test;
import com.factory.PageinstancesFactory;
import com.pages.LoginPage;
import com.pages.StartAuctionpage;

@Test(testName = "Start Auction", description = "Start Auction Functionality")

public class StartAuctionTest extends BaseTest{
	
	@Test
	
	public void StartAuctionPage() throws AWTException, InterruptedException {
		
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpasslogin();
	
		StartAuctionpage startAuction = PageinstancesFactory.getInstance(StartAuctionpage.class);
		startAuction.searchAndStartAuction().goToHome();
		startAuction.selectFromAllProductDropDown().goToHome();
		startAuction.selectMainCategoryAndStartAuction().goToHome();
		startAuction.startAuctionFromSpeciality().goToHome();
	}

}

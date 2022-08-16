package com.tests;

import java.awt.AWTException;
import org.testng.annotations.Test;
import com.factory.PageinstancesFactory;
import com.pages.LoginPage;
import com.pages.StartAuctionpage;

@Test(testName = "2. Start Auction[Add to Cart]", description = "Start Auction Functionality")

public class StartAuctionTest extends BaseTest {

	@Test(priority = 0, description = "1. Search a Product and Start the Auction!")
	public void StartAuctionWay0() throws AWTException, InterruptedException {

		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		StartAuctionpage startAuction = PageinstancesFactory.getInstance(StartAuctionpage.class);
		startAuction.searchAndStartAuction().goToHome();
	}

	@Test(priority = 1, description = "2. Start the Auction from All Products Drop-down!")
	public void StartAuctionWay1() throws AWTException, InterruptedException {

		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		StartAuctionpage startAuction = PageinstancesFactory.getInstance(StartAuctionpage.class);
		startAuction.selectFromAllProductDropDown().goToHome();
	}

	@Test(priority = 2, description = "3. Start the Auction from Explore Category!")
	public void StartAuctionWay2() throws AWTException, InterruptedException {

		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		StartAuctionpage startAuction = PageinstancesFactory.getInstance(StartAuctionpage.class);
		startAuction.selectMainCategoryAndStartAuction().goToHome();
	}

	@Test(priority = 3, description = "4. Start the Auction from Speciality Store!")
	public void StartAuctionWay3() throws AWTException, InterruptedException {

		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		StartAuctionpage startAuction = PageinstancesFactory.getInstance(StartAuctionpage.class);
		startAuction.startAuctionFromSpeciality().goToHome().cancelAuction();
	}

}

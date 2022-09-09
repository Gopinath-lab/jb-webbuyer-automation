package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.AutoBidPage;
import com.pages.LoginPage;
import com.pages.PaymentMethodsPage;

@Test(testName = "3. AutoBid", description = "AutoBid and payment functionality", priority = 2)

public class AutoBidTest extends BaseTest {

	@Test(priority = 0, testName = "Search Product by 'keywordsearch' and start AutoBid", description = "1.Search Product by 'keywordsearch' and start AutoBid with Netbanking payment - Functionality test")
	public void AutoBidByKeywordSearchandNetBankingPayment() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		AutoBidPage autoBidPage = PageinstancesFactory.getInstance(AutoBidPage.class);
		autoBidPage.searchAndStartAuctionInAutoBid();
		PaymentMethodsPage paymentMethod = PageinstancesFactory.getInstance(PaymentMethodsPage.class);
		paymentMethod.netBankingPayment();
	}

	@Test(enabled = true, priority = 1, testName = "Search Product from Main category and start AutoBid", description = "2.Search Product from Main category and start AutoBid with card payment - Functionality test")
	public void AutoBidFromMainCategoryandCardPayment() throws Exception {
//		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
//		loginPage.launchURL().emailpassLoginGeneral();
		AutoBidPage autoBidPage = PageinstancesFactory.getInstance(AutoBidPage.class);
		autoBidPage.searchFromMainCategoryAndAutoBid();
		PaymentMethodsPage paymentMethod = PageinstancesFactory.getInstance(PaymentMethodsPage.class);
		paymentMethod.cardPaymentMethod();
	}

	@Test(enabled = true, priority = 2, testName = "Search Product from Speciality store and start AutoBid", description = "3.Search Product from Speciality Store and start AutoBid with wallet payment - Functionality test")
	public void AutoBidFromSpecialityStoreandWalletPayment() throws Exception {
//		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
//		loginPage.launchURL().emailpassLoginGeneral();
		AutoBidPage autoBidPage = PageinstancesFactory.getInstance(AutoBidPage.class);
		autoBidPage.searchFromSpecialityStoreAndAutoBid();
		PaymentMethodsPage paymentMethod = PageinstancesFactory.getInstance(PaymentMethodsPage.class);
		paymentMethod.walletPaymentMethod();
		
	}

	@Test(enabled = true, priority = 3, testName = "Search Product from All Products dropdown and start AutoBid", description = "4.Search Product from All products dropdown and start AutoBid with COD payment - Functionality test")
	public void AutoBidFromAllProductsDropdownandCODOption() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		AutoBidPage autoBidPage = PageinstancesFactory.getInstance(AutoBidPage.class);
		autoBidPage.allProductsDropDownAutoBid();
		PaymentMethodsPage paymentMethod = PageinstancesFactory.getInstance(PaymentMethodsPage.class);
		paymentMethod.CODPayment();
	}
}

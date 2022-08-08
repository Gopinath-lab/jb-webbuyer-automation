package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.AutoBidPage;
import com.pages.LoginPage;
import com.pages.PaymentMethodsPage;

@Test(testName = "Auto Bid", description = "AutoBid and payment functionality")

public class AutoBidTest extends BaseTest {
	
	@Test
	
	public void AutoBidPage () throws Exception {
		
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		
		AutoBidPage autoBidPage = PageinstancesFactory.getInstance(AutoBidPage.class);
		autoBidPage.searchFromMainCategoryAndAutoBid();
		
		PaymentMethodsPage paymentMethod = PageinstancesFactory.getInstance(PaymentMethodsPage.class);
		paymentMethod.walletPaymentMethod();
		
//		PaymentMethodsPage paymentMethodsPage = PageinstancesFactory.getInstance(PaymentMethodsPage.class);
//		paymentMethodsPage.netBankingPayment();
				
	}

}

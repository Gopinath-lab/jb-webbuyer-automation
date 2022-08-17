package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.AutoBidPage;
import com.pages.BuyNowPage;
import com.pages.LoginPage;
import com.pages.PaymentMethodsPage;

@Test(testName = "4. BuyNow", description = "Buy Now and payment functionality", priority = 3)

public class BuyNowTest extends BaseTest {

	@Test(priority = 0, description = "1. Search Product by 'keywordsearch' and BuyNow with Netbanking payment - Functionality test")
	public void BuyNowSearchProducyUsingKeywordandNetBankingPayment() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		BuyNowPage buyNowPage = PageinstancesFactory.getInstance(BuyNowPage.class);
		buyNowPage.searchProductandBuyNow();
		PaymentMethodsPage paymentMethod = PageinstancesFactory.getInstance(PaymentMethodsPage.class);
		paymentMethod.netBankingPayment();
	}

	@Test(enabled = false, priority = 1, testName = "Search Product from Main category and BuyNow", description = "Search Product from Main category and BuyNow with card payment - Functionality test")
	public void BuyNowFromMainCategoryandCardPayment() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		BuyNowPage buyNowPage = PageinstancesFactory.getInstance(BuyNowPage.class);
		buyNowPage.MainCategoryandBuyNow();
		PaymentMethodsPage paymentMethod = PageinstancesFactory.getInstance(PaymentMethodsPage.class);
		paymentMethod.cardPaymentMethod();
	}

	@Test(enabled = false, priority = 2, testName = "Search Product from Speciality store and BuyNow", description = "Search Product from Speciality Store and BuyNow with wallet payment - Functionality test")
	public void BuyNowFromSpecialityStoreandWalletPayment() throws Exception {
//		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
//		loginPage.launchURL().emailpassLoginGeneral();
		BuyNowPage buyNowPage = PageinstancesFactory.getInstance(BuyNowPage.class);
		buyNowPage.specialityStoreandBuyNow();
		PaymentMethodsPage paymentMethod = PageinstancesFactory.getInstance(PaymentMethodsPage.class);
		paymentMethod.walletPaymentMethod();
	}

	@Test(enabled = false, priority = 3, testName = "Search Product from All Products dropdown and BuyNow", description = "Search Product from All products dropdown and BuyNow with COD payment - Functionality test")
	public void BuyNowFromAllProductsDropdownandCODOption() throws Exception {
//		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
//		loginPage.launchURL().emailpassLoginGeneral();
		BuyNowPage buyNowPage = PageinstancesFactory.getInstance(BuyNowPage.class);
		buyNowPage.selectFromAllProductDropDownandBuyNow();
		PaymentMethodsPage paymentMethod = PageinstancesFactory.getInstance(PaymentMethodsPage.class);
		paymentMethod.CODPayment();
	}

}

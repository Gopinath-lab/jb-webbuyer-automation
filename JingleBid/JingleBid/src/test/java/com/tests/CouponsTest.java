package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.CouponsPage;
import com.pages.LoginPage;
import com.pages.PaymentMethodsPage;

@Test(testName = "7. Coupon verification")

public class CouponsTest extends BaseTest {

	@Test(priority = 0, description = "1. Referral Page Check!")
	public void ReferralPage() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		CouponsPage coupon = PageinstancesFactory.getInstance(CouponsPage.class);
		coupon.referralpage();
	}

	@Test(priority = 0, description = "2. Couponapplyverfication Check!")
	public void Couponapplyverfication() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		CouponsPage coupon = PageinstancesFactory.getInstance(CouponsPage.class);
		coupon.AutoBiddealwithcoupon();
		PaymentMethodsPage paymentMethod = PageinstancesFactory.getInstance(PaymentMethodsPage.class);
		paymentMethod.netBankingPayment();
	}

}

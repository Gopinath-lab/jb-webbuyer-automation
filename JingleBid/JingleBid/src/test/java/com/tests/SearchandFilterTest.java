package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginPage;
import com.pages.SearchandFilterPage;

@Test(testName = "8. Search and Filter", description = "Start Auction Functionality", priority = 7)

public class SearchandFilterTest extends BaseTest{
	
		@Test(description = "1. Validating Search and Filter!")
		public void SearchandFiltercheck() throws Exception {
			LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
			loginPage.launchURL().emailpassLoginGeneral();
			SearchandFilterPage searchandfilter = PageinstancesFactory.getInstance(SearchandFilterPage.class);
			searchandfilter.sortByOptionandListView();
			searchandfilter.filterbyPriceMethod().filterByBrand().filterByDisplay().filterByChipset().filterByBatterySize().sortByOptionandListView().productsearchToHomePage();
		}
}

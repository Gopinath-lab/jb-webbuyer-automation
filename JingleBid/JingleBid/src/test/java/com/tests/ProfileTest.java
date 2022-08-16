package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginPage;
import com.pages.ProfilePage;

@Test(testName = "5. View Profile", description = "Validating Profile Functionality")
public class ProfileTest extends BaseTest {

	@Test(enabled=false, description = "1. Validating Profile Update Functionality!")
	public void PersonalInformationUpdate() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.profileupdate();
//		profilePage.filterMethod().filterByBrand().filterByDisplay().filterByChipset().filterByBatterySize().sortByOptionandListView();
	}
	@Test(enabled=false, description = "2. Validating Profile Image Upload Functionality!")
	public void Profileimageupload() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.profileImageUpload();
	}
	@Test(enabled=false, description = "3. Validating Phone Number Change!")
	public void PhonenumberUpdate() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.phoneNumberChange();
	}
	@Test(enabled=false, description = "4. Validating Password Change!")
	public void PasswordUpdate() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.changePassword();
	}
	@Test(enabled=false, description = "5. Validating Add Delivery Address!")
	public void AddDeliveryAddress() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.addNewAddress();
	}
	@Test(description = "6. Validating Update Delivery Address!")
	public void EditDeliveryAddress() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.deliveryAddressUpdate();
	}
}
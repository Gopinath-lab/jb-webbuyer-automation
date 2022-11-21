package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.LoginPage;
import com.pages.ProfilePage;

@Test(testName = "5. View Profile", description = "Validating Profile Functionality")
public class ProfileTest extends BaseTest {

//	@Test(enabled = true, description = "1. Validating Profile Update Functionality!", priority = 1, invocationCount = 3)
	@Test(enabled = true, description = "1. Validating Profile Update Functionality!", priority = 1)
	public void PersonalInformationUpdate() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.profileupdate();
	}

	@Test(enabled = true, description = "2. Validating Profile Image Upload Functionality!", priority = 2)
	public void Profileimageupload() throws Exception {
//		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
//		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.profileImageUpload();
	}

	@Test(enabled = true, description = "3. Validating Phone Number Change!", priority = 3)
	public void PhonenumberUpdate() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.phoneNumberChange();
	}

	@Test(enabled = true, description = "4. Validating Password Change!", priority = 4)
	public void PasswordUpdate() throws Exception {
//		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
//		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.changePassword();
	}

	@Test(enabled = true, description = "5. Validating Add New Delivery Address!", priority = 5)
	public void AddDeliveryAddress() throws Exception {
//		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
//		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.addNewAddress();
	}

	@Test(enabled = true, description = "6. Validating Edit Delivery Address!", priority = 6)
	public void EditDeliveryAddress() throws Exception {
//		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
//		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.deliveryAddressEdit();
	}

	@Test(enabled = true, description = "7. Validating Delete Delivery Address!", priority = 7)
	public void DeleteDeliveryAddress() throws Exception {
		LoginPage loginPage = PageinstancesFactory.getInstance(LoginPage.class);
		loginPage.launchURL().emailpassLoginGeneral();
		ProfilePage profilePage = PageinstancesFactory.getInstance(ProfilePage.class);
		profilePage.deliveryAddressDelete();
	}
}
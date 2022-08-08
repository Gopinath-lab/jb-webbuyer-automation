package com.tests;

import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.RecoverPassword;

@Test(testName = "Recover Password Test", description = "Validating Login Functionality")
public class RecoverPassTest extends BaseTest {

	@Test
	public void recoverpassword() throws Exception {
		RecoverPassword rcpass = PageinstancesFactory.getInstance(RecoverPassword.class);
		rcpass.launchURL();
		rcpass.passwordRecovery();
	}
}
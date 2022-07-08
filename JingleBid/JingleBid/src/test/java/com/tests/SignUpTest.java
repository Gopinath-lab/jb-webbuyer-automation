package com.tests;


import org.testng.annotations.Test;

import com.factory.PageinstancesFactory;
import com.pages.SignUpPage;

@Test(testName = "SignUp Test", description = "Sign Up Functionality Testing")

public class SignUpTest extends BaseTest{
	
	//@Parameters ({"url", "userName", "enterEmail","password", "enterPhone", "otpValue"})
	@Test
	public void SignUpPage ()throws Exception {
		SignUpPage SignUpPage = PageinstancesFactory.getInstance(SignUpPage.class);
		SignUpPage.launchURL().signUp().logOut();

		
		
	
	}
}

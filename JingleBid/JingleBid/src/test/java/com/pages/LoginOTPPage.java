package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class LoginOTPPage extends BasePage {

	public LoginOTPPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
		// TODO Auto-generated constructor stub
	}

	SeleniumHelper seleniumHelper;

	@FindBy(xpath = "//span[contains(text(),'OR Email/Password Login?')]")
	public static WebElement emailpasslogin;
	@FindBy(xpath = "//input[@id='phoneNumber']")
	public WebElement phno;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginOTPBtn;
	@FindBy(xpath = "//iframe[@title='recaptcha challenge expires in two minutes']")
	public WebElement captcha;
	@FindBy(xpath = "//input[@name='otpField01']")
	public WebElement otp;
	@FindBy(xpath = "//span[text()='SIGN IN']")
	public WebElement signbtn;
	@FindBy(xpath = "//div[text()='Logged in Successfully']")
	private WebElement loginsuccessful;

	public LoginOTPPage launchURL() {
		driver.get(TestProperties.getProperty("login.url"));
		return this;
	}

	public LoginOTPPage LoginwithOTP() {
		seleniumHelper.clickOnWebElement(phno);
		seleniumHelper.sendKeys(phno, TestProperties.getProperty("signup.enterPhone"));
		seleniumHelper.clickOnWebElement(loginOTPBtn);
		if (seleniumHelper.isElementDisplayed(captcha)) {
			Assert.assertTrue(true);
			System.out.println("Google Image Captcha Interrupted, So can't able to Login!");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Google Image Captcha Interrupted, So can't able to Login!");
		} else {
			System.out.println("No Captcha, So can able to Login!");
			seleniumHelper.sendKeys(otp, TestProperties.getProperty("signup.otp"));
			seleniumHelper.clickOnWebElement(signbtn);
			Assert.assertTrue(seleniumHelper.isElementDisplayed(loginsuccessful),
					"Login successful message is not displaying");
			ReportUtil.addScreenShot(LogStatus.PASS, "Login with OTP Successfull!");
			return this;
		}
		return this;
	}

}

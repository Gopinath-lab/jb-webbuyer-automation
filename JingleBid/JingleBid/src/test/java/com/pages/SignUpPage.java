package com.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.basepage.BasePage;
import com.context.Constants;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class SignUpPage extends BasePage{

	SeleniumHelper seleniumHelper;
	Constants constants;

	@FindBy(xpath= "//div[@class='fs-11 fw-600 jingle-blue']")
	private WebElement signup;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement name;
	@FindBy(xpath = "//input[@class='ant-select-selection-search-input']")
	private WebElement gender;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[2]")
	private WebElement genderValue;
	@FindBy(xpath = "//input[@id='phoneNumber']")
	private WebElement phone;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement pass;
	@FindBy(xpath = "//input[@id='referralCode']")
	private WebElement referralCodeEnter;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement accept;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitbtn;
	@FindBy (xpath = "//input[@name='otpField01']")
	private WebElement otp;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement finishbutn;
	@FindBy(xpath = "//iframe[@title='recaptcha challenge expires in two minutes']")
	private WebElement captcha;
	@FindBy (xpath = "//span[@class='dashboard-profile-name']")
	private WebElement profileName;
	@FindBy(xpath = "//div[@class='ant-modal-body']")
	private WebElement signUpCouponPopOp;
	@FindBy(xpath = "//span[@class='anticon anticon-close ant-modal-close-icon']")
	private WebElement closeButton;
	@FindBy(xpath = "//div[@class='header-text']")
	private WebElement jingleBidLogo;
	@FindBy(xpath = "//img[@class='referral-img']")
	private WebElement referralIcon;
	@FindBy(xpath ="//div[@class='ant-col card ant-col-xs-24 ant-col-sm-24 ant-col-md-10 ant-col-lg-10 ant-col-xl-10']")
	private WebElement referralSignUpIcon;
	@FindBy(xpath ="(//span[text()='Signup Coupon']/parent::div)[2]")
	private WebElement signUpCouponText;
	
	public SignUpPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}

	public SignUpPage launchURL() {
		driver.get(TestProperties.getProperty("login.url"));
		return this;
	}


//	public SignUpPage signUp(String uname1, String email1, String phnumber1, String pwd1, String otp1) throws InterruptedException {
//		seleniumHelper.clickOnWebElement(signup);
//		seleniumHelper.sendKeys(name, uname1);
//		seleniumHelper.clickOnWebElement(gender);	
//		seleniumHelper.clickOnWebElement(genderValue);
//		seleniumHelper.sendKeys(email, email1);
//		seleniumHelper.sendKeys(phone, phnumber1);
//		seleniumHelper.sendKeys(pass, pwd1);
//		seleniumHelper.clickOnWebElement(accept);
//		seleniumHelper.clickOnWebElement(submitbtn);
//		seleniumHelper.sendKeys(otp, otp1);
//		seleniumHelper.clickOnWebElement(finishbutn);
//		Thread.sleep(1000);
//		Assert.assertTrue(seleniumHelper.isElementDisplayed(profileName), "SignUp successful");
//		ReportUtil.addScreenShot(LogStatus.PASS, "SignUp Successful");
//		return this;
//	}

	// **--By use getproperty method--** //
	public SignUpPage signUp() throws InterruptedException {
		seleniumHelper.clickOnWebElement(signup);
		seleniumHelper.sendKeys(name, TestProperties.getProperty("signup.userName"));
		seleniumHelper.clickOnWebElement(gender);	
		seleniumHelper.clickOnWebElement(genderValue);
		seleniumHelper.sendKeys(email, TestProperties.getProperty("signup.email"));
		seleniumHelper.sendKeys(pass, TestProperties.getProperty("signup.password"));
		seleniumHelper.sendKeys(phone, TestProperties.getProperty("signup.enterPhone"));
		seleniumHelper.clickOnWebElement(submitbtn);
		seleniumHelper.sendKeys(otp, TestProperties.getProperty("signup.otp"));
		seleniumHelper.clickOnWebElement(finishbutn);
		Thread.sleep(1000);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(profileName), "SignUp successful");
		ReportUtil.addScreenShot(LogStatus.PASS, "SignUp Successful");
		return this;
	
	}
	
	public SignUpPage signUpusingReferral() throws InterruptedException {
		seleniumHelper.clickOnWebElement(signup);
		seleniumHelper.sendKeys(name, TestProperties.getProperty("signup.userName"));
		seleniumHelper.clickOnWebElement(gender);	
		seleniumHelper.clickOnWebElement(genderValue);
		seleniumHelper.sendKeys(email, TestProperties.getProperty("signup.email"));
		seleniumHelper.sendKeys(pass, TestProperties.getProperty("signup.password"));
		seleniumHelper.sendKeys(phone, TestProperties.getProperty("signup.enterPhone"));
		seleniumHelper.sendKeys(referralCodeEnter, "DSUZSNPA");
		seleniumHelper.clickOnWebElement(accept);
		seleniumHelper.clickOnWebElement(submitbtn);
		seleniumHelper.sendKeys(otp, TestProperties.getProperty("signup.otp"));
		seleniumHelper.clickOnWebElement(finishbutn);
		if (seleniumHelper.isElementDisplayed(captcha)) {
			//Assert.assertTrue(true);
			System.out.println("Google Image Captcha Interrupted, So can't able to Login!");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Google Image Captcha Interrupted, So can't able to Login!");
			return this;
		}
		seleniumHelper.waitForElement(signUpCouponPopOp, 10);
		if(seleniumHelper.isElementDisplayed(signUpCouponPopOp)) {
		Assert.assertTrue(seleniumHelper.isElementDisplayedwithoutBgColor(signUpCouponPopOp), "SignUp coupon applied successfully");
		ReportUtil.addScreenShot(LogStatus.PASS, "SignUp successful and SignUp coupon applied successfully");
		seleniumHelper.clickOnWebElement(closeButton);
		}
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(referralIcon);
		seleniumHelper.waitForElementVisible(referralSignUpIcon, 10);
		seleniumHelper.clickOnWebElement(referralSignUpIcon);
		if(seleniumHelper.isElementDisplayedwithoutBgColor(signUpCouponText)) {
			String actualTextinReferralCode = signUpCouponText.getText();
			Assert.assertEquals(actualTextinReferralCode, TestProperties.getProperty("expectedTextinSignUpCoupon"));
			ReportUtil.addScreenShot(LogStatus.PASS,"Directing to referral page and SignUp Coupon is available");	
	}
		else {ReportUtil.addScreenShot(LogStatus.FAIL, "Directing to referral page but SignUp Coupon is not available");
			
		}
		return this;
}}


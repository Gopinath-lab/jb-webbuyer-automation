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
	public static WebElement signup;
	@FindBy(xpath = "//input[@id='name']")
	public static WebElement name;
	@FindBy(xpath = "//input[@class='ant-select-selection-search-input']")
	public static WebElement gender;
	@FindBy(xpath = "//input[@id='email']")
	public static WebElement email;
	@FindBy(xpath = "(//div[@class='ant-select-item-option-content'])[2]")
	public static WebElement genderValue;
	@FindBy(xpath = "//input[@id='phoneNumber']")
	public static WebElement phone;
	@FindBy(xpath = "//input[@id='password']")
	public static WebElement pass;
	@FindBy(xpath = "//input[@id='referralCode']")
	public WebElement referralCodeEnter;
	@FindBy(xpath = "//input[@type='checkbox']")
	public static WebElement accept;
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement submitbtn;
	@FindBy (xpath = "//input[@name='otpField01']")
	public static WebElement otp;
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement finishbutn;
	@FindBy (xpath = "//span[@class='dashboard-profile-name']")
	public static WebElement profileName;
	@FindBy(xpath = "//div[@class='ant-modal-body']")
	private WebElement signUpCouponPopOp;
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
		seleniumHelper.waitForElement(signUpCouponPopOp, 10);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(signUpCouponPopOp), "SignUp coupon applied successfully");
		ReportUtil.addScreenShot(LogStatus.PASS, "SignUp successful and SignUp coupon applied successfully");
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(referralIcon);
		seleniumHelper.waitForElementVisible(referralSignUpIcon, 10);
		seleniumHelper.clickOnWebElement(referralSignUpIcon);
		if(seleniumHelper.isElementDisplayed(signUpCouponText)) {
			String actualTextinReferralCode = signUpCouponText.getText();
			Assert.assertEquals(actualTextinReferralCode, TestProperties.getProperty("expectedTextinSignUpCoupon"));
			ReportUtil.addScreenShot(LogStatus.PASS,"Directing to referral page and SignUp Coupon is available");	
	}
		return this;
}}	


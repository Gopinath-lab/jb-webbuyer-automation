package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.basepage.BasePage;
import com.github.javafaker.Faker;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.LoggerUtil;
import com.util.ReportUtil;
import com.util.TestProperties;

/**
 * The Class represents Login page.
 *
 * @author Omprakash darsi
 */
public class LoginPage extends BasePage {

	SeleniumHelper seleniumHelper;
	//Login with Email/Password WebElements
	@FindBy(xpath = "//span[contains(text(),'OR Email/Password Login?')]")
	public static WebElement emailpasslogin;
	
	@FindBy(xpath = "//input[@id='email']")
	public static WebElement uname;

	@FindBy(xpath = "//input[@id='password']")
	public static WebElement pwd;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-round login-btn']")
	public static WebElement logbtn;
	
	@FindBy(xpath = "//div[text()='Logged in Successfully']")
	private WebElement loginsuccessful;
	
	@FindBy(xpath = "//div[@class='ant-dropdown-trigger ant-dropdown-open']")
	private WebElement menudrop;
	
	@FindBy(xpath = "//div[@class='logout-icon']")
	private WebElement signout;
	
	//OTP Login WebElements
	@FindBy(xpath = "//input[@id='phoneNumber']") 
	public WebElement phno;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginOTPBtn;
	
	@FindBy(xpath = "//input[@name='otpField01']")
	public WebElement otp;
	
	@FindBy(xpath = "//span[text()='SIGN IN']")
	public WebElement signbtn;
	
	//Signout WebElements
	@FindBy(xpath = "(//span[@class='anticon anticon-down cl-grey'])[2]")
	public static WebElement menubtn;
	
	@FindBy(xpath = "//div[@class='logout-icon']")
	public static WebElement logoutbtn;
	
	@FindBy(xpath = "//span[@class='dashboard-profile-name']")
	public static WebElement prfle;
	
	//Recover Password WebElements
	
	@FindBy(xpath = "//span[text()='Recover Password']")
	public WebElement recoverPwd;
	
	@FindBy(xpath = "//input[@name='phoneNumber']")
	public WebElement recoverPwdenterphno;
	
	@FindBy(xpath = "//button[@id='sign-in-button']")
	public WebElement recoverPwdSbmtbtn;
	
	@FindBy(xpath = "//input[@name='otpField01']")
	public WebElement recoverypwdOTP;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement recoveryVerifyBtn;
	
	@FindBy(xpath = "//input[@name='newPassword']")
	public WebElement newPwd;

	@FindBy(xpath = "//input[@name='confirmPassword']")
	public WebElement cnfrmPwd;
	
	@FindBy(xpath = "//span[text()='CHANGE PASSWORD']")
	public WebElement pwdChangeBtn;
	
	@FindBy(xpath ="//div[@class='ant-notification-notice notification-success ant-notification-notice-success ant-notification-notice-closable']")
	public WebElement pwdchangednotice;
	
	//View profile - To return back to login page after signout
	
	@FindBy(xpath = "//p[text()='View Profile']")
	public WebElement viewProfile;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}
	public Faker faker = new Faker(); // Used to generate random text like, name, city address, color
	SoftAssert softassert = new SoftAssert();
	
	public LoginPage launchURL() {
		driver.get(TestProperties.getProperty("login.url"));
		return this;
	}
	
	public LoginPage login (){
		seleniumHelper.clickOnWebElement(emailpasslogin);
		seleniumHelper.sendKeys(uname, TestProperties.getProperty("login-username"));
		seleniumHelper.sendKeys(pwd, TestProperties.getProperty("login-password"));
		seleniumHelper.clickOnWebElement(logbtn);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(loginsuccessful),"Login successful message is not displaying");
		ReportUtil.addScreenShot(LogStatus.PASS, "Login successfully");
		return this;
			}
	
	
	public LoginPage LoginwithOTP() {
		seleniumHelper.clickOnWebElement(phno);
		seleniumHelper.sendKeys(phno, TestProperties.getProperty("signup.enterPhone"));
		seleniumHelper.clickOnWebElement(loginOTPBtn);
		seleniumHelper.sendKeys(otp, TestProperties.getProperty("signup.otp"));
		seleniumHelper.clickOnWebElement(signbtn);
		
		Assert.assertTrue(seleniumHelper.isElementDisplayed(loginsuccessful),"Login successful message is not displaying");
		ReportUtil.addScreenShot(LogStatus.PASS, "Login with OTP successful");
		
		return this;
		
	}
	
	public LoginPage signout() {
		
		seleniumHelper.clickOnWebElement(menubtn);
		seleniumHelper.clickOnWebElement(logoutbtn);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(prfle), "Logout successful");
		ReportUtil.addScreenShot(LogStatus.PASS, "Logout successful");
		return this;	
	}
	
	public LoginPage passwordRecovery () {
		seleniumHelper.clickOnWebElement(emailpasslogin);
		seleniumHelper.clickOnWebElement(recoverPwd);
		seleniumHelper.clickOnWebElement(recoverPwdenterphno);
		seleniumHelper.sendKeys(recoverPwdenterphno, TestProperties.getProperty("signup.enterPhone"));
		seleniumHelper.clickOnWebElement(recoverPwdSbmtbtn);
		seleniumHelper.sendKeys(recoverypwdOTP, TestProperties.getProperty("signup.otp"));
		seleniumHelper.clickOnWebElement(recoveryVerifyBtn);
		seleniumHelper.sendKeys(newPwd, TestProperties.getProperty("newPassword"));
		seleniumHelper.sendKeys(cnfrmPwd, TestProperties.getProperty("confirmPassword"));
		seleniumHelper.clickOnWebElement(pwdChangeBtn);
		seleniumHelper.clickOnWebElement(pwdChangeBtn);
			
		Assert.assertTrue(seleniumHelper.isElementDisplayed(pwdchangednotice), "Password changed successfully");
		ReportUtil.addScreenShot(LogStatus.PASS, "Password changed successfully");
		
		return this;
	}
	//To return back to login page after signout
	public LoginPage viewProfile () {
			seleniumHelper.clickOnWebElement(viewProfile);
		
		return this;
		
		
	}
}

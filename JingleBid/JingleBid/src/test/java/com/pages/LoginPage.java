package com.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.basepage.BasePage;
import com.github.javafaker.Faker;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class LoginPage extends BasePage {

	SeleniumHelper seleniumHelper;

	// Login with Email/Password WebElements
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

	// Signout WebElements
	@FindBy(xpath = "(//span[@class='anticon anticon-down cl-grey'])[2]")
	public static WebElement menubtn;
	@FindBy(xpath = "(//div[@class='menu-profile-dropdown'])[5]")
	public static WebElement logoutbtn;

	// View profile - To return back to login page after signout
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

	public LoginPage emailpasslogin() {
		seleniumHelper.clickOnWebElement(emailpasslogin);
		seleniumHelper.sendKeys(uname, TestProperties.getProperty("login-username"));
		seleniumHelper.sendKeys(pwd, TestProperties.getProperty("login-password"));
		seleniumHelper.clickOnWebElement(logbtn);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(loginsuccessful),
				"Login successful message is not displaying");
		ReportUtil.addScreenShot(LogStatus.PASS, "Email/Pass Login Successfull!");
		return this;
	}

	public void logout() {	
		seleniumHelper.clickOnWebElement(menubtn);
		seleniumHelper.jsClick(logoutbtn);
	}

	// To return back to login page after signout
	public void viewProfile() {
		seleniumHelper.clickOnWebElement(viewProfile);
	}

}

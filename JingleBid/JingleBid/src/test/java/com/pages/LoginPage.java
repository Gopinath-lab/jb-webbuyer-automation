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

/**
 * The Class represents Login page.
 *
 * @author Omprakash darsi
 */
public class LoginPage extends BasePage {

	SeleniumHelper seleniumHelper;

	@FindBy(xpath = "//span[contains(text(),'OR Email/Password Login?')]")
	public static WebElement emailpasslogin;
	
	@FindBy(xpath = "//input[@id='email']")
	public static WebElement uname;

	@FindBy(xpath = "//input[@id='password']")
	public static WebElement pwd;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-round login-btn']")
	public static WebElement logbtn;
	
	@FindBy(xpath = "//div[text()='Logged in Successfully']")
	private WebElement loginsuccessfull;
	
	@FindBy(xpath = "//div[@class='ant-dropdown-trigger ant-dropdown-open']")
	private WebElement menudrop;
	
	@FindBy(xpath = "//div[@class='logout-icon']")
	private WebElement signout;
	
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}
	public Faker faker = new Faker(); // Used to generate random text like, name, city address, color
	SoftAssert softassert = new SoftAssert();
	
	public LoginPage launchURL(String url) {
		driver.get(url);
		return this;
	}
	
	public LoginPage login(String userName, String password) throws InterruptedException {
		seleniumHelper.clickOnWebElement(emailpasslogin);
		seleniumHelper.sendKeys(uname, userName);
		seleniumHelper.sendKeys(pwd, password);
		seleniumHelper.clickOnWebElement(logbtn);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(loginsuccessfull),"Login successfull message is not displaying");
		ReportUtil.addScreenShot(LogStatus.PASS, "Login successfully");
		return this;
			}
	public void LoginwithOTP() {
		
	}
	
}

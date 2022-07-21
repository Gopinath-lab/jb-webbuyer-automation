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

public class RecoverPassword extends BasePage {

	SeleniumHelper seleniumHelper;

	// Recover Password WebElements
	@FindBy(xpath = "//span[contains(text(),'OR Email/Password Login?')]")
	private WebElement emailpasslogin;
	@FindBy(xpath = "//span[text()='Recover Password']")
	private WebElement recoverPwd;
	@FindBy(xpath = "//input[@name='phoneNumber']")
	private WebElement recoverPwdenterphno;
	@FindBy(xpath = "//button[@id='sign-in-button']")
	private WebElement recoverPwdSbmtbtn;
	@FindBy(xpath = "//iframe[@title='recaptcha challenge expires in two minutes']")
	private WebElement captcha;
	@FindBy(xpath = "//input[@name='otpField01']")
	private WebElement recoverypwdOTP;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement recoveryVerifyBtn;
	@FindBy(xpath = "//input[@name='newPassword']")
	private WebElement newPwd;
	@FindBy(xpath = "//input[@name='confirmPassword']")
	private WebElement cnfrmPwd;
	@FindBy(xpath = "//span[text()='CHANGE PASSWORD']")
	private WebElement pwdChangeBtn;
	@FindBy(xpath = "//div[@class='ant-notification-notice notification-success ant-notification-notice-success ant-notification-notice-closable']")
	private WebElement pwdchangednotice;

	public RecoverPassword(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
		// TODO Auto-generated constructor stub
	}

	public RecoverPassword launchURL() {
		driver.get(TestProperties.getProperty("login.url"));
		return this;
	}

	public RecoverPassword passwordRecovery() {
		seleniumHelper.clickOnWebElement(emailpasslogin);
		seleniumHelper.clickOnWebElement(recoverPwd);
		seleniumHelper.clickOnWebElement(recoverPwdenterphno);
		seleniumHelper.sendKeys(recoverPwdenterphno, TestProperties.getProperty("signup.enterPhone"));
		seleniumHelper.clickOnWebElement(recoverPwdSbmtbtn);
		if (seleniumHelper.isElementDisplayed(captcha)) {
			Assert.assertTrue(true);
			System.out.println("Google Image Captcha Interrupted, So can't able to Recover Password!");
			ReportUtil.addScreenShot(LogStatus.FAIL,
					"Google Image Captcha Interrupted, So can't able to Recover Password!");
		} else {
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
		return this;
	}
}

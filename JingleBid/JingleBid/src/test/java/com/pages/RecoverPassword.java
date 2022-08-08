package com.pages;

import javax.swing.plaf.ActionMapUIResource;

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
	public static WebElement emailpasslogin;
	@FindBy(xpath = "//span[text()='Recover Password']")
	public WebElement recoverPwd;
	@FindBy(xpath = "//input[@name='phoneNumber']")
	public WebElement recoverPwdenterphno;
	@FindBy(xpath = "//button[@id='sign-in-button']")
	public WebElement recoverPwdSbmtbtn;
	@FindBy(xpath = "//iframe[@title='recaptcha challenge expires in two minutes']")
	public WebElement captcha;
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
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public WebElement pwdchangednotice;

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
			String expectedTextinPasswordChange = "Password changed successfully";
			String actualTextinPwdChange = pwdchangednotice.getText();
			Assert.assertEquals(actualTextinPwdChange, expectedTextinPasswordChange);
			if (actualTextinPwdChange.equalsIgnoreCase(expectedTextinPasswordChange)){
				//	Assert.assertEq(seleniumHelper.isElementDisplayed(pwdchangednotice), "Password changed successfully");
			ReportUtil.addScreenShot(LogStatus.PASS, "Password changed successfully");}
			else {
				seleniumHelper.highlightWebElement(pwdchangednotice);
				ReportUtil.addScreenShot(LogStatus.FAIL, "Error occured while changing password");
			}

			return this;
		}
		return this;
	}
}

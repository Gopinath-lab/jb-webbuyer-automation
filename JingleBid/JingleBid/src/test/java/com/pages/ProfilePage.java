package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.basepage.BasePage;
import com.github.javafaker.Faker;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;

public class ProfilePage extends BasePage {

	SeleniumHelper seleniumHelper;

	@FindBy(xpath = "//p[contains(text(),'View Profile')]")
	private static WebElement viewprofile;
	@FindBy(xpath = "//input[@id='User_Name']")
	private static WebElement username;
	@FindBy(xpath = "//input[@id='Email_ID']")
	private static WebElement emailid;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary save-btn']")
	private static WebElement lgbtn;
	@FindBy(xpath = "//div[text()='Updated Successfully']")
	private WebElement updatesuccess;

	public ProfilePage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
		
	}
	public Faker faker = new Faker();

	public ProfilePage profileupdate() {
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.waitForElementToBeClickable(username, "10");
		seleniumHelper.doubleClickOnElement(driver, username);
		seleniumHelper.backspace(username);
		seleniumHelper.sendKeys(username, "Automation");
		seleniumHelper.backspace(emailid);
		seleniumHelper.sendKeys(emailid, "m");
		seleniumHelper.clickOnWebElement(lgbtn);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(updatesuccess),
				"Updated Successfully message is not displaying");
		ReportUtil.addScreenShot(LogStatus.PASS, "Updated Successfully");
		return this;
	}
}

package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.basepage.BasePage;
import com.github.javafaker.Faker;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class ProfilePage extends BasePage {

	SeleniumHelper seleniumHelper;

	@FindBy(xpath = "//p[contains(text(),'View Profile')]")
	public static WebElement viewprofile;
	@FindBy(xpath = "//input[@id='User_Name']")
	public static WebElement username;
	@FindBy(xpath = "//input[@id='Email_ID']")
	public static WebElement emailid;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary save-btn']")
	public static WebElement lgbtn;
	@FindBy(xpath = "//div[text()='Updated Successfully']")
	private WebElement updatesuccess;
	@FindBy(xpath = "//div[@class='ant-select ant-select-single ant-select-show-arrow ant-select-open']")
	private WebElement genderselect;
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder']")
	private WebElement genderselectDropDown;
	@FindBy(xpath = "//div[@class='buyer-camera-icon bg-blue']")
	private WebElement imageuploadIcon;
	@FindBy(xpath = "//img[@srs='https://dev-jinglebid-images.s3.ap-south-1.amazona…6%20-%201618464310860%20-%20Group%203034%403x.png']")
	private WebElement image;
	
	public ProfilePage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
		
	}
//	public Faker faker = new Faker();

	public ProfilePage profileupdate() throws AWTException {
		Robot bot = new Robot ();
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.waitForElementToBeClickable(username, "10");
		seleniumHelper.doubleClickOnElement(driver, username);
		seleniumHelper.backspace(username);
		seleniumHelper.sendKeys(username, TestProperties.getProperty("newProfileName"));
		seleniumHelper.doubleClickOnElement(driver, emailid);
		bot.keyPress(KeyEvent.VK_CONTROL);
		bot.keyPress(KeyEvent.VK_A);
		bot.keyRelease(KeyEvent.VK_CONTROL);
		bot.keyRelease(KeyEvent.VK_A);
		bot.keyPress(KeyEvent.VK_BACK_SPACE);
		bot.keyRelease(KeyEvent.VK_BACK_SPACE);		
		seleniumHelper.sendKeys(emailid, TestProperties.getProperty("newProfileEmail"));
		seleniumHelper.clickOnWebElement(lgbtn);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(updatesuccess),
				"Updated Successfully message is not displaying");
		ReportUtil.addScreenShot(LogStatus.PASS, "Updated Successfully");
		return this;
	}
	
	public ProfilePage profileImageUpload () {
		seleniumHelper.clickOnWebElement(viewprofile);
		//	seleniumHelper.waitForElementToBeClickable(imageuploadIcon, "10");
		WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
		addFile.sendKeys("/Users/Dell/Downloads/image.jpeg");
		
		//image.sendKeys("C:\\Users\\Dell\\Downloads\\image.jpeg");
		return this;
	}
}

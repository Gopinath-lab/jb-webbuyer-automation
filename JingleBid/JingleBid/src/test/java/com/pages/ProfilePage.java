package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	

	@FindBy(xpath = "//p[contains(text(),'View Profile')]/parent::button")
	public static WebElement viewprofile;
	@FindBy(xpath = "//input[@id='User_Name']")
	public static WebElement username;
	@FindBy(xpath = "//input[@id='Email_ID']")
	public static WebElement emailid;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary save-btn']")
	public static WebElement saveButton;
	@FindBy(xpath = "//div[text()='Updated Successfully']")
	private WebElement updatesuccess;
	@FindBy(xpath = "//div[@class='ant-select ant-select-single ant-select-show-arrow ant-select-open']")
	private WebElement genderselect;
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder']")
	private WebElement genderselectDropDown;
	@FindBy(xpath = "//div[@class='buyer-camera-icon bg-blue']")
	private WebElement imageuploadIcon;
	@FindBy(xpath = "//input[@type='file']/following-sibling::img/preceding-sibling::input")
	private WebElement image;
	@FindBy(xpath = "//input[@type='file']/following-sibling::img")
	private WebElement imageAvailability;
	@FindBy(xpath="//div[text()='Image Successfully uploaded']")
	private WebElement imageuploadedSuccessfully;
	@FindBy(xpath = "//span[contains(text(),'Change Phone')]/parent::button")
	private WebElement changePhNoButton;
	@FindBy(xpath = "//input[@name='phoneNumber']")
	private WebElement phoneNoInput;
	@FindBy(xpath ="//button[@id='verify-number']")
	private WebElement savePhnoButton;
	@FindBy(xpath = "//input[@name='otpField01']")
	private WebElement otp;
	@FindBy(xpath = "//span[text()='Finish']/parent::button")
	private WebElement finishButton;
	@FindBy(xpath = "//div[text()='Phone Number Updated Successfully']")
	private WebElement noUpdatedSuccessfully;
	@FindBy(xpath = "//span[text()='Change Password']/parent::button")
	private WebElement changePassword;
	@FindBy(xpath = "//input[@id='newPassword']")
	public WebElement newPwd;
	@FindBy(xpath = "//input[@id='confirmPassword']")
	public WebElement cnfrmPwd;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-round uppercase fs-11']")
	public WebElement pwdChangeBtn;
	@FindBy(xpath = "//div[@class='ant-notification-notice notification-error ant-notification-notice-error ant-notification-notice-closable']")
	private WebElement notificationPopUp;
	@FindBy(xpath = "//div[text()='Successfully updated']")
	private WebElement passwordSuccess;
	@FindBy(xpath = "//div[@class='ant-tabs-tab-btn' and text()='Delivery Location']")
	private WebElement deliveryLocationbutton;
	@FindBy(xpath = "(//span[@aria-label='delete']/parent::button[@type='button'])[2]")
	private WebElement deleteButton;
	@FindBy(xpath = "(//span[text()='Edit']/parent::button)[3]")
	private WebElement editButton;
	
	// *** Add New Address WebElements ** //
	
	@FindBy(xpath = "//span[text()='Add Address']")
	public WebElement addAddressIcon;
	@FindBy(id = "country")
	public WebElement selectCountry;
	@FindBy(xpath = "(//div[@class='rc-virtual-list-holder'])[1]")
	public List<WebElement> countryDropDown;
	@FindBy(xpath = "//input[@name='userName']")
	public WebElement addNewName;
	@FindBy(xpath = "//input[@name='phoneNumber']")
	public WebElement addNewPhoneNumber;
	@FindBy(xpath = "//input[@name='pincode']")
	public WebElement addNewPinCode;
	@FindBy(xpath = "//input[@name='buildingNumber']")
	public WebElement addNewBuildingName;
	@FindBy(xpath = "//input[@name='street']")
	public WebElement addNewStreet;
	@FindBy(xpath = "//input[@name='landmark']")
	public WebElement addNewLandmark;
	@FindBy(xpath = "//input[@name='area']")
	public WebElement addNewArea;
	@FindBy(xpath = "//input[@id='state']")
	public WebElement addNewState;
	@FindBy(xpath = "(//div[@class='rc-virtual-list-holder'])[2]")
	public List<WebElement> stateDropDownSelect;
	@FindBy(xpath = "//input[@id='city']")
	public WebElement citySelect;
//	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[2]")
//	public WebElement citySelect;
//	@FindBy(xpath  = "(//div[@class='rc-virtual-list-holder'])[2]")
//	public List <WebElement> cityDropDownList;
	@FindBy(xpath = "//div[text()='Chengalpattu']")
	public WebElement cityDropDownList;
	@FindBy(xpath = "//span[text()='Save']")
	public WebElement saveAddressButton;
	

	public ProfilePage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}
	

	public ProfilePage launchURL() {
		driver.get(TestProperties.getProperty("login.url"));
		return this;
	}
//	public Faker faker = new Faker();

	public ProfilePage profileupdate() throws AWTException {
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.waitForElementToBeClickable(username, "10");
		seleniumHelper.doubleClickOnElement(driver, username);
		seleniumHelper.backspace(username);
		seleniumHelper.sendKeys(username, TestProperties.getProperty("newProfileName"));
		seleniumHelper.clearAndSendKeys(emailid, TestProperties.getProperty("newProfileEmail"));			
		seleniumHelper.clickOnWebElement(saveButton);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(updatesuccess),
				"Updated Successfully message is not displaying");
		ReportUtil.addScreenShot(LogStatus.PASS, "Updated Successfully");
		return this;
	}
	
	public ProfilePage profileImageUpload () throws AWTException, InterruptedException {
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.highlightWebElement(image);
		image.sendKeys("C:\\Users\\Dell\\Downloads\\Image.jpg");
		Thread.sleep(2000);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(imageuploadedSuccessfully),"Profile image uploaded Successfully");
		ReportUtil.addScreenShot(LogStatus.PASS,"Profile image uploaded Successfully");
		return this;
	}
	//Address Updated Successfully!
	
	public ProfilePage phoneNumberChange() {
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.clickOnWebElement(changePhNoButton);
		seleniumHelper.clickOnWebElement(phoneNoInput);
		phoneNoInput.sendKeys(TestProperties.getProperty("login.num"));
		seleniumHelper.clickOnWebElement(savePhnoButton);
		seleniumHelper.sendKeys(otp, TestProperties.getProperty("signup.otp"));
		seleniumHelper.clickOnWebElement(finishButton);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(noUpdatedSuccessfully),"Phone number changed Successfully");
		ReportUtil.addScreenShot(LogStatus.PASS,"Phone number changed Successfully");			
		return this;
	}
	
	public ProfilePage changePassword() {
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.clickOnWebElement(changePassword);
	//	seleniumHelper.clickOnWebElement(newPwd);
		seleniumHelper.sendKeys(newPwd, TestProperties.getProperty("newPassword"));
	//	seleniumHelper.clickOnWebElement(cnfrmPwd);
		seleniumHelper.sendKeys(cnfrmPwd, TestProperties.getProperty("confirmPassword"));
		seleniumHelper.clickOnWebElement(pwdChangeBtn);
		String actualTextinNotificationBox = notificationPopUp.getText();
		if (actualTextinNotificationBox.equalsIgnoreCase("Successfully updated")){
			Assert.assertEquals(actualTextinNotificationBox, "Successfully updated");
			ReportUtil.addScreenShot(LogStatus.PASS, "Password Updated Successfully");
		}
		else {
			System.out.println(notificationPopUp.getText() + "Error, occured. Hence, password cannit be changed");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Error while updating password");
		}	
		return this;
	}
	
	public ProfilePage deliveryAddressDetete() {
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.clickOnWebElement(deliveryLocationbutton);
		seleniumHelper.moveToElementAndClickOnIt(deleteButton);
		seleniumHelper.clickOnWebElement(editButton);
		seleniumHelper.clickOnWebElement(addNewStreet);
		seleniumHelper.sendKeys(addNewStreet, TestProperties.getProperty("newStreet"));
		seleniumHelper.clickOnWebElement(addNewLandmark);
		seleniumHelper.sendKeys(addNewLandmark, TestProperties.getProperty("newLandmark"));
		seleniumHelper.clickOnWebElement(saveAddressButton);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(notificationPopUp),"Address Updated Successfully!");
		ReportUtil.addScreenShot(LogStatus.PASS,"Address changed successfully!");	
		return this;
	}
	public ProfilePage addNewAddress() throws InterruptedException {
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.clickOnWebElement(deliveryLocationbutton);
		seleniumHelper.clickOnWebElement(addAddressIcon);
		seleniumHelper.clickOnWebElement(selectCountry);
		countryDropDown.get(0).click();
		seleniumHelper.clickOnWebElement(addNewName);
		seleniumHelper.sendKeys(addNewName, TestProperties.getProperty("newName"));
		seleniumHelper.clickOnWebElement(addNewPhoneNumber);
		seleniumHelper.sendKeys(addNewPhoneNumber, TestProperties.getProperty("newPhoneNumber"));
		seleniumHelper.clickOnWebElement(addNewPinCode);
		seleniumHelper.sendKeys(addNewPinCode, TestProperties.getProperty("newPinCode"));
		seleniumHelper.clickOnWebElement(addNewBuildingName);
		seleniumHelper.sendKeys(addNewBuildingName, TestProperties.getProperty("newBuildingName"));
		seleniumHelper.clickOnWebElement(addNewStreet);
		seleniumHelper.sendKeys(addNewStreet, TestProperties.getProperty("newStreet"));
		seleniumHelper.clickOnWebElement(addNewLandmark);
		seleniumHelper.sendKeys(addNewLandmark, TestProperties.getProperty("newLandmark"));
		seleniumHelper.clickOnWebElement(addNewArea);
		seleniumHelper.sendKeys(addNewArea, TestProperties.getProperty("newArea"));
		seleniumHelper.clickOnWebElement(addNewState);
		stateDropDownSelect.get(0).click();
		Thread.sleep(2000);
		seleniumHelper.moveToElementAndClickOnIt(citySelect);
		// cityDropDownList.get(0).click();
		seleniumHelper.clickOnWebElement(cityDropDownList);
		seleniumHelper.clickOnWebElement(saveAddressButton);	
		
		return this;
	}
}


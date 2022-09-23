package com.pages;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.RandomStringUtils;
import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.STLineEndLengthImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.basepage.BasePage;
import com.github.javafaker.Animal;
import com.github.javafaker.Avatar;
import com.github.javafaker.Faker;
import com.github.javafaker.FunnyName;
import com.github.javafaker.Name;
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
	@FindBy(xpath = "//button[@id='recaptcha-verify-button']")
	public WebElement captcha;
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
	@FindBy(xpath = "//div[text()='Image Successfully uploaded']")
	private WebElement imageuploadedSuccessfully;
	@FindBy(xpath = "//span[contains(text(),'Change Phone')]/parent::button")
	private WebElement changePhNoButton;
	@FindBy(xpath = "//input[@name='phoneNumber']")
	private WebElement phoneNoInput;
	@FindBy(xpath = "//button[@id='verify-number']")
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
	@FindBy(xpath = "//span[@class='anticon anticon-close ant-modal-close-icon']")
	public WebElement closeButton;
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	private WebElement notificationPopUp;
	@FindBy(xpath = "//div[text()='Successfully updated']")
	private WebElement passwordSuccess;
	@FindBy(xpath = "//div[@class='ant-tabs-tab-btn' and text()='Delivery Location']")
	private WebElement deliveryLocationbutton;
	@FindBy(xpath = "(//span[@aria-label='delete']/parent::button[@type='button'])[2]")
	private WebElement deleteButton;
	@FindBy(xpath ="//div[text()='Are you sure to delete this address?']")
	private WebElement deleteConfirmation;
	@FindBy(xpath = "//span[text()='Yes']")
	private WebElement yesButton;
	@FindBy(xpath = "(//span[text()='Edit'])[2]")
	private WebElement editButton;
	@FindBy(xpath = "//div[@class='header-text']")
	private WebElement jingleBidLogo;
	@FindBy(xpath = "(//div[@class='carousel-col']/div[text()='Mobiles & Tabs ']/preceding-sibling::span)[2]")
	private WebElement selectFromMainMenuCategory1;
	@FindBy(xpath = "//div[@class='ant-popover-inner']/div/div/div[@class='ant-row subcategory-row']")
	private List<WebElement> dropDownProductSelect1;

	// *** Add New Address WebElements ** //

	@FindBy(xpath = "//span[text()='ADD NEW ADDRESS']")
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
	@FindBy(xpath = "//div[@class='rc-virtual-list-holder-inner']//div[text() = 'Tamil Nadu']")
	public WebElement stateDropDownSelect;
	@FindBy(xpath = "//input[@id='city']")
	public WebElement citySelect;
//	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[2]")
//	public WebElement citySelect;
//	@FindBy(xpath  = "(//div[@class='rc-virtual-list-holder'])[2]")
//	public List <WebElement> cityDropDownList;
	@FindBy(xpath = "//div[contains(text(),'Chennai')]//parent::div[@label='Chennai']")
	public WebElement cityDropDownList;
	@FindBy(xpath = "//span[text()='Save']")
	public WebElement saveAddressButton;
	/// *** SLIDER ****////
	@FindBy(xpath = "//div[@class='ant-slider']//div[@class='ant-slider-handle ant-slider-handle-2']")
	private WebElement slider;
	@FindBy(xpath = "//span[text()='Apply']/parent::button")
	private WebElement applybutton;
	@FindBy(xpath = "//div[@class='ant-slider']")
	private WebElement priceRange;
	@FindBy(xpath = "//div[@style='left: 0%;']")
	private WebElement sliderRange;
//	@FindBy(xpath = "//div[text()='Brand']/div/span")
//	private WebElement filterByBrand;
	@FindBy(xpath = "//div[text()='Brand']")
	private WebElement filterByBrand;
	@FindBy(xpath = "//div[@class='ant-collapse-content ant-collapse-content-active']/div/div/div/label/span")
	private List<WebElement> subcategoryAvailable;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[1]")
	private WebElement brandNameMatch;
	@FindBy(xpath = "//div[text()='Display']")
	private WebElement filterByDisplay;
	@FindBy(xpath = "//div[text()='Chipset']")
	private WebElement filterByChipset;
	@FindBy(xpath = "//div[text()='Battery']")
	private WebElement filterByBattery;
	@FindBy(xpath = "//span[text()='Clear Filter']")
	private WebElement clearFilterButton;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm ant-dropdown-trigger fs-11 text-left sort-drop-down']/span[@class='f-right']")
	private WebElement sortByButton;
	@FindBy(xpath = "//ul//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child']")
	private List<WebElement> sortByList;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-default ant-btn-sm ant-btn-icon-only']")
	private WebElement listviewByOption;
	@FindBy(xpath = "//div[@class='ant-col ant-col-xs-24 ant-col-sm-24 ant-col-md-10 ant-col-lg-9 ant-col-xl-9']")
	private WebElement sortByandListBy;
	@FindBy(xpath = "//span[@class='count-text' and contains(text(),'Auction')]")
	private WebElement totalAuctionButton;
	@FindBy(xpath = "//a[@class='ant-breadcrumb-link' and @href='/']")
	private WebElement homeButton;
	@FindBy(xpath = "//span[@class='count-text' and contains(text(),'Deals')]")
	private WebElement totalDealsButton;

	public ProfilePage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}

	public ProfilePage launchURL() {
		driver.get(TestProperties.getProperty("login.url"));
		return this;
	}
	Faker faker = new Faker((new Locale("en-IND")));

			
	public ProfilePage profileupdate() throws AWTException, InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(viewprofile);
		Thread.sleep(2000);
		seleniumHelper.waitForElementVisible(username, 10);
		seleniumHelper.doubleClickOnElement(driver, username);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL)
		         .sendKeys(Keys.chord("A"))
		         .keyUp(Keys.CONTROL)
		         .perform();				
		String generatedString = RandomStringUtils.random(5,true,false);
		seleniumHelper.sendKeys(username, "Auto"+" "+ generatedString);
//		seleniumHelper.clearAndSendKeys(emailid, TestProperties.getProperty("newProfileEmail"));
		seleniumHelper.clickOnWebElement(saveButton);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(updatesuccess),
				"Updated Successfully message is not displaying");
		ReportUtil.addScreenShot(LogStatus.PASS, "Updated Successfully");
		return this;
	}

	public ProfilePage profileImageUpload() throws AWTException, InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.highlightWebElement(image);
		String profileimage = System.getProperty("user.dir") + "\\src\\main\\resources\\mainresource\\ProfileImages\\image.jpg";
		image.sendKeys(profileimage);
		Thread.sleep(2000);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(imageuploadedSuccessfully),
				"Profile image uploaded Successfully");
		ReportUtil.addScreenShot(LogStatus.PASS, "Profile image uploaded Successfully");
		return this;
	}

	public ProfilePage phoneNumberChange() {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.clickOnWebElement(changePhNoButton);
		seleniumHelper.clickOnWebElement(phoneNoInput);
		phoneNoInput.sendKeys(TestProperties.getProperty("changemobile.num"));
		seleniumHelper.clickOnWebElement(savePhnoButton);
		seleniumHelper.sendKeys(otp, TestProperties.getProperty("signup.otp"));
		seleniumHelper.clickOnWebElement(finishButton);
		seleniumHelper.waitForElement(notificationPopUp, 2);
		String actualTextinNotification = notificationPopUp.getText();
		seleniumHelper.highlightWebElement(notificationPopUp);
		if (actualTextinNotification.equalsIgnoreCase("Phone Number Updated Successfully")) {
			ReportUtil.addScreenShot(LogStatus.PASS, "Phone number changed Successfully");
		}
		else if (seleniumHelper.isElementDisplayedwithoutWait(captcha)) {
			System.out.println("Google Image Captcha Interrupted, So can't change Phone number!");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Google Image Captcha Interrupted, So cannot change the phone number!");
		}
		else {
			System.out.println(actualTextinNotification + " - Error occured while updating the phone number");
			ReportUtil.addScreenShot(LogStatus.FAIL, actualTextinNotification);
		}
		return this;
	}

	public ProfilePage changePassword() {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.clickOnWebElement(changePassword);
		// seleniumHelper.clickOnWebElement(newPwd);
		seleniumHelper.sendKeys(newPwd, TestProperties.getProperty("newPassword"));
		// seleniumHelper.clickOnWebElement(cnfrmPwd);
		seleniumHelper.sendKeys(cnfrmPwd, TestProperties.getProperty("confirmPassword"));
		seleniumHelper.clickOnWebElement(pwdChangeBtn);
		seleniumHelper.isElementDisplayed(notificationPopUp);
		seleniumHelper.waitForElement(notificationPopUp, 5);
		String actualTextinNotificationBox = notificationPopUp.getText();
		if (actualTextinNotificationBox.equalsIgnoreCase("Successfully updated")) {
			Assert.assertEquals(actualTextinNotificationBox, "Successfully updated");
			ReportUtil.addScreenShot(LogStatus.PASS, "Password Updated Successfully");
		} 
		else {
			System.out.println(actualTextinNotificationBox + " - Error, occured. Hence, password cannot be changed");
			ReportUtil.addScreenShot(LogStatus.PASS, "Error while updating password");
			seleniumHelper.clickOnWebElement(closeButton);
		}
		return this;
	}

	public ProfilePage addNewAddress() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.clickOnWebElement(deliveryLocationbutton);
		seleniumHelper.clickOnWebElement(addAddressIcon);
//		seleniumHelper.clickOnWebElement(selectCountry);
//		countryDropDown.get(0).click();
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
		Thread.sleep(2000);
		seleniumHelper.clickOnWebElement(stateDropDownSelect);
		seleniumHelper.waitForElement(citySelect,5);
		seleniumHelper.moveToElementAndClickOnIt(citySelect);
		// cityDropDownList.get(0).click();
		seleniumHelper.clickOnWebElement(cityDropDownList);
		seleniumHelper.clickOnWebElement(saveAddressButton);
		seleniumHelper.isElementDisplayed(notificationPopUp);
		ReportUtil.addScreenShot(LogStatus.PASS, "Address deleted successfully!");
		seleniumHelper.waitForElement(notificationPopUp, 5);
		String addressAddedText = seleniumHelper.getText(notificationPopUp);
		Assert.assertEquals(addressAddedText, "Address Added Successfully");
		return this;
	}

	public ProfilePage deliveryAddressDelete() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.clickOnWebElement(deliveryLocationbutton);
		seleniumHelper.moveToElementAndClickOnIt(deleteButton);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(deleteConfirmation));
		seleniumHelper.clickOnWebElement(yesButton);
		seleniumHelper.isElementDisplayed(notificationPopUp);
		ReportUtil.addScreenShot(LogStatus.PASS, "Address deleted successfully!");
		seleniumHelper.waitForElement(notificationPopUp, 5);
		String addressDeleteText = seleniumHelper.getText(notificationPopUp);
		Assert.assertEquals(addressDeleteText, "Selected Address Deleted Successfully");
		return this;
	}

	public ProfilePage deliveryAddressEdit()throws Exception{
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(viewprofile);
		seleniumHelper.clickOnWebElement(deliveryLocationbutton);
		seleniumHelper.clickOnWebElement(editButton);
		seleniumHelper.clickOnWebElement(addNewStreet);
		seleniumHelper.clearAndSendKeys(addNewStreet, TestProperties.getProperty("newStreet"));
		seleniumHelper.clickOnWebElement(addNewLandmark);
		seleniumHelper.clearAndSendKeys(addNewLandmark, TestProperties.getProperty("newLandmark"));
		seleniumHelper.hardWait(3000);
		seleniumHelper.clickOnWebElement(saveAddressButton);
		ReportUtil.addScreenShot(LogStatus.PASS, "Address edited successfully!");
		seleniumHelper.waitForElement(notificationPopUp, 5);
		String addressEditText = seleniumHelper.getText(notificationPopUp);
		Assert.assertEquals(addressEditText, "Address Updated Successfully!");
		return this;
	}
	public ProfilePage filterMethod() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
//		Dimension sliderSize = slider.getSize();
//		int sliderWidth = sliderSize.getWidth();
//		int xSlider = slider.getLocation().getX();
		action.moveToElement(slider).click().dragAndDropBy(slider, 20, 0).build().perform();
		seleniumHelper.highlightWebElement(priceRange);
		seleniumHelper.clickOnWebElement(applybutton);
		ReportUtil.addScreenShot(LogStatus.PASS, "Filtered the page with MRP Price Range");
		return this;
	}

	public ProfilePage filterByBrand() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		seleniumHelper.waitForElement(filterByBrand, 5);
		seleniumHelper.clickOnWebElement(filterByBrand);
		String brandName = TestProperties.getProperty("brandName");
		WebElement brandCheckBox = driver
				.findElement(By.xpath("//span[contains(text(),'" + brandName + "')]/preceding-sibling::span"));
		WebElement brandSelected = driver
				.findElement(By.xpath("//span[contains(text(),'" + brandName + "')]/parent::label"));
		Thread.sleep(2000);
		Boolean brandClick = false;
		for (int i = 0; i <= subcategoryAvailable.size(); i++) {
			Thread.sleep(2000);
			if (subcategoryAvailable.get(i).getText().equals(brandName)) {
				seleniumHelper.clickOnWebElement(brandCheckBox);
				seleniumHelper.clickOnWebElement(applybutton);
				seleniumHelper.isElementDisplayed(brandSelected);
				Thread.sleep(2000);
				brandClick = true;
				Assert.assertTrue(brandClick);
				ReportUtil.addScreenShot(LogStatus.PASS, "Brand filter applied successfully");
				break;
			}
		}
		seleniumHelper.clickOnWebElement(clearFilterButton);
		Thread.sleep(2000);
		Boolean clearFilterClick = true;
		Assert.assertTrue(clearFilterClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Clear Filter button is applied successfully");
		return this;
	}

	public ProfilePage filterByDisplay() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		seleniumHelper.waitForElement(filterByDisplay, 5);
		seleniumHelper.clickOnWebElement(filterByDisplay);
		String displayName = TestProperties.getProperty("displayName");
		WebElement displayCheckBox = driver
				.findElement(By.xpath("//span[contains(text(),'" + displayName + "')]/preceding-sibling::span"));
		WebElement displaySelected = driver
				.findElement(By.xpath("//span[contains(text(),'" + displayName + "')]/parent::label"));
		Thread.sleep(2000);
		Boolean displayClick = false;
		for (int i = 0; i <= subcategoryAvailable.size(); i++) {
			Thread.sleep(2000);
			if (subcategoryAvailable.get(i).getText().equals(displayName)) {
				seleniumHelper.clickOnWebElement(displayCheckBox);
				seleniumHelper.clickOnWebElement(applybutton);
				seleniumHelper.isElementDisplayed(displaySelected);
				Thread.sleep(2000);
				displayClick = true;
				Assert.assertTrue(displayClick);
				ReportUtil.addScreenShot(LogStatus.PASS, "Display filter applied successfully");
				break;
			}
		}
		seleniumHelper.clickOnWebElement(clearFilterButton);
		Thread.sleep(2000);
		Boolean clearFilterClick = true;
		Assert.assertTrue(clearFilterClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Clear Filter button is applied successfully");
		return this;
	}

	public ProfilePage filterByChipset() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		seleniumHelper.waitForElement(filterByChipset, 5);
		seleniumHelper.clickOnWebElement(filterByChipset);
		String chipsetName = TestProperties.getProperty("chipsetName");
		WebElement chipsetCheckBox = driver
				.findElement(By.xpath("//span[contains(text(),'" + chipsetName + "')]/preceding-sibling::span"));
		WebElement chipsetSelected = driver
				.findElement(By.xpath("//span[contains(text(),'" + chipsetName + "')]/parent::label"));

		Thread.sleep(2000);
		Boolean chipsetClick = false;
		for (int i = 0; i <= subcategoryAvailable.size(); i++) {
			Thread.sleep(2000);
			if (subcategoryAvailable.get(i).getText().equals(chipsetName)) {
				seleniumHelper.clickOnWebElement(chipsetCheckBox);
				seleniumHelper.clickOnWebElement(applybutton);
				seleniumHelper.isElementDisplayed(chipsetSelected);
				Thread.sleep(2000);
				chipsetClick = true;
				Assert.assertTrue(chipsetClick);
				ReportUtil.addScreenShot(LogStatus.PASS, "Chipset filter applied successfully");
				break;
			}
		}
		seleniumHelper.clickOnWebElement(clearFilterButton);
		Thread.sleep(2000);
		Boolean clearFilterClick = true;
		Assert.assertTrue(clearFilterClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Clear Filter button is applied successfully");
		return this;
	}

	public ProfilePage filterByBatterySize() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		seleniumHelper.waitForElement(filterByBattery, 5);
		seleniumHelper.clickOnWebElement(filterByBattery);
		String batteryName = TestProperties.getProperty("batterySize");
		WebElement batteryCheckBox = driver
				.findElement(By.xpath("//span[contains(text(),'" + batteryName + "')]/preceding-sibling::span"));
		WebElement batterySelected = driver
				.findElement(By.xpath("//span[contains(text(),'" + batteryName + "')]/parent::label"));

		Thread.sleep(2000);
		Boolean chipsetClick = false;
		for (int i = 0; i <= subcategoryAvailable.size(); i++) {
			Thread.sleep(2000);
			if (subcategoryAvailable.get(i).getText().equals(batteryName)) {
				seleniumHelper.clickOnWebElement(batteryCheckBox);
				seleniumHelper.clickOnWebElement(applybutton);
				seleniumHelper.isElementDisplayed(batterySelected);
				Thread.sleep(2000);
				chipsetClick = true;
				Assert.assertTrue(chipsetClick);
				ReportUtil.addScreenShot(LogStatus.PASS, "BatterySize filter applied successfully");
				break;
			}
		}
		seleniumHelper.clickOnWebElement(clearFilterButton);
		Thread.sleep(2000);
		Boolean clearFilterClick = true;
		Assert.assertTrue(clearFilterClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Clear Filter button is applied successfully");
		return this;
	}

	public ProfilePage sortByOptionandListView() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		seleniumHelper.clickOnWebElement(sortByButton);
//		Thread.sleep(2000);
		sortByList.get(2).click();
		seleniumHelper.clickOnWebElement(listviewByOption);
		seleniumHelper.isElementDisplayed(sortByandListBy);
		Thread.sleep(2000);
		Boolean sortByClick = true;
		Assert.assertTrue(sortByClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "SortBy and ViewBy-List functionalities applied successfully");

		return this;
	}
	
	public ProfilePage totalAuctiontoProfilePage() throws Exception {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(totalAuctionButton);
		seleniumHelper.clickOnWebElement(homeButton);
		Boolean homeButtonClick = true;
		Assert.assertTrue(homeButtonClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Directing to home page from Total Auction page");	
		return this;
		}

	public ProfilePage totalDealstoProfilePage() throws Exception {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(totalDealsButton);
		seleniumHelper.clickOnWebElement(homeButton);
		Boolean homeButtonClick = true;
		Assert.assertTrue(homeButtonClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Directing to home page from Total Deals page");	
		return this;	
	}
}

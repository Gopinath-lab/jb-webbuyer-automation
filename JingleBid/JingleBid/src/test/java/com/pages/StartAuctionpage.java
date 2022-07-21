package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class StartAuctionpage extends BasePage{
	
	SeleniumHelper seleniumHelper;
	
	@FindBy(xpath= "//input[@placeholder='Search Products']")
	private WebElement searchProductInputBox;
	
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement searchButton;
	
	@FindBy(xpath = "(//h6[@class='search-product'])[1]")
	private WebElement searchDropDownSelect;
	
	@FindBy(xpath = "//span[text()='SELECT PRODUCT']")
	private WebElement selectProductButton;
	
	@FindBy(xpath = "(//div[@class='ant-col ant-col-24 all-quantity'])[2]")
	private WebElement emailVisibility;
	
	@FindBy(xpath = "(//button[@class='ant-btn quantity-btn'])[1]")
	private WebElement quantitySelect;
	
	@FindBy(xpath = "//span[text() = 'Confirm']")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	private WebElement notificationBox;
	
	@FindBy(xpath = "//div[@class='text-center success-icon success-card']")
	private WebElement requestSentNotification;
	
	//Specialty category WebElement
	
	@FindBy(xpath = "(//input[@id='image'])[1]")
	private WebElement selectSpecialityStore;
	
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[1]")
	private WebElement  selectProductAfterSearch;

	//WebElement for Add Address
	
	@FindBy(xpath = "//span[text()='Add Address']")
	private WebElement addAddressIcon;
	
	@FindBy(id="country")
	private WebElement selectCountry;
	
	@FindBy(xpath = "(//div[@class='rc-virtual-list-holder'])[1]")
	private List <WebElement> countryDropDown;
	
	@FindBy(xpath = "//input[@name='userName']")
	private WebElement addNewName;
	
	@FindBy(xpath= "//input[@name='phoneNumber']")
	private WebElement addNewPhoneNumber;
	
	@FindBy(xpath ="//input[@name='pincode']")
	private WebElement addNewPinCode;
	
	@FindBy(xpath = "//input[@name='buildingNumber']")
	private WebElement addNewBuildingName;
	
	@FindBy(xpath = "//input[@name='street']")
	private WebElement addNewStreet;
	
	@FindBy(xpath = "//input[@name='landmark']")
	private WebElement addNewLandmark;
	
	@FindBy(xpath = "//input[@name='area']")
	private WebElement addNewArea;
	
	@FindBy(xpath = "//input[@id='state']")
	private WebElement addNewState;
	
	@FindBy(xpath = "(//div[@class='rc-virtual-list-holder'])[2]")
	private List <WebElement>  stateDropDownSelect;	
	
	@FindBy(xpath = "//input[@id='city']")
	private WebElement citySelect;
	
//	@FindBy(xpath = "(//span[@class='ant-select-selection-item'])[2]")
//	private WebElement citySelect;
	
//	@FindBy(xpath  = "(//div[@class='rc-virtual-list-holder'])[2]")
//	private List <WebElement> cityDropDownList;
	
	@FindBy(xpath = "//div[text()='Chengalpattu']")
	private WebElement cityDropDownList;
	
	@FindBy(xpath ="//span[text()='Save']")
	private WebElement saveAddressButton;
	
	
	//Go to home WebElement
	
	@FindBy(xpath="//button[@type='button' and @class='ant-btn ant-btn-primary success-modal-btn']")
	private WebElement goToHomeButton;
	
	public StartAuctionpage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}
	
	//WebElements to select product from Main Menu

	@FindBy(xpath="(//div[@class='carousel-col']/span/img)[32]")
	public WebElement mainMenuCategorySelect;
	
	@FindBy(xpath= "//div[@class='ant-popover-inner']/div/div/div[@class='ant-row subcategory-row']")
	//@FindBy(xpath = "(//div[@class='sub-category-menu'])[2]")
	public List <WebElement> dropDownProductSelect;
	
	//WebElements to select from All Products dropdown
	
	@FindBy(xpath = "//span[text()='All Products']")
	public WebElement allProductSelect;
	
	@FindBy(xpath = "//li[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-vertical']")
	public List <WebElement> categorySelectSelectDropDown;
	
	@FindBy(xpath = " //li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child']")
	public List <WebElement> subCategorySelectProductDropDown;
	
	
	
	public StartAuctionpage searchAndStartAuction() throws AWTException {
		
		seleniumHelper.clickOnWebElement(searchProductInputBox);
		seleniumHelper.sendKeys(searchProductInputBox, TestProperties.getProperty("productName"));
		searchProductInputBox.sendKeys(Keys.ESCAPE);
		searchProductInputBox.sendKeys(Keys.ENTER);
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.clickOnWebElement(selectProductButton);
		seleniumHelper.clickOnWebElement(quantitySelect);
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
		//	System.out.println("Email address visibility test passed:" + emailVisibility.getText());

		}
		else {
			System.out.println(notificationBox.getText() + ". Hence order cannot be completed");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Email address not mentioned");
		}
		
		seleniumHelper.clickOnWebElement(confirmButton);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			Assert.assertTrue(true);
			System.out.println(notificationBox.getText() + ".Hence cannot order a product");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Error occured while ordering a product!");
		}
		else {
			System.out.println("No error while ordering product!");
			ReportUtil.addScreenShot(LogStatus.PASS,"Product searched and ordered successfully!");
		}
		
		return this;	
		
	}
	public StartAuctionpage startAuctionFromSpeciality() {
				
		seleniumHelper.clickOnWebElement(selectSpecialityStore);
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.clickOnWebElement(selectProductButton);
		seleniumHelper.clickOnWebElement(quantitySelect);
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
			// System.out.println("Email address visibility test passed:" + emailVisibility.getText());

		}
		else {
			System.out.println(notificationBox.getText() + " - Error occured, Hence order cannot be placed");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Email address not mentioned");
		}
		
		seleniumHelper.clickOnWebElement(confirmButton);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			Assert.assertTrue(true);
			System.out.println(notificationBox.getText() + ".Hence, cannot order a product");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Error occured while ordering a product from Speciality Store!");
		}
		else {
			System.out.println("No error while ordering product!");
			ReportUtil.addScreenShot(LogStatus.PASS,"Product ordered successfully from Speciality Store!");
		}
		return this;
	}
	public StartAuctionpage goToHome() {
		seleniumHelper.clickOnWebElement(goToHomeButton);
		return this;
	}
	
	public StartAuctionpage selectMainCategoryAndStartAuction () throws InterruptedException {
		
		seleniumHelper.moveToElementAndClickOnIt(mainMenuCategorySelect);
		seleniumHelper.jsClick(dropDownProductSelect.get(3));
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.clickOnWebElement(selectProductButton);
		seleniumHelper.clickOnWebElement(quantitySelect);
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
		//cityDropDownList.get(0).click();
		seleniumHelper.clickOnWebElement(cityDropDownList);
		seleniumHelper.clickOnWebElement(saveAddressButton);
		
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
		//	System.out.println("Email address visibility test passed:" + emailVisibility.getText());
		}
		else {
			System.out.println(notificationBox.getText() + " - Error occured, Hence order cannot be placed");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Email address not mentioned");
		}
		seleniumHelper.clickOnWebElement(confirmButton);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			Assert.assertTrue(true);
			System.out.println(notificationBox.getText() + ".Hence, cannot order a product");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Error occured while ordering a product from Main Menu!");
		}			
		return this;
		}
	
	public StartAuctionpage selectFromAllProductDropDown() {
		
		seleniumHelper.clickOnWebElement(allProductSelect);
		categorySelectSelectDropDown.get(1).click();
		subCategorySelectProductDropDown.get(0).click();
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.clickOnWebElement(selectProductButton);
		seleniumHelper.clickOnWebElement(quantitySelect);
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
//			System.out.println("Email address visibility test passed:" + emailVisibility.getText());

		}
		else {
			System.out.println(notificationBox.getText() + " - Error occured, Hence order cannot be placed");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Email address not mentioned");
		}
		
		seleniumHelper.clickOnWebElement(confirmButton);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			Assert.assertTrue(true);
			System.out.println(notificationBox.getText() + ".Hence, cannot order a product");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Error occured while ordering a product from All products dropdown");
		}
		else {
			System.out.println("No error while ordering product!");
			ReportUtil.addScreenShot(LogStatus.PASS,"Product ordered successfully from All products dropdown");
		}
		
		
		
		return this;
	
	}
 }





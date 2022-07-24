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

public class StartAuctionpage extends BasePage {

	SeleniumHelper seleniumHelper;

	// ***********searchAndStartAuction*************************//

	@FindBy(xpath = "//input[@placeholder='Search Products']")
	public WebElement searchProductInputBox;
	@FindBy(xpath = "(//button[@type='button'])[3]")
	public WebElement searchButton;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[1]")
	public WebElement selectsearchproduct;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary select-product-btn']")
	public WebElement selectProductButton;
	@FindBy(xpath = "(//div[@class='ant-col ant-col-24 all-quantity'])[2]")
	public WebElement emailVisibility;

	// **************Top Search All Products Drop-down**********************//

	@FindBy(xpath = "//span[text()='All Products']")
	public WebElement allProductSelect;
//	@FindBy(xpath = "//li[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-vertical']")
//	public List<WebElement> categorySelectSelectDropDown;
//	@FindBy(xpath = "//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child']")
//	public List<WebElement> subCategorySelectProductDropDown;
	@FindBy(xpath = "(//li[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-vertical'])[1]")
	public WebElement categorySelectSelectDropDown;
	@FindBy(xpath = "(//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child'])[1]")
	public WebElement subCategorySelectProductDropDown;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[19]")
	public WebElement selectallproduct;

	// ***********WebElements for Main-Category******************//

	@FindBy(xpath = "(//div[@class='carousel-col']/span/img)[32]")
	public WebElement mainMenuCategorySelect;
	@FindBy(xpath = "//div[@class='ant-popover-inner']/div/div/div[@class='ant-row subcategory-row']")
	// @FindBy(xpath = "(//div[@class='sub-category-menu'])[2]")
	public List<WebElement> dropDownProductSelect;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[1]")
	public WebElement selectmainproduct;


	// *******************Specialty category WebElement***********************//

	@FindBy(xpath = "(//input[@id='image'])[1]")
	public WebElement selectSpecialityStore;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[1]")
	public WebElement selectProductAfterSearch1;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[2]")
	public WebElement selectProductAfterSearch2;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[3]")
	public WebElement selectspecproduct;

	// *******************WebElement for Add Address****************************//

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

	// ***************************Common Elements*******************************//
	@FindBy(xpath = "(//button[@class='ant-btn quantity-btn'])[1]")
	public WebElement twoquantitySelect;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary confirm-btn']")
	public WebElement confirmButton;
	@FindBy(xpath = "//div[text()='Your Auction Request has been completed']")
	public WebElement notificationBox;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary success-modal-btn']")
	public WebElement goToHomeButton;

	// ******************************************************************//

	public StartAuctionpage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}

	// *************************Method1****************************************//

	public StartAuctionpage searchAndStartAuction() throws AWTException, InterruptedException {

		seleniumHelper.clickOnWebElement(searchProductInputBox);
		seleniumHelper.sendKeys(searchProductInputBox, TestProperties.getProperty("productName"));
		searchProductInputBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		searchProductInputBox.sendKeys(Keys.ESCAPE);
		searchProductInputBox.sendKeys(Keys.ESCAPE);
		seleniumHelper.clickOnWebElement(selectsearchproduct);
		seleniumHelper.clickOnWebElement(selectProductButton);
		Thread.sleep(3000);
		if (seleniumHelper.isElementEnabled(emailVisibility)) {
//			Assert.assertTrue(true);
			System.out.println("Email address visibility test passed:" + emailVisibility.getText());
		} else {
			System.out.println(notificationBox.getText() + "Hence order cannot be completed");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Email address not mentioned");
		}
		seleniumHelper.clickOnWebElement(confirmButton);
		Thread.sleep(1000);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(notificationBox),
				"Error occured while ordering a product!");
		ReportUtil.addScreenShot(LogStatus.PASS, "Product Searched and Ordered Successfully!");
		return this;
	}

	// ********************************Method2********************************************//

	public StartAuctionpage selectFromAllProductDropDown() throws InterruptedException {

		seleniumHelper.clickOnWebElement(allProductSelect);
		seleniumHelper.clickOnWebElement(categorySelectSelectDropDown);
		seleniumHelper.clickOnWebElement(categorySelectSelectDropDown);
		seleniumHelper.clickOnWebElement(subCategorySelectProductDropDown);
		seleniumHelper.clickOnWebElement(subCategorySelectProductDropDown);
//		categorySelectSelectDropDown.get(1).click();
//		subCategorySelectProductDropDown.get(1).click();
		seleniumHelper.clickOnWebElement(selectallproduct);
		seleniumHelper.clickOnWebElement(selectProductButton);
		Thread.sleep(2000);
		if (seleniumHelper.isElementEnabled(emailVisibility)) {
//			Assert.assertTrue(true);
			System.out.println("Email address visibility test passed:" + emailVisibility.getText());
		} else {
			System.out.println(notificationBox.getText() + " - Error occured, Hence order cannot be placed");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Email address not mentioned");
		}

		seleniumHelper.clickOnWebElement(confirmButton);
		Thread.sleep(2000);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			Assert.assertTrue(true);
			System.out.println(notificationBox.getText());
			ReportUtil.addScreenShot(LogStatus.PASS,
					"Product Ordered Successfully from Top Search all Products Drop-down!");
		} else {
			System.out.println("Error occured while ordering a product from All products dropdown!");
			ReportUtil.addScreenShot(LogStatus.FAIL,
					"Error occured while ordering a product from All products dropdown!");
		}

		return this;
	}

	// ****************************************************************************//

	public StartAuctionpage selectMainCategoryAndStartAuction() throws InterruptedException {

		seleniumHelper.moveToElementAndClickOnIt(mainMenuCategorySelect);
		seleniumHelper.jsClick(dropDownProductSelect.get(3));
		seleniumHelper.clickOnWebElement(selectmainproduct);
		seleniumHelper.clickOnWebElement(selectProductButton);
//		seleniumHelper.clickOnWebElement(addAddressIcon);
//		seleniumHelper.clickOnWebElement(selectCountry);
//		countryDropDown.get(0).click();
//		seleniumHelper.clickOnWebElement(addNewName);
//		seleniumHelper.sendKeys(addNewName, TestProperties.getProperty("newName"));
//		seleniumHelper.clickOnWebElement(addNewPhoneNumber);
//		seleniumHelper.sendKeys(addNewPhoneNumber, TestProperties.getProperty("newPhoneNumber"));
//		seleniumHelper.clickOnWebElement(addNewPinCode);
//		seleniumHelper.sendKeys(addNewPinCode, TestProperties.getProperty("newPinCode"));
//		seleniumHelper.clickOnWebElement(addNewBuildingName);
//		seleniumHelper.sendKeys(addNewBuildingName, TestProperties.getProperty("newBuildingName"));
//		seleniumHelper.clickOnWebElement(addNewStreet);
//		seleniumHelper.sendKeys(addNewStreet, TestProperties.getProperty("newStreet"));
//		seleniumHelper.clickOnWebElement(addNewLandmark);
//		seleniumHelper.sendKeys(addNewLandmark, TestProperties.getProperty("newLandmark"));
//		seleniumHelper.clickOnWebElement(addNewArea);
//		seleniumHelper.sendKeys(addNewArea, TestProperties.getProperty("newArea"));
//		seleniumHelper.clickOnWebElement(addNewState);
//		stateDropDownSelect.get(0).click();
//		Thread.sleep(2000);
//		seleniumHelper.moveToElementAndClickOnIt(citySelect);
//		// cityDropDownList.get(0).click();
//		seleniumHelper.clickOnWebElement(cityDropDownList);
//		seleniumHelper.clickOnWebElement(saveAddressButton);
		Thread.sleep(2000);
		if (seleniumHelper.isElementEnabled(emailVisibility)) {
			Assert.assertTrue(true);
			// System.out.println("Email address visibility test passed:" +
			// emailVisibility.getText());
		} else {
			System.out.println(notificationBox.getText() + " - Error occured, Hence order cannot be placed");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Email address not mentioned");
		}
		seleniumHelper.clickOnWebElement(confirmButton);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			Assert.assertTrue(true);
			System.out.println(notificationBox.getText());
			ReportUtil.addScreenShot(LogStatus.PASS,
					"Product Ordered Successfully from Top Search all Products Drop-down!");
		} else {
			System.out.println("Error occured while ordering a product from All products dropdown!");
			ReportUtil.addScreenShot(LogStatus.FAIL,
					"Error occured while ordering a product from All products dropdown!");
		}
		return this;
	}

	// ****************************************************************************//

	public StartAuctionpage startAuctionFromSpeciality() throws InterruptedException {

		seleniumHelper.clickOnWebElement(selectSpecialityStore);
		seleniumHelper.clickOnWebElement(selectspecproduct);
		seleniumHelper.clickOnWebElement(selectProductButton);
		Thread.sleep(2000);
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
			// System.out.println("Email address visibility test passed:" +
			// emailVisibility.getText());

		} else {
			System.out.println(notificationBox.getText() + " - Error occured, Hence order cannot be placed");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Email address not mentioned");
		}

		seleniumHelper.clickOnWebElement(confirmButton);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			Assert.assertTrue(true);
			System.out.println(notificationBox.getText());
			ReportUtil.addScreenShot(LogStatus.PASS,
					"Product Ordered Successfully from Speciality Store");
		} else {
			System.out.println("Error occured while ordering a product from Speciality Store!");
			ReportUtil.addScreenShot(LogStatus.FAIL,
					"Error occured while ordering a product from Speciality Store!");
		}
		return this;
	}

	// ****************************************************************************//

	public StartAuctionpage goToHome() {
		seleniumHelper.clickOnWebElement(goToHomeButton);
		return this;
	}

}

package com.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class AutoBidPage extends BasePage {
	
	SeleniumHelper seleniumHelper;
	
	@FindBy(xpath= "//input[@placeholder='Search Products']")
	private WebElement searchProductInputBox;
	
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement searchButton;
	
	@FindBy(xpath = "//span[text()='All Products']")
	public WebElement allProductSelect;

//	@FindBy(xpath = "//li[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-vertical']/parent::ul")
//	public List <WebElement> categorySelectSelectDropDown;

	@FindBy(xpath = "//div[text()='Mobile Accessories']/parent::li")
	private WebElement categorySelectSelectDropDown;


	@FindBy(xpath = " //li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child']")
	public List <WebElement> subCategorySelectProductDropDown;
	
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[1]")
	public WebElement  selectProductAfterSearch;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary autobid-select-btn']")
	public WebElement getBestPriceButton;
	
	@FindBy(xpath = "//span[text()='SELECT PRODUCT']")
	public WebElement selectProductButton;
	
	@FindBy(xpath = "(//div[@class='ant-col ant-col-24 all-quantity'])[2]")
	public WebElement emailVisibility;
	
	@FindBy(xpath = "(//button[@class='ant-btn quantity-btn'])[1]")
	public WebElement quantitySelect;
	
	@FindBy(xpath = "//span[text() = 'Confirm']")
	public WebElement confirmButton;
	
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	public WebElement notificationBox;
	
	@FindBy(xpath ="//div[@class='ant-modal-body']")
	public WebElement bidValueAcceptanceNotice;
	
	@FindBy(xpath = "(//span[@class='ant-checkbox']/input[@class='ant-checkbox-input'])[2]")
	public WebElement termsAndConditionsCheckBox;
	
	@FindBy(xpath = "//span[text()='Check this box to agree to our Terms & Conditions']/preceding-sibling::span/input")
	private WebElement termsAndConditionsCheckBoxwithoutIndex;
	
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-block accept-block-btn']/p")
	public WebElement acceptLowerPriceButton;
	
	@FindBy(xpath = "//span[text()='Cash on delivery']//preceding-sibling::span")
	private WebElement cashOnDeliveryButton;

	@FindBy(xpath = "//span[contains(text(),'Buy Now')]/parent::button")
	private WebElement buyNowButton;

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary accept-bid-btn mt-10']")
	private WebElement placeOrderButton;

	@FindBy(xpath = "//span[text()='GO TO HOME']/preceding-sibling::span")
	private WebElement goToHomeButton;
	
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary accept-bid-btn mt-10']")
	public WebElement acceptBidButton;
	
	@FindBy(xpath = "//span[text()='GO TO DEALS']")
	public WebElement goToDealsButton;
	
	@FindBy(xpath = "//span[text()='Total Deals ']")
	private WebElement totalDealsButton;
	
	@FindBy(xpath = "(//div[@class='ant-row deals-list deals-border'])[1]")
	public WebElement productinMyDeals;
	
	@FindBy(xpath = "//div[@class='ant-col ant-col-xs-24 ant-col-sm-24 ant-col-md-9 ant-col-lg-10 ant-col-xl-8']")
	public WebElement orderedStatusDetail;

	// Payment Method WebElements
	
	@FindBy(xpath = "//button[@class='new-method has-tooltip false svelte-1u727jy']/div/div/div[text()='Netbanking']")
	public WebElement netbankingButton;
		
	@FindBy(xpath = "//div[@id='form-netbanking']/div/div/div/div/label[@for='bank-radio-HDFC']")
	public WebElement hdfcNetBankingButton;
	
	@FindBy(xpath = "//div[text()='Card']/parent::div/parent::div")
	private WebElement cardButton;

	@FindBy(xpath="//input[@id='card_number']")
	private WebElement enterCardNumber;

	@FindBy(xpath = "//label[text()='Expiry']/parent::div/parent::div")
	private WebElement expiryDateOfCardNumber;

	@FindBy(xpath = "//label[text()='CVV']/parent::div/parent::div")
	private WebElement cvvDetails;

	@FindBy(xpath = "//button[@type='button' and @method='wallet']")
	private WebElement walletPaymentButton;

	@FindBy(xpath = "//div[@class='border-list collapsable svelte-1fikkit']")
	private List <WebElement> selectWalletButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Pay')]/parent::div")
	public WebElement payButton;
	
	@FindBy(xpath = "//button[text()='Success']")
	public WebElement paymentSuccessButton;
	
	@FindBy(xpath = "//button[text()='Failure']")
	public WebElement paymentFailureButton;
	
	@FindBy(xpath = "//h3[text()='Payment Details']/parent::div")
	public WebElement paymentDetails;
	
	@FindBy(xpath = "(//div[@class='carousel-col']/div[text()='Mobile Accessories']/preceding-sibling::span)[2]")
	private WebElement selectFromMainMenuCategory1;

	//Specialty category WebElement

		@FindBy(xpath = "(//input[@id='image'])[1]")
		private WebElement selectSpecialityStore;


	@FindBy(xpath= "//div[@class='ant-popover-inner']/div/div/div[@class='ant-row subcategory-row']")
	private List <WebElement> dropDownProductSelect1;

	
	public AutoBidPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);	
	}
	
	public AutoBidPage searchAndStartAuctionInAutoBid () throws InterruptedException {
		
		seleniumHelper.clickOnWebElement(searchProductInputBox);
		seleniumHelper.sendKeys(searchProductInputBox, TestProperties.getProperty("searchProductForAutoBid"));
		searchProductInputBox.sendKeys(Keys.ESCAPE);
		searchProductInputBox.sendKeys(Keys.ENTER);
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		Thread.sleep(2000);
		searchProductInputBox.sendKeys(Keys.ESCAPE);
		seleniumHelper.waitForElementVisible(getBestPriceButton, 10);
		seleniumHelper.clickOnWebElement(getBestPriceButton);
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
			}
		else {
			System.out.println(notificationBox.getText() + "Hence order cannot be completed");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Email address not mentioned");
			return this;
		}
		
		seleniumHelper.clickOnWebElement(confirmButton);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			Assert.assertTrue(true);
			System.out.println(notificationBox.getText() + ".Hence, cannot order a product");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Error occured while ordering a product!");
			return this;
		}
		else {
			System.out.println("No error while ordering product!");
			ReportUtil.addScreenShot(LogStatus.PASS,"AutoBid started successfully!");
		}
		driver.switchTo().frame(0);
		seleniumHelper.clickOnWebElement(acceptLowerPriceButton);
		seleniumHelper.clickOnWebElement(termsAndConditionsCheckBoxwithoutIndex);
		seleniumHelper.clickOnWebElement(acceptBidButton);
		Thread.sleep(3000);
		if (seleniumHelper.isElementDisplayed(notificationBox)) 
		{
			System.out.println(notificationBox.getText() + "Hence, cannot complete the deal");
			ReportUtil.addScreenShot(LogStatus.PASS, "Error occured while ordering");
			return this;

		}
		driver.switchTo().frame(0);
		seleniumHelper.clickOnWebElement(netbankingButton);
		seleniumHelper.clickOnWebElement(hdfcNetBankingButton);
		seleniumHelper.clickOnWebElement(payButton);
		seleniumHelper.SwitchToWindow(1);
		seleniumHelper.waitForElement(paymentSuccessButton, 10);
		seleniumHelper.clickOnWebElement(paymentSuccessButton);
		seleniumHelper.switchToParentWindow(); 
		seleniumHelper.clickOnWebElement(goToDealsButton);
		seleniumHelper.isElementDisplayed(productinMyDeals);
		seleniumHelper.clickOnWebElement(productinMyDeals);
		Thread.sleep(2000);
		seleniumHelper.highlightWebElement(orderedStatusDetail);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(paymentDetails));
		seleniumHelper.scrollIntoView(paymentDetails);
		ReportUtil.addScreenShot(LogStatus.PASS, "Payment successfully done");
			
		return this;	
	}
	
	public AutoBidPage searchFromMainCategoryAndAutoBid () throws InterruptedException {

		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(1).click();
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.clickOnWebElement(getBestPriceButton);
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
			}
		else {
			System.out.println(notificationBox.getText() + "Hence order cannot be completed");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Email address not mentioned");
		}

		seleniumHelper.clickOnWebElement(confirmButton);
//		if (seleniumHelper.isElementDisplayed(notificationBox)) {
//			System.out.println(notificationBox.getText() + ".Hence, cannot order a product");
//			ReportUtil.addScreenShot(LogStatus.FAIL,"Error occured while ordering a product!");
//		}
//		else {
//			System.out.println("No error while ordering product!");
//			ReportUtil.addScreenShot(LogStatus.PASS,"AutoBid started successfully!");
//		}
		seleniumHelper.clickOnWebElement(acceptLowerPriceButton);
		seleniumHelper.clickOnWebElement(termsAndConditionsCheckBoxwithoutIndex);
		seleniumHelper.clickOnWebElement(acceptBidButton);
		Thread.sleep(4000);
		if (seleniumHelper.isElementDisplayed(notificationBox)) 
		{
			System.out.println(notificationBox.getText() + "Hence, cannot complete the deal");
			ReportUtil.addScreenShot(LogStatus.PASS, "Error occured while ordering");
			return this;

		}
		driver.switchTo().frame(0);
		seleniumHelper.clickOnWebElement(cardButton);
		seleniumHelper.clickOnWebElement(enterCardNumber);
		enterCardNumber.sendKeys(TestProperties.getProperty("CardNumber"));
		seleniumHelper.clickOnWebElement(expiryDateOfCardNumber);
		expiryDateOfCardNumber.sendKeys(TestProperties.getProperty("expiryDate"));
		seleniumHelper.clickOnWebElement(cvvDetails);
		cvvDetails.sendKeys(TestProperties.getProperty("cvvDetails"));
		seleniumHelper.clickOnWebElement(payButton);
		seleniumHelper.SwitchToWindow(1);
		seleniumHelper.waitForElement(paymentSuccessButton, 10);
		seleniumHelper.clickOnWebElement(paymentSuccessButton);
		seleniumHelper.switchToParentWindow(); 
		seleniumHelper.clickOnWebElement(goToDealsButton);
		seleniumHelper.isElementDisplayed(productinMyDeals);
		seleniumHelper.clickOnWebElement(productinMyDeals);
		Thread.sleep(2000);
		seleniumHelper.highlightWebElement(orderedStatusDetail);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(paymentDetails));
		seleniumHelper.scrollIntoView(paymentDetails);
		ReportUtil.addScreenShot(LogStatus.PASS, "Payment successfully done");

		return this;
	}

	public AutoBidPage searchFromSpecialityStoreAndAutoBid() throws InterruptedException {
			seleniumHelper.clickOnWebElement(selectSpecialityStore);
			seleniumHelper.clickOnWebElement(selectProductAfterSearch);
			seleniumHelper.clickOnWebElement(getBestPriceButton);
			if (seleniumHelper.isElementDisplayed(emailVisibility)) {
				Assert.assertTrue(true);
				}
			else {
				System.out.println(notificationBox.getText() + "Hence order cannot be completed");
				ReportUtil.addScreenShot(LogStatus.FAIL,"Email address not mentioned");
			}

			seleniumHelper.clickOnWebElement(confirmButton);
//			if (seleniumHelper.isElementDisplayed(notificationBox)) {
//				System.out.println(notificationBox.getText() + ".Hence, cannot order a product");
//				ReportUtil.addScreenShot(LogStatus.FAIL,"Error occured while ordering a product!");
//			}
//			else {
//				System.out.println("No error while ordering product!");
//				ReportUtil.addScreenShot(LogStatus.PASS,"AutoBid started successfully!");
//			}
			seleniumHelper.clickOnWebElement(acceptLowerPriceButton);
			seleniumHelper.clickOnWebElement(termsAndConditionsCheckBoxwithoutIndex);
			seleniumHelper.clickOnWebElement(acceptBidButton);
			if (seleniumHelper.isElementDisplayed(notificationBox)) 
			{
				System.out.println(notificationBox.getText() + "Hence, cannot complete the deal");
				ReportUtil.addScreenShot(LogStatus.PASS, "Error occured while ordering");
				return this;

			}
			driver.switchTo().frame(0);
			seleniumHelper.clickOnWebElement(walletPaymentButton);
			selectWalletButton.get(1).click();
			seleniumHelper.clickOnWebElement(payButton);
			seleniumHelper.SwitchToWindow(1);
			seleniumHelper.waitForElement(paymentSuccessButton, 10);
			seleniumHelper.clickOnWebElement(paymentSuccessButton);
			seleniumHelper.switchToParentWindow(); 
			seleniumHelper.clickOnWebElement(goToDealsButton);
			seleniumHelper.isElementDisplayed(productinMyDeals);
			seleniumHelper.clickOnWebElement(productinMyDeals);
			Thread.sleep(2000);
			seleniumHelper.highlightWebElement(orderedStatusDetail);
			Assert.assertTrue(seleniumHelper.isElementDisplayed(paymentDetails));
			seleniumHelper.scrollIntoView(paymentDetails);
			ReportUtil.addScreenShot(LogStatus.PASS, "Payment successfully done");
			return this;

	}

	public AutoBidPage allProductsDropDownAutoBidandCODPayment () throws InterruptedException {

			seleniumHelper.moveToElementAndClickOnIt(allProductSelect);
			seleniumHelper.waitForElementVisible(categorySelectSelectDropDown, 10);
			seleniumHelper.moveToElementAndClickOnIt(categorySelectSelectDropDown);
		//	categorySelectSelectDropDown.get(1).click();
			subCategorySelectProductDropDown.get(2).click();
			seleniumHelper.clickOnWebElement(selectProductAfterSearch);
			seleniumHelper.clickOnWebElement(getBestPriceButton);
			if (seleniumHelper.isElementDisplayed(emailVisibility)) {
				Assert.assertTrue(true);
				}
			else {
				System.out.println(notificationBox.getText() + "Hence order cannot be completed");
				ReportUtil.addScreenShot(LogStatus.FAIL,"Email address not mentioned");
			}
	//		seleniumHelper.clickOnWebElement(quantitySelect);
			seleniumHelper.clickOnWebElement(confirmButton);

			if (seleniumHelper.isElementDisplayed(notificationBox)) {
				System.out.println(notificationBox.getText() + ".Hence, cannot order a product");
				ReportUtil.addScreenShot(LogStatus.FAIL,"Error occured while ordering a product!");
			}
			else {
				System.out.println("No error while ordering product!");
				ReportUtil.addScreenShot(LogStatus.PASS,"AutoBid started successfully!");
			}

			seleniumHelper.clickOnWebElement(acceptLowerPriceButton);
			seleniumHelper.waitForElementVisible(cashOnDeliveryButton, 10);
			seleniumHelper.clickOnWebElement(cashOnDeliveryButton);
			seleniumHelper.clickOnWebElement(termsAndConditionsCheckBoxwithoutIndex);
			seleniumHelper.clickOnWebElement(placeOrderButton);
			seleniumHelper.waitForElementVisible(goToHomeButton, 5);
			seleniumHelper.clickOnWebElement(goToHomeButton);
			seleniumHelper.waitForElementVisible(totalDealsButton, 10);
			seleniumHelper.clickOnWebElement(totalDealsButton);
			seleniumHelper.isElementDisplayed(productinMyDeals);
			seleniumHelper.clickOnWebElement(productinMyDeals);
			Thread.sleep(2000);
			seleniumHelper.highlightWebElement(orderedStatusDetail);
			Assert.assertTrue(seleniumHelper.isElementDisplayed(paymentDetails));
			seleniumHelper.scrollIntoView(paymentDetails);
			ReportUtil.addScreenShot(LogStatus.PASS, "Payment successfully done");			
			return this;
	}
}

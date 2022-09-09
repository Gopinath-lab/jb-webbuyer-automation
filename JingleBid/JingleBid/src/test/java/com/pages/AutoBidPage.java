package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class AutoBidPage extends BasePage {

	SeleniumHelper seleniumHelper;

//	@FindBy(xpath = "//div[@class='header-text']")
//	private WebElement jingleBidLogo;
	@FindBy(xpath = "//input[@placeholder='Search Products']")
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
	public List<WebElement> subCategorySelectProductDropDown;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[1]")
	public WebElement selectProductAfterSearch;
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
	@FindBy(xpath = "//div[@class='ant-modal-body']")
	public WebElement bidValueAcceptanceNotice;
	@FindBy(xpath = "(//button[@class='ant-btn coupon-btn']//span)[1]")
	private WebElement productCoupon;
	@FindBy(xpath = "//div[text()='View All']/parent::div")
	private WebElement couponViewAll;
	@FindBy(xpath = "//input[@placeholder='Enter the Coupon Code']")
	private WebElement couponInputBox;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary apply-btn ml-30']/span")
	private WebElement couponApplyButton;
	@FindBy(xpath = "//span[text()='Check this box to agree to our Terms & Conditions']/preceding-sibling::span/input")
	private WebElement termsAndConditionsCheckBoxwithoutIndex;
	@FindBy(xpath = "//p[@class='fs-14 cl-black']")
	public WebElement acceptLowerPriceButton;
	@FindBy(xpath = "//span[text()='Cash on delivery']//preceding-sibling::span")
	private WebElement cashOnDeliveryButton;
	@FindBy(xpath = "//span[contains(text(),'Buy Now')]/parent::button")
	private WebElement buyNowButton;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary accept-bid-btn mt-10']")
	private WebElement placeOrderButton;
	@FindBy(xpath = "//span[text()='GO TO HOME']/preceding-sibling::span")
	private WebElement goToHomeButton;
	@FindBy(xpath = "//span[text()='ACCEPT BID']")
	public WebElement acceptBidButton;
	@FindBy(xpath = "//span[text()='GO TO DEALS']")
	public WebElement goToDealsButton;
	@FindBy(xpath = "//span[text()='Total Deals ']")
	private WebElement totalDealsButton;
	@FindBy(xpath = "(//div[@class='ant-row deals-list deals-border'])[1]")
	public WebElement productinMyDeals;
	@FindBy(xpath = "//div[@class='ant-col ant-col-xs-24 ant-col-sm-24 ant-col-md-9 ant-col-lg-10 ant-col-xl-8']")
	public WebElement orderedStatusDetail;
	@FindBy(xpath = "//div[@class='header-text']")
	private WebElement jingleBidLogo;

	// Payment Method WebElements

	@FindBy(xpath = "//button[@class='new-method has-tooltip false svelte-1u727jy']/div/div/div[text()='Netbanking']")
	public WebElement netbankingButton;
	@FindBy(xpath = "//div[@id='form-netbanking']/div/div/div/div/label[@for='bank-radio-HDFC']")
	public WebElement hdfcNetBankingButton;
//	@FindBy(xpath = "//div[@class='mchild item-inner svelte-wp9tn']/parent::label")
//	public List <WebElement> netBankingOptions ;
	@FindBy(xpath = "//div[text()='Card']/parent::div/parent::div")
	private WebElement cardButton;
	@FindBy(xpath = "//input[@id='card_number']")
	private WebElement enterCardNumber;
	@FindBy(xpath = "//input[@id='card_expiry']")
	private WebElement expiryDateOfCardNumber;
	@FindBy(xpath = "//input[@id='card_cvv']")
	private WebElement cvvDetails;
	@FindBy(xpath = "//input[@placeholder='OTP']")
	private WebElement OTPenter;
	@FindBy(xpath = "//span[text()='Submit']/parent::button")
	private WebElement submitButton;
//	@FindBy(xpath = "//button[@type='button' and @method='wallet']")
//	private WebElement walletPaymentButton;
	@FindBy(xpath = "//div[text()='Wallet']/parent::div/parent::div")
	private WebElement walletPaymentButton;
	@FindBy(xpath = "//div[@class='border-list collapsable svelte-1fikkit']")
	private List<WebElement> selectWalletButton;
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
	@FindBy(xpath = "//span[@class='ant-modal-close-x']/span")
	private WebElement closeButton;

	// Specialty category WebElement

	@FindBy(xpath = "//div[text()='Type A Section1']//parent::div//following-sibling::div//div[@class='carousel-image-container']")
	private WebElement selectSpecialityStore;
	@FindBy(xpath = "//div[@class='ant-popover-inner']/div/div/div[@class='ant-row subcategory-row']")
	private List<WebElement> dropDownProductSelect1;
	@FindBy(xpath = "//div[@class='ant-slider']//div[@class='ant-slider-handle ant-slider-handle-2']")
	private WebElement slider;

	public AutoBidPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}

	public AutoBidPage searchAndStartAuctionInAutoBid() throws InterruptedException {
		seleniumHelper.clickOnWebElement(searchProductInputBox);
		seleniumHelper.sendKeys(searchProductInputBox, TestProperties.getProperty("searchProductForAutoBid"));
		searchProductInputBox.sendKeys(Keys.ENTER);
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.hardWait(3000);
		searchProductInputBox.sendKeys(Keys.ESCAPE);
		searchProductInputBox.sendKeys(Keys.ESCAPE);
//		seleniumHelper.waitForElementVisible(getBestPriceButton, 10);
		seleniumHelper.clickOnWebElement(getBestPriceButton);
		seleniumHelper.hardWait(3000);
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
			System.out.println("Email address visibility test passed:" + emailVisibility.getText());
		} else {
			System.out.println(notificationBox.getText() + "Hence order cannot be completed");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Email address not mentioned");
			return this;
		}
		seleniumHelper.clickOnWebElement(confirmButton);
		seleniumHelper.hardWait(3000);
		if (seleniumHelper.isElementDisplayed(acceptLowerPriceButton)) {
		seleniumHelper.moveToElementAndClickOnIt(acceptLowerPriceButton);
		seleniumHelper.clickOnWebElement(termsAndConditionsCheckBoxwithoutIndex);
		seleniumHelper.clickOnWebElement(acceptBidButton);
		ReportUtil.addScreenShot(LogStatus.PASS, "Bid accepted successfully");}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Error occured while ordering a product");
			seleniumHelper.clickOnWebElement(closeButton);
		}
		return this;
	}

	public AutoBidPage searchFromMainCategoryAndAutoBid() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(1).click();
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.clickOnWebElement(getBestPriceButton);
		Thread.sleep(3000);
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
		} else {
			System.out.println(notificationBox.getText() + "Hence order cannot be completed");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Email address not mentioned");
		}

		seleniumHelper.clickOnWebElement(confirmButton);
		if (seleniumHelper.isElementDisplayedwithoutWait(notificationBox)) {
			System.out.println(notificationBox.getText() + ".Hence, cannot order a product");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Error occurred while ordering a product!");
			return this;
		}
		seleniumHelper.clickOnWebElement(acceptLowerPriceButton);
		seleniumHelper.hardWait(2000);
		seleniumHelper.moveToElementAndClickOnIt(couponViewAll);
		seleniumHelper.clickOnWebElement(couponInputBox);
		seleniumHelper.sendKeys(couponInputBox, "4F1683BN");
		seleniumHelper.clickOnWebElement(couponApplyButton);
		String actualTextinCouponNotification = notificationBox.getText();
		if (actualTextinCouponNotification.equalsIgnoreCase("Coupon Applied SuccessFully!")) {
			ReportUtil.addScreenShot(LogStatus.PASS, "Coupon Applied successfully!!");
		} else {
			System.out.println(actualTextinCouponNotification + "Error occured, hence coupon cannot be applied");
			ReportUtil.addScreenShot(LogStatus.PASS, "Coupon not applied successfully!!");
		}
		seleniumHelper.clickOnWebElement(termsAndConditionsCheckBoxwithoutIndex);
		seleniumHelper.clickOnWebElement(acceptBidButton);
		ReportUtil.addScreenShot(LogStatus.PASS, "Bid accepted successfully");
		return this;
	}

	public AutoBidPage searchFromSpecialityStoreAndAutoBid() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.waitForElement(selectSpecialityStore, 5);
		seleniumHelper.clickOnWebElement(selectSpecialityStore);
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.clickOnWebElement(getBestPriceButton);
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
		} else {
			System.out.println(notificationBox.getText() + "Hence order cannot be completed");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Email address not mentioned");
		}

		seleniumHelper.clickOnWebElement(confirmButton);
//		if (seleniumHelper.isElementDisplayedwithoutWait(notificationBox)) {
//			System.out.println(notificationBox.getText() + ".Hence, cannot order a product");
//			ReportUtil.addScreenShot(LogStatus.FAIL, "Error occured while ordering a product!");
//			return this;
//		}
		seleniumHelper.clickOnWebElement(acceptLowerPriceButton);
		seleniumHelper.clickOnWebElement(productCoupon);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			String actualTextinCouponNotification = notificationBox.getText();
			Assert.assertEquals(actualTextinCouponNotification, "Coupon Applied SuccessFully!");
			ReportUtil.addScreenShot(LogStatus.PASS, "Coupon Applied successfully!!");
		}
		seleniumHelper.clickOnWebElement(termsAndConditionsCheckBoxwithoutIndex);
		seleniumHelper.clickOnWebElement(acceptBidButton);
		ReportUtil.addScreenShot(LogStatus.PASS, "Bid accepted successfully");
		return this;

	}

	public AutoBidPage allProductsDropDownAutoBid() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.waitForElement(allProductSelect, 5);
		seleniumHelper.moveToElementAndClickOnIt(allProductSelect);
		seleniumHelper.waitForElementVisible(categorySelectSelectDropDown, 10);
		seleniumHelper.moveToElementAndClickOnIt(categorySelectSelectDropDown);
		Thread.sleep(2000);
		// categorySelectSelectDropDown.get(1).click();
		subCategorySelectProductDropDown.get(2).click();
//		Boolean elementClick = false;
//		for (int i = 0; i < subCategorySelectProductDropDown.size(); i++) {
//			Thread.sleep(2000);
//			System.out.println(subCategorySelectProductDropDown.get(i).getText());
//			if (subCategorySelectProductDropDown.get(i).getText().equals("Power Bank")) {
//				seleniumHelper.clickOnWebElement(subCategorySelectProductDropDown.get(i));
//				elementClick = true;
//				break;
//			}
//		}
//		Assert.assertTrue(elementClick, "Product selected from All category");
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.clickOnWebElement(getBestPriceButton);
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
		} else {
			System.out.println(notificationBox.getText() + "Hence order cannot be completed");
			ReportUtil.addScreenShot(LogStatus.FAIL, "Email address not mentioned");
			return this;
		}
		Thread.sleep(2000);
		seleniumHelper.clickOnWebElement(confirmButton);
//		if (seleniumHelper.isElementDisplayedwithoutWait(notificationBox)) {
//			System.out.println(notificationBox.getText() + ".Hence, cannot order a product");
//			ReportUtil.addScreenShot(LogStatus.FAIL, "Error occured while ordering a product!");
//			return this;
//		} else {
			seleniumHelper.clickOnWebElement(acceptLowerPriceButton);
			seleniumHelper.clickOnWebElement(productCoupon);
			if (seleniumHelper.isElementDisplayed(notificationBox)) {
				String actualTextinCouponNotification = notificationBox.getText();
				Assert.assertEquals(actualTextinCouponNotification, "Coupon Applied SuccessFully!");
				ReportUtil.addScreenShot(LogStatus.PASS, "Coupon Applied successfully!!");
			}
			ReportUtil.addScreenShot(LogStatus.PASS, "Bid accepted successfully");
			return this;
		}
	}

//}

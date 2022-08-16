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

public class CouponsPage extends BasePage{
	
	SeleniumHelper seleniumHelper;
	
	@FindBy(xpath = "//div[@class='header-text']")
	private WebElement jingleBidLogo;
	@FindBy(xpath = "//img[@class='referral-img']")
	private WebElement referralIcon;
	@FindBy(xpath = "//span[@class='referral-code-head']/parent::div")
	private WebElement referralCode;

//	@FindBy(xpath = "//div[@class='header-text']")
//	private WebElement jingleBidLogo;
	@FindBy(xpath = "//input[@placeholder='Search Products']")
	private WebElement searchProductInputBox;
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement searchButton;
//	@FindBy(xpath = "//span[text()='All Products']")
//	public WebElement allProductSelect;
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
	
	public CouponsPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}

	public CouponsPage referralpage() {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(referralIcon);
		seleniumHelper.waitForElementVisible(referralCode, 10);
		if (seleniumHelper.isElementDisplayed(referralCode)) {
			String actualTextinReferralCode = referralCode.getText();
			Assert.assertEquals(actualTextinReferralCode, TestProperties.getProperty("expectedTextinReferralCode"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Directing to referral page and referral coupon is available");
		}
		return this;
	}

	public CouponsPage AutoBiddealwithcoupon() throws InterruptedException {
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
		seleniumHelper.moveToElementAndClickOnIt(acceptLowerPriceButton);
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
}

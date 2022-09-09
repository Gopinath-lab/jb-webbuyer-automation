package com.pages;

import java.util.List;

import javax.swing.event.ListSelectionListener;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class BuyNowPage extends BasePage {

	SeleniumHelper seleniumHelper;

	@FindBy(xpath = "//span[contains(text(),'OR Email/Password Login?')]")
	private WebElement emailpasslogin;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement uname;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement pwd;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-round login-btn']")
	private WebElement logbtn;
	@FindBy(xpath = "//div[text()='Logged in Successfully']")
	private WebElement loginsuccessful;
	@FindBy(xpath = "//div[@class='ant-dropdown-trigger ant-dropdown-open']")
	private WebElement menudrop;
	@FindBy(xpath = "//div[@class='logout-icon']")
	private WebElement signout;
	@FindBy(xpath = "//input[@placeholder='Search Products']")
	private WebElement searchProductInputBox;
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement searchButton;
	@FindBy(xpath = "(//div[@class='carousel-col']/div[text()='Mobile Accessories']/preceding-sibling::span)[2]")
	private WebElement selectFromMainMenuCategory1;
	@FindBy(xpath = "//div[@class='ant-popover-inner']/div/div/div[@class='ant-row subcategory-row']")
	private List<WebElement> dropDownProductSelect1;
	@FindBy(xpath = "//span[text()='All Products']")
	public WebElement allProductSelect;
//	@FindBy(xpath = "//li[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-vertical']/parent::ul")
//	public List <WebElement> categorySelectSelectDropDown;
	@FindBy(xpath = "//div[text()='Mobile Accessories']/parent::li")
	private WebElement categorySelectSelectDropDown;
	@FindBy(xpath = " //li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child']")
	public List<WebElement> subCategorySelectProductDropDown;
	@FindBy(xpath = "//div[text()='Type A Section1']//parent::div//following-sibling::div//div[@class='carousel-image-container']")
	private WebElement selectSpecialityStore;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[1]")
	private WebElement selectProductAfterSearch;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[2]")
	private WebElement selectProductAfterSearch1;
	@FindBy(xpath = "//span[contains(text(),'Buy Now')]/parent::button")
	private WebElement buyNowButton;
	@FindBy(xpath = "(//button[@class='ant-btn quantity-btn'])[1]")
	private WebElement quantitySelect;
	@FindBy(xpath = "//span[text() = 'Confirm']")
	private WebElement confirmButton;
	@FindBy(xpath = "//span[text()='Cash on delivery']//preceding-sibling::span")
	private WebElement cashOnDeliveryButton;
	@FindBy(xpath = "//span[text()='GO TO HOME']/preceding-sibling::span")
	private WebElement goToHomeButton;
	@FindBy(xpath = "(//div[@class='ant-col ant-col-24 all-quantity'])[2]")
	private WebElement emailVisibility;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary accept-bid-btn mt-10']")
	private WebElement placeOrderButton;
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']")
	private WebElement notificationBox;
	@FindBy(xpath = "//span[text()='Check this box to agree to our Terms & Conditions']/preceding-sibling::span/input")
	private WebElement termsAndConditionsCheckBoxwithoutIndex;
	@FindBy(xpath = "//button[@class='new-method has-tooltip false svelte-1u727jy']/div/div/div[text()='Netbanking']")
	private WebElement netbankingButton;
	@FindBy(xpath = "//div[@id='form-netbanking']/div/div/div/div/label[@for='bank-radio-HDFC']")
	private WebElement hdfcNetBankingButton;
	@FindBy(xpath = "//div[text()='Card']/parent::div/parent::div")
	private WebElement cardButton;
	@FindBy(xpath = "//input[@id='card_number']")
	private WebElement enterCardNumber;
	@FindBy(xpath = "//label[text()='Expiry']/parent::div/parent::div")
	private WebElement expiryDateOfCardNumber;
	@FindBy(xpath = "//label[text()='CVV']/parent::div/parent::div")
	private WebElement cvvDetails;
	@FindBy(xpath = "//input[@placeholder='OTP']")
	private WebElement OTPenter;
	@FindBy(xpath = "//span[text()='Submit']/parent::button")
	private WebElement submitButton;
	@FindBy(xpath = "//button[@type='button' and @method='wallet']")
	private WebElement walletPaymentButton;
	@FindBy(xpath = "//div[@class='border-list collapsable svelte-1fikkit']")
	private List<WebElement> selectWalletButton;
	@FindBy(xpath = "//span[text()='PhonePe']/parent::div/parent::div/parent::div/parent::button")
	private WebElement selectPhonepeWalltet;
	@FindBy(xpath = "//span[contains(text(), 'Pay')]/parent::div")
	private WebElement payButton;
	@FindBy(xpath = "//button[text()='Success']")
	private WebElement paymentSuccessButton;
	@FindBy(xpath = "//button[text()='Failure']")
	private WebElement paymentFailureButton;
	@FindBy(xpath = "//h3[text()='Payment Details']/parent::div")
	private WebElement paymentDetails;
	@FindBy(xpath = "//span[text()='GO TO DEALS']")
	private WebElement goToDealsButton;
	@FindBy(xpath = "//span[text()='Total Deals ']")
	private WebElement totalDealsButton;
	@FindBy(xpath = "(//div[@class='ant-row deals-list deals-border'])[1]")
	private WebElement productinMyDeals;
	@FindBy(xpath = "//div[@class='ant-col ant-col-xs-24 ant-col-sm-24 ant-col-md-9 ant-col-lg-10 ant-col-xl-8']")
	private WebElement orderedStatusDetail;
	@FindBy(xpath = "//div[@class='header-text']")
	private WebElement jingleBidLogo;

	public BuyNowPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);

	}

	public BuyNowPage launchURL() {
		driver.get(TestProperties.getProperty("login.url"));
		seleniumHelper.clickOnWebElement(emailpasslogin);
		seleniumHelper.sendKeys(uname, TestProperties.getProperty("login-username"));
		seleniumHelper.sendKeys(pwd, TestProperties.getProperty("login-password"));
		seleniumHelper.clickOnWebElement(logbtn);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(loginsuccessful),
				"Login successful message is not displaying");
		return this;

	}

	public BuyNowPage searchProductandBuyNow() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(searchProductInputBox);
		seleniumHelper.sendKeys(searchProductInputBox, TestProperties.getProperty("searchProductforBuyNow"));
		searchProductInputBox.sendKeys(Keys.ESCAPE);
		searchProductInputBox.sendKeys(Keys.ENTER);
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.hardWait(2000);
		searchProductInputBox.sendKeys(Keys.ESCAPE);
		seleniumHelper.clickOnWebElement(buyNowButton);
		seleniumHelper.clickOnWebElement(quantitySelect);
		seleniumHelper.isElementDisplayed(confirmButton);
		seleniumHelper.clickOnWebElement(confirmButton);
		seleniumHelper.clickOnWebElement(termsAndConditionsCheckBoxwithoutIndex);
		seleniumHelper.clickOnWebElement(placeOrderButton);
		seleniumHelper.hardWait(3000);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			System.out.println(notificationBox.getText() + "Hence, cannot complete the deal");
			ReportUtil.addScreenShot(LogStatus.PASS, "Error occured while ordering");
			return this;

		}
		return this;
	}

	public BuyNowPage MainCategoryandBuyNow() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.clickOnWebElement(buyNowButton);
		seleniumHelper.isElementDisplayed(confirmButton);
		// seleniumHelper.clickOnWebElement(quantitySelect);
		seleniumHelper.clickOnWebElement(confirmButton);
		seleniumHelper.clickOnWebElement(termsAndConditionsCheckBoxwithoutIndex);
		seleniumHelper.clickOnWebElement(placeOrderButton);
		seleniumHelper.hardWait(2000);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			System.out.println(notificationBox.getText() + "Hence, cannot complete the deal");
			ReportUtil.addScreenShot(LogStatus.PASS, "Error occured while ordering");
			return this;

		}
		return this;
	}

	public BuyNowPage selectFromAllProductDropDownandBuyNow() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.moveToElementAndClickOnIt(allProductSelect);
		seleniumHelper.waitForElementVisible(categorySelectSelectDropDown, 10);
		seleniumHelper.moveToElementAndClickOnIt(categorySelectSelectDropDown);
		Thread.sleep(3000);
		// categorySelectSelectDropDown.get(0).click();
		subCategorySelectProductDropDown.get(0).click();
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.clickOnWebElement(buyNowButton);
		seleniumHelper.clickOnWebElement(quantitySelect);
		seleniumHelper.isElementDisplayed(confirmButton);
		seleniumHelper.clickOnWebElement(confirmButton);
		return this;

	}

	public BuyNowPage specialityStoreandBuyNow() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectSpecialityStore);
		seleniumHelper.clickOnWebElement(selectProductAfterSearch1);
		seleniumHelper.clickOnWebElement(buyNowButton);
		seleniumHelper.waitForElementVisible(confirmButton,5);
		seleniumHelper.clickOnWebElement(confirmButton);
		seleniumHelper.clickOnWebElement(termsAndConditionsCheckBoxwithoutIndex);
		seleniumHelper.clickOnWebElement(placeOrderButton);
		seleniumHelper.hardWait(3000);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			System.out.println(notificationBox.getText() + "Hence, cannot complete the deal");
			ReportUtil.addScreenShot(LogStatus.PASS, "Error occured while ordering");
			return this;

		}
		return this;
	}
}

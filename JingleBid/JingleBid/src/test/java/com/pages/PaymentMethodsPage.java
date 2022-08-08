package com.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class PaymentMethodsPage extends BasePage {

	SeleniumHelper seleniumHelper;
	
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
	
	@FindBy(xpath = "//label[@class='radio-label mfix']")
	public List <WebElement> netBankingOptions ;
	
	@FindBy(xpath = "//div[text()='Card']/parent::div/parent::div")
	private WebElement cardButton;

	@FindBy(xpath="//input[@id='card_number']")
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

	@FindBy(xpath = " //div[text()='Wallet']//parent::div//parent::div//parent::button")
	private WebElement walletPaymentButton;
	
	@FindBy(xpath = "//button[@class=' radio-option slotted-radio']")
	private List <WebElement> selectWalletButton;
	
	@FindBy(xpath = "//span[@id='footer-cta']")
	public WebElement payButton;
	
	@FindBy(xpath = "//button[text()='Success']")
	public WebElement paymentSuccessButton;
	
	@FindBy(xpath = "//button[text()='Failure']")
	public WebElement paymentFailureButton;
	
	@FindBy(xpath = "//h3[text()='Payment Details']/parent::div")
	public WebElement paymentDetails;
	
	@FindBy(xpath = "//span[contains(text(),'Payment Method')]")
	private WebElement paymentMethodDetails;
	
	@FindBy(xpath = "//span[text()='Cash on delivery']//preceding-sibling::span")
	private WebElement cashOnDeliveryButton;
	
	@FindBy(xpath = "//span[text()='Check this box to agree to our Terms & Conditions']/preceding-sibling::span/input")
	private WebElement termsAndConditionsCheckBoxwithoutIndex;
	
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary accept-bid-btn mt-10']")
	private WebElement placeOrderButton;

	@FindBy(xpath = "//span[text()='GO TO HOME']/preceding-sibling::span")
	private WebElement goToHomeButton;


	
	public PaymentMethodsPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
		
	}

	public PaymentMethodsPage netBankingPayment() throws InterruptedException {
		driver.switchTo().frame(0);
		seleniumHelper.scrollIntoView(netbankingButton);
		seleniumHelper.clickOnWebElement(netbankingButton);
		//seleniumHelper.clickOnWebElement(hdfcNetBankingButton);
		Boolean elementClick = false;
		for (int i = 0; i < netBankingOptions.size(); i++) {
			Thread.sleep(2000);
			System.out.println(netBankingOptions.get(i).getText());
			if(netBankingOptions.get(i).getText().equals("SBI")) {
				seleniumHelper.clickOnWebElement(netBankingOptions.get(i));
				elementClick = true;
				break;
			}
		}
		Assert.assertTrue(elementClick,"Verification - SBI option clicked");
		seleniumHelper.clickOnWebElement(payButton);
		seleniumHelper.SwitchToWindow(1);
		seleniumHelper.waitForElement(paymentSuccessButton, 10);
		seleniumHelper.clickOnWebElement(paymentSuccessButton);
		seleniumHelper.switchToParentWindow(); 
		seleniumHelper.clickOnWebElement(goToDealsButton);
		seleniumHelper.isElementDisplayed(productinMyDeals);
		seleniumHelper.clickOnWebElement(productinMyDeals);
		seleniumHelper.hardWait(2000);
		seleniumHelper.highlightWebElement(orderedStatusDetail);
		seleniumHelper.waitForElementVisible(paymentMethodDetails,10);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(paymentDetails));
		seleniumHelper.scrollIntoView(paymentDetails);
		ReportUtil.addScreenShot(LogStatus.PASS, "Payment successfully done");
		return this;	
	}
	public PaymentMethodsPage walletPaymentMethod() throws InterruptedException {
		driver.switchTo().frame(0);
		seleniumHelper.scrollIntoView(walletPaymentButton);
		seleniumHelper.clickOnWebElement(walletPaymentButton);
		Boolean elementClickwallet = false;
		for (int i = 0; i <=selectWalletButton.size(); i++) {
			Thread.sleep(2000);
			if(selectWalletButton.get(i).getText().equals("PhonePe")) {
				seleniumHelper.clickOnWebElement(selectWalletButton.get(i));
				elementClickwallet = true;
				break;
			}	
		}
		Assert.assertTrue(elementClickwallet,"Verification - PhonePe option clicked");
		seleniumHelper.clickOnWebElement(payButton);
		seleniumHelper.SwitchToWindow(1);
		seleniumHelper.waitForElement(paymentSuccessButton, 10);
		seleniumHelper.clickOnWebElement(paymentSuccessButton);
		seleniumHelper.switchToParentWindow(); 
		seleniumHelper.clickOnWebElement(goToDealsButton);
		seleniumHelper.isElementDisplayed(productinMyDeals);
		seleniumHelper.clickOnWebElement(productinMyDeals);
		seleniumHelper.hardWait(2000);
		seleniumHelper.highlightWebElement(orderedStatusDetail);
		seleniumHelper.scrollIntoView(paymentDetails);
		seleniumHelper.waitForElementVisible(paymentMethodDetails,10);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(paymentDetails));
		ReportUtil.addScreenShot(LogStatus.PASS, "Payment successfully done");
		return this;
	}
	public PaymentMethodsPage cardPaymentMethod () throws InterruptedException {
		driver.switchTo().frame(0);
		seleniumHelper.scrollIntoView(cardButton);
		seleniumHelper.clickOnWebElement(cardButton);
		seleniumHelper.clickOnWebElement(enterCardNumber);
		enterCardNumber.sendKeys(TestProperties.getProperty("CardNumber"));
		seleniumHelper.clickOnWebElement(expiryDateOfCardNumber);
		expiryDateOfCardNumber.sendKeys(TestProperties.getProperty("expiryDate"));
		seleniumHelper.clickOnWebElement(cvvDetails);
		cvvDetails.sendKeys(TestProperties.getProperty("cvvDetails"));
		seleniumHelper.clickOnWebElement(payButton);
		seleniumHelper.SwitchToWindow(1);
		seleniumHelper.clickOnWebElement(OTPenter);
		seleniumHelper.sendKeys(OTPenter, TestProperties.getProperty("login.otp"));
		seleniumHelper.clickOnWebElement(submitButton);
//		seleniumHelper.waitForElement(paymentSuccessButton, 10);
//		seleniumHelper.clickOnWebElement(paymentSuccessButton);
		seleniumHelper.switchToParentWindow(); 
		seleniumHelper.clickOnWebElement(goToDealsButton);
		seleniumHelper.isElementDisplayed(productinMyDeals);
		seleniumHelper.clickOnWebElement(productinMyDeals);
		seleniumHelper.hardWait(2000);
		seleniumHelper.highlightWebElement(orderedStatusDetail);
		seleniumHelper.scrollIntoView(paymentDetails);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(paymentDetails));
		ReportUtil.addScreenShot(LogStatus.PASS, "Payment successfully done");
		return this;
	}
	
	public PaymentMethodsPage CODPayment () throws InterruptedException {
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
		seleniumHelper.hardWait(2000);
		seleniumHelper.highlightWebElement(orderedStatusDetail);
		Assert.assertTrue(seleniumHelper.isElementDisplayed(paymentDetails));
		seleniumHelper.scrollIntoView(paymentDetails);
		seleniumHelper.waitForElementVisible(paymentMethodDetails,10);
		ReportUtil.addScreenShot(LogStatus.PASS, "Payment successfully done");			

		return this;
	}

}

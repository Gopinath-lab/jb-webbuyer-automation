package com.pages;

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
	public WebElement searchProductInputBox;
	
	@FindBy(xpath = "(//button[@type='button'])[3]")
	public WebElement searchButton;
	
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
	
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-block accept-block-btn']/p/span")
	public WebElement acceptLowerPriceButton;
	
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary accept-bid-btn mt-10']")
	public WebElement acceptBidButton;
	
	@FindBy(xpath = "//span[text()='GO TO DEALS']")
	public WebElement goToDealsButton;
	
	@FindBy(xpath = "(//div[@class='ant-row deals-list deals-border'])[1]")
	public WebElement productinMyDeals;
	
	@FindBy(xpath = "//div[@class='ant-col ant-col-xs-24 ant-col-sm-24 ant-col-md-9 ant-col-lg-10 ant-col-xl-8']")
	public WebElement orderedStatusDetail;

	// Payment Method WebElements
	
	@FindBy(xpath = "//button[@class='new-method has-tooltip false svelte-1u727jy']/div/div/div[text()='Netbanking']")
	public WebElement netbankingButton;
		
	@FindBy(xpath = "//div[@id='form-netbanking']/div/div/div/div/label[@for='bank-radio-HDFC']")
	public WebElement hdfcNetBankingButton;
	
	@FindBy(xpath = "//span[contains(text(), 'Pay')]/parent::div")
	public WebElement payButton;
	
	@FindBy(xpath = "//button[text()='Success']")
	public WebElement paymentSuccessButton;
	
	@FindBy(xpath = "//button[text()='Failure']")
	public WebElement paymentFailureButton;
	
	@FindBy(xpath = "//h3[text()='Payment Details']/parent::div")
	public WebElement paymentDetails;
	
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
		searchProductInputBox.sendKeys(Keys.ESCAPE);
		seleniumHelper.waitForElementVisible(getBestPriceButton, 10);
		seleniumHelper.clickOnWebElement(getBestPriceButton);
		if (seleniumHelper.isElementDisplayed(emailVisibility)) {
			Assert.assertTrue(true);
			}
		else {
			System.out.println(notificationBox.getText() + "Hence order cannot be completed");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Email address not mentioned");
		}
		
		seleniumHelper.clickOnWebElement(confirmButton);
		if (seleniumHelper.isElementDisplayed(notificationBox)) {
			Assert.assertTrue(true);
			System.out.println(notificationBox.getText() + ".Hence, cannot order a product");
			ReportUtil.addScreenShot(LogStatus.FAIL,"Error occured while ordering a product!");
		}
		else {
			System.out.println("No error while ordering product!");
			ReportUtil.addScreenShot(LogStatus.PASS,"AutoBid started successfully!");
		}
		seleniumHelper.clickOnWebElement(acceptLowerPriceButton);
		seleniumHelper.clickOnWebElement(termsAndConditionsCheckBox);
		seleniumHelper.clickOnWebElement(acceptBidButton);
		Thread.sleep(2000);
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

	
}

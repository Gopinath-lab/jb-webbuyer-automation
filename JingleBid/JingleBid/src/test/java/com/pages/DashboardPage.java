package com.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
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

public class DashboardPage extends BasePage {

	SeleniumHelper seleniumHelper;

	String expectedTextinPlayStore = "Jinglebid";
	String expectedAboutUsURL = "https://about-us.jinglebid.com/";
	String expectedJingleBidTVURL = "https://www.youtube.com/results?search_query=JINGLEBID+TV";
	String expectedJingleBidTvFooter = "Jinglebid TV";
	String expectedPrivacyPolicyURL = "https://qa.jinglebid.com/privacy-policy";
	String expectedReturnRefundURL = "https://qa.jinglebid.com/return-refund-policy";

	@FindBy(xpath = "//a[text()='Download the App']")
	private WebElement downloadAppLink;
	@FindBy(xpath = "//span[text()='Install']")
	private WebElement appInstallButton;
	@FindBy(xpath = "(//span[contains(text(),'Jinglebid')])[2]")
	private WebElement actualTextinPlaystore;
	@FindBy(xpath = "//h3[contains(text(),'Why should you buy on Jinglebid?')]")
	private WebElement actualtextinAboutUSPage;
	@FindBy(xpath = "//a[text()='About Us']/parent::div/a")
	private WebElement aboutUslinkonTopofDashboard;
	@FindBy(xpath = "//a[text()='Jinglebid TV']")
	private WebElement jingleBidTVIcon;
	@FindBy(xpath = "//div[@class='header-text']")
	private WebElement jingleBidLogo;
	@FindBy(xpath = "//div[text()='ABOUT ']")
	private WebElement aboutinBottomBanner;
	@FindBy(xpath = "//li[text()='Home']")
	private WebElement homeButtoninFooter;
	@FindBy(xpath = "//a[text()='About Us']/parent::li/a")
	private WebElement aboutUsInFooter;
	@FindBy(xpath = "//div[text()='Jinglebid TV']")
	private WebElement jingleBidTvFooter;
	@FindBy(xpath = "//div[text()='Jinglebid TV']/parent::div/div[@class='footer-list']/ul/li/a")
	private WebElement youtubeinFooter;
	@FindBy(xpath = "//div[text()='POLICY ']")
	private WebElement policyinFooter;
	@FindBy(xpath = "//div[@class='footer-list']/ul/a/li[contains(text(),'Privacy')]")
	private WebElement privacyPolicyButton;
	@FindBy(xpath = "//div[@class='footer-list']/ul/a/li[contains(text(),'Refund policy')]")
	private WebElement refundReturnPolicyButton;
	@FindBy(xpath = "//div[@class='footer-list']/ul/a/li[contains(text(),'Conditions')]")
	private WebElement termsandConditionsButton;
	@FindBy(xpath = "//div[contains(text(),'SOCIAL')]")
	private WebElement socialinFooter;
	@FindBy(xpath = "//div[@class='footer-list']/ul/a/li[contains(text(),'Facebook')]")
	private WebElement facebookIconFooter;
	@FindBy(xpath = "//div[@class='footer-list']/ul/a/li[contains(text(),'Twitter')]")
	private WebElement twitterIconFooter;
	@FindBy(xpath = "//div[@class='footer-list']/ul/a/li[contains(text(),'Linked')]")
	private WebElement linkedInIconFooter;
	@FindBy(xpath = "//div[@class='footer-list']/ul/a/li[contains(text(),'Instagram')]")
	private WebElement instagramIconFooter;
	@FindBy(xpath = "//div[contains(text(),'Contact')]")
	private WebElement contactUsInFooter;
	@FindBy(xpath = "//a[contains(@href,'mailto')]")
	private WebElement emailInFooter;
	@FindBy(xpath = "//a//li[text()='hello@jinglebid.com']")
	private WebElement emailCheck;
	@FindBy(xpath = "//a[contains(@href,'tel')]")
	private WebElement telephoneNoContact;
	@FindBy(xpath = "//a//li[text()='+91-1414-9373-00']")
	private WebElement telephoneNoCheck;
	@FindBy(xpath = "//div[contains(text(),'Registered Office Address ')]")
	private WebElement addressInFooter;
	@FindBy(xpath = "//div[@class='footer-list cursor-fix']")
	private WebElement jbAddress;
	@FindBy(xpath = "//iframe[@id='fc_widget']")
	private WebElement chatBoxFrame;
	@FindBy(xpath = "//div[@id='chat-icon']")
	private WebElement chatBoxIcon;
	@FindBy(xpath = "//div[@class='viewport h-chat-custom h-open']")
	private WebElement chatBoxPopup;
	@FindBy(xpath = "//div[@class='fc-conversation-view']/div/div/div/h1[contains(text(),'Inbox')]")
	private WebElement inboxTextinChatBox;
	@FindBy(xpath = "//div[@class='d_hotline minimize ']")
	private WebElement closeChatBox;
	@FindBy(xpath = "//span[@class='count-text' and contains(text(),'Auction')]")
	private WebElement totalAuctionButton;
	@FindBy(xpath = "//div[@class='ant-card-head-wrapper']")
	private WebElement totalAuctionandDealsheader;
	@FindBy(xpath = "//span[@class='count-text' and contains(text(),'Deals')]")
	private WebElement totalDealsButton;
	@FindBy(xpath = "//span[@aria-label='file-text']")
	private WebElement requestProductIcon;
	@FindBy(xpath = "//input[@id='Product_Name']")
	private WebElement requestProductName;
	@FindBy(xpath = "//input[@id='Reference_Url']")
	private WebElement requestProductURL;
	@FindBy(xpath = "//input[@id='Model_Number']")
	private WebElement requestModelNo;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//div[text()=' Request Sent ']")
	private WebElement requestSent;
	@FindBy(xpath = "//div[@class='ant-modal-content']")
	private WebElement requestSentNotificationBox;
	@FindBy(xpath = "//label[@class ='ant-checkbox-wrapper ant-checkbox-group-item']//span//following-sibling::span")
	private List<WebElement> totalAuctionFilterList;
	@FindBy(xpath = "//span[text()='Clear All']//parent::button")
	private WebElement clearAllFilterButton;
	@FindBy(xpath = "//span[text()='Profile']")
	private WebElement profilePage;
	@FindBy(xpath ="//a[@class='ant-breadcrumb-link' and @href='/']")
	private WebElement homeButtonIcon;
	@FindBy(xpath = "//span[@class='anticon anticon-appstore']")
	private WebElement iconViewButton;
	
	

	public DashboardPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}

	/// ****IF ELSE Condition*****/////
	public DashboardPage Topbarhyperlinks() {
		if (seleniumHelper.isElementDisplayedwithoutBgColor(downloadAppLink)) {
			seleniumHelper.clickOnWebElement(downloadAppLink);
			seleniumHelper.SwitchToWindow(1);
			seleniumHelper.isElementDisplayedwithoutBgColor(appInstallButton);
			Assert.assertEquals(actualTextinPlaystore.getText(), TestProperties.getProperty("expectedTextinPlayStore"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Verify Top Bar - Download the App Link");
			seleniumHelper.switchToParentWithChildClose();
		} 
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to Jinglebid app in PlayStore");
			return this;
		}

		if (seleniumHelper.isElementDisplayedwithoutBgColor(aboutUslinkonTopofDashboard)) {
			seleniumHelper.clickOnWebElement(aboutUslinkonTopofDashboard);
			seleniumHelper.SwitchToWindow(1);
			String actualAboutUsURL = driver.getCurrentUrl();
			System.out.println(actualAboutUsURL);
			Assert.assertEquals(actualAboutUsURL, TestProperties.getProperty("expectedAboutUsURL"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Verify Top Bar - About Us Link");
			seleniumHelper.switchToParentWithChildClose();
		}

		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to About Us page");
			return this;
		}

		if (seleniumHelper.isElementDisplayedwithoutBgColor(jingleBidTVIcon)) {
			seleniumHelper.clickOnWebElement(jingleBidTVIcon);
			seleniumHelper.SwitchToWindow(1);
			String actualJingleBidTVURL = driver.getCurrentUrl();
			Assert.assertEquals(actualJingleBidTVURL, TestProperties.getProperty("expectedJingleBidTVURL"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Directing to Youtube - JingleBid TV ");
			seleniumHelper.switchToParentWithChildClose();
		}

		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to Youtube - JingleBid TV ");
			return this;
		}
		if (seleniumHelper.isElementDisplayedwithoutBgColor(jingleBidLogo)) {
			seleniumHelper.clickOnWebElement(jingleBidLogo);
			Assert.assertEquals(jingleBidLogo.getText(), TestProperties.getProperty("expectedTextinPlayStore"));
			seleniumHelper.highlightWebElement(jingleBidLogo);
			ReportUtil.addScreenShot(LogStatus.PASS, "JingleBid Logo is displayed ");
		} else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "JingleBid Logo is not displayed ");
			return this;
		}
		return this;
	}

	public DashboardPage footerBannerAboutUs() {
		seleniumHelper.scrollIntoView(aboutinBottomBanner);
		if (seleniumHelper.isElementDisplayedwithoutBgColor(homeButtoninFooter)) {
			seleniumHelper.clickOnWebElement(homeButtoninFooter);
			ReportUtil.addScreenShot(LogStatus.PASS, "Footer Home button Directed to home page Succesfully!");
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Footer Home button not Directed to home page ");
			return this;
		}
		
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.scrollIntoView(aboutinBottomBanner);
		if (seleniumHelper.isElementDisplayedwithoutBgColor(aboutUsInFooter)) {
			seleniumHelper.clickOnWebElement(aboutUsInFooter);
			seleniumHelper.SwitchToWindow(1);
			String actualAboutUsURL1 = driver.getCurrentUrl();
			System.out.println(actualAboutUsURL1);
			Assert.assertEquals(actualAboutUsURL1, TestProperties.getProperty("expectedAboutUsURL"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Directing to AboutUs page ");
			seleniumHelper.switchToParentWithChildClose();
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to AboutUs Page");
			return this;
		}
		return this;
	}

	public DashboardPage footerJingleBidTv() throws InterruptedException {
		seleniumHelper.scrollIntoView(jingleBidTvFooter);
		if (seleniumHelper.isElementDisplayedwithoutBgColor(youtubeinFooter)) {
			seleniumHelper.clickOnWebElement(youtubeinFooter);
			seleniumHelper.SwitchToWindow(1);
			Assert.assertEquals(driver.getCurrentUrl(), TestProperties.getProperty("expectedJingleBidTVURL"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Directing to Youtube - JingleBid TV ");
			seleniumHelper.switchToParentWithChildClose();
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to Youtube - JingleBid TV ");
			return this;
		}
		return this;
	}

	public DashboardPage policyinFooter() throws InterruptedException {
		seleniumHelper.scrollIntoView(policyinFooter);
		if (seleniumHelper.isElementDisplayedwithoutBgColor(privacyPolicyButton)) {
			seleniumHelper.clickOnWebElement(privacyPolicyButton);
			seleniumHelper.SwitchToWindow(1);
			Assert.assertEquals(driver.getCurrentUrl(), TestProperties.getProperty("expectedPrivacyPolicyURL"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Directing to Privacy Policy Page ");
			seleniumHelper.switchToParentWithChildClose();
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to Privacy Policy Page ");
			return this;
		}
		if (seleniumHelper.isElementDisplayedwithoutBgColor(refundReturnPolicyButton)) {
			seleniumHelper.clickOnWebElement(refundReturnPolicyButton);
			seleniumHelper.SwitchToWindow(1);
			Assert.assertEquals(driver.getCurrentUrl(), TestProperties.getProperty("expectedReturnRefundURL"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Directing to Return and Refund Policy Page ");
			seleniumHelper.switchToParentWithChildClose();
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to Return and Refund Policy Page ");
			return this;
		}
		if (seleniumHelper.isElementDisplayedwithoutBgColor(termsandConditionsButton)) {
			seleniumHelper.clickOnWebElement(termsandConditionsButton);
			seleniumHelper.SwitchToWindow(1);
			Assert.assertEquals(driver.getCurrentUrl(), TestProperties.getProperty("expectedTermsandConditionsURL"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Directing to Terms and Conditions page");
			seleniumHelper.switchToParentWithChildClose();
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to Terms and Conditions page ");
			return this;
		}
		return this;
	}

	public DashboardPage socialNetworkinFooter() throws Exception {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.scrollIntoView(socialinFooter);
		if (seleniumHelper.isElementDisplayedwithoutBgColor(facebookIconFooter)) {
			seleniumHelper.clickOnWebElement(facebookIconFooter);
			seleniumHelper.SwitchToWindow(1);
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl(), TestProperties.getProperty("expectedJBFacebookURL"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Directing to Facebook - JingleBid page");
			seleniumHelper.switchToParentWithChildClose();
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to Facebook - JingleBid Page");
			return this;
		}
		if (seleniumHelper.isElementDisplayedwithoutBgColor(twitterIconFooter)) {
			seleniumHelper.scrollIntoView(socialinFooter);
			seleniumHelper.clickOnWebElement(twitterIconFooter);
			seleniumHelper.SwitchToWindow(1);
			Thread.sleep(2000);
			Assert.assertEquals(driver.getCurrentUrl(), TestProperties.getProperty("expectedJBTwitterURL"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Directing to Twitter - JingleBid page");
			seleniumHelper.switchToParentWithChildClose();
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to Twitter - JingleBid Page");
			return this;
		}
		if (seleniumHelper.isElementDisplayedwithoutBgColor(linkedInIconFooter)) {
			seleniumHelper.clickOnWebElement(linkedInIconFooter);
			seleniumHelper.SwitchToWindow(1);
			String actualURLContainstext = driver.getTitle();
			Thread.sleep(2000);
			Assert.assertTrue(actualURLContainstext.contains("Linked"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Directing to LinkedIn page");
			seleniumHelper.switchToParentWithChildClose();
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to LinkedIn - JingleBid Page");
			return this; }

		if (seleniumHelper.isElementDisplayedwithoutBgColor(instagramIconFooter)) {
			seleniumHelper.scrollIntoView(socialinFooter);
			seleniumHelper.clickOnWebElement(instagramIconFooter);
			seleniumHelper.SwitchToWindow(1);
			Thread.sleep(3000);
			String actualInstagramContains = driver.getTitle();
			Assert.assertTrue(actualInstagramContains.contains("Instagram"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Directing to Instagram page");
			seleniumHelper.switchToParentWithChildClose();
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Not directing to Instagram - JingleBid Page");
			return this;
			}
	
		return this;
		}

	public DashboardPage contactUsFooter() throws Exception {
//		Robot bot = new Robot();
		seleniumHelper.scrollIntoView(contactUsInFooter);
		if (seleniumHelper.isElementDisplayed(emailInFooter)) {
//			seleniumHelper.scrollIntoView(emailInFooter);
			Assert.assertTrue(seleniumHelper.isElementEnabled(emailInFooter));
			seleniumHelper.highlightWebElementwithoutBg(emailCheck);
//			Thread.sleep(4000);
//			bot.keyPress(KeyEvent.VK_ESCAPE);
//			bot.keyRelease(KeyEvent.VK_ESCAPE);
//			bot.keyPress(KeyEvent.VK_ALT);
//			bot.keyPress(KeyEvent.VK_F4);
//			bot.keyRelease(KeyEvent.VK_F4);
//			bot.keyRelease(KeyEvent.VK_ALT);
//			seleniumHelper.switchToParentWindow();
			String actualAttributeinEmail = emailCheck.getText();
			Assert.assertEquals(actualAttributeinEmail, TestProperties.getProperty("expectedTextinEmail"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Email ID is available in Contact US and is enabled");
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Email ID is not available in Contact US and is not enabled");
			return this;
			}

		if (seleniumHelper.isElementDisplayed(telephoneNoContact)) {
			seleniumHelper.scrollIntoView(telephoneNoContact);
//			seleniumHelper.moveToElementAndClickOnIt(telephoneNoContact);
			Assert.assertTrue(seleniumHelper.isElementEnabled(telephoneNoCheck));
			seleniumHelper.highlightWebElementwithoutBg(telephoneNoCheck);
//			bot.keyPress(KeyEvent.VK_ESCAPE);
//			bot.keyRelease(KeyEvent.VK_ESCAPE);
			String actualTextInTelephoneContact = telephoneNoCheck.getText();
			Assert.assertEquals(actualTextInTelephoneContact,
					TestProperties.getProperty("expectedTextinTelephoneToContact"));
			ReportUtil.addScreenShot(LogStatus.PASS, "Phone Number is available in ContactUs and is enabled");
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Phone Number is ntot available in ContactUs and is not enabled");
			return this;
			}

		return this;
	}

	public DashboardPage addressinFooter() {
		seleniumHelper.scrollIntoView(addressInFooter);
		if (seleniumHelper.isElementDisplayedwithoutBgColor(jbAddress)) {
			System.out.println("Registered Office Address = ' " + jbAddress.getText() + "'");
		ReportUtil.addScreenShot(LogStatus.PASS, "Address is available in Registered Office Address");
		}
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Address is not available in Registered Office Address");
			return this;
			}
		
		return this;
	}

	public DashboardPage chatboxIcon() {
		driver.switchTo().frame(chatBoxFrame);
		if (seleniumHelper.isElementDisplayed(chatBoxIcon)) {
			seleniumHelper.moveToElementAndClickOnIt(chatBoxIcon);
			// String actualTextInChatBox = seleniumHelper.getText(inboxTextinChatBox);
			Assert.assertTrue(seleniumHelper.isElementDisplayedwithoutBgColor(chatBoxPopup));
			ReportUtil.addScreenShot(LogStatus.PASS, "ChatBox is present and is clickable");
			seleniumHelper.clickOnWebElement(closeChatBox);
			seleniumHelper.switchToParentWindow();
		}
		
		else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "ChatBox is not present and is not clickable");
			return this;
			}
		return this;
	}

	public DashboardPage totalAuction() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(totalAuctionButton);
		String actualTextinTotalAuction = seleniumHelper.getText(totalAuctionandDealsheader);
		Assert.assertEquals(actualTextinTotalAuction, TestProperties.getProperty("expectedTextinTotalAuction"));
		seleniumHelper.highlightWebElement(totalAuctionandDealsheader);
		Thread.sleep(2000);
		ReportUtil.addScreenShot(LogStatus.PASS,
				"Total Auction page is clickable and directing to Total auctions page");
		return this;
	}

	public DashboardPage totalDeals() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(totalDealsButton);
		String actualTextinTotalDeals = seleniumHelper.getText(totalAuctionandDealsheader);
		Assert.assertEquals(actualTextinTotalDeals, TestProperties.getProperty("expectedTextinTotalDeals"));
		seleniumHelper.highlightWebElement(totalAuctionandDealsheader);
		Thread.sleep(2000);
		ReportUtil.addScreenShot(LogStatus.PASS, "Total Deals page is clickable and directing to Total Deals page");
		return this;
	}

	public DashboardPage productRequest() {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(requestProductIcon);
		seleniumHelper.clickOnWebElement(requestProductName);
		requestProductName.sendKeys(TestProperties.getProperty("requestProductName"));
		seleniumHelper.clickOnWebElement(requestProductURL);
		requestProductURL.sendKeys(TestProperties.getProperty("productURL"));
		seleniumHelper.clickOnWebElement(requestModelNo);
		requestModelNo.sendKeys(TestProperties.getProperty("productModelNo"));
		seleniumHelper.clickOnWebElement(submitButton);
		if (seleniumHelper.isElementDisplayed(requestSentNotificationBox)) {
			Assert.assertTrue(seleniumHelper.isElementDisplayed(requestSent));
			ReportUtil.addScreenShot(LogStatus.PASS, "Product Request sent successfully");
		} else {
			ReportUtil.addScreenShot(LogStatus.FAIL, "Product request is not successful");
		}
		return this;
	}
	public DashboardPage totalauctionfilter () throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(totalAuctionButton);
		String totalAuctionFilter = TestProperties.getProperty("totalAuctionFilter");
		WebElement filterCheckBox = driver
				.findElement(By.xpath("//span[contains(text(),'" + totalAuctionFilter + "')]/preceding-sibling::span"));
		Thread.sleep(2000);
		Boolean auctionFilterClick = false;
		for (int i = 0; i < totalAuctionFilterList.size(); i++) {
			Thread.sleep(4000);
//			System.out.println(totalAuctionFilterList.get(i).getText());
			if (totalAuctionFilterList.get(i).getText().equalsIgnoreCase(totalAuctionFilter)) {
				seleniumHelper.moveToElementAndClickOnIt(filterCheckBox);
				Thread.sleep(4000);
				break;
			}
			}
			auctionFilterClick = true;
			Assert.assertTrue(auctionFilterClick);
			ReportUtil.addScreenShot(LogStatus.PASS, "Total Auction filter applied successfully");
			Boolean clearFilter = false;
			
				seleniumHelper.clickOnWebElement(clearAllFilterButton);
				seleniumHelper.isElementDisplayedwithoutBgColor(clearAllFilterButton);
			Thread.sleep(2000);
			clearFilter = true;
			Assert.assertTrue(clearFilter);
			ReportUtil.addScreenShot(LogStatus.PASS, "Clear All Filter button applied successfully");
			return this;
}
	public DashboardPage totalDealFilter () throws InterruptedException {
			seleniumHelper.clickOnWebElement(jingleBidLogo);
			seleniumHelper.clickOnWebElement(totalDealsButton);
			String totalAuctionFilter = TestProperties.getProperty("totalAuctionFilter");
			WebElement filterCheckBox = driver
					.findElement(By.xpath("//span[contains(text(),'" + totalAuctionFilter + "')]/preceding-sibling::span"));
			Thread.sleep(2000);
			Boolean auctionFilterClick = false;
			for (int i = 0; i < totalAuctionFilterList.size(); i++) {
				Thread.sleep(4000);
				if (totalAuctionFilterList.get(i).getText().equalsIgnoreCase(totalAuctionFilter)) {
					seleniumHelper.moveToElementAndClickOnIt(filterCheckBox);
					Thread.sleep(4000);
					break;
				}
				}
				auctionFilterClick = true;
				Assert.assertTrue(auctionFilterClick);
				ReportUtil.addScreenShot(LogStatus.PASS, "Total Deals filter applied successfully");
				Boolean clearFilter = false;
				
					seleniumHelper.clickOnWebElement(clearAllFilterButton);
					seleniumHelper.isElementDisplayedwithoutBgColor(clearAllFilterButton);
				Thread.sleep(2000);
				clearFilter = true;
				Assert.assertTrue(clearFilter);
				ReportUtil.addScreenShot(LogStatus.PASS, "Clear All Filter button applied successfully");
				return this;
	}
	
	public DashboardPage totalDealsToProfilePage() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(totalDealsButton);
		seleniumHelper.isElementDisplayed(profilePage);
		seleniumHelper.clickOnWebElement(profilePage);
		Boolean profileclick = false;
		Thread.sleep(2000);
		profileclick = true;
		Assert.assertTrue(profileclick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Directed to Profile Page from Total Deals page");
		return this;	
	}
	public DashboardPage totalAuctionToProfilePage() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(totalAuctionButton);
		seleniumHelper.isElementDisplayed(profilePage);
		seleniumHelper.clickOnWebElement(profilePage);
		Boolean profileclick = false;
		Thread.sleep(2000);
		profileclick = true;
		Assert.assertTrue(profileclick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Directed to Profile Page from Total Auction page");
		return this;
	}
	public DashboardPage totalDealsToHomePage () throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(totalDealsButton);
		seleniumHelper.isElementDisplayed(homeButtonIcon);
		seleniumHelper.clickOnWebElement(homeButtonIcon);
		Boolean homePageclick = false;
		Thread.sleep(2000);
		homePageclick = true;
		Assert.assertTrue(homePageclick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Directed to Home Page from Total Deals page");
		return this;
	}
	public DashboardPage totalAuctionToHomePage () throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(totalAuctionButton);
		seleniumHelper.isElementDisplayed(homeButtonIcon);
		seleniumHelper.clickOnWebElement(homeButtonIcon);
		Boolean homePageclick = false;
		Thread.sleep(2000);
		homePageclick = true;
		Assert.assertTrue(homePageclick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Directed to Home Page from Total Auction page");
		return this;
	}
	public DashboardPage totalDealsViewFunctionality () throws Exception {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(totalDealsButton);
		seleniumHelper.isElementDisplayedwithoutBgColor(iconViewButton);
		seleniumHelper.clickOnWebElement(iconViewButton);
		Thread.sleep(2000);
		Boolean viewClick = false;
		viewClick = true;
		Assert.assertTrue(viewClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Grid View functionality is selected");
		return this;
	}
	
	public DashboardPage totalAuctionViewFunctionality () throws Exception {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(totalAuctionButton);
		seleniumHelper.isElementDisplayedwithoutBgColor(iconViewButton);
		seleniumHelper.clickOnWebElement(iconViewButton);
		Thread.sleep(2000);
		Boolean viewClick = false;
		viewClick = true;
		Assert.assertTrue(viewClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Grid View functionality is selected");
		return this;
	}
}

	
	
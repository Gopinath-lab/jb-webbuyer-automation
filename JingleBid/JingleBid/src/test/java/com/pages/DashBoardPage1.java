package com.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class DashBoardPage1 extends BasePage{

	SeleniumHelper seleniumHelper;
	
	String expectedTextinPlayStore="Jinglebid";
	String expectedAboutUsURL="https://about-us.jinglebid.com/";
	String expectedJingleBidTVURL = "https://www.youtube.com/results?search_query=JINGLEBID+TV";
	String expectedJingleBidTvFooter = "Jinglebid TV";
	String expectedPrivacyPolicyURL="https://qa.jinglebid.com/privacy-policy";
	String expectedReturnRefundURL="https://qa.jinglebid.com/return-refund-policy";
	
	@FindBy(xpath = "//a[text()='Download the App']")
	private WebElement downloadAppLink;
	
	@FindBy(xpath = "//span[text()='Install']")
	private WebElement appInstallButton;
	
	@FindBy(xpath = "(//span[contains(text(),'Jinglebid')])[2]")
	private WebElement actualTextinPlaystore;
	
	@FindBy(xpath = "//h3[contains(text(),'Why should you buy on Jinglebid?')]")
	private WebElement actualtextinAboutUSPage;
	
	@FindBy(xpath= "//a[text()='About Us']/parent::div/a")
	private WebElement aboutUslinkonTopofDashboard;
	
	@FindBy(xpath = "//a[text()='Jinglebid TV']")
	private WebElement jingleBidTVIcon;
	
	@FindBy(xpath = "(//*[contains(text(),'Jinglebid')])[1]")
	private WebElement jingleBidYTPage;
	
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
	
	
	@FindBy(xpath = "//a[contains(@href,'tel')]")
	private WebElement telephoneNoContact;
	
	@FindBy(xpath = "//div[contains(text(),'Registered Office Address ')]")
	private WebElement addressInFooter;
	
	@FindBy(xpath = "//div[@class='footer-list cursor-fix']")
	private WebElement jbAddress;
	
	@FindBy(xpath = "//iframe[@id='fc_widget']")
	private WebElement chatBoxFrame;
	
	@FindBy(xpath = "//div[@id='chat-icon']")
	private WebElement chatBoxIcon;
	
	@FindBy(xpath = "//div[@class='fc-conversation-view']")
	private WebElement chatBox;
	
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
	
	@FindBy(xpath = "//img[@class='referral-img']")
	private WebElement referralIcon;
	@FindBy(xpath ="//span[@class='referral-code-head']/parent::div")
	private WebElement referralCode;
	
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
	
	public DashBoardPage1(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper (driver);
		
	}
	
	////******ArrayList Dashboard Page********//////
	
	private void validateHyperlinks(WebElement webElement, WebElement validationData, String text, String textinReport) throws InterruptedException {
		if (seleniumHelper.isElementDisplayed(webElement)) {
			seleniumHelper.clickOnWebElement(webElement);
			seleniumHelper.SwitchToWindow(1);
			Thread.sleep(1000);
			Assert.assertEquals(validationData.getText(), TestProperties.getProperty(text));	
			ReportUtil.addScreenShot(LogStatus.PASS,textinReport);
			seleniumHelper.switchToParentWithChildClose();
		}
	}
	
	public DashBoardPage1 hyperlinks1 () throws InterruptedException {
		ArrayList<WebElement> hyperlinks= new ArrayList<WebElement>();
		hyperlinks.add(downloadAppLink);
		hyperlinks.add(aboutUslinkonTopofDashboard);
		hyperlinks.add(jingleBidTVIcon);
		
		ArrayList<WebElement> validationElement = new ArrayList<WebElement>();
		validationElement.add(actualTextinPlaystore);
		validationElement.add(actualtextinAboutUSPage);
		validationElement.add(jingleBidYTPage);
		
		ArrayList<String> validateText = new ArrayList<String>();
		validateText.add("expectedTextinPlayStore");
		validateText.add("expectedTextinAboutUs");
		validateText.add("expectedTextinYouTube");
		
		ArrayList<String> reportText = new ArrayList<String> ();
		reportText.add("Directing to Jinglebid app in PlayStore and Install button available");
		reportText.add("Directing to AboutUs page ");
		reportText.add("Directing to YouTube - JingleBid TV");
		
		for (int i = 0; i < hyperlinks.size(); i++) {
			validateHyperlinks(hyperlinks.get(i), validationElement.get(i), validateText.get(i), reportText.get(i));
			
		}
		return this;	
		
	}
	}
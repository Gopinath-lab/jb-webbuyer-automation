package com.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.apache.poi.hpsf.ClipboardData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.basepage.BasePage;
import com.helper.SeleniumHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.util.ReportUtil;
import com.util.TestProperties;

public class ShareableLink extends BasePage{

	SeleniumHelper seleniumHelper;

	@FindBy(xpath = "//input[@placeholder='Search Products']")
	private WebElement searchProductInputBox;
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement searchButton;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[1]")
	public WebElement selectProductAfterSearch;
	@FindBy(xpath = "//span[@class='anticon anticon-share-alt share-icon']")
	private WebElement shareButton;
	@FindBy(xpath = "//div[@class='ant-popover-inner-content']")
	private WebElement shareOptions;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-icon-only share-product-copy']//img")
	private WebElement copyUrlButton;
	
	public ShareableLink(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}
	
	public ShareableLink shareableURL() throws InterruptedException, Exception, Exception {
		seleniumHelper.clickOnWebElement(searchProductInputBox);
		seleniumHelper.sendKeys(searchProductInputBox, TestProperties.getProperty("searchProductForAutoBid"));
		searchProductInputBox.sendKeys(Keys.ENTER);
		seleniumHelper.clickOnWebElement(selectProductAfterSearch);
		seleniumHelper.hardWait(3000);
		searchProductInputBox.sendKeys(Keys.ESCAPE);
		searchProductInputBox.sendKeys(Keys.ESCAPE);
		seleniumHelper.clickOnWebElement(shareButton);
		seleniumHelper.isElementDisplayedwithoutBgColor(shareOptions);
		seleniumHelper.waitForElement(copyUrlButton, 5);
		seleniumHelper.clickOnWebElement(copyUrlButton);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        String newCopiedURL = (String) contents.getTransferData(DataFlavor.stringFlavor);
        System.out.println(newCopiedURL);
//		String url = copyUrlButton.getAttribute(null);
		driver.switchTo().newWindow(WindowType.TAB);
        driver.get(newCopiedURL);
        Boolean openLink = true;
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        String newCopiedURL = (String) clipboard.getContents(null).getTransferData(DataFlavor.stringFlavor);
//        String newURL = actions(Keys.chord(Keys.LEFT_CONTROL, "v")).build().perform();
//        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(openLink, "Opened new tab and URL copied is pasted");
        ReportUtil.addScreenShot(LogStatus.PASS,"New tab opened and copy pasted the URL copied");
		return this;	
	}
	}

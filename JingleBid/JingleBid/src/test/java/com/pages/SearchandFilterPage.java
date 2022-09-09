package com.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
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

public class SearchandFilterPage extends BasePage{

	SeleniumHelper seleniumHelper;

	@FindBy(xpath = "//div[@class='header-text']")
	private WebElement jingleBidLogo;
	@FindBy(xpath = "(//div[@class='carousel-col']/div[text()='Mobiles & Tabs ']/preceding-sibling::span)[2]")
	private WebElement selectFromMainMenuCategory1;
	@FindBy(xpath = "//div[@class='ant-popover-inner']/div/div/div[@class='ant-row subcategory-row']")
	private List<WebElement> dropDownProductSelect1;

	/// *** SLIDER ****////
	@FindBy(xpath = "//div[@class='ant-slider']//div[@class='ant-slider-handle ant-slider-handle-2']")
	private WebElement slider;
	@FindBy(xpath = "//span[text()='Apply']/parent::button")
	private WebElement applybutton;
	@FindBy(xpath = "//div[@class='ant-slider']")
	private WebElement priceRange;
	@FindBy(xpath = "//div[@style='left: 0%;']")
	private WebElement sliderRange;
//	@FindBy(xpath = "//div[text()='Brand']/div/span")
//	private WebElement filterByBrand;
	@FindBy(xpath = "//div[text()='Brand']")
	private WebElement filterByBrand;
	@FindBy(xpath = "//div[@class='ant-collapse-content ant-collapse-content-active']/div/div/div/label/span")
	private List<WebElement> subcategoryAvailable;
	@FindBy(xpath = "(//h6[@class='mt-10 ellipsis-l e-2 fa13 product-name'])[1]")
	private WebElement brandNameMatch;
	@FindBy(xpath = "//div[text()='Display']")
	private WebElement filterByDisplay;
	@FindBy(xpath = "//div[text()='Chipset']")
	private WebElement filterByChipset;
	@FindBy(xpath = "//div[text()='Battery']")
	private WebElement filterByBattery;
	@FindBy(xpath = "//span[text()='Clear Filter']")
	private WebElement clearFilterButton;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-sm ant-dropdown-trigger fs-11 text-left sort-drop-down']/span[@class='f-right']")
	private WebElement sortByButton;
	@FindBy(xpath = "//ul//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child']")
	private List<WebElement> sortByList;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-default ant-btn-sm ant-btn-icon-only']")
	private WebElement listviewByOption;
	@FindBy(xpath = "//div[@class='ant-col ant-col-xs-24 ant-col-sm-24 ant-col-md-10 ant-col-lg-9 ant-col-xl-9']")
	private WebElement sortByandListBy;
	@FindBy(xpath = "//div[@class='ant-card-head-wrapper']")
	private WebElement totalAuctionandDealsheader;
	@FindBy(xpath = "//span[@class='count-text' and contains(text(),'Deals')]")
	private WebElement totalDealsButton;
	@FindBy(xpath = "//input[@placeholder='Search Products']")
	private WebElement searchProductInputBox;
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement searchButton;
	@FindBy(xpath ="//a[@class='ant-breadcrumb-link' and @href='/']")
	private WebElement homeButtonIcon;
	
	public SearchandFilterPage(WebDriver driver) {
		super(driver);
		seleniumHelper = new SeleniumHelper(driver);
	}

	public SearchandFilterPage launchURL() {
		driver.get(TestProperties.getProperty("login.url"));
		return this;
	}
//	public Faker faker = new Faker();


	public SearchandFilterPage filterbyPriceMethod() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
//		Dimension sliderSize = slider.getSize();
//		int sliderWidth = sliderSize.getWidth();
//		int xSlider = slider.getLocation().getX();
		action.moveToElement(slider).click().dragAndDropBy(slider, 20, 0).build().perform();
		seleniumHelper.highlightWebElement(priceRange);
		seleniumHelper.clickOnWebElement(applybutton);
		ReportUtil.addScreenShot(LogStatus.PASS, "Filtered the page with MRP Price Range");
		return this;
	}

	public SearchandFilterPage filterByBrand() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		seleniumHelper.waitForElement(filterByBrand, 5);
		seleniumHelper.clickOnWebElement(filterByBrand);
		String brandName = TestProperties.getProperty("brandName");
		WebElement brandCheckBox = driver
				.findElement(By.xpath("//span[contains(text(),'" + brandName + "')]/preceding-sibling::span"));
		WebElement brandSelected = driver
				.findElement(By.xpath("//span[contains(text(),'" + brandName + "')]/parent::label"));
		Thread.sleep(2000);
		Boolean brandClick = false;
		for (int i = 0; i <= subcategoryAvailable.size(); i++) {
			Thread.sleep(2000);
			if (subcategoryAvailable.get(i).getText().equals(brandName)) {
				seleniumHelper.clickOnWebElement(brandCheckBox);
				seleniumHelper.clickOnWebElement(applybutton);
				seleniumHelper.isElementDisplayed(brandSelected);
				Thread.sleep(2000);
				brandClick = true;
				Assert.assertTrue(brandClick);
				ReportUtil.addScreenShot(LogStatus.PASS, "Brand filter applied successfully");
				break;
			}
		}
		seleniumHelper.clickOnWebElement(clearFilterButton);
		Thread.sleep(2000);
		Boolean clearFilterClick = true;
		Assert.assertTrue(true);
		ReportUtil.addScreenShot(LogStatus.PASS, "Clear Filter button is applied successfully");
		return this;
	}

	public SearchandFilterPage filterByDisplay() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		seleniumHelper.waitForElement(filterByDisplay, 5);
		seleniumHelper.clickOnWebElement(filterByDisplay);
		String displayName = TestProperties.getProperty("displayName");
		WebElement displayCheckBox = driver
				.findElement(By.xpath("//span[contains(text(),'" + displayName + "')]/preceding-sibling::span"));
		WebElement displaySelected = driver
				.findElement(By.xpath("//span[contains(text(),'" + displayName + "')]/parent::label"));
		Thread.sleep(2000);
		Boolean displayClick = false;
		for (int i = 0; i <= subcategoryAvailable.size(); i++) {
			Thread.sleep(2000);
			if (subcategoryAvailable.get(i).getText().equals(displayName)) {
				seleniumHelper.clickOnWebElement(displayCheckBox);
				seleniumHelper.clickOnWebElement(applybutton);
				seleniumHelper.isElementDisplayed(displaySelected);
				Thread.sleep(2000);
				displayClick = true;
				Assert.assertTrue(displayClick);
				ReportUtil.addScreenShot(LogStatus.PASS, "Display filter applied successfully");
				break;
			}
		}
		seleniumHelper.clickOnWebElement(clearFilterButton);
		Thread.sleep(2000);
		Boolean clearFilterClick = true;
		Assert.assertTrue(true);
		ReportUtil.addScreenShot(LogStatus.PASS, "Clear Filter button is applied successfully");
		return this;
	}

	public SearchandFilterPage filterByChipset() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		seleniumHelper.waitForElement(filterByChipset, 5);
		seleniumHelper.clickOnWebElement(filterByChipset);
		String chipsetName = TestProperties.getProperty("chipsetName");
		WebElement chipsetCheckBox = driver
				.findElement(By.xpath("//span[contains(text(),'" + chipsetName + "')]/preceding-sibling::span"));
		WebElement chipsetSelected = driver
				.findElement(By.xpath("//span[contains(text(),'" + chipsetName + "')]/parent::label"));

		Thread.sleep(2000);
		Boolean chipsetClick = false;
		for (int i = 0; i <= subcategoryAvailable.size(); i++) {
			Thread.sleep(2000);
			if (subcategoryAvailable.get(i).getText().equals(chipsetName)) {
				seleniumHelper.clickOnWebElement(chipsetCheckBox);
				seleniumHelper.clickOnWebElement(applybutton);
				seleniumHelper.isElementDisplayed(chipsetSelected);
				Thread.sleep(2000);
				chipsetClick = true;
				Assert.assertTrue(chipsetClick);
				ReportUtil.addScreenShot(LogStatus.PASS, "Chipset filter applied successfully");
				break;
			}
		}
		seleniumHelper.clickOnWebElement(clearFilterButton);
		Thread.sleep(2000);
		Boolean clearFilterClick = true;
		Assert.assertTrue(true);
		ReportUtil.addScreenShot(LogStatus.PASS, "Clear Filter button is applied successfully");
		return this;
	}

	public SearchandFilterPage filterByBatterySize() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		seleniumHelper.waitForElement(filterByBattery, 5);
		seleniumHelper.clickOnWebElement(filterByBattery);
		String batteryName = TestProperties.getProperty("batterySize");
		WebElement batteryCheckBox = driver
				.findElement(By.xpath("//span[contains(text(),'" + batteryName + "')]/preceding-sibling::span"));
		WebElement batterySelected = driver
				.findElement(By.xpath("//span[contains(text(),'" + batteryName + "')]/parent::label"));

		Thread.sleep(2000);
		Boolean chipsetClick = false;
		for (int i = 0; i <= subcategoryAvailable.size(); i++) {
			Thread.sleep(2000);
			if (subcategoryAvailable.get(i).getText().equals(batteryName)) {
				seleniumHelper.clickOnWebElement(batteryCheckBox);
				seleniumHelper.clickOnWebElement(applybutton);
				seleniumHelper.isElementDisplayed(batterySelected);
				Thread.sleep(2000);
				chipsetClick = true;
				Assert.assertTrue(chipsetClick);
				ReportUtil.addScreenShot(LogStatus.PASS, "BatterySize filter applied successfully");
				break;
			}
		}
		seleniumHelper.clickOnWebElement(clearFilterButton);
		Thread.sleep(2000);
		Boolean clearFilterClick = true;
		Assert.assertTrue(clearFilterClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Clear Filter button is applied successfully");
		return this;
	}

	public SearchandFilterPage sortByOptionandListView() throws InterruptedException {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(selectFromMainMenuCategory1);
		dropDownProductSelect1.get(0).click();
		seleniumHelper.clickOnWebElement(sortByButton);
		Thread.sleep(2000);
		sortByList.get(2).click();
		seleniumHelper.clickOnWebElement(listviewByOption);
		seleniumHelper.isElementDisplayed(sortByandListBy);
		Thread.sleep(2000);
		Boolean sortByClick = true;
		Assert.assertTrue(sortByClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "SortBy and ViewBy-List functionalities applied successfully");

		return this;
	}
	public SearchandFilterPage productsearchToHomePage () throws Exception {
		seleniumHelper.clickOnWebElement(jingleBidLogo);
		seleniumHelper.clickOnWebElement(searchProductInputBox);
		seleniumHelper.sendKeys(searchProductInputBox, TestProperties.getProperty("searchProductForAutoBid"));
		searchProductInputBox.sendKeys(Keys.ENTER);
		seleniumHelper.isElementDisplayedwithoutBgColor(homeButtonIcon);
		seleniumHelper.clickOnWebElement(homeButtonIcon);
		Thread.sleep(2000);
		Boolean viewClick = false;
		viewClick = true;
		Assert.assertTrue(viewClick);
		ReportUtil.addScreenShot(LogStatus.PASS, "Directed to home page after product search");
		return this;
	}
}
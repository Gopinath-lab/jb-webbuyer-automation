package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.context.WebDriverContext;
import com.listeners.LogListener;
import com.listeners.ReportListener;
import com.util.LoggerUtil;
import com.util.TestProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Every test class should extend this calss.
 *
 */
@Listeners({ ReportListener.class, LogListener.class })
public class BaseTest {

	/** The driver. */
	protected WebDriver driver;

	/**
	 * Global setup.
	 */
	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		LoggerUtil.info("************************** Test Execution Started ************************************");
		TestProperties.loadAllPropertie();
	}

	/**
	 * Wrap all up.
	 *
	 * @param context the context
	 * @throws Exception
	 */
	@AfterSuite(alwaysRun = true)
	public void wrapAllUp(ITestContext context) throws Exception {
		int total = context.getAllTestMethods().length;
		int passed = context.getPassedTests().size();
		int failed = context.getFailedTests().size();
		int skipped = context.getSkippedTests().size();
		LoggerUtil.info("Total number of testcases : " + total);
		LoggerUtil.info("Number of testcases Passed : " + passed);
		LoggerUtil.info("Number of testcases Failed : " + failed);
		LoggerUtil.info("Number of testcases Skipped  : " + skipped);
		// boolean mailSent = EmailConfig.ReportEmail(); // MailUtil.sendMail(total, passed, failed, skipped);
		LoggerUtil.info("************************** Test Execution Finished ************************************");
	}

	/**
	 * Setup.
	 */
	@BeforeClass
	protected void setup() {
//		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverContext.setDriver(driver);
	}

	/**
	 * Wrap up.
	 */
//	@AfterClass
//	public void wrapUp() {
//		if (driver != null) {
//			driver.close();
//			driver.quit();
//		}
//	}
}

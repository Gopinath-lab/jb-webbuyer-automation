package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.basepage.BasePage;

public class webelements extends BasePage {

	public webelements(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//span[contains(text(),'OR Email/Password Login?')]")
	public WebElement emailpasslogin;
	@FindBy(xpath = "//input[@id='email']")
	public static WebElement uname;
	@FindBy(xpath = "//input[@id='password']")
	public static WebElement pwd;
	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary ant-btn-round login-btn']")
	public static WebElement logbtn;
	@FindBy(xpath = "//div[text()='Logged in Successfully']")
	public WebElement loginsuccessful;
}

